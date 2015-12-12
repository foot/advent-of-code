(ns day4.part1
  (:require [planck.core :refer [slurp]]
            [goog.string :as gstring] 
            [clojure.string :as string] 
            [goog.crypt :as crypt])
  (:import [goog.crypt Md5]))

(defn ->hex-hash [data]
  (-> (doto (Md5.)
        (.update data))
      .digest
      crypt/byteArrayToHex))

(defn find-advent-coin [data prefix]
  (->> (map (fn [i] [i (->hex-hash (str data i))]) (range))
       (filter (fn [[i d]] (gstring/startsWith d prefix)))
       first
       first))

(defn main [n]
  (-> "ckczppom"
      (find-advent-coin (string/join (take n (repeat 0))))
      prn))

(defn -main []
  (main 5))
