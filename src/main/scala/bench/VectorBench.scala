package bench

import org.openjdk.jmh.annotations._

@BenchmarkMode(scala.Array(Mode.Throughput))
@Fork(value = 3, jvmArgs = scala.Array("-server", "-Xms8G", "-Xmx8G", "-XX:+AlwaysPreTouch", "-XX:+UseG1GC"))
@Warmup(iterations = 15)
@Measurement(iterations = 15)
@State(Scope.Benchmark)
class VectorBench {

  @Param(scala.Array("250000", "120000"))
  var size: Int = _

  var vector: Vector[Int] = _

  @Setup(Level.Trial)
  def init: Unit = {
    vector = Vector((0 until size): _*)
  }

  @Benchmark
  def reduce: Unit = {
    vector.reduce((a, b) ⇒ a + b)
  }
}
