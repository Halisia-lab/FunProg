package progfun
import better.files.File
import play.api.libs.json.Json
import progfun.parsing.FileParser

import java.text.SimpleDateFormat
import java.util.Calendar

import com.typesafe.config.{Config, ConfigFactory}

object Main extends App {

  val conf: Config = ConfigFactory.load()
  val input : String = conf.getString("appplication.input-file")
  val source = scala.io.Source.fromFile(input)

  val json = FileParser.execute(source)
  val result = Json.prettyPrint(Json.toJson(json))

  val format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss")
  val now = format.format(Calendar.getInstance().getTime)

  val output_json : String = conf.getString("appplication.output-json-file")

  val f = File(output_json)
  f.createIfNotExists().appendLine().appendLines(result)

}
