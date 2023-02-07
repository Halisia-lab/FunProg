package progfun.parser

import com.typesafe.config.{Config, ConfigFactory}
import org.scalatest.funsuite.AnyFunSuite
import progfun.models.{Coordinate, Lawn, Lawnmower, Orientation, Position}
import progfun.utils.ListComparator
import progfun.writer.JSONWriter
import progfun.writer.JSONWriter.JSONResult

import scala.io.BufferedSource

class FileParserSpec extends AnyFunSuite {

  val conf: Config = ConfigFactory.load()
  val input: String = conf.getString("appplication.input-file")
  val source: BufferedSource = scala.io.Source.fromFile(input)

  val output: JSONWriter.JSONResult = FileParser.execute(source)
  val parsedLawnmowers: List[Lawnmower] = output.tondeuses

  val limit: Coordinate = new Coordinate(5, 5)
  val lawn: Lawn = new Lawn(5, 5)
  val lawnmower1: Lawnmower = Lawnmower(
    lawn,
    Position(Coordinate(3, 3), Orientation("E")),
    List("A", "A", "D", "A", "A", "D", "A", "D", "D", "A"),
    Position(Coordinate(5, 1), Orientation("E"))
  )
  val lawnmower2: Lawnmower = Lawnmower(
    lawn,
    Position(Coordinate(1, 2), Orientation("N")),
    List("G", "A", "G", "A", "G", "A", "G", "A", "A"),
    Position(Coordinate(1, 3), Orientation("N"))
  )
  val lawnmowers: List[Lawnmower] = List(lawnmower1, lawnmower2)

  val jsonResult: JSONResult = new JSONResult(limit, lawnmowers)

  test("should output equal jsonResult") {
    assert(jsonResult.equals(output))
  }

  test("Should parsedLawnmowers equal lawnmowers") {
    assert(ListComparator.areLawnmowerListsEqual(parsedLawnmowers, lawnmowers))
  }

}
