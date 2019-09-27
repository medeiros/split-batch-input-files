(defn split-file
			"Split a file in several pieces, generating several files
       with standard sequential numbering, starting at zero.
       Created for parallel processing of files."
			[file pieces]
			(let [data (split-lines (slurp file))
						partition-data (partition-all (/ (count data) pieces) data)]
					 (loop [i 0]
								 (if (< i (count partition-data))
									 (let [file-name (str file "." i)]
												(printf "generating: %s\n" file-name)
												(spit file-name (join "\n" (nth partition-data i)))
												(recur (inc i)))))))