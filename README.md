## Scala Parallel Collection Benchmark

This version is rewrote from source code of [How big should a collection be to go parallel?](http://docs.scala-lang.org/overviews/parallel-collections/performance.html#how-big-should-a-collection-be-to-go-parallel) in Scala Language Doc with [sbt-jmh](https://github.com/ktoso/sbt-jmh).

### Why I rewrite original source code? 
[Because of `scala.testing.Benchmark` is already deprecated](https://github.com/scala/docs.scala-lang/issues/752). I rewrote it with JMH, then we could get more accurate results. 

Environment:
* CPU: E3-1231 v3 without hyper-threading and turbo boost
* RAM: 16G, I allocated 8G for each benchmark.
* OS: Debian 8 with limitation(2.5GHz) of CPU frequency.
* JVM: Oracle 1.8.0_144-b01
* Scala: 2.12.3

Result:
```
[info] MapBench.map           120000       N/A  thrpt   45    91.299 ±   1.214  ops/s
[info] MapBench.map            15000       N/A  thrpt   45   702.102 ±   1.874  ops/s
[info] ParMapBench.map        120000         1  thrpt   45    98.208 ±   0.464  ops/s
[info] ParMapBench.map        120000         2  thrpt   45   188.050 ±   1.217  ops/s
[info] ParMapBench.map        120000         4  thrpt   45   287.804 ±   2.439  ops/s
[info] ParMapBench.map         15000         1  thrpt   45   872.125 ±   2.228  ops/s
[info] ParMapBench.map         15000         2  thrpt   45  1578.931 ±   8.447  ops/s
[info] ParMapBench.map         15000         4  thrpt   45  2556.409 ±  14.718  ops/s
[info] ParVectorBench.reduce  250000         1  thrpt   45   582.542 ±  12.397  ops/s
[info] ParVectorBench.reduce  250000         2  thrpt   45   655.938 ±  12.524  ops/s
[info] ParVectorBench.reduce  250000         4  thrpt   45   927.864 ±   7.750  ops/s
[info] ParVectorBench.reduce  120000         1  thrpt   45   944.875 ± 137.443  ops/s
[info] ParVectorBench.reduce  120000         2  thrpt   45  1481.952 ±  34.182  ops/s
[info] ParVectorBench.reduce  120000         4  thrpt   45  2468.674 ±  42.307  ops/s
[info] VectorBench.reduce     250000       N/A  thrpt   45   495.297 ±   1.650  ops/s
[info] VectorBench.reduce     120000       N/A  thrpt   45  1116.625 ±   2.346  ops/s
```

References: 
* [Original Markdown](https://github.com/scala/docs.scala-lang/blob/44840f5/_overviews/parallel-collections/performance.md#how-big-should-a-collection-be-to-go-parallel)
