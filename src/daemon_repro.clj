(ns daemon-repro)

(defn foo [m]
  (let [a (agent 0)]
    (send a inc)
    (await a))

  (->> (mapv #(str (.getName %) " alive=" (.isAlive %) " daemon=" (.isDaemon %))
             (.. Thread getAllStackTraces keySet))
       (filterv #(re-find #"clojure-agent-send.*" %))
       (mapv println)))
