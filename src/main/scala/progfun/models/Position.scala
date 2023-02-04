package progfun.models

case class Position(coordinate: Coordinate, orientation: Orientation) {

  def turn(instruction: Char): Orientation = {
    instruction match {
      case 'A' => orientation.moveStraight()
      case 'D' => orientation.turnRight()
      case 'G' => orientation.turnLeft()
      case _ => orientation
    }
  }

  def move(orientation: Orientation, instruction: Char): Coordinate  = {
    orientation match {
      case Orientation('N') => moveNorth(instruction)
      case Orientation('S') => moveSouth(instruction)
      case Orientation('E') => moveEast(instruction)
      case Orientation('W') => moveWest(instruction)
      case _ => Coordinate(coordinate.x, coordinate.y)
    }
  }

  def moveNorth(instruction: Char): Coordinate = {
    instruction match {
      case 'A' => Coordinate(coordinate.x, coordinate.y + 1)
      case 'D' => Coordinate(coordinate.x + 1, coordinate.y)
      case 'G' => Coordinate(coordinate.x - 1, coordinate.y)
      case _ => Coordinate(coordinate.x, coordinate.y)
    }
  }

  def moveSouth(instruction: Char): Coordinate = {
    instruction match {
      case 'A' => Coordinate(coordinate.x, coordinate.y-1)
      case 'D' => Coordinate(coordinate.x-1, coordinate.y)
      case 'G' => Coordinate(coordinate.x+1, coordinate.y)
      case _ => Coordinate(coordinate.x, coordinate.y)
    }
  }

  def moveEast(instruction: Char): Coordinate = {
    instruction match {
      case 'A' => Coordinate(coordinate.x+1, coordinate.y)
      case 'D' => Coordinate(coordinate.x, coordinate.y-1)
      case 'G' => Coordinate(coordinate.x, coordinate.y+1)
      case _ => Coordinate(coordinate.x, coordinate.y)
    }
  }

  def moveWest(instruction: Char): Coordinate = {
    instruction match {
      case 'A' => Coordinate(coordinate.x-1, coordinate.y)
      case 'D' => Coordinate(coordinate.x, coordinate.y+1)
      case 'G' => Coordinate(coordinate.x, coordinate.y-1)
      case _ => Coordinate(coordinate.x, coordinate.y)
    }
  }

  override def toString: String = {
    s"position: ${coordinate.toString}, ${orientation.toString}"
  }
}

