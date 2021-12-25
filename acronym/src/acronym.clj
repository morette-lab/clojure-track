(ns acronym)

(defn do-acronym [acc list-words]
    (if (empty? list-words) 
      acc
      (let []
        (def new-acc 
          (str acc  
               (->  (get list-words 0)
                    (get 0)
                    (str)
                    (clojure.string/upper-case))))

        (do-acronym new-acc (vec (rest list-words))))))

(defn acronym [phrase] 
  (if (= "" phrase) 
    ""
    (do-acronym 
      "" 
      (clojure.string/split phrase #"\s|-|([a-z](?=[A-Z]))"))))

