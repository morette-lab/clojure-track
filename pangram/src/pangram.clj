(ns pangram
  (:require [clojure.string :as str]))

(defn int->string 
  [number]
  (str (char number)))

(defn pangram? [sentence]
  (def polished-sentence
    (-> 
      (str/replace sentence #"\s" "")
      (str/lower-case)
      (str/split #"")
      (set)))

  (empty? (filter (fn [uni-alph]
            (let [str-uni-alph (int->string uni-alph)]
              (if (contains? polished-sentence str-uni-alph)
                (let []
                  (disj polished-sentence str-uni-alph)
                  false)
                true)))
            (range 97 122))))

