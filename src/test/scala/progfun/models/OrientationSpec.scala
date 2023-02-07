package progfun.models

import org.scalatest.funsuite.AnyFunSuite

class OrientationSpec extends AnyFunSuite {

  val north: Orientation = new Orientation("N")
  val south: Orientation = new Orientation("S")
  val east: Orientation = new Orientation("E")
  val west: Orientation = new Orientation("W")

  test("Turn right from north should return east") {
    assert(north.turnRight() === east)
  }

  test("Turn right from south should return west") {
    assert(south.turnRight() === west)
  }

  test("Turn right from east should return south") {
    assert(east.turnRight() === south)
  }

  test("Turn right from west should return north") {
    assert(west.turnRight() === north)
  }

  test("Turn left from north should return west") {
    assert(north.turnLeft() === west)
  }

  test("Turn left from south should return east") {
    assert(south.turnLeft() === east)
  }

  test("Turn left from east should return north") {
    assert(east.turnLeft() === north)
  }

  test("Turn left from west should return south") {
    assert(west.turnLeft() === south)
  }

  test("Move straight should return the same position for each direction") {
    assert(south.moveStraight() == south)
    assert(south.moveStraight() === south)
    assert(east.moveStraight() === east)
    assert(west.moveStraight() === west)
  }
}
