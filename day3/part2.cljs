(ns day3.part2
  [:require
   [planck.core :refer [slurp]]
   [day3.part1 :refer [initial-location move parse-input]]])

(defn every-other [data]
  (->> data
       (map-indexed vector)
       (group-by (fn [[i v]] (or (zero? i) (even? i))))
       vals
       (map vals)))

(->> (slurp "day3/input")
     parse-input
     every-other
     (mapcat (partial reductions move initial-location))
     (group-by identity)
     count  
     prn)
