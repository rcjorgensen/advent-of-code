Minimize
  obj: x0 + x1 + x2 + x3 + x4

Subject To
  c0: x0 + x1 + x3 = 10
  c1: x1 + x2 = 11
  c2: x0 + x1 + x2 = 14
  c3: x0 + x3 + x4 = 16
  c4: x4 = 11
  c5: x0 + x1 = 8

Bounds
  x0 >= 0
  x1 >= 0
  x2 >= 0
  x3 >= 0
  x4 >= 0

Generals
  x0 x1 x2 x3 x4

End
