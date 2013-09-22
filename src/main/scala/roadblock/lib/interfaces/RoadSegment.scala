package roadblock.lib.interfaces

/**
 * User: denise
 * Date: 9/18/13
 * Time: 4:32 PM
 */
trait RoadSegment {
  def state : RoadState
  def frontNeighbor : RoadSegment
  def backNeighbor : RoadSegment
  def leftSideNeighbor : RoadSegment
  def rightSideNeighbor : RoadSegment
  def segmentType : Symbol

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
  def getState():RoadState = {
    state
  }
  def getFrontNeighbor():RoadSegment = {
    frontNeighbor
  }
  def getBackNeighbor():RoadSegment = {
    backNeighbor
  }
  def getLeftSideNeighbor():RoadSegment = {
    leftSideNeighbor
  }
  def getRightSideNeighbor():RoadSegment = {
    rightSideNeighbor
  }
}
