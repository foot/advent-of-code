(ns day3.part1
  [:require [planck.core :refer [slurp]]])

(def initial-location [0 0])

(def table {"^" [0 1]
            "v" [0 -1]
            "<" [-1 0]
            ">" [1 0]})

(defn move [[x y] [dx dy]]
  [(+ x dx) (+ y dy)])

(defn parse-input [data]
  (->> data
       .trim
       (map table)))

(defn -main []
  (->> (slurp "day3/input")
       parse-input
       (reductions move initial-location)
       (group-by identity)
       count
       prn))
