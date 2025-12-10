Minimize
  obj: x0 + x1 + x2 + x3 + x4

Subject To
  c0: x0 + x1 + x3 + x4 = 66
  c1: x1 + x3 + x4 = 50
  c2: x0 + x1 + x2 + x4 = 47
  c3: x1 + x2 + x3 = 37
  c4: x0 + x1 + x2 + x3 = 53
  c5: x0 = 16

Bounds
  x0 >= 0
  x1 >= 0
  x2 >= 0
  x3 >= 0
  x4 >= 0

Generals
  x0 x1 x2 x3 x4

End
