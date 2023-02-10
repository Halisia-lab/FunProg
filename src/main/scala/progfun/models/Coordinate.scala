package progfun.models

import play.api.libs.json.{Json, Writes}

case class Coordinate(x: Int, y: Int) {

  def equals(obj: Coordinate): Boolean = {
    this.x == obj.x && this.y == obj.y
  }
}

object Coordinate {
  @SuppressWarnings(Array("org.wartremover.warts.Any"))
  implicit val writes: Writes[Coordinate] = Writes { coordinate =>
    Json.obj(
      "x" -> coordinate.x,
      "y" -> coordinate.y
    )
  }

}
