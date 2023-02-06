package progfun
import better.files.File
import play.api.libs.json.Json
import progfun.parsing.FileParser


import com.typesafe.config.{Config, ConfigFactory}

object Main extends App {

  val conf: Config = ConfigFactory.load()
  val input : String = conf.getString("appplication.input-file")
  val source = scala.io.Source.fromFile(input)

  val output = FileParser.execute(source)
  val resultJson = Json.prettyPrint(Json.toJson(output))

  val output_json : String = conf.getString("appplication.output-json-file")

  val f = File(output_json)
  f.createIfNotExists().appendLine().appendLines(resultJson)

}
