(ns culture.facts-test
  (:require [clojure.edn :as edn]
            [clojure.string :as str]
            [clojure.test :refer [deftest is]]
            [culture.facts :as facts]))

(deftest quito-has-culture-basis
  (let [sb (facts/spec-basis "quito")]
    (is (= 9 (count sb)))
    (is (= (count sb) (count (set (map :culture/id sb)))))
    (is (every? #(str/starts-with? (:culture/url %) "https://") sb))
    (is (every? #(= "quito" (:culture/municipality %)) sb))
    (is (every? #(= "ECU" (:culture/country %)) sb))
    (is (every? #(seq (:culture/summary %)) sb))
    (is (every? #(string? (:culture/retrieved-at %)) sb))))

(deftest unknown-municipality-has-no-basis
  (is (nil? (facts/spec-basis "guayaquil")))
  (is (nil? (facts/spec-basis "zzz"))))

(deftest coverage-is-honest
  (let [c (facts/coverage ["quito" "guayaquil"])]
    (is (= 2 (:requested c)))
    (is (= 1 (:covered c)))
    (is (= ["guayaquil"] (:missing-municipalities c)))))

(deftest by-kind-filters
  (is (= 4 (count (facts/by-kind "quito" :dish))))
  (is (= ["quito.beverage.canelazo"]
         (mapv :culture/id (facts/by-kind "quito" :beverage))))
  (is (empty? (facts/by-kind "quito" :craft)))
  (is (empty? (facts/by-kind "guayaquil" :dish))))

(deftest tx-file-matches-catalog
  (let [tx (edn/read-string (slurp "data/culture-tx.edn"))
        flat (mapcat val (sort-by key facts/catalog))]
    (is (= (vec flat) (vec tx)))))
