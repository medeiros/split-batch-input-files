(defn split-file
	[file pieces]
	(let [data (clojure.string/split-lines(slurp file))]
		(let [partition-data (partition-all (/ (count data) pieces) data)]
			(loop [i 0]
				(if (< i (count partition-data))
					(let [file-name (str file "." i)]
						(println (str "generating: " file-name))
						(spit file-name (clojure.string/join "\n" (nth partition-data i)))
						(recur (inc i)))
					(println "no more"))))))
