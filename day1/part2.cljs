(ns day1.part1
  (:require [planck.core :refer [slurp]]))

(def table {"(" 1 ")" -1})

(->> (slurp "part1-input")
     .trim
     (map table)
     (reductions +)
     (take-while (partial <= 0))
     count
     (+ 1)
     prn)
