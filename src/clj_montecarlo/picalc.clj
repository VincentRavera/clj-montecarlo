(ns clj-montecarlo.picalc)

;;
;; ACercl = pi * r*r
;; ACarr  =  (2 * r )**2 = 4 r*r

;; ACercl = pi * (r**2 * 4 ) / 4
;; ACercl = pi * ACarr / 4

;; pi = 4 * ACercl / ACarr
;;



(defn picalc
  "PI calculator"
  [numtot]
  (let [calcPI (fn [acircle asquare]
                 (/ (* 4.0 acircle) asquare))
        computeOne (fn []
                     (let [x (rand)
                           y (rand)]
                       (if (< ( + (* x x ) (* y y)) 1)
                         1
                         0)))]
    (calcPI (reduce (fn [x, _]
                      (+ x (computeOne)))
                    0
                    (range numtot))
            numtot)
    ;; ;; A boring loop would be
    ;; (loop [i numtot
    ;;        numcircle 0]
    ;;   (if (= i 0)
    ;;     (calcPI numcircle numtot)
    ;;     (recur (dec i) (+ numcircle (computeOne)))))
    ))

(defn compute
  "Pretty print the pi calc and wraps it"
  [numtot]
  (let [mypi (picalc numtot)
        calc-error (fn [val expected]
                     (/ (Math/abs (- val expected)) expected))]
    (println "My PI is" mypi)
    (println "   PI is" Math/PI)
    (println "Error is" (calc-error mypi Math/PI))))
