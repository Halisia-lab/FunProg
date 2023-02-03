package progfun.models

case class Position(coordinate: Coordinate, orientation: Orientation) {

  def turn(instruction: Char): Unit = {
    instruction match {
      case 'A' => orientation.moveStraight()
      case 'D' => orientation.turnRight()
      case 'G' => orientation.turnLeft()
      case _ => orientation
    }
  }

  def move(orientation: Orientation, instruction: Char): Unit = {
    orientation match {
      case Orientation('N') => moveNorth(instruction)
      case Orientation('S') => moveSouth(instruction)
      case Orientation('E') => moveEast(instruction)
      case Orientation('W') => moveWest(instruction)
    }
  }

  def moveNorth(instruction: Char): Unit = {
    instruction match {
      case 'A' => Coordinate(coordinate.x, coordinate.y+1)
      case 'D' => Coordinate(coordinate.x+1, coordinate.y)
      case 'G' => Coordinate(coordinate.x-1, coordinate.y)
    }
  }

  def moveSouth(instruction: Char): Unit = {
    instruction match {
      case 'A' => Coordinate(coordinate.x, coordinate.y-1)
      case 'D' => Coordinate(coordinate.x-1, coordinate.y)
      case 'G' => Coordinate(coordinate.x+1, coordinate.y)
    }
  }

  def moveEast(instruction: Char): Unit = {
    instruction match {
      case 'A' => Coordinate(coordinate.x+1, coordinate.y)
      case 'D' => Coordinate(coordinate.x, coordinate.y-1)
      case 'G' => Coordinate(coordinate.x, coordinate.y+1)
    }
  }

  def moveWest(instruction: Char): Unit = {
    instruction match {
      case 'A' => Coordinate(coordinate.x-1, coordinate.y)
      case 'D' => Coordinate(coordinate.x, coordinate.y+1)
      case 'G' => Coordinate(coordinate.x, coordinate.y-1)
    }
  }
}

