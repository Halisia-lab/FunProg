package progfun.writer

import org.scalatest.funsuite.AnyFunSuite
import progfun.models.{Coordinate, Lawn, Lawnmower, Orientation, Position}
import progfun.writer.JSONWriter.JSONResult

class JSONWriterSpec extends AnyFunSuite {

  val lawn : Lawn = new Lawn(5,5)
  val lawnmower1 : Lawnmower = Lawnmower(lawn, Position(Coordinate(3,3), Orientation("E")), List("A","A","D","A","A","D","A","D","D","A"), Position(Coordinate(5,1), Orientation("E")))
  val lawnmower2 : Lawnmower = Lawnmower(lawn, Position(Coordinate(1,2), Orientation("N")), List("G","A","G","A","G","A","G","A","A"), Position(Coordinate(1,3), Orientation("N")))
  val lawnmowers : List[Lawnmower] = List(lawnmower1, lawnmower2)
  val jsonWriter : JSONResult = JSONWriter.JSONResult(Coordinate(5, 5), lawnmowers)

  test("JSON writer") {
    assert(jsonWriter.limite.x === lawn.height)
    assert(jsonWriter.limite.y === lawn.width)
  }
}
