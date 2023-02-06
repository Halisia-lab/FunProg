package progfun
import better.files.File
import play.api.libs.json.Json
import progfun.parsing.FileParser
import progfun.writer.CSVWriter


import com.typesafe.config.{Config, ConfigFactory}

object Main extends App {

  // Configuration
  val conf: Config = ConfigFactory.load()
  val input : String = conf.getString("appplication.input-file")
  val source = scala.io.Source.fromFile(input)
  val output = FileParser.execute(source)

  // JSON
  val resultJson = Json.prettyPrint(Json.toJson(output))
  val output_json : String = conf.getString("appplication.output-json-file")
  val JSONFile = File(output_json)
  JSONFile.createIfNotExists().appendLines(resultJson)

  // CSV
  val lawnmowers = output.tondeuses
  val resultCSV = CSVWriter.formatCSV(lawnmowers, 1)
  val output_csv : String = conf.getString("appplication.output-csv-file")
  val CSVFile = File(output_csv)
  val firstCSVLine : String = "numéro;début_x;début_y;début_direction;fin_x;fin_y;fin_direction;instructions"
  CSVFile.createIfNotExists().appendLines(firstCSVLine)
  CSVFile.appendLines(resultCSV)

}
