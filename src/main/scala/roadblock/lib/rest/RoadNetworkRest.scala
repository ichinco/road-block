package roadblock.lib.rest

import net.liftweb._
import common._
import http._
import rest._
import util._
import Helpers._
import json._
import net.liftweb.json.JsonDSL._
import scala.xml._
import roadblock.lib.segments.SegmentState
import roadblock.comet.Universe

/**
 * A full REST example
 */
object RoadNetworkRest extends RestHelper {

  // Serve /api/item and friends
  serve( "rest" / "network" prefix {

    // POST if we find the item, merge the fields from the
    // the POST body and update the item
    case Nil JsonPost json -> _ =>
      Universe ! json
      ("success" -> true) : JValue

  })
}
