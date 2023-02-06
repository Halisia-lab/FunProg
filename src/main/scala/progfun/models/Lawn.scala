package progfun.models

class Lawn(val height: Int, val width: Int) {

  override def toString: String = {
    s"limite: ${height.toString}, ${width.toString}"
  }
}

object Lawn {}
