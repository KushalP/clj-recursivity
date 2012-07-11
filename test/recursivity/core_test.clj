(ns recursivity.core-test
  (:use [recursivity.core])
  (:use [expectations])
  )

(expect 8 (m-bind #(+ 5 %1) 3))
(expect nil (m-bind #(+ 5 %1) nil))

(expect 3 (get-or-else 3 5))
(expect 5 (get-or-else nil 5))

