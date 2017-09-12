package benchmark

import java.util.concurrent.ForkJoinPool

import org.openjdk.jmh.annotations._

import scala.collection.parallel.ForkJoinTaskSupport
import scala.collection.parallel.mutable.ParHashMap

@BenchmarkMode(scala.Array(Mode.Throughput))
@Fork(value = 3, jvmArgs = scala.Array("-server", "-Xms8G", "-Xmx8G", "-XX:+AlwaysPreTouch", "-XX:+UseG1GC"))
@Warmup(iterations = 15)
@Measurement(iterations = 15)
@State(Scope.Benchmark)
class ParMapBench {

  @Param(scala.Array("120000", "15000"))
  var size: Int = _

  @Param(scala.Array("1", "2", "4"))
  var thread: Int = _

  var parHashMap: ParHashMap[Int, Int] = _

  @Setup(Level.Trial)
  def init = {
    parHashMap = ParHashMap((0 until size) zip (0 until size): _*)
    parHashMap.tasksupport = new ForkJoinTaskSupport(new ForkJoinPool(thread))
  }

  @Benchmark
  def map = {
    parHashMap.map(kv => kv)
  }

}
