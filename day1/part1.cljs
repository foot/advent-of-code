(ns day1.part1
  (:require [planck.core :refer [slurp]]))

(def table {"(" 1 ")" -1})

(->> (slurp "part1-input")
    .trim
    (group-by identity)
    (map (fn [[k v]] k (* (get table k) (count v))))
    (apply +)
    prn)
