package progfun.models

case class Lawnmower(lawn: Lawn, start: Position) {

  def doInstructions(instructions: List[Char]): Position = instructions match {
    case instruction :: rest => {
      start.turn(instruction)
      start.move(start.orientation, instruction)
      doInstructions(rest)
      Position(start.coordinate, start.orientation)
    }
    case _ => Position(start.coordinate, start.orientation)
  }

}
