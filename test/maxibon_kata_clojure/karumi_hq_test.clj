(ns maxibon-kata-clojure.karumi_hq-test
  (:require [clojure.test.check.clojure-test :refer [defspec]]
            [clojure.test.check.generators :as gen]
            [clojure.test.check.properties :as prop]
            [maxibon-kata-clojure.generators :refer :all]
            [maxibon-kata-clojure.karumi_hq :refer :all]))

(defspec office-should-start-the-day-with-at-least-10-maxibons
         100
         (prop/for-all [office gen-office]
           (= 10 (:maxibons office))))
