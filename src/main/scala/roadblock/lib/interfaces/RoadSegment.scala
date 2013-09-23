package roadblock.lib.interfaces

import net.liftweb.json.{Extraction, JValue}

import net.liftweb._
import util._
import Helpers._
import common._
import json._

/**
 * User: denise
 * Date: 9/18/13
 * Time: 4:32 PM
 */
trait RoadSegment {
  var state : RoadState
  var frontNeighbor : RoadSegment
  var backNeighbor : RoadSegment
  var leftSideNeighbor : RoadSegment
  var rightSideNeighbor : RoadSegment
  var segmentType : Symbol
  var x : Integer = 0
  var y : Integer = 0

  def tick()

  def acceptCar(car : Car) = {
    new RoadState {
      def isOccupied(): Boolean = true

      def isCollided(): Boolean = state.isOccupied()

      def forwardMotionPermitted(): Boolean = frontNeighbor.segmentType!='no_segment

      def leftwardMotionPermitted(): Boolean = leftSideNeighbor.segmentType!='no_segment

      def backwardMotionPermitted(): Boolean = backNeighbor.segmentType!='no_segment

      def rightwardMotionPermitted(): Boolean = rightSideNeighbor.segmentType!='no_segment
    }
  }
  def unacceptCar(car : Car) = {
    new RoadState {
      def isOccupied(): Boolean = false

      def isCollided(): Boolean = false

      def forwardMotionPermitted(): Boolean = frontNeighbor.segmentType !='no_segment

      def leftwardMotionPermitted(): Boolean = leftSideNeighbor.segmentType !='no_segment

      def backwardMotionPermitted(): Boolean = backNeighbor.segmentType !='no_segment

      def rightwardMotionPermitted(): Boolean = rightSideNeighbor.segmentType !='no_segment
    }
  }

  object RoadSegment {
    private implicit val formats = net.liftweb.json.DefaultFormats

    implicit def toJson(item: RoadSegment): JValue = Extraction.decompose(item)

    implicit def toJson(items: Seq[RoadSegment]): JValue = Extraction.decompose(items)
  }
}
