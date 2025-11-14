module Day3 where

import qualified Data.Map
import qualified Data.Maybe

splitInHalf :: [a] -> ([a], [a])
splitInHalf s = splitAt n s
  where
    n = length s `div` 2

firstCommon :: (String, String) -> Char
firstCommon (x : xs, ys) =
  if x `elem` ys
    then x
    else firstCommon (xs, ys)

priorities = Data.Map.fromList $ zip (['a'..'z'] ++ ['A'..'Z']) [1..52]

priority c = Data.Maybe.fromMaybe 0 (Data.Map.lookup c priorities)

score = sum . map (priority . firstCommon . splitInHalf)

groupInThrees :: [a] -> [[a]]
groupInThrees [] = []
groupInThrees (x:y:z:xs) = [x,y,z] : groupInThrees xs


common [xs,ys,zs] = let v = firstCommon (xs,ys) in
   if v `elem` zs
    then v
    else common [tail xs, ys, zs]

score' = sum . map (priority . common) . groupInThrees

main = do
  ls <- lines <$> readFile "day-3-input.txt"
  print . score $ ls
  print . score' $ ls