module Day1 where

import Data.List ( sort )

splitLines :: String -> [String]
splitLines "" = []
splitLines xs = start : splitLines (drop 1 rest)
  where start = takeWhile (/='\n') xs
        rest = dropWhile (/='\n') xs

split :: [String] -> [[Int]]
split [] = []
split xs = start : split (drop 1 rest)
  where start = map read (takeWhile (/="") xs)
        rest = dropWhile (/="") xs

top :: Int -> [Int] -> [Int]
top n = take n . reverse . sort

main :: IO ()
main = do
    s <- readFile "day-1-input.txt"
    let sums = map sum . split . splitLines $ s
    print (sum . top 1 $ sums)
    print (sum . top 3 $ sums)