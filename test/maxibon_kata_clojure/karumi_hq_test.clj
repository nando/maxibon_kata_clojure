(ns maxibon-kata-clojure.karumi_hq-test
  (:require [clojure.test.check.clojure-test :refer [defspec]]
            [clojure.test.check.generators :as gen]
            [clojure.test.check.properties :as prop]
            [maxibon-kata-clojure.karumi_hq :refer :all]))

;;;;;;;;;;;;;;;;
;; generators ;;
;;;;;;;;;;;;;;;;

(def gen-non-empty-string
  (let [chars "abcdefghijklmnopqrstuvwxyz0123456789"]
    (gen/let [cs (gen/list (gen/elements chars))]
      (apply str (rand-nth chars) cs))))

(def gen-office
  (gen/let [name gen-non-empty-string]
    (create-office name)))

;;;;;;;;;;;
;; specs ;;
;;;;;;;;;;;

(defspec office-should-start-the-day-with-at-least-10-maxibons
         100
         (prop/for-all [office gen-office]
           (= 10 (:maxibons office))))
