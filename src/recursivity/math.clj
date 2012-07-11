(ns recursivity.math
  )

(defn sqrt [input] (Math/sqrt input))
(defn pow [base, exponent] (Math/pow base exponent))
(def pi Math/PI)
(def e Math/E)

(defn mean [values] (/ (reduce #(+ %1 %2) values ) (count values)))

(defn avg [values] (mean values))

(defn median [values]
  (let [sorted (sort < values)]
    (if (= 0 (rem (count sorted) 2))
      (/ (+ (nth sorted (/ (- (count sorted) 1) 2)) (nth sorted (/ (+ (count sorted) 1) 2))) 2)
      (nth sorted (/ (- (count sorted) 1) 2)))
    )
  )

(defn max-value [values] (reduce #(if (> %1 %2) %1 %2) values))

(defn min-value [values] (reduce #(if (< %1 %2) %1 %2) values))

(defn variance-with-count [values count]
  (let [average (avg values)]
    (reduce
     #(+ %1
         (/
          (pow (- %2 average) 2)
          count))
     0
     values)
    )
  )

(defn variance [values] (variance-with-count values (count values)))

(defn std-dev [values] (rationalize (sqrt (variance values))))

(defn sample-std-dev [values]
  (rationalize (sqrt
   (variance-with-count values (- (count values) 1))
   )))

(defn true-range [high low last-close] (- (max-value [high last-close]) (min-value [low last-close])))

(defn gaussian [mean std-dev value]
    (rationalize (let [first (/ 1 (* std-dev (sqrt (* 2 pi))))
      second (pow e (/ (* -1 (pow (- mean value) 2)) (* 2 (pow std-dev 2))))]
      (* first second)))
  )

(defn sigmoid [value]
  (rationalize (/ 1.0 (+ 1 (pow 1 (* -1 value)))))
  )

(defn euclidian-dist [value-pairs] 
  (sqrt (reduce #(+ %1 (pow (- (nth %2 0) (nth %2 1)) 2)) 0 value-pairs))
  )