Minimize
  obj: x0 + x1 + x2 + x3 + x4 + x5 + x6

Subject To
  c0: x0 + x2 + x4 + x5 + x6 = 33
  c1: x0 + x1 + x2 + x6 = 29
  c2: x0 + x1 + x3 + x6 = 29
  c3: x0 + x2 + x5 = 28
  c4: x2 + x4 + x6 = 9
  c5: x3 + x6 = 8

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
