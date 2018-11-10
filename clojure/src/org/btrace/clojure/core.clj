(ns org.btrace.clojure.core
  (:require [clojure.core.async :as async]))

(defn start-go-loop []
  (let [ch (async/chan)]
    (async/go-loop []
      (when-let [v (async/<! ch)]
        (printf "ROB: loop received v:%s\n" v)
        (recur)))
    ch))
