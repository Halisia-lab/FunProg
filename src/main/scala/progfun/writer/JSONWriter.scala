package progfun.writer

import play.api.libs.json.{Json, Writes}
import progfun.models.{Coordinate, Lawnmower}

object JSONWriter {

  case class JSONResult(limite: Coordinate, lawnmowers: List[Lawnmower])

  object JSONResult {
    implicit val writes: Writes[JSONResult] = Json.writes[JSONResult]
    def writes(result: JSONResult) = Json.obj(
      "limite"    -> result.limite,
      "tondeuses" -> result.lawnmowers
    )
  }
}
