package example

import cats.data.EitherT
import cats.effect.IO
import cats.effect.unsafe.implicits.global
import scala.concurrent.duration._

object Test {
  def main(args: Array[String]): Unit =
    println(fs2.io.readOutputStream(1)(_ => EitherT.left[Unit](IO.pure(())))
      .compile
      .drain
      .value
      .timeout(5.seconds)
      .unsafeRunSync())
}
