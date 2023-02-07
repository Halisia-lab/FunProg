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

  def move(orientation: Orientation, instruction: String): Coordinate = {
    orientation match {
      case Orientation("N") => moveNorth(instruction)
      case Orientation("S") => moveSouth(instruction)
      case Orientation("E") => moveEast(instruction)
      case Orientation("W") => moveWest(instruction)
      case _                => Coordinate(coordinate.x, coordinate.y)
    }
  }

  def moveNorth(instruction: String): Coordinate = {
    instruction match {
      case "A" => Coordinate(coordinate.x, coordinate.y + 1)
      case "D" => Coordinate(coordinate.x + 1, coordinate.y)
      case "G" => Coordinate(coordinate.x - 1, coordinate.y)
      case _   => Coordinate(coordinate.x, coordinate.y)
    }
  }

  def moveSouth(instruction: String): Coordinate = {
    instruction match {
      case "A" => Coordinate(coordinate.x, coordinate.y - 1)
      case "D" => Coordinate(coordinate.x - 1, coordinate.y)
      case "G" => Coordinate(coordinate.x + 1, coordinate.y)
      case _   => Coordinate(coordinate.x, coordinate.y)
    }
  }

  def moveEast(instruction: String): Coordinate = {
    instruction match {
      case "A" => Coordinate(coordinate.x + 1, coordinate.y)
      case "D" => Coordinate(coordinate.x, coordinate.y - 1)
      case "G" => Coordinate(coordinate.x, coordinate.y + 1)
      case _   => Coordinate(coordinate.x, coordinate.y)
    }
  }

  def moveWest(instruction: String): Coordinate = {
    instruction match {
      case "A" => Coordinate(coordinate.x - 1, coordinate.y)
      case "D" => Coordinate(coordinate.x, coordinate.y + 1)
      case "G" => Coordinate(coordinate.x, coordinate.y - 1)
      case _   => Coordinate(coordinate.x, coordinate.y)
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
