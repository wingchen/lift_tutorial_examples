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
 * Date: 11/3/13
 * Time: 8:05 PM
 * To change this template use File | Settings | File Templates.
 */
class MyAjax {
  def changeDom =
    "name=changeme [onclick]" #> SetHtml("changable", Text("I am a chagned man."))

  def triggerJsFunction =
    "name=trigger_js_function [onclick]" #> JE.JsRaw("alert('js function is triggered');").cmd

  def onDomChange =
    "name=type_something [onkeydown]" #> SHtml.ajaxInvoke(() => {
      JE.JsRaw("$('#typeted').html($('[name=type_something]').val())").cmd
    })

}
