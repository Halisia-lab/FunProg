package progfun
import better.files.File
import play.api.libs.json.Json
import progfun.parsing.FileParser

import java.text.SimpleDateFormat
import java.util.Calendar

object Main extends App {

  val json = FileParser.execute()
  val result = Json.prettyPrint(Json.toJson(json))

  val format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss")
  val now = format.format(Calendar.getInstance().getTime)

  val f = File("src/main/resources/" + now + ".json")
  f.createIfNotExists().appendLines(result)

}
