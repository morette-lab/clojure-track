(ns anagram
  (:require [clojure.string :refer [lower-case]]))

(defn anagrams-for [word prospect-list]
 (filter (fn [item]
           (let [wlc (lower-case word)
                 ilc (lower-case item)]
             (and 
               (not= wlc ilc) 
               (= 
                 (sort (lower-case ilc)) 
                 (sort (lower-case wlc)))))) 
         prospect-list))
