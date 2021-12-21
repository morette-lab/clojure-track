(ns flatten-array)

(defn do-flatten [arr acc-param]
  (reduce (fn [acc item]
            (if (vector? item) 
              (do-flatten item acc) 
              (if (nil? item) 
                acc
                (conj acc item))))
          acc-param arr))

(defn flatten [arr]
  (do-flatten arr []))


