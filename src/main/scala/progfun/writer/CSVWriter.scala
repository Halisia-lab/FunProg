package progfun.writer

import progfun.models.Lawnmower

object CSVWriter {
  def formatCSV(lawnmowers: List[Lawnmower], num: Int) : String = lawnmowers match {
    case tondeuse :: reste => {
      val startX = tondeuse.start.coordinate.x.toString
      val startY = tondeuse.start.coordinate.y.toString
      val startOrientation = tondeuse.start.orientation.direction
      val endX = tondeuse.end.coordinate.x.toString
      val endY = tondeuse.end.coordinate.y.toString
      val endOrientation = tondeuse.end.orientation.direction
      val instruction = tondeuse.instruction.mkString

      val step = num.toString.concat(";")
        .concat(startX).concat(";")
        .concat(startY).concat(";")
        .concat(startOrientation).concat(";")
        .concat(endX).concat(";")
        .concat(endY).concat(";")
        .concat(endOrientation)
        .concat(";")
        .concat(instruction).concat("\n")
      step.concat(formatCSV(reste, num + 1))
    }
    case Nil => ""
  }

}
