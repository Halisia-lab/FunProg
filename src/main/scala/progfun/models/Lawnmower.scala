package progfun.models

case class Lawnmower(lawn: Lawn, start: Position) {

//  def doInstructions(instructions: List[Char]): Unit = instructions match {
//
//    case instruction :: rest => {
//      val pos = start.move(start.orientation, instruction)
//      val orient = start.turn(instruction)
//      doInstructions(rest)
//      print(pos.x)
//      print(pos.y)
//      print(orient)
//    }
//    case _ => println(Position(start.coordinate, start.orientation))
//  }

  def doInstructions(instructions: List[Char], position: Position): Position = instructions match {

    case Nil => position
    case instruction::rest =>
//      print(start.coordinate.x)
//      print(start.coordinate.y)
//      print(start.orientation.direction)
      doInstructions(rest, Position(position.move(position.orientation, instruction), position.turn(instruction)))

  }

  override def toString: String = {
    s"tondeuse: ${start.toString}"
  }

//
//  def max(xs:List[Int]): Int = xs match {
//    case Nil => throw new Exception("Wait a little")
//    case x::Nil => x
//    case x1::x2::reste =>
//      if (x1 < x2)
//        max (x2::reste)
//      else
//        max (x1::reste)
//  }


}
