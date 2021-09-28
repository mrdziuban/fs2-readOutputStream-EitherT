# fs2-readOutputStream-EitherT

This is a repository to demonstrate a hanging code issue using [`fs2.io.readOutputStream`](https://github.com/typelevel/fs2/blob/v3.1.3/io/jvm/src/main/scala/fs2/io/ioplatform.scala#L68) and [`cats.data.EitherT`](https://github.com/typelevel/cats/blob/v2.6.1/core/src/main/scala/cats/data/EitherT.scala#L14).

Clone this repository, `cd` into the directory, and run one of the following commands to reproduce the issue on either fs2 v2.x or v3.x:

```bash
sbt fs2-2/run
sbt fs2-3/run
```

In both cases, you should see a `java.util.concurrent.TimeoutException` after 5 seconds.
