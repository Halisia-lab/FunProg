package progfun.models

import play.api.libs.json.{Json, Writes}

case class Coordinate(x: Int, y: Int) {

  def isOut(coordinate: Coordinate): Boolean = {
    this.x > coordinate.x || this.y > coordinate.y || this.x < 0 || this.y < 0
  }


   def equals(obj: Coordinate): Boolean = {
    this.x == obj.x && this.y == obj.y
  }
}

object Coordinate {
  @SuppressWarnings(Array("org.wartremover.warts.Any"))
    implicit val writes: Writes[Coordinate] = Writes { coordinate =>
    Json.obj(
      "x"  -> coordinate.x,
      "y" -> coordinate.y
    )
  }

}
