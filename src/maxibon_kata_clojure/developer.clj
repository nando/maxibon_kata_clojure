(ns maxibon-kata-clojure.developer)

(def developers [
  { :name "Pedro",
    :grabs 3 },
  { :name "Davide",
    :grabs 0 },
  { :name "Alberto",
    :grabs 1 },
  { :name "Jorge",
    :grabs 2 },
  { :name "Sergio",
    :grabs 1 }])

(defn names
  "Returns a vector with developer names"
  []
  (map #(:name %) developers))

(defn info
  "Receives a developer's name and returns a hash map with her/his data"
  [ name ]
  (some #(and (= name (:name %)) %) developers))
