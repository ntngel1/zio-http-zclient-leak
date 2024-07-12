import zio.http.{Header, Headers, Request, URL, ZClient}
import zio.{Console, Schedule, Scope, ZIO, ZIOAppDefault, durationInt}

object HttpsClient extends ZIOAppDefault {
  val url     = URL.decode("https://jsonplaceholder.typicode.com/todos/1").toOption.get
  val headers = Headers(Header.Host("jsonplaceholder.typicode.com"))
  val program = (for {
    res <- ZClient.request(Request.get(url).addHeaders(headers))
    data <- res.body.asString
    _ <- Console.printLine(data)
  } yield ())
    .ignore
    .schedule(Schedule.spaced(1.second))

  val run =
    program.provide(
      ZClient.default,
      Scope.default,
    )

}