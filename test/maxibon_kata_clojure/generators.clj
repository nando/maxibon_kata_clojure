(ns maxibon-kata-clojure.generators
  (:require [clojure.test.check.generators :as gen]
            [maxibon-kata-clojure.developer :refer :all]
            [maxibon-kata-clojure.karumi_hq :refer :all]))

(def gen-developer-index
  (gen/choose 0
              (dec (count developers))))

(def gen-developer-name
  (gen/elements (names)))

(def gen-developer-from-csv
  (gen/elements developers))

(def gen-unpredictible-developer
  (gen/fmap (fn [[name maxibons]]
              { :name name
                :grabs maxibons
                :origin :unpredictible-developers })
            (gen/tuple gen-developer-name
                       gen/small-integer)))

(def gen-group-of-developers
  (gen/let [ n (gen/choose 2 6)]
     (gen/vector gen-developer-from-csv n)))

(def gen-non-empty-string
  (let [chars "abcdefghijklmnopqrstuvwxyz0123456789"]
    (gen/let [cs (gen/list (gen/elements chars))]
      (apply str (rand-nth chars) cs))))

(def gen-office
  (gen/let [name gen-non-empty-string]
    (create-office name)))
