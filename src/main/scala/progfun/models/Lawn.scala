package progfun.models

class Lawn(height: Int, width: Int) {
  override def toString: String = {
    s"limite: ${height.toString}, ${width.toString}"
  }
}

object Lawn {}
