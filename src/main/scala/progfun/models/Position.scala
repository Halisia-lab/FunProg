package progfun.models

import play.api.libs.json.{Json, Writes}

case class Position(coordinate: Coordinate, orientation: Orientation) {

  def turn(instruction: String): Orientation = {
    instruction match {
      case "A" => orientation.moveStraight()
      case "D" => orientation.turnRight()
      case "G" => orientation.turnLeft()
      case _   => orientation
    }
  }

  def move(
      orientation: Orientation,
      instruction: String,
      limit: Lawn
  ): Coordinate = {
    orientation match {
      case Orientation("N") => moveNorth(instruction, limit)
      case Orientation("S") => moveSouth(instruction)
      case Orientation("E") => moveEast(instruction, limit)
      case Orientation("W") => moveWest(instruction)
      case _                => coordinate
    }
  }

  def moveNorth(instruction: String, limit: Lawn): Coordinate = {
    instruction match {
      case "A" =>
        if (limit.height > coordinate.y)
          Coordinate(coordinate.x, coordinate.y + 1)
        else coordinate
      case _ => coordinate
    }
  }

  def moveSouth(instruction: String): Coordinate = {
    instruction match {
      case "A" =>
        if (coordinate.y > 0) Coordinate(coordinate.x, coordinate.y - 1)
        else coordinate
      case _ => coordinate
    }
  }

  def moveEast(instruction: String, limit: Lawn): Coordinate = {
    instruction match {
      case "A" =>
        if (coordinate.x < limit.width)
          Coordinate(coordinate.x + 1, coordinate.y)
        else coordinate
      case _ => coordinate
    }
  }

  def moveWest(instruction: String): Coordinate = {
    instruction match {
      case "A" =>
        if (coordinate.x > 0) Coordinate(coordinate.x - 1, coordinate.y)
        else coordinate
      case _ => coordinate
    }
  }

  override def toString: String = {
    s"position: ${coordinate.toString}, ${orientation.toString}"
  }
}

object Position {
  @SuppressWarnings(Array("org.wartremover.warts.Any"))
  implicit val writes: Writes[Position] = Writes { position =>
    Json.obj(
      "point"     -> position.coordinate,
      "direction" -> position.orientation.direction
    )
  }
}
