(ns recursivity.core
  (import [clojure.lang Associative Sequential]))

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

(defn get-lines 
  ([text] (get-lines text (System/getProperty "line.separator")))
  ([text separator]
    (seq (.split text separator)))
  )


(defn read-csv 
  ([input] (read-csv input ","))
  ([input separator] (map #(.split %1 separator) input))
  )


(defmulti csv type)
(defmethod csv Sequential ([input] (read-csv input ","))
  ([input separator] (read-csv input separator))
  )
(defmethod csv String ([input] (read-csv (get-lines input) ","))
  ([input separator] (read-csv (get-lines input) separator))
  )
(defmethod csv java.io.InputStream ([input] (read-csv (get-lines (slurp input)) ","))
  ([input separator] (read-csv (get-lines (slurp input)) separator))
  )


;(defmethod foo String [s] :a-string)



