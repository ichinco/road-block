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
case class SegmentState(segment : RoadSegment) {
  val segmentType = segment.segmentType
  val x :Int = segment.x
  val y :Int = segment.y
  val left = segment.state.leftwardMotionPermitted()
  val right = segment.state.rightwardMotionPermitted()
  val top = segment.state.forwardMotionPermitted()
  val bottom = segment.state.backwardMotionPermitted()
  val collided = segment.state.collided
  val occupied = segment.state.occupied
}

object SegmentState {
  private implicit val formats = net.liftweb.json.DefaultFormats

  implicit def toJson(item: SegmentState): JValue = {
    ("type" -> item.segmentType) ~
    ("x" -> item.x) ~
    ("y" -> item.y) ~
    ("left" -> item.left) ~
    ("right" -> item.right) ~
    ("top" -> item.top) ~
    ("bottom" -> item.bottom) ~
    ("collided" -> item.collided) ~
    ("occupied" -> item.occupied)
  }

}
