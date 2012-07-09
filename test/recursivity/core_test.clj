(ns recursivity.core-test
  (:use [recursivity.core])
  (:use [expectations])
  )

(expect 6 (avg [3 5 10]))
(expect 6 (avg '(3 5 10)))

(expect 23 (max-value '(10 5 3 15 23 12)))

(expect  3 (min-value '(10 5 3 15 23 12)))

(expect 10 (median '(10 5 3 23 12)))
(expect 11 (median '(10 5 3 15 23 12)))
(expect 4 (median '(5 3)))

(expect 21704 (variance '(600 470 170 430 300)))

(expect  2N (std-dev '(2 4 4 4 5 5 7 9)))

(expect 427617987059879/200000000000000 (sample-std-dev '(2 4 4 4 5 5 7 9))) ; appr 2.138089935299395

(expect 0.9100000000000037 (true-range 48.7 47.79 48.16))

(expect (rationalize 0.5) (sigmoid 0))

(expect  (rationalize 0.03401870545760999) (gaussian 73 6.2 66))

(expect 20.518284528683193 (euclidian-dist [[3 18] [104 90]]))

