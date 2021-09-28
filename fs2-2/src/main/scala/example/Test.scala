package example

import cats.data.EitherT
import cats.effect.{Blocker, IO}
import scala.concurrent.ExecutionContext
import scala.concurrent.duration._

object Test {
  implicit val cs = IO.contextShift(ExecutionContext.global)
  implicit val tmr = IO.timer(ExecutionContext.global)
  val blocker = Blocker.liftExecutionContext(ExecutionContext.global)

  def main(args: Array[String]): Unit =
    println(fs2.io.readOutputStream(blocker, 1)(_ => EitherT.left[Unit](IO.pure(())))
      .compile
      .drain
      .value
      .timeout(5.seconds)
      .unsafeRunSync())
}
