Minimize
  obj: x0 + x1 + x2 + x3 + x4 + x5 + x6 + x7 + x8

Subject To
  c0: x3 + x4 = 7
  c1: x0 + x3 + x6 + x7 = 48
  c2: x3 + x6 + x8 = 37
  c3: x0 + x3 + x4 + x5 + x7 + x8 = 58
  c4: x0 + x4 + x6 + x7 + x8 = 56
  c5: x2 + x3 + x7 = 33
  c6: x1 + x6 + x7 + x8 = 69
  c7: x1 + x2 + x3 + x7 = 51
  c8: x3 + x4 + x6 + x7 = 45
  c9: x1 + x3 + x4 + x5 + x6 = 57

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
