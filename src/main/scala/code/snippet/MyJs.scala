package code.snippet

import scala.xml.{NodeSeq, Text}
import net.liftweb.util._
import net.liftweb.common._
import java.util.Date
import Helpers._
import net.liftweb.http.{js, SHtml, S}
import net.liftweb.http.js.JsCmds.{SetHtml, RedirectTo, Noop}
import net.liftweb.http.js.{JE, JsCmd}

/**
 * Created with IntelliJ IDEA.
 * User: Winston
 * Date: 11/23/13
 * Time: 10:05 AM
 * To change this template use File | Settings | File Templates.
 */
class MyJs {
  def bodyOnload = {
    val jsonMsg = "{\"msg\":\"this message is from the backend\"}"
    "#page_init [onload]" #> JE.JsRaw("alertJsonObj(%s)".format(jsonMsg)).cmd
  }

  def iniJs = {
    val jsonMsg = "{\"msg\":\"this message is from the backend\"}"
    "#ini_script *" #> JE.JsRaw("alertJsonObj(%s)".format(jsonMsg)).cmd
  }
}
