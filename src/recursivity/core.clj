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

(defn slurp-classpath [path] 
  (let [in (.getResourceAsStream (class (Object.)) path)]
    (try (slurp in) (finally (.close in)))
    )
  )

(defn read-csv [txt-contents] 5)