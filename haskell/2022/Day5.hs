{-# OPTIONS_GHC -Wno-incomplete-patterns #-}

module Day5 where

column :: Int -> [String] -> String
column n = dropWhile (== ' ') . map (head . take 1 . drop (1 + (n - 1) * 4))

columns :: [String] -> [String]
columns ls = [column n ls | n <- [1 .. 9]]

remove :: Int -> Int -> [String] -> [String]
remove = remove' 1

remove' :: Int -> Int -> Int -> [String] -> [String]
remove' _ 0 _ cs = cs
remove' pos m n (c : cs)
  | pos /= n = c : remove' (pos + 1) m n cs
  | otherwise = drop m c : cs

get :: Int -> Int -> [String] -> String
get = get' 1

get' :: Int -> Int -> Int -> [String] -> String
get' pos m n (c : cs)
  | pos /= n = get' (pos + 1) m n cs
  | otherwise = take m c

add :: Int -> String -> [String] -> [String]
add = add' 1

add' :: Int -> Int -> String -> [String] -> [String]
add' pos n xs (s : ss)
  | pos /= n = s : add' (pos + 1) n xs ss
  | otherwise = (xs ++ s) : ss

parseInstruction :: String -> [Int]
parseInstruction "" = []
parseInstruction l = x : parseInstruction xs
  where
    x = read . takeWhile (/= ' ') . drop 1 . dropWhile (/= ' ') $ l
    xs = drop 1 . dropWhile (/= ' ') . drop 1 . dropWhile (/= ' ') $ l

explodeInstruction :: [Int] -> [Int]
explodeInstruction xs = concat (replicate (head xs) (tail xs))

parseInstructions :: [String] -> [Int]
parseInstructions = concatMap (explodeInstruction . parseInstruction)

executeInstruction :: Int -> Int -> Int -> [String] -> [String]
executeInstruction n i j columns = add j crates columns'
  where
    crates = get n i columns
    columns' = remove n i columns

executeInstructions :: [Int] -> [String] -> [String]
executeInstructions [] columns = columns
executeInstructions (x : y : xs) columns = executeInstructions xs columns'
  where
    columns' = executeInstruction 1 x y columns

parseInstructions2 :: [String] -> [[Int]]
parseInstructions2 = map parseInstruction

executeInstructions2 :: [[Int]] -> [String] -> [String]
executeInstructions2 [] columns = columns
executeInstructions2 ([n, i, j] : xs) columns = executeInstructions2 xs columns'
  where
    columns' = executeInstruction n i j columns

solve :: [String] -> [Char]
solve ls =
  let init = columns (take 8 ls)
      inst = parseInstructions (drop 10 ls)
   in map head (executeInstructions inst init)

solve2 :: [String] -> [Char]
solve2 ls =
  let init = columns (take 8 ls)
      inst = parseInstructions2 (drop 10 ls)
   in map head (executeInstructions2 inst init)

main :: IO ()
main = do
  ls <- lines <$> readFile "day-5-input.txt"

  print (solve ls)
  print (solve2 ls)