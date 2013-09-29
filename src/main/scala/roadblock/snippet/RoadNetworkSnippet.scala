package roadblock
package snippet

import net.liftweb._
import http._
import js._
import JsCmds._
import JE._
import roadblock.comet.Universe
import scala.xml.{Text, NodeSeq}

/**
 * User: denise
 * Date: 9/19/13
 * Time: 2:38 PM
 */
class RoadNetworkSnippet extends StatefulSnippet {
  def dispatch = {
    case "change" => change
  }

  var x : Int = 0
  var y : Int = 0
  var segmentType : String = ""
  var direction : String = ""

  def change(in: NodeSeq): NodeSeq = {
    Text("")
  }

}
