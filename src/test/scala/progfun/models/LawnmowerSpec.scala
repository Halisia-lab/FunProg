package progfun.models

import org.scalatest.funsuite.AnyFunSuite

class LawnmowerSpec extends AnyFunSuite {

  val lawn: Lawn = new Lawn(5, 5)
  val instructions: List[String] =
    List("A", "A", "D", "A", "A", "D", "A", "D", "D", "A")
  val start: Position = new Position(new Coordinate(3, 3), new Orientation("E"))
  val end: Position = new Position(new Coordinate(5, 1), new Orientation("E"))
  val lawnmowerIn: Lawnmower = new Lawnmower(lawn, start, instructions, start)
  val lawnmowerOut: Lawnmower = new Lawnmower(lawn, start, instructions, end)
  test("doInstructions with Nil instructions should return same Lawnmower ") {
    assert(lawnmowerIn.doInstructions(Nil, start) === lawnmowerIn)
  }

  test("doInstructions with non Nil instructions should return same Lawnmower ") {
    assert(lawnmowerIn.doInstructions(instructions, start) === lawnmowerOut)
  }
}
