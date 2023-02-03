package fr.esgi.al.funprog

import progfun.models.Limite

object Main extends App {
  println("Ici le programme principal")
  val source = scala.io.Source.fromFile("tmp/input.txt")
  val lines = try source.mkString finally source.close()


  val limitLine = lines.lines().toList().get(0)
  val limite = new Limite(limitLine.charAt(0).asDigit, limitLine.charAt(2).asDigit)


  val result = limitLine.charAt(0).asDigit
  val position1 = lines.lines().toList().get(1)
  val instructions1 = lines.lines().toList().get(1)
  println(limite);



  //val jsonFile:String = "{ \"first_name\": \"Phil\", \"last_name\": \"Hellmuth\"}";
  // Le code suivant ne compilera pas.
  // var tmp = null;
  // var tmp2 = if (tmp == 1) "yes" else 1

  // println(s"tmp: $tmp, tmp2: $tmp2")
}
