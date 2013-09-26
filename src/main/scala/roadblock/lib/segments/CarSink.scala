package roadblock.lib.segments

import roadblock.lib.interfaces.{RoadNetwork, RoadState, Car, RoadSegment}

/**
 * User: denise
 * Date: 9/26/13
 * Time: 11:56 AM
 */
class CarSink extends RoadSegment {
  frontNeighbor = new NowhereSegment()
  backNeighbor = new NowhereSegment()
  leftSideNeighbor = new NowhereSegment()
  rightSideNeighbor = new NowhereSegment()
  var state: roadblock.lib.interfaces.RoadState = null
  var segmentType : Symbol = 'sink

  override def acceptCar(car : Car) = {
    val newState = new RoadState {
      def occupied: Boolean = false

      def forwardMotionPermitted(): Boolean = false

      def leftwardMotionPermitted(): Boolean = false

      def backwardMotionPermitted(): Boolean = false

      def rightwardMotionPermitted(): Boolean = false

      def collided: Boolean = false
    }
  }
}
