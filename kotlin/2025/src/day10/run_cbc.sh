#!/usr/bin/env bash

total=0

shopt -s nullglob
for lp in lp/*.lp; do
  obj=$(
    cbc "$lp" solve quit \
      | grep "Objective value" \
      | awk '{printf "%d", ($NF + 0.5)}'
  )
  total=$((total + obj))
done

echo $total
