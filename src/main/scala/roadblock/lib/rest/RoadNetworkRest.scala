package roadblock.lib.rest

import net.liftweb._
import common._
import http._
import rest._
import util._
import Helpers._
import json._
import net.liftweb.json.JsonDSL._
import net.liftweb.json.JsonAST._
import scala.xml._
import roadblock.lib.segments.SegmentState
import roadblock.comet.Universe

/**
 * A full REST example
 */
object RoadNetworkRest extends RestHelper {

  def addToUniverse(json : JValue) : JValue = {
    Universe ! json.extract[SegmentState]
    ("success" -> true) : JValue
  }

  serve {
    case "rest" :: "network" :: "update" :: Nil JsonPost ((json, req)) =>
      addToUniverse(json)
  }

}
