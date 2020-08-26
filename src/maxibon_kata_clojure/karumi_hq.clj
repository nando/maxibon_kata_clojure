(ns maxibon-kata-clojure.karumi_hq
  (:require [maxibon-kata-clojure.developer :as dev :refer :all]))

(defn create-office
  "Creates a new office for Karumi with the name received (:madrid if omitted)"
  ([]
    (create-office :madrid))
  ([name]
    { :name name,
      :maxibons 10 }))

(defn open-fridge
  "One developer opens the office's fridge..."
  ([office developer]
    { :name (:name office),
      :maxibons (- (:maxibons office)
                   (:grabs developer)) }))
