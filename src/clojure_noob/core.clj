(ns clojure-noob.core
  (:require [flambo.conf :as conf]
            [flambo.api :as f]
            ;; [flambo.streaming :as fs]
           )
  ;; (:require [clj-kafka.zk :as zk])
  (:require [clojure.string :as str])
  (:import (org.apache.spark.streaming StreamingContext)
           (org.apache.spark.streaming.kafka010 KafkaUtils)
           (org.apache.spark.streaming.api.java JavaStreamingContext)
           (org.apache.spark.streaming Duration)
           )
  (:gen-class))


(def master "spark://prashanths-mbp.lan:7077")
(def app-name "kafka stream")
(def conf {})
(def env {
           "spark.executor.memory" "1G",
           "spark.files.overwrite" "true"})

(defn -main
  "This is where the magic happens."
  [& args]
  
  (def cc (-> (conf/spark-conf)
             (conf/app-name "kafka_direct_stream")
             (conf/master master)
             ))
  
  (def scc (JavaStreamingContext. cc (Duration. 1000)))
  ;; (def scc (-> (JavaStreamingContext.)
  ;;              (c)))
;;  (def stream ())
  

  (let [c (-> (conf/spark-conf)
              (conf/master master)
              (conf/app-name "adapters")
              (conf/set "spark.akka.timeout" "300")
              (conf/set-executor-env env))
        ;; ssc (fs/streaming-context c 1000) 

        ;; stream (fs/kafka-direct-stream ssc
        ;;                                str
        ;;                                str
        ;;                                StringDeserializer
        ;;                                StringDeserializer
        ;;                                {:metadata.broker.list "localhost:9092"}
        ;;                                (set '("test"))
        ;;                                )
        ]

    ;; (-> stream 
    ;;     ;; (fs/map (memfn _2))
    ;;     ;; (fs/flat-map (f/fn [l] (s/split l #" ")))
    ;;     (fs/print)
    ;;     )
    
    ;; (.start ssc)
    ;; (.awaitTermination ssc)
    )
  )
