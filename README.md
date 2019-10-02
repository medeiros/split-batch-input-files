# split-batch-input-files

[![CircleCI](https://img.shields.io/circleci/build/github/medeiros/split-batch-input-files/master)](https://circleci.com/gh/medeiros/split-batch-input-files) 
[![Code Size](https://img.shields.io/github/languages/code-size/medeiros/split-batch-input-files)](https://img.shields.io/github/languages/code-size/medeiros/split-batch-input-files)
[![License](https://img.shields.io/github/license/medeiros/split-batch-input-files)](https://img.shields.io/github/license/medeiros/split-batch-input-files)

This library splits a file in several, so an ETL mechanism (like Spring 
Batch) is able to read data in parallel, improving overall performance.

This library would be used in JVM-based applications.

Created in Clojure functional language.

## Todo list:

- add function to remove generated files
- improve unit tests using some cool lib
- ~~add unit tests~~
- ~~add file to Leiningen project, in order to generate a lib jar~~


#### Clojure Style: cheet sheet being adopted:

[CheatSheet URL][https://github.com/bbatsov/clojure-style-guide]

## Installation

    $ lein -uberjar

## Usage

Just call the lib function:

    split-file [file pieces]

And your file will be splitted in pieces.

## Examples

    (split-file "test-file.csv" 3)

- test-file.csv file has five lines
- It will generate:
    - test-file.csv.0: containing 2 lines
    - test-file.csv.1: containing 2 lines
    - test-file.csv.2: containing the remainder 5th line

## License

Copyright © 2019 Daniel Medeiros

Distributed under the MIT License.

