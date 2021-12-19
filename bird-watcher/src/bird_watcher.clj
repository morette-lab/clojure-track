(ns bird-watcher)

(def last-week 
  [0 2 5 3 7 8 4])

(defn today [birds]
  (last birds))

(defn inc-bird [birds]
  (def last-item (peek birds))
  (conj (pop birds) (+ last-item 1)))

(defn day-without-birds? [birds]
  (if (= nil (some zero? birds)) false true))

(defn n-days-count [birds n]
  (reduce (fn [acc n] 
            (+ n acc)) 0
    (subvec birds 0 n)))

(defn busy-days [birds]
  (reduce (fn [acc n] 
            (if (>= n 5) (+ acc 1) acc)) 0 birds))

(defn odd-week? [birds]
  (def week (reduce (fn [acc n]
            (if (or (odd? n) (zero? n)) 
              (conj acc true) 
              (conj acc false))) 
          [true] birds))
  (every? true? week))
