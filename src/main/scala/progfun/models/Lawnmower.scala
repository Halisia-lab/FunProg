package progfun.models

case class Lawnmower(lawn: Lawn, start: Position, instruction: List[Char], fin: Position) {

  def doInstructions(instructions: List[Char], position: Position): Lawnmower = instructions match {

    case Nil => Lawnmower(lawn, start, instruction, position)
    case instruction::rest =>
      doInstructions(rest, Position(position.move(position.orientation, instruction), position.turn(instruction)))
  }

  override def toString: String = {
    s"tondeuse: ${fin.toString}"
  }



}
