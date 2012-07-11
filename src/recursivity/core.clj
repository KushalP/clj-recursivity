(ns recursivity.core
  )

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