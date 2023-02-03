package progfun.models

case class Orientation(direction: Char) extends Enumeration {

  val NORTH = 'N'
  val EAST = 'E'
  val SOUTH = 'S'
  val WEST = 'W'

  def turnRight(): Unit = direction match {
    case NORTH => Orientation('E')
    case EAST  => Orientation('S')
    case SOUTH => Orientation('W')
    case WEST  => Orientation('N')
  }

  def turnLeft(): Unit = direction match {
    case NORTH => Orientation('W')
    case EAST  => Orientation('N')
    case SOUTH => Orientation('E')
    case WEST  => Orientation('S')
  }

  def moveStraight(): Unit = Orientation(direction)
}

object Orientation {}
