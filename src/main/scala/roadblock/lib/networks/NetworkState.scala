package roadblock.lib.networks

import roadblock.lib.interfaces.{RoadNetwork, RoadSegment}
import net.liftweb.json.JValue

import net.liftweb._
import util._
import Helpers._
import common._
import json._

import net.liftweb.json.JsonDSL._
import net.liftweb.json.JsonAST._
import roadblock.lib.segments.SegmentState

/**
 * User: denise
 * Date: 9/24/13
 * Time: 1:31 PM
 */
case class NetworkState(network : RoadNetwork) {
  def segments : Seq[RoadSegment] = network.segments

}

object NetworkState {
  private implicit val formats = net.liftweb.json.DefaultFormats

  implicit def toJson(item : NetworkState) : JValue = {
    "segments" -> item.segments.map((s: RoadSegment) => {
      val state = SegmentState()
      state.setBasedOnRoadSegment(s)
      state
    })
  }
}