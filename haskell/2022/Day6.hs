module Day6 where

solve :: String -> Int
solve s = go 4 s
  where
    go pos (a : b : c : d : cs)
      | a `elem` [b, c, d] = go (pos + 1) (b : c : d : cs)
      | b `elem` [c, d] = go (pos + 2) (c : d : cs)
      | c == d = go (pos + 3) (d : cs)
      | otherwise = pos
    go pos _ = 0

containsDuplicates :: Eq a => [a] -> Bool
containsDuplicates [] = False
containsDuplicates (x:xs) = x `elem` xs || containsDuplicates xs

solve' :: String -> Int
solve' cs = go 14 (take 14 cs) (drop 14 cs)
  where
    go pos buffer (c:cs)
      | containsDuplicates buffer = go (pos + 1) (tail buffer ++ [c]) cs
      | otherwise = pos
    go _ _ _ = 0

main :: IO ()
main = do
  input <- readFile "day-6-input.txt"

  print (solve input)
  print (solve' input)