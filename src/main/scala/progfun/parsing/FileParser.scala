package progfun.parsing

import progfun.models.{Coordinate, Lawn, Lawnmower, Orientation, Position}

class FileParser {

}

object FileParser {
  def parse(): Unit = {
    val source = scala.io.Source.fromFile("tmp/input.txt")
    val lines = try source.mkString finally source.close()

    println(lines)


    val limitLine = lines.lines().toList.get(0)
    val lawn = new Lawn(limitLine.charAt(0).asDigit, limitLine.charAt(2).asDigit)

    val result = limitLine.charAt(0).asDigit
    val position1 = lines.lines().toList.get(1)
    val x = position1.charAt(0).asDigit
    val y = position1.charAt(2).asDigit
    val orientation = new Orientation(position1.charAt(4))
    val instructions1 = lines.lines().toList.get(2)
    val instructionsList = instructions1.toList


    val start = Position(new Coordinate(x, y), orientation)
    val lawnmower1 = Lawnmower(lawn, start, instructionsList)

    println(instructionsList)
  }
}
