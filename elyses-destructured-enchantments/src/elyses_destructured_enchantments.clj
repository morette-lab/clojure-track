(ns elyses-destructured-enchantments)

(defn first-card
  "Returns the first card from deck."
  [deck]
  (let [[first-item] deck]
    first-item))

(defn second-card
  "Returns the second card from deck."
  [deck]
  (let [[first-item second-item] deck]
    second-item))

(defn swap-top-two-cards
  "Returns the deck with first two items reversed."
  [deck]
  (let [[first-item second-item & rest-deck] deck]
    (vec (conj rest-deck first-item second-item))))

(defn discard-top-card
  "Returns a vector containing the first card and
   a vector of the remaining cards in the deck."
  [deck]
  (let [[first-item & rest-deck] deck]
    (if (nil? rest-deck) 
      (vector first-item nil) 
      (vector first-item (vec rest-deck)))))

(def face-cards
  ["jack" "queen" "king"])

(defn insert-face-cards
  "Returns the deck with face cards between its head and tail."
  [deck]
  (if (empty? deck) 
    face-cards
    (let [[first-item & rest-deck] deck]
      (if (nil? rest-deck) 
        (vec (flatten (conj [first-item] face-cards)))
        (vec (flatten (conj [first-item] face-cards rest-deck)))))))
