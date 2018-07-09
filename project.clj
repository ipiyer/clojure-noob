(defproject clojure-noob "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 ]
  :main ^:skip-aot clojure-noob.core
  :target-path "target/%s"
  :aot [clojure-noob.core]
  :profiles {:uberjar {:aot :all}
             :provided
             {:dependencies
              [
                [org.clojure/clojure "1.8.0"]
                 [yieldbot/flambo "0.8.2"]
                 [org.apache.spark/spark-streaming_2.11 "2.2.2"]
                 [org.apache.spark/spark-streaming-kafka-0-10_2.11 "2.2.2"]
                 [org.apache.spark/spark-streaming-kafka-0-10-assembly_2.10 "2.2.2"]
                 [clj-kafka "0.3.4"]
               ]
              }})
