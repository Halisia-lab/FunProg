package progfun.models

case class Orientation(direction: String) extends Enumeration {

  val NORTH = "N"
  val EAST = "E"
  val SOUTH = "S"
  val WEST = "W"

  def turnRight(): Orientation = direction match {
    case NORTH => Orientation("E")
    case EAST  => Orientation("S")
    case SOUTH => Orientation("W")
    case WEST  => Orientation("N")
  }

  def turnLeft(): Orientation = direction match {
    case NORTH => Orientation("W")
    case EAST  => Orientation("N")
    case SOUTH => Orientation("E")
    case WEST  => Orientation("S")
  }

  def moveStraight(): Orientation = Orientation(direction)

  override def toString: String = {
    s"orientation: ${direction}"
  }

  def equals(obj: Orientation): Boolean = {
    this.direction == obj.direction
  }
}

object Orientation {}
