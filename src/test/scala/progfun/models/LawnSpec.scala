package progfun.models

import org.scalatest.funsuite.AnyFunSuite

class LawnSpec extends AnyFunSuite {

  val lawn : Lawn = new Lawn(5,5)

  test("Lawn height should be equal to 5") {
    assert(lawn.height === 5)
  }

  test("Lawn width should be equal to 5") {
    assert(lawn.width === 5)
  }
}
