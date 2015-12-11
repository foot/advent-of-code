(ns day2.part1
  [:require
   [planck.core :refer [slurp]]
   [clojure.string :refer [split-lines]]])

(defn parse-line [line]
  (-> line
      .trim
      (.split "x")
      (->> (map js/parseInt))))

(defn parse-file [data]
  (->> data
       split-lines
       (map parse-line)))

(defn calculate-wrapping-needs [[l w h]]
  (let [side-sizes [(* l w) (* w h) (* h l)]]
    (+ (apply + (map (partial * 2) side-sizes)) (apply min side-sizes))))

(defn -main []
  (->> (slurp "day2/input")
       parse-file
       (map calculate-wrapping-needs)
       (apply +)
       prn))
