Minimize
  obj: x0 + x1 + x2 + x3 + x4 + x5 + x6 + x7 + x8

Subject To
  c0: x0 + x1 + x2 + x3 + x4 + x5 + x6 = 64
  c1: x0 + x3 + x4 + x5 + x7 + x8 = 59
  c2: x0 + x2 + x4 + x6 + x7 = 45
  c3: x0 + x2 + x4 + x5 + x6 + x7 + x8 = 74
  c4: x0 + x3 + x6 + x8 = 47
  c5: x6 + x7 + x8 = 45
  c6: x1 + x2 = 18
  c7: x2 + x4 + x6 + x7 = 45
  c8: x4 + x5 + x6 = 33

Bounds
  x0 >= 0
  x1 >= 0
  x2 >= 0
  x3 >= 0
  x4 >= 0
  x5 >= 0
  x6 >= 0
  x7 >= 0
  x8 >= 0

Generals
  x0 x1 x2 x3 x4 x5 x6 x7 x8

End
