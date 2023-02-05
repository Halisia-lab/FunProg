package progfun.writer

import play.api.libs.json.{Json, Writes}

object JSONWriter {

  case class JSONCoordinate(x: Int, y: Int)

  case class JSONPosition(point: JSONCoordinate, direction: String)

  case class JSONLawnmowers(debut: JSONPosition, instructions: List[String], fin: JSONPosition)

  case class JSONResult(limite: JSONCoordinate, tondeuses: List[JSONLawnmowers])

  object JSONCoordinate {
    implicit val writes: Writes[JSONCoordinate] = Json.writes[JSONCoordinate]
    def writes(coordinate: JSONCoordinate) = Json.obj(
      "x"  -> coordinate.x,
      "y" -> coordinate.y
    )
  }

  object JSONPosition {
    implicit val writes: Writes[JSONPosition] = Json.writes[JSONPosition]
    def writes(position: JSONPosition) = Json.obj(
      "point"  -> position.point,
      "direction" -> position.direction
    )
  }

  object JSONLawnmowers {
    implicit val writes: Writes[JSONLawnmowers] = Json.writes[JSONLawnmowers]
    def writes(lawnmowers: JSONLawnmowers) = Json.obj(
      "debut"  -> lawnmowers.debut,
      "instructions" -> lawnmowers.instructions,
      "fin" -> lawnmowers.fin
    )
  }

  object JSONResult {
    implicit val writes: Writes[JSONResult] = Json.writes[JSONResult]
    def writes(result: JSONResult) = Json.obj(
      "limite"  -> result.limite,
      "tondeuses" -> result.tondeuses
    )
  }
}
