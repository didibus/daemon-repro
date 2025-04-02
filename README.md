Reproducing what appears to be a bug with clojure -X and clj -X, where it does not replace the agent pooledExecutor with one that has daemon thread, and therefore -X invocations that used the agent pooledExecutor never terminate (or maybe take a long time, I didn't have the patience to wait).

Run it with: `clojure -X:foo`

Issue in this repro happens with Clojure CLI Version: 1.12.0.1530
