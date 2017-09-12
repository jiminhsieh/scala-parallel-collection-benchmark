package benchmark

import org.openjdk.jmh.annotations._

@BenchmarkMode(scala.Array(Mode.Throughput))
@Fork(value = 3, jvmArgs = scala.Array("-server", "-Xms8G", "-Xmx8G", "-XX:+AlwaysPreTouch", "-XX:+UseG1GC"))
@Warmup(iterations = 15)
@Measurement(iterations = 15)
@State(Scope.Benchmark)
class MapBench {

  @Param(scala.Array("120000", "15000"))
  var size: Int = _

  var hashMap: collection.mutable.HashMap[Int, Int] = _

  @Setup(Level.Trial)
  def init = {
    hashMap = collection.mutable.HashMap((0 until size) zip (0 until size): _*)
  }

  @Benchmark
  def map = {
    hashMap.map(kv => kv)
  }

}
