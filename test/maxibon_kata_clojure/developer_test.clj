(ns maxibon-kata-clojure.developer-test
  (:require [clojure.test.check.clojure-test :refer [defspec]]
            [clojure.test.check.generators :as gen]
            [clojure.test.check.properties :as prop]
            [maxibon-kata-clojure.developer :refer :all]))

;; generators
(def gen-developer-index
  (gen/choose 0
              (dec (count developers))))

(def gen-developer-name
  (gen/elements (names)))

;; specs
(defspec info-function-searchs-developer-by-name
  100
  (prop/for-all [index gen-developer-index]
    (let [dev (nth developers index)]
      (= dev (info (:name dev))))))

(defspec names-function-returns-valid-developer-names
  100
  (prop/for-all [name gen-developer-name]
    (some #(= name (:name %)) developers)))

(defspec any-developer-should-grab-at-least-0-maxibons
  100
  (prop/for-all [name gen-developer-name,
                 maxibons gen/int]
    (let [dev {:name name,
               :grabs maxibons}]
      (>= (grabs dev) 0))))

(defspec add-developer-function-let-us-search-new-developer-info
  100
  (prop/for-all [name gen-developer-name,
                 maxibons gen/int]
    (let [team (add-developer name maxibons)
          new-developer (info team name)]
      (= name (:name new-developer))
      (= maxibons (:grabs new-developer)))))
