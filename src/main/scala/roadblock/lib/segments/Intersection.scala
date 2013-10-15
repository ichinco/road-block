package roadblock.lib.segments

import roadblock.lib.interfaces.{RoadState, RoadSegment}

/**
 * User: denise
 * Date: 10/14/13
 * Time: 10:53 PM
 */
class Intersection extends NotNullSegment {

  var segmentType : Symbol= 'intersection
  var state : RoadState= null
}
