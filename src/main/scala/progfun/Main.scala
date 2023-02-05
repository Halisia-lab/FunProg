package progfun
import better.files.File
import play.api.libs.json.Json
import progfun.parsing.FileParser
import progfun.writer.CSVWriter

import java.text.SimpleDateFormat
import java.util.Calendar

object Main extends App {

  val inputObjects = FileParser.execute()
  val lawnmowers = inputObjects.tondeuses

  val format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss")
  val now = format.format(Calendar.getInstance().getTime)

  val resultJson = Json.prettyPrint(Json.toJson(inputObjects))
  val jsonFile = File("src/main/resources/" + now + ".json")
  jsonFile.createIfNotExists().appendLines(resultJson)


  val resultCSV = CSVWriter.formatCSV(lawnmowers, 1)
  val CSVFile = File("src/main/resources/" + now + ".csv")
  val firstCSVLine : String = "numéro;début_x;début_y;début_direction;fin_x;fin_y;fin_direction;instructions"
  CSVFile.createIfNotExists().appendLines(firstCSVLine)
  CSVFile.appendLines(resultCSV)

}
