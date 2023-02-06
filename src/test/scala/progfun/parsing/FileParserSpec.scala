package progfun.parsing

import com.typesafe.config.{Config, ConfigFactory}
import org.scalatest.funsuite.AnyFunSuite
import progfun.models.{Coordinate, Lawn, Lawnmower}
import progfun.parsing.FileParser.parseLines
import progfun.utils.ListComparator
import progfun.writer.JSONWriter
import progfun.writer.JSONWriter.JSONResult

import scala.io.BufferedSource


class FileParserSpec extends AnyFunSuite {

  val conf: Config = ConfigFactory.load()
  val input : String = conf.getString("appplication.input-file")
  val source: BufferedSource = scala.io.Source.fromFile(input)

  val output: JSONWriter.JSONResult = FileParser.execute(source)
  val parsedLawnmowers: List[Lawnmower] = output.tondeuses

  val limit: Coordinate = new Coordinate(5,5)
  val lawn: Lawn = new Lawn(5,5)
  val lawnsPositions: List[String] = List("3 3 E", "1 2 N")
  val lawnsInstructions: List[String] = List("AADAADADDA", "GAGAGAGAA")

  //parseLines() function test
  val mowerList: List[Lawnmower] = parseLines(lawn, lawnsPositions, lawnsInstructions, 1)
  test("Should parsedLawnmowers equal mowerList") {
    assert(ListComparator.areLawnmowerListsEqual(parsedLawnmowers, mowerList))
  }

  //execute() function test
  val jsonResult:JSONResult = new JSONResult(limit, mowerList)
  test("should output equal jsonResult") {
    assert(jsonResult.equals(output))
  }
}
