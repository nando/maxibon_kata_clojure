(ns maxibon-kata-clojure.karumi_hq
  (:require [maxibon-kata-clojure.developer :as dev :refer :all]))

(def maxibons-to-buy 10)

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
    (let [maxibons-left (max 0 (- (:maxibons office)
                               (:grabs developer)))]
      { :name (:name office),
        :maxibons (if (> maxibons-left 2)
                     maxibons-left
                     (+ maxibons-left maxibons-to-buy)) })))
