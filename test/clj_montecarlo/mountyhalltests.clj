(ns clj-montecarlo.mountyhalltests
  (:require [clj-montecarlo.mountyhall :as sut]
            [clojure.test :as t]))

(t/deftest testPickAGoat
  (t/testing "Picking a goat that is not picked and not the prize"
    (t/is (= 2
          (sut/pickAGoat (range 3) 0 1)))))

(t/deftest testSwitch
  (t/testing "Tesing the switch decision"
    (t/is (let [current (sut/pickADoor (range 3))]
            (not (= current (sut/decisionAlwaysSwitch '(0 2) current)))))))
