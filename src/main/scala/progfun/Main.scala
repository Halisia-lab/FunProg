package progfun

import play.api.libs.json.Json
import progfun.parsing.FileParser
import progfun.writer.JSONWriter

object Main extends App {
  println("Ici le programme principal")

  FileParser.parse()

  val coordinate = JSONWriter.JSONCoordinate(1,2)
  val position = JSONWriter.JSONPosition(coordinate, "S")
  val lawnmowers = JSONWriter.JSONLawnmowers(position, List("A", "D", "G"), position)
  val result = JSONWriter.JSONResult(coordinate, List(lawnmowers))

  val json = Json.toJson(result)

  println(json)


  //val jsonFile:String = "{ \"first_name\": \"Phil\", \"last_name\": \"Hellmuth\"}";
  // Le code suivant ne compilera pas.
  // var tmp = null;
  // var tmp2 = if (tmp == 1) "yes" else 1

  // println(s"tmp: $tmp, tmp2: $tmp2")
}
