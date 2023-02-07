package progfun.models

import org.scalatest.funsuite.AnyFunSuite

class CoordinateSpec extends AnyFunSuite {

  val coordinate: Coordinate = new Coordinate(3, 5)

  test("The coordinate x should be equal to 3") {
    assert(coordinate.x === 3)
  }

  test("The coordinate y should be equal to 5") {
    assert(coordinate.y === 5)
  }

}
