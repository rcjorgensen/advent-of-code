Minimize
  obj: x0 + x1 + x2 + x3 + x4 + x5

Subject To
  c0: x0 + x5 = 5
  c1: x0 + x2 + x5 = 25
  c2: x1 = 17
  c3: x0 + x1 + x2 + x4 = 57
  c4: x1 + x2 + x3 + x4 = 53
  c5: x3 + x5 = 1

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
