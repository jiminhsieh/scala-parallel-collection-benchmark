package benchmark

import java.util.concurrent.ForkJoinPool

import org.openjdk.jmh.annotations._

import scala.collection.parallel.ForkJoinTaskSupport
import scala.collection.parallel.immutable.ParVector

@BenchmarkMode(scala.Array(Mode.Throughput))
@Fork(value = 3, jvmArgs = scala.Array("-server", "-Xms8G", "-Xmx8G", "-XX:+AlwaysPreTouch", "-XX:+UseG1GC"))
@Warmup(iterations = 15)
@Measurement(iterations = 15)
@State(Scope.Benchmark)
class ParVectorBench {

  @Param(scala.Array("250000", "120000"))
  var size: Int = _

  @Param(scala.Array("1", "2", "4"))
  var thread: Int = _

  var parVector: ParVector[Int] = _


  @Setup(Level.Trial)
  def init: Unit = {
    parVector = ParVector((0 until size): _*)
    parVector.tasksupport = new ForkJoinTaskSupport(new ForkJoinPool(thread))
  }

  @Benchmark
  def reduce: Unit = {
    parVector.reduce((a, b) ⇒ a + b)
  }

}
