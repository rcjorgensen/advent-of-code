Minimize
  obj: x0 + x1 + x2 + x3 + x4 + x5

Subject To
  c0: x0 + x2 + x4 = 39
  c1: x0 + x1 + x2 + x3 + x4 + x5 = 56
  c2: x1 = 11
  c3: x0 + x1 + x4 = 32
  c4: x0 + x4 + x5 = 24
  c5: x2 + x3 + x4 = 24

Bounds
  x0 >= 0
  x1 >= 0
  x2 >= 0
  x3 >= 0
  x4 >= 0
  x5 >= 0

Generals
  x0 x1 x2 x3 x4 x5

End
