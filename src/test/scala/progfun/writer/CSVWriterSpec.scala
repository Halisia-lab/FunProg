package progfun.writer

import org.scalatest.funsuite.AnyFunSuite
import progfun.models.{Coordinate, Lawn, Lawnmower, Orientation, Position}

class CSVWriterSpec extends AnyFunSuite {

  val lawn : Lawn = new Lawn(5,5)
  val lawnmower1 : Lawnmower = Lawnmower(lawn, Position(Coordinate(3,3), Orientation("E")), List("A","A","D","A","A","D","A","D","D","A"), Position(Coordinate(5,1), Orientation("E")))
  val lawnmower2 : Lawnmower = Lawnmower(lawn, Position(Coordinate(1,2), Orientation("N")), List("G","A","G","A","G","A","G","A","A"), Position(Coordinate(1,3), Orientation("N")))
  val lawnmowers : List[Lawnmower] = List(lawnmower1, lawnmower2)

  val result : String = "1;3;3;E;5;1;E;AADAADADDA\n2;1;2;N;1;3;N;GAGAGAGAA\n"

  test("CSV result with 2 lawnmowers") {
    assert(CSVWriter.formatCSV(lawnmowers, 1) === result)
  }
 }
