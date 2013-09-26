package roadblock.lib.cars

import roadblock.lib.interfaces.{RoadNetwork, RoadSegment, Car}
import roadblock.lib.segments.NowhereSegment

/**
 * User: denise
 * Date: 9/18/13
 * Time: 4:37 PM
 */
class CruiseControl(desiredSpeed : Integer) extends Car { //speed will be in seconds per segment
  currentSegment= new NowhereSegment()
  var ticksInCurrentSegment : Integer = 0
  var ticking : Boolean = false

  def tick(network: RoadNetwork) = {
    if (!ticking) {
      ticking = true
      if (ticksInCurrentSegment > desiredSpeed &&
        this.currentSegment.state.forwardMotionPermitted()) {
        val newSegment = network.getForwardSegment(this.currentSegment, 1)
        if (!newSegment.state.occupied){
          this.changeToSegment(newSegment)
          ticksInCurrentSegment = 0
        }
      } else {
        ticksInCurrentSegment.+=(1)
      }
      ticking = false
    }
  }
}
