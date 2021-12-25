(ns reverse-string)

(defn reverse-string [s]
  (clojure.string/join "" (reverse (seq s))))
