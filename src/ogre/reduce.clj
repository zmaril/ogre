(ns ogre.reduce
  (:refer-clojure :exclude [count])
  (:use ogre.util)
  (:import (com.tinkerpop.gremlin.java GremlinPipeline)
           (com.tinkerpop.pipes.util.structures Pair)))

(defn gather
  ([^GremlinPipeline p] (.gather p))
  ([^GremlinPipeline p f] (.gather p (f-to-pipef f))))

(defn order
  ([^GremlinPipeline p] (.order p))
  ([^GremlinPipeline p compare]
     (.order p (f-to-pipef (fn [^Pair pair]                                      
                             (compare (.getA pair)
                                      (.getB pair)))))))
;; (defn order-decr
;;   ([p] (.order p )))

(defn count! [^GremlinPipeline p]
  (.count p))
