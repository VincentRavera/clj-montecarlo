(ns clj-montecarlo.core
  (:gen-class)
  (:require
   [clj-montecarlo.picalc :as picalc]
   [clj-montecarlo.mountyhall :as mh]))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (let [sep "========================"]
    (println sep)
    (picalc/compute 10000)
    (println sep)
    (mh/compute 10000)
    ))
