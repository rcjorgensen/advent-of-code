Minimize
  obj: x0 + x1 + x2 + x3 + x4 + x5 + x6

Subject To
  c0: x0 + x4 + x5 + x6 = 50
  c1: x0 + x1 + x4 + x5 + x6 = 58
  c2: x1 + x2 + x6 = 29
  c3: x0 + x2 + x3 = 34
  c4: x0 + x1 + x4 = 34
  c5: x0 + x2 + x4 + x5 = 43
  c6: x0 + x1 + x4 = 34

Bounds
  x0 >= 0
  x1 >= 0
  x2 >= 0
  x3 >= 0
  x4 >= 0
  x5 >= 0
  x6 >= 0

Generals
  x0 x1 x2 x3 x4 x5 x6

End
