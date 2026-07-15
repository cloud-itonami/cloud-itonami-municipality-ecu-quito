(ns ordinance.facts-test
  (:require [clojure.string :as str]
            [clojure.test :refer [deftest is]]
            [ordinance.facts :as facts]))

(deftest quito-has-spec-basis
  (let [sb (facts/spec-basis "quito")]
    (is (= 2 (count sb)))
    (is (every? #(str/starts-with? (:ordinance/url %) "https://www.gob.ec/") sb))))

(deftest unknown-municipality-has-no-spec-basis
  (is (nil? (facts/spec-basis "guayaquil")))
  (is (nil? (facts/spec-basis "zzz"))))

(deftest coverage-is-honest
  (let [c (facts/coverage ["quito" "guayaquil"])]
    (is (= 2 (:requested c)))
    (is (= 1 (:covered c)))
    (is (= ["guayaquil"] (:missing-municipalities c)))))

(deftest by-topic-filters
  (is (= ["quito.ordenanza-090-2025-tasas-residuos"]
         (mapv :ordinance/id (facts/by-topic "quito" :environment))))
  (is (empty? (facts/by-topic "quito" :labor)))
  (is (empty? (facts/by-topic "guayaquil" :governance))))
