(ns day2.part2
  [:require
   [planck.core :refer [slurp]]
   [day2.part1 :refer [parse-file]]])

(defn calculate-ribbon-length [dimensions]
  (let [smallest-sides (take 2 (sort dimensions))
        circumference-length (apply + (map (partial * 2) smallest-sides))
        bow-length (apply * dimensions)]
    (+ circumference-length bow-length)))

(defn -main []
  (->> (slurp "day2/input")
       parse-file
       (map calculate-ribbon-length)
       (apply +)
       prn))
