Minimize
  obj: x0 + x1 + x2 + x3 + x4 + x5 + x6 + x7 + x8

Subject To
  c0: x0 + x1 + x2 + x7 + x8 = 88
  c1: x1 + x3 + x5 + x7 + x8 = 71
  c2: x2 + x6 + x7 = 41
  c3: x3 + x5 + x8 = 37
  c4: x4 + x5 + x8 = 180
  c5: x3 + x4 + x5 + x8 = 196
  c6: x1 + x5 + x6 = 25

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
