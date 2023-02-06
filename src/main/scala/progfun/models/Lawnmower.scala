package progfun.models

import play.api.libs.json.{Json, Writes}

case class Lawnmower(lawn: Lawn, start: Position, instruction: List[String], end: Position) {

  def doInstructions(instructions: List[String], position: Position): Lawnmower = {
    instructions match {
    case Nil => {
      Lawnmower(lawn, start, instruction, position)
    }
    case instruction::rest => {


      doInstructions(rest, Position(position.move(position.orientation, instruction), position.turn(instruction)))
    }
  }
  }

  override def toString: String = {
    s"tondeuse: ${end.toString}"
  }
}

object Lawnmower {
  @SuppressWarnings(Array("org.wartremover.warts.Any"))
  implicit val writes: Writes[Lawnmower] = Writes { lawnMower =>
    Json.obj(
      "debut" -> lawnMower.start,
      "instructions" -> lawnMower.instruction,
      "fin"          -> lawnMower.end
    )
  }
}


