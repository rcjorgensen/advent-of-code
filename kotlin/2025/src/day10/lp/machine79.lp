Minimize
  obj: x0 + x1 + x2 + x3 + x4 + x5 + x6 + x7 + x8

Subject To
  c0: x1 + x4 + x5 + x6 = 63
  c1: x1 + x4 + x5 + x6 + x7 + x8 = 80
  c2: x0 + x2 + x4 + x5 + x8 = 64
  c3: x3 + x5 + x7 + x8 = 51
  c4: x1 + x2 + x4 + x6 + x8 = 58
  c5: x1 + x4 + x6 + x8 = 57
  c6: x0 + x2 + x5 + x8 = 49
  c7: x2 + x3 + x4 + x5 + x6 + x8 = 78

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
