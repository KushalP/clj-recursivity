(ns recursivity.core-test
  (:use [recursivity.core])
  (:use [clojure.test])
  )

(deftest calculates-avg
  (is (= 6 (avg [3 5 10])))
  (is (= 6 (avg '(3 5 10)))))

(deftest calculate-max
  (is (= 23 (max-value '(10 5 3 15 23 12))))
  )

(deftest calculate-min
  (is (= 3 (min-value '(10 5 3 15 23 12)))))

(deftest calculate-median
  (is (= 10 (median '(10 5 3 23 12))))
  (is (= 11 (median '(10 5 3 15 23 12))))
  (is (= 4 (median '(5 3))))
  )

(deftest calc-variance
  (is (= 21704 (variance '(600 470 170 430 300)))))

(deftest calc-std-dev
  (is (= 2N (std-dev '(2 4 4 4 5 5 7 9))))
  )

(deftest calc-sample-std-dev
  (is (= 427617987059879/200000000000000 (sample-std-dev '(2 4 4 4 5 5 7 9)))) ; appr 2.138089935299395
  )

(deftest calc-truerange
  (is (= 0.9100000000000037 (true-range 48.7 47.79 48.16)))
  )

(deftest calc-sigmoid
  (is (= (rationalize 0.5) (sigmoid 0))))

(deftest calc-gaussian
  (is (= (rationalize 0.03401870545760999) (gaussian 73 6.2 66))))

(deftest calc-euclidian-dist
  (is (= 20.518284528683193 (euclidian-dist [3 18 104 90]))))
