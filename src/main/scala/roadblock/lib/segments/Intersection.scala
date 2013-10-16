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

    val order : Seq[RoadSegment] = Random.shuffle(Seq(this.frontNeighbor, this.backNeighbor, this.leftSideNeighbor, this.rightSideNeighbor))
    val newFront = order(0)
    val newBack = order(1)
    val newLeft = order(2)
    val newRight = order(3)

    this.frontNeighbor = newFront
    this.backNeighbor = newBack
    this.leftSideNeighbor = newLeft
    this.rightSideNeighbor = newRight

    super.acceptCar(car)
  }
}
