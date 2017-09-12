## Scala Parallel Collection Benchmark

This version is rewrote from source code of [How big should a collection be to go parallel?](http://docs.scala-lang.org/overviews/parallel-collections/performance.html#how-big-should-a-collection-be-to-go-parallel) in Scala Language Doc with [sbt-jmh](https://github.com/ktoso/sbt-jmh).

### Why I rewrite original source code? 
[Because of `scala.testing.Benchmark` is already deprecated](https://github.com/scala/docs.scala-lang/issues/752). I rewrote it with JMH, then we could get more accurate results. 

Reference: 
* [Original Markdown](https://github.com/scala/docs.scala-lang/blob/44840f5/_overviews/parallel-collections/performance.md#how-big-should-a-collection-be-to-go-parallel)
