(ns maxibon-kata-clojure.developer
  (:require [maxibon-kata-clojure.csv :as csv :refer :all]))

(def developers (csv/load_developers "Karumies"))

(defn add-developer
  "Returns 'developers' with the new developer added"
  [ name grabs ]
  (conj developers { :name name
                     :grabs grabs }))

(defn grabs
  "Returns the number of maxibons the developer likes to grab (if possible!!)"
  [info]
  (max 0 (:grabs info)))

(defn names
  "Returns a vector with developer team names (Karumies if ommited!!)"
  []
  (map #(:name %) developers))

(defn info
  "Receives a developer's name and returns a hash map with her/his data"
  ([ name ]
   (some #(and (= name (:name %)) %) developers))
  ([ team name ]
   (some #(and (= name (:name %)) %) team)))
