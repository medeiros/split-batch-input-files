;; https://github.com/bbatsov/clojure-style-guide

(use '[clojure.string :only [split-lines join]])

(defn- partitioned-data-from-file
  "Load a file and return it as a partitioned list."
  [file pieces]
  (let [data (split-lines (slurp file))]
    (partition-all (/ (count data) pieces) data)))

(defn- generate-file
  "Create partial file based on index."
  [file i partition-data]
  (let [file-name (str file "." i)]
    (printf "generating: %s\n" file-name)
    (spit file-name (join "\n" (nth partition-data i)))))

(defn split-file
  "Split a given file in several files.
   Generates several files with standard sequential
   numbering, starting at zero.
   Created for parallel processing of files."
  [file pieces]
  (let [partition-data (partitioned-data-from-file file pieces)]
    (map #(generate-file file % partition-data)
          (range 0 (count partition-data)))))

;; todo: add function to remove generated files
;; todo: add unit test
;; todo: add to leiningen to generate jar lib
