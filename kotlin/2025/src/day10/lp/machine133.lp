Minimize
  obj: x0 + x1 + x2 + x3 + x4

Subject To
  c0: x1 + x3 + x4 = 20
  c1: x0 + x1 + x2 = 123
  c2: x2 + x3 = 124
  c3: x0 + x1 + x2 = 123
  c4: x0 + x4 = 7
  c5: x1 + x4 = 13

Bounds
  x0 >= 0
  x1 >= 0
  x2 >= 0
  x3 >= 0
  x4 >= 0

Generals
  x0 x1 x2 x3 x4

End
