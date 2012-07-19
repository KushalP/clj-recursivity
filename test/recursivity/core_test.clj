(ns recursivity.core-test
  (:use [recursivity.core])
  (:use [expectations])
  )

(expect 8 (m-bind #(+ 5 %1) 3))
(expect nil (m-bind #(+ 5 %1) nil))

(expect 3 (get-or-else 3 5))
(expect 5 (get-or-else nil 5))
(expect 5 (get-or-else nil #(+ 2 3)))

(expect true (.contains (slurp-classpath "/test.txt") "hello world"))
(expect true (.contains (slurp-classpath "/test.txt") "bye cruel world"))

(expect 2 (count (get-lines (slurp-classpath "/test.txt"))))
(expect 2 (count (get-lines (.getResourceAsStream (class (Object.)) "/test.txt"))))

(expect 14 (count (csv (get-lines (slurp-classpath "/tennis.csv")))))

(expect 5 (count (nth (csv (get-lines (slurp-classpath "/tennis.csv"))) 0)))

(expect "high" (nth (nth (csv (get-lines (slurp-classpath "/tennis.csv"))) 4) 2))

(expect "high" (nth (nth (classpath-resource csv "/tennis.csv") 4) 2))

(expect "high" (nth (nth (csv (slurp-classpath "/tennis.csv")) 4) 2))

(expect "male" (nth (nth (classpath-resource csv "/numerical-bayes.csv") 0) 0))

(expect 6 (nth (nth (classpath-resource csv "/numerical-bayes.csv") 0) 1))

(expect "hello" (get-value "hello"))

(expect 5 (get-value "5"))

(def props (properties (slurp-classpath "/test.properties")))
(def inprops (classpath-resource properties "/test.properties"))

(expect "world" (:hello props))
(expect "www.google.com" (:some.host props))
(expect 80 (:port props))

(expect "world" (:hello inprops))
(expect "www.google.com" (:some.host inprops))
(expect 80 (:port inprops))
