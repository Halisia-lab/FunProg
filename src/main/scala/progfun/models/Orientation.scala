package progfun.models

case class Orientation(direction: Char) extends Enumeration {

  val NORTH = 'N'
  val EAST = 'E'
  val SOUTH = 'S'
  val WEST = 'W'

  /*def turnRight(): Orientation = direction match {
    case NORTH => Orientation('E')
    case EAST  => Orientation('S')
    case SOUTH => Orientation('W')
    case WEST  => Orientation('N')
  }

  def turnLeft(): Orientation = direction match {
    case NORTH => Orientation('W')
    case WEST  => Orientation('N')
    case SOUTH => Orientation('E')
    case WEST  => Orientation('S')
  }*/

  def move(): Orientation = Orientation(direction)
}

object Orientation {}
