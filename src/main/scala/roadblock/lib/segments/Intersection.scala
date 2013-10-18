package roadblock.lib.segments

import roadblock.lib.interfaces.{Car, RoadState, RoadSegment}
import scala.util.Random

/**
 * User: denise
 * Date: 10/14/13
 * Time: 10:53 PM
 */
class Intersection extends NotNullSegment {

  var segmentType : Symbol= 'intersection
  var state : RoadState= null

  override def acceptCar(car:Car) = {

    val potentialForwards = Seq(this.frontNeighbor, this.backNeighbor,
      this.leftSideNeighbor, this.rightSideNeighbor).filter(
        neighbor =>  {
          neighbor.backNeighbor.equals(this)
        }
    )

    if (potentialForwards.size > 0) {
      val newFront = potentialForwards(0)

      this.leftSideNeighbor = if (this.leftSideNeighbor == newFront) this.frontNeighbor else this.leftSideNeighbor
      this.rightSideNeighbor = if (this.rightSideNeighbor == newFront) this.frontNeighbor else this.rightSideNeighbor
      this.backNeighbor = if (this.backNeighbor == newFront) this.frontNeighbor else this.backNeighbor
      this.frontNeighbor = newFront
    }

    super.acceptCar(car)
  }
}
