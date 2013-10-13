package roadblock.lib.interfaces

import net.liftweb.json.{Extraction, JValue}

import net.liftweb._
import util._
import Helpers._
import common._
import json._
import roadblock.lib.segments.{NullSegment, EmptySegment}

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
  var car : Car

  def tick(network:RoadNetwork) = {
    if (this.car != null){
      this.car.tick(network)
    }
  }

  def initializeState() = {
    val initialState = new RoadState {
      def occupied: Boolean = false

      def forwardMotionPermitted(): Boolean = frontNeighbor.segmentType!='no_segment && frontNeighbor.segmentType!='empty_segment

      def leftwardMotionPermitted(): Boolean = leftSideNeighbor.segmentType!='no_segment && leftSideNeighbor.segmentType!='empty_segment

      def backwardMotionPermitted(): Boolean = backNeighbor.segmentType!='no_segment  && backNeighbor.segmentType!='empty_segment

      def rightwardMotionPermitted(): Boolean = rightSideNeighbor.segmentType!='no_segment && rightSideNeighbor.segmentType!='empty_segment

      def collided: Boolean = false
    }

    state = initialState
  }

  def acceptCar(car : Car) = {
    val alreadyOccupied = this.state.occupied
    val newState = new RoadState {
      def occupied: Boolean = true

      def collided: Boolean = alreadyOccupied

      def forwardMotionPermitted(): Boolean = frontNeighbor.segmentType!='no_segment

      def leftwardMotionPermitted(): Boolean = leftSideNeighbor.segmentType!='no_segment

      def backwardMotionPermitted(): Boolean = backNeighbor.segmentType!='no_segment

      def rightwardMotionPermitted(): Boolean = rightSideNeighbor.segmentType!='no_segment
    }
    this.car = car
    state = newState
  }
  def unacceptCar(car : Car) = {
    val newState = new RoadState {
      def occupied: Boolean = false

      def collided: Boolean = false

      def forwardMotionPermitted(): Boolean = frontNeighbor.segmentType !='no_segment

      def leftwardMotionPermitted(): Boolean = leftSideNeighbor.segmentType !='no_segment

      def backwardMotionPermitted(): Boolean = backNeighbor.segmentType !='no_segment

      def rightwardMotionPermitted(): Boolean = rightSideNeighbor.segmentType !='no_segment
    }

    this.car = Car.empty()
    state = newState
  }
}

object RoadSegment {
  def empty() : RoadSegment = {
    new NullSegment()
  }
}


