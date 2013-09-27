package roadblock.lib.segments

import roadblock.lib.interfaces.{RoadNetwork, RoadState, Car, RoadSegment}
import roadblock.lib.cars.CruiseControl

/**
 * User: denise
 * Date: 9/26/13
 * Time: 11:55 AM
 */
class CarSource(ticksToNewCar : Int) extends NotNullSegment {
  var state: roadblock.lib.interfaces.RoadState = null
  var segmentType : Symbol = 'source

  var ticksWithNoCar : Int = 0

  override def tick(network : RoadNetwork) = {
    this.car.tick(network)
    if (ticksWithNoCar > ticksToNewCar && !state.occupied) {
      val car = new CruiseControl(1)
      car.changeToSegment(this)
      ticksWithNoCar = 0
    } else {
      ticksWithNoCar.+=(1)
    }
  }
}
