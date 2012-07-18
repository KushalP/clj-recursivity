(ns recursivity.core)

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

(defn classpath-resource [func path]
  (let [in (.getResourceAsStream (class (Object.)) path)]
    (try (func in) (finally (.close in)))
    ))

(defn slurp-classpath [path] 
  (classpath-resource slurp path)
  )


(defn get-value [input]
  (if 
    (instance? clojure.lang.Symbol (read-string input))
      input
      (read-string input)
      ))

(defmulti get-lines (fn [input & args] (type input)))

(defmethod get-lines String 
  ([text] (get-lines text (System/getProperty "line.separator")))
  ([text separator]
    (seq (.split text separator)))
  )

(defmethod get-lines java.io.InputStream 
  ([in] (get-lines in (System/getProperty "line.separator")))
  ([in separator]
    (try (get-lines (slurp in)) (finally (.close in)))
  ))


(defmulti csv (fn [input & args] (type input)))
(defmethod csv clojure.lang.Sequential 
  ([input] (csv input ","))
  ([input separator] (map #(.split %1 separator) input))
  )
(defmethod csv String ([input] (csv input ","))
  ([input separator] (csv (get-lines input) separator))
  )
(defmethod csv java.io.InputStream ([input] (csv input ","))
  ([input separator] (csv (slurp input) separator))
  )

;; properties?



