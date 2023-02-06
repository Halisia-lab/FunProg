package progfun.models

import org.scalatest.funsuite.AnyFunSuite

class PositionSpec extends AnyFunSuite {

  val coordinate : Coordinate = new Coordinate(2,3)
  val orientation : Orientation = new Orientation("S")

  val position : Position = new Position(coordinate, orientation)
  test("The position coordinates should be (3,5") {
    assert(position.coordinate.x === 2)
    assert(position.coordinate.y === 3)
  }

  test("The position orientation should be S") {
    assert(position.orientation.direction === "S")
  }
}
