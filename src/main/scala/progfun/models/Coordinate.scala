package progfun.models

case class Coordinate(x: Int, y: Int) {

  def isOut(coordinate: Coordinate): Boolean = {
    this.x > coordinate.x || this.y > coordinate.y || this.x < 0 || this.y < 0
  }
}

object Coordinate {}
