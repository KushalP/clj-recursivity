(ns recursivity.core
  (:require clojure.contrib.math)
  )

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
          (clojure.contrib.math/expt (- %2 average) 2)
          count))
     0
     values)
    )
  )

(defn variance [values] (variance-with-count values (count values)))

(defn std-dev [values] (rationalize (Math/sqrt (variance values))))

(defn sample-std-dev [values]
  (rationalize (Math/sqrt
   (variance-with-count values (- (count values) 1))
   )))

(defn gaussian [mean std-dev value] 5)

(defn sigmoid [value] 5)

(defn true-range [high low last-close] (- (max-value [high last-close]) (min-value [low last-close])))

(defn m-bind [function value]
  (if (nil? value)
    nil
    (function value)))

(defn get-or-else [value default]
  (if (nil? value)
    (if (ifn? default)
      (default)
      default)
    value))

(defn slurp-classpath [path] 5)

(defn read-csv [txt-contents] 5)