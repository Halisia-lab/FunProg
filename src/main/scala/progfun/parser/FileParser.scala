package progfun.parser
import progfun.exceptions.InvalidInputDataException
import progfun.models.{Coordinate, Lawn, Lawnmower, Orientation, Position}
import progfun.writer.JSONWriter
import progfun.writer.JSONWriter.JSONResult

import scala.io.BufferedSource

object FileParser {

  def listLawnmowers(
      lines: List[String],
      lawnmowers: List[String]
  ): List[String] = {

    lines match {
      case lawnmower :: _ :: others => {
        val listLawnmower = lawnmowers :+ lawnmower
        listLawnmowers(others, listLawnmower)
      }
      case Nil     => lawnmowers
      case List(_) => lawnmowers
    }
  }

  def listInstructions(
      lines: List[String],
      instructions: List[String]
  ): List[String] = {

    lines match {
      case _ :: instruction :: others => {
        val listInstruction = instructions :+ instruction
        listInstructions(others, listInstruction)
      }
      case Nil     => instructions
      case List(_) => instructions
    }
  }

  @SuppressWarnings(Array("org.wartremover.warts.Throw"))
  def parseLines(
      lawn: Lawn,
      listLawns: List[String],
      listInstr: List[String],
      num: Int
  ): List[Lawnmower] = {

    (listLawns, listInstr) match {
      case (lawnmower :: restLawnmowers, instructions :: restInstructions) => {
        val position: String = lawnmower
        val x = position.charAt(0).asDigit
        val y = position.charAt(2).asDigit
        val orientation = new Orientation(position.charAt(4).toString)
        val instructionsList = instructions.toList
        val listString = instructionsList.map(instr => instr.toString)
        val start = Position(new Coordinate(x, y), orientation)
        val lawnmower1 = Lawnmower(lawn, start, listString, start)

        lawnmower1.doInstructions(listString, start) +: parseLines(
          lawn,
          restLawnmowers,
          restInstructions,
          num + 1
        )
      }
      case (List(_), Nil) | (Nil, List(_)) =>
        throw InvalidInputDataException("Format du fichier en entrée incorrect")
      case (Nil, Nil) => List()
    }
  }

  @SuppressWarnings(Array("org.wartremover.warts.Throw"))
  def execute(source: BufferedSource): JSONResult = {

    val lines = try source.mkString
    finally source.close()
    val linesList: List[String] = lines.split("\n").toList

    linesList match {
      case limite :: rest => {
        val lawn = new Lawn(limite.charAt(0).asDigit, limite.charAt(2).asDigit)
        val listLawns: List[String] = listLawnmowers(rest, List())
        val listInstr: List[String] = listInstructions(rest, List())
        val listMawers = parseLines(lawn, listLawns, listInstr, 1)
        JSONWriter.JSONResult(Coordinate(lawn.height, lawn.width), listMawers)
      }
      case _ =>
        throw InvalidInputDataException("Erreur dans le fichier en entrée")
    }
  }

}
