(ns split-batch-input-files.split-file-test
  (:require [clojure.test :refer :all]
            [split-batch-input-files.split-file :refer :all]
            [clojure.java.io :as jio]))

(deftest should-partition-data-from-file
  (testing "FIXME, I fail."
    (let [data (partitioned-data-from-file (jio/file (jio/resource "test-file.csv")), 3)]
      (is (= (count data) 3))
      (is (= (count (nth data 0)) 1))
      (is (= (count (nth data 1)) 2))
      (is (= (count (nth data 2)) 1)))))
