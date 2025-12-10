Minimize
  obj: x0 + x1 + x2 + x3 + x4 + x5

Subject To
  c0: x1 + x2 + x4 = 42
  c1: x0 + x1 + x4 + x5 = 45
  c2: x1 + x3 = 21
  c3: x5 = 10

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
