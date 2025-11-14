{-# OPTIONS_GHC -Wno-incomplete-patterns #-}

module Day4 where

splitBy :: (Foldable t, Eq a) => t a -> [a] -> [[a]]
splitBy _ [] = []
splitBy cs s =
  let start = takeWhile notSplitChar s
      rest = dropWhile notSplitChar s
   in start : splitBy cs (drop 1 rest)
  where
    notSplitChar x = x `notElem` cs

leftContained :: Ord a => [a] -> Bool
leftContained [x,y,z,v] = z <= x && y <= v

rightContained :: Ord a => [a] -> Bool
rightContained [x,y,z,v] = leftContained [z,v,x,y]

contained :: [Int] -> Bool
contained xs = leftContained xs || rightContained xs

overlaps :: [Int] -> Bool
overlaps [x,y,u,v] = u <= y && x <= v

solve :: String -> Int
solve = length . filter contained . map (map read . splitBy ",-") . lines

solve' :: String -> Int
solve' = length . filter overlaps . map (map read . splitBy ",-") . lines

main :: IO ()
main = do
  input <- readFile "day-4-input.txt"
  print (solve input)
  print (solve' input)