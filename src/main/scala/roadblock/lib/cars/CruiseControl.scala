package roadblock.lib.cars

import roadblock.lib.interfaces.{RoadNetwork, RoadSegment, Car}
import roadblock.lib.segments.NowhereSegment

/**
 * User: denise
 * Date: 9/18/13
 * Time: 4:37 PM
 */
class CruiseControl(desiredSpeed : Integer) extends Car { //speed will be in seconds per segment
  var currentSegment : RoadSegment = new NowhereSegment()
  var ticksInCurrentSegment : Integer = 0

  def tick(network: RoadNetwork) = {
    if (ticksInCurrentSegment > desiredSpeed) {
      this.currentSegment.unacceptCar(this)
      val newSegment = network.getForwardSegment(this.currentSegment, 1)
      currentSegment = newSegment
      this.currentSegment.acceptCar(this)
      ticksInCurrentSegment = 0
    } else {
      ticksInCurrentSegment.+=(1)
    }
  }
}
