package roadblock.lib.segments

import net.liftweb.json._

import net.liftweb._
import util._
import Helpers._
import common._
import json._

import net.liftweb.json.JsonDSL._
import net.liftweb.json.JsonAST._
import roadblock.lib.interfaces.RoadSegment

/**
 * User: denise
 * Date: 9/24/13
 * Time: 12:07 PM
 */
case class SegmentState() {
  var segmentType = 'none
  var x :Int = 0
  var y :Int = 0
  var left = false
  var right = false
  var top = false
  var bottom = false
  var collided = false
  var occupied = false
  var direction : Symbol = 'none

  def setBasedOnRoadSegment(segment : RoadSegment) = {
    segmentType = segment.segmentType
    x = segment.x
    y = segment.y
    left = segment.state.leftwardMotionPermitted()
    right = segment.state.rightwardMotionPermitted()
    top = segment.state.forwardMotionPermitted()
    bottom = segment.state.backwardMotionPermitted()
    collided = segment.state.collided
    occupied = segment.state.occupied
    direction = {
      if (segment.frontNeighbor != null && segment.frontNeighbor.x < segment.x) {
        'left
      } else if (segment.frontNeighbor != null && segment.frontNeighbor.x > segment.x) {
        'right
      } else if (segment.frontNeighbor != null && segment.frontNeighbor.y < segment.y) {
        'up
      } else if (segment.frontNeighbor != null && segment.frontNeighbor.y > segment.y) {
        'down
      } else {
        'none
      }
    }
  }
}

object SegmentState {
  private implicit val formats = net.liftweb.json.DefaultFormats

  def apply(in: JValue): Box[SegmentState] = Helpers.tryo{in.extract[SegmentState]}

  def unapply(in: JValue): Option[SegmentState] = apply(in)

  def fromJson(in : JValue) : SegmentState = {
    val state : SegmentState = SegmentState()
    state.segmentType = (in \ "segmentType").extract[Symbol]
    state.x = (in \ "x").extract[Int]
    state.y = (in \ "y").extract[Int]
    state.direction = (in \ "direction").extract[Symbol]
    state
  }

  implicit def toJson(item: SegmentState): JValue = {
    ("segmentType" -> item.segmentType) ~
    ("x" -> item.x) ~
    ("y" -> item.y) ~
    ("left" -> item.left) ~
    ("right" -> item.right) ~
    ("top" -> item.top) ~
    ("bottom" -> item.bottom) ~
    ("collided" -> item.collided) ~
    ("occupied" -> item.occupied) ~
    ("direction" -> item.direction)
  }

}
