import zio.console._

object dvFileCount extends zio.App {

  def run(args: List[String]) =
    myAppLogic.exitCode

  val myAppLogic =
    for {
      _ <- putStrLn("Hello! What is your name?")
      name <- getStrLn
      _ <- putStrLn(s"Hello, ${name}, welcome to ZIO!")
      _ <- putStrLn("Let's count the word from file")
      _ <- putStrLn(readfile(s"src/main/resources/data.csv"))

    } yield ()

  def readfile(file: String): String = {
    val source = scala.io.Source.fromFile(file)
    try {
      val line = source.getLines.flatMap(c => c.split(" ")).toSeq
      line.size.toString
    } finally source.close()
  }
}
