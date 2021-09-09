(ns clj-montecarlo.mountyhall)

(defn pickADoor
  "Pick any door"
  [doors]
  (rand-nth doors))

(defn pickAGoat
  "Pick any door that is not picked or a car"
  [doors picked prize]
  (let [notpicked (fn [x] (not (= x picked)))
        notprize (fn [x] (not (= x prize)))]
    (rand-nth (filter notpicked (filter notprize doors)))))

(defn decisionAlwaysSwitch
  "Always switch"
  [doors current]
  (let [filterCurrent (fn [x] (not (= x current)))]
    (rand-nth (filter filterCurrent doors))))

(defn decisionAlwaysKeep
  "Always keep"
  [_ current]
  current)

(defn computeone
   "Compute a montyhall"
  [numofdoors decision]
  (let [doors (range numofdoors)
        current (pickADoor doors)
        prize (pickADoor doors)
        goat (pickAGoat doors current prize)
        filterGoat (fn [x] (not (= goat x)))]
    (if (= (decision (filter filterGoat doors) current) prize)
      1
      0)))

(defn mean
  "Compute mean in a list"
  [mylist]
  (/ (reduce + mylist) (count mylist)))

(defn compute
  "Compute a number of times"
  [numtot]
  (let [numofdoor 3
        decision decisionAlwaysSwitch
        mapcomputer (fn [_] (computeone numofdoor decision))
        games (map mapcomputer (range numtot))]
    (println "MontyHall number of games: " numtot)
    (println "MontyHall number of doors: " numofdoor)
    (println "MontyHall success rate: " (* 100.0 (mean games)) "%")))
