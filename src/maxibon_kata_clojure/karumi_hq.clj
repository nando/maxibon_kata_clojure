(ns maxibon-kata-clojure.karumi_hq)

(defn create-office
  "Creates a new office for Karumi with the name received (:madrid if omitted)"
  ([]
    (create-office :madrid))
  ([name]
    { :name name,
      :maxibons 10 }))
