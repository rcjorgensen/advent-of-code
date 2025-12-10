Minimize
  obj: x0 + x1 + x2 + x3 + x4

Subject To
  c0: x0 + x1 + x3 + x4 = 23
  c1: x1 + x2 + x3 + x4 = 170
  c2: x0 + x1 + x2 = 160
  c3: x0 + x2 + x4 = 167
  c4: x0 + x2 + x3 + x4 = 169

Bounds
  x0 >= 0
  x1 >= 0
  x2 >= 0
  x3 >= 0
  x4 >= 0

Generals
  x0 x1 x2 x3 x4

End
