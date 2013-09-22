package roadblock.comet

import net.liftweb.http.{CometListener, CometActor}
import net.liftweb.http.js.{JE, JsCmd}
import net.liftweb.json._
import net.liftweb.util.ClearClearable
import net.liftweb.json.JsonDSL._

/**
 * User: denise
 * Date: 9/22/13
 * Time: 3:52 PM
 */
class JsonListener extends CometActor with CometListener {

  def registerWith = Universe

  override def lowPriority = {
    case _ => {
      sendState()
    }
  }

  def render = {
    ClearClearable
  }

  private[this] def sendState() = {
    partialUpdate(NewMessageNg(""))
  }

}

case class NewMessageNg(message: String) extends JsCmd {
  implicit val formats = DefaultFormats.lossless
  val json: JValue = ("message" -> message)
  override val toJsCmd = JE.JsRaw(""" $(document).trigger('new-ng-state', %s)""".format( compact( render( json ) ) ) ).toJsCmd
}
