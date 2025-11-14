module Day2 where

splitBy :: Eq t => t -> [t] -> [[t]]
splitBy _ [] = []
splitBy c s =
  let start = takeWhile (/= c) s
      rest = dropWhile (/= c) s
   in start : splitBy c (drop 1 rest)

score :: String -> Int
score "A X" = 4
score "A Y" = 8
score "A Z" = 3
score "B X" = 1
score "B Y" = 5
score "B Z" = 9
score "C X" = 7
score "C Y" = 2
score "C Z" = 6

score' :: String -> Int
score' "A X" = 3
score' "A Y" = 4
score' "A Z" = 8
score' "B X" = 1
score' "B Y" = 5
score' "B Z" = 9
score' "C X" = 2
score' "C Y" = 6
score' "C Z" = 7

main :: IO ()
main = do
    s <- readFile "day-2-input.txt"
    let rounds = splitBy '\n' s
    print . sum . map score $ rounds 
    print . sum . map score' $ rounds