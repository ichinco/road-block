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

  def tick()

  def acceptCar(car : Car) = {
    new RoadState {
      def isOccupied(): Boolean = true

      def isCollided(): Boolean = state.isOccupied()

      def forwardMotionPermitted(): Boolean = frontNeighbor != null

      def leftwardMotionPermitted(): Boolean = leftSideNeighbor != null

      def backwardMotionPermitted(): Boolean = backNeighbor != null

      def rightwardMotionPermitted(): Boolean = rightSideNeighbor != null
    }
  }
  def unacceptCar(car : Car) = {
    new RoadState {
      def isOccupied(): Boolean = false

      def isCollided(): Boolean = false

      def forwardMotionPermitted(): Boolean = frontNeighbor != null

      def leftwardMotionPermitted(): Boolean = leftSideNeighbor != null

      def backwardMotionPermitted(): Boolean = backNeighbor != null

      def rightwardMotionPermitted(): Boolean = rightSideNeighbor != null
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
