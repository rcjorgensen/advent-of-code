{-# OPTIONS_GHC -Wno-incomplete-patterns #-}
{-# OPTIONS_GHC -Wno-overlapping-patterns #-}

module Day7 where

import Data.List (sort)
import Day4 (splitBy)

data File = File Int String
  deriving (Show)

data Directory = Directory String [File] [Directory]
  deriving (Show)

dirExists' :: [Directory] -> String -> Bool
dirExists' [] _ = False
dirExists' (d : ds) n = name d == n || dirExists' ds n

dirExists :: Directory -> String -> Bool
dirExists (Directory _ _ ds) = dirExists' ds

fileExists :: [File] -> String -> Bool
fileExists [] _ = False
fileExists ((File _ name) : fs) n = n == name || fileExists fs n

name :: Directory -> String
name (Directory n _ _) = n

addDir :: Directory -> Directory -> Directory
addDir (Directory name fs ds) d = Directory name fs (d : ds)

mkdir :: Directory -> String -> Directory
mkdir d name =
  if dirExists d name
    then d
    else addDir d (empty name d)

addFile :: Directory -> File -> Directory
addFile (Directory name fs ds) (File s n) =
  if fileExists fs n
    then Directory name fs ds
    else Directory name (File s n : fs) ds

root :: Directory
root = Directory "/" [] []

empty :: String -> Directory -> Directory
empty name parent = Directory name [] []

cd :: String -> Directory -> Directory
cd n (Directory _ _ ds) = search n ds

search :: String -> [Directory] -> Directory
search n (d : ds) = if name d == n then d else search n ds

replace :: Directory -> Directory -> Directory
replace newDir oldDir = if name oldDir == name newDir then newDir else oldDir

replaceDir :: Directory -> Directory -> Directory
replaceDir (Directory n fs ds) newDir = Directory n fs (map (replace newDir) ds)

build' :: [String] -> [Directory] -> Directory -> Directory
build' [] [] dir = dir
build' [] (p : ps) dir = build' [] ps (replaceDir p dir)
build' (i : is) ps dir
  | i == "$ cd /" || i == "$ ls" = build' is ps dir
  | i == "$ cd .." = build' is (drop 1 ps) (replaceDir (head ps) dir)
  | take 3 i == "dir" = build' is ps (mkdir dir (drop 4 i))
  | take 4 i == "$ cd" = build' is (dir : ps) (cd (drop 5 i) dir)
  | otherwise = build' is ps (addFile dir (File (read size) fileName))
  where
    size = takeWhile (/= ' ') i
    fileName = drop 1 (dropWhile (/= ' ') i)

build :: [String] -> Directory
build is = build' is [] root

fileSize :: File -> Int
fileSize (File s _) = s

size :: Directory -> Int
size (Directory _ fs ds) = sum (map fileSize fs) + sum (map size ds)

directories :: Directory -> [Directory]
directories (Directory _ _ ds) = ds

sumSizes dir = if size dir <= 100000 then size dir + sumOfChildren else sumOfChildren
  where
    sumOfChildren = sum (map sumSizes (directories dir))

solve :: [String] -> Int
solve = sumSizes . build

flatten :: Directory -> [Directory]
flatten d = d : concatMap flatten (directories d)

solve' :: [String] -> Int
solve' ls =
  let root = build ls
      unused = 70000000 - size root
      needed = 30000000
      dirs = flatten root
   in minimum (map size (filter (\d -> size d + unused >= needed) dirs))

main :: IO ()
main = do
  ls <- lines <$> readFile "day-7-input.txt"

  print (solve ls)
  print (solve' ls)