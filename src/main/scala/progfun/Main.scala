package progfun

import progfun.parsing.FileParser

object Main extends App {
  println("Ici le programme principal")

  FileParser.parse()



  //val jsonFile:String = "{ \"first_name\": \"Phil\", \"last_name\": \"Hellmuth\"}";
  // Le code suivant ne compilera pas.
  // var tmp = null;
  // var tmp2 = if (tmp == 1) "yes" else 1

  // println(s"tmp: $tmp, tmp2: $tmp2")
}
