(ns clj-montecarlo.core
  (:gen-class)
  (:require
    [clj-montecarlo.picalc :as picalc]))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (let [sep "========================"]
    (println sep)
    (picalc/compute 1000000)))
