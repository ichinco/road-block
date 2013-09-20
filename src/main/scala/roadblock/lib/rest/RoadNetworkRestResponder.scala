package roadblock.lib.rest

import roadblock.lib.grid.{RoadGrid, RoadGridSegment}
import net.liftweb.http.rest.{RestHelper, JsonSelect, XmlSelect}

/**
 * User: denise
 * Date: 9/19/13
 * Time: 3:55 PM
 */
object RoadNetworkRestResponder extends RestHelper {

  implicit def expenseToRestResponse : JxCvtPF[RoadGrid] = {
    case (JsonSelect, e, _) => toJSON(e)
    case (XmlSelect, e, _) => toXML(e)
  }

  serveJx[RoadGrid] {
    case "roadnetwork" :: id :: Nil Get _ => new RoadGrid(1)
  }

}
