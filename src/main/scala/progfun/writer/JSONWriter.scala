package progfun.writer

import play.api.libs.json.{Json, Writes}
import progfun.models.{Coordinate, Lawnmower}
import progfun.utils.ListComparator

object JSONWriter {

  case class JSONResult(limite: Coordinate, tondeuses: List[Lawnmower]) {

    def equals(obj: JSONResult): Boolean = {
      this.limite.x == obj.limite.x &&
        this.limite.y == obj.limite.y &&
        ListComparator.areLawnmowerListsEqual(this.tondeuses, obj.tondeuses)
    }
  }

  object JSONResult {
    implicit val writes: Writes[JSONResult] = Json.writes[JSONResult]
    def writes(result: JSONResult) = Json.obj(
      "limite"  -> result.limite,
      "tondeuses" -> result.tondeuses
    )
  }
}
