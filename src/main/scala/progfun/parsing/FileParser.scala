package progfun.parsing
import progfun.exceptions.InvalidInputDataException
import progfun.models.{Coordinate, Lawn, Lawnmower, Orientation, Position}

object FileParser {

  def listLawnmowers(lines : List[String], lawnmowers : List[String]) : List[String] = {

    lines match {
      case lawnmower :: _ :: others => {
        val lawns = lawnmowers :+ lawnmower
        listLawnmowers(others, lawns)
      }
      case Nil => lawnmowers
      case List(_) => lawnmowers
    }
  }

  def listInstructions(lines : List[String], instructions: List[String]): List[String] = {

    lines match {
      case _ :: inst :: others => {
        val insts = instructions :+ inst
        listInstructions(others, insts)
      }
      case Nil => instructions
      case List(_) => instructions
    }
  }

  @SuppressWarnings(Array("org.wartremover.warts.Throw"))
  def parseLines(lawn: Lawn, listLawns : List[String], listInstrs : List[String]) : Unit = {

        (listLawns, listInstrs) match {
          case (lawnmower :: restLawnmowers, instructions :: restInstructions) => {
            val position : String = lawnmower
            val x = position.charAt(0).asDigit
            val y = position.charAt(2).asDigit
            val orientation = new Orientation(position.charAt(4))
            val instructionsList = instructions.toList

            val start = Position(new Coordinate(x, y), orientation)
            val lawnmower1 = Lawnmower(lawn, start, instructionsList, start)
            println(lawnmower1.doInstructions(instructionsList, start))

            parseLines(lawn, restLawnmowers, restInstructions)
          }
          case (List(_), Nil) | (Nil, List(_)) => throw InvalidInputDataException("Format du fichier en entrée incorrect")
          case  (Nil, Nil) => println("End")
        }
  }




  @SuppressWarnings(Array("org.wartremover.warts.Throw"))
  def execute(): Unit = {
    val source = scala.io.Source.fromFile("tmp/input.txt")
    val lines = try source.mkString finally source.close()

    println(lines)

    val linesList : List[String] = lines.split("\n").toList

    linesList match {
      case limite :: rest  => {
        val lawn = new Lawn(limite.charAt(0).asDigit, limite.charAt(2).asDigit)
        val listLawns : List[String] = listLawnmowers(rest, List())
        val listInstrs : List[String] = listInstructions(rest, List())
        parseLines(lawn, listLawns, listInstrs)

      }
      case _ => throw InvalidInputDataException("Erreur dans le fichier en entrée")
    }
  }
}
