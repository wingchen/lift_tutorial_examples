package code.snippet

import scala.xml.{NodeSeq, Text}
import net.liftweb.util._
import net.liftweb.common._
import java.util.Date
import Helpers._
import net.liftweb.http.{js, SHtml, S}
import net.liftweb.http.js.JsCmds.RedirectTo
import net.liftweb.http.js.JsCmd
import js.JsCmds.Noop

class Forms {

  def regularForm = {
    var username = ""
    var password = ""

    def process() = {
      S.notice("username","username: " + username)
      S.notice("password","password: " + password)
      S.redirectTo(S.uri)
    }

    var bindings = "name=username" #> SHtml.text(username, username = _)
    bindings &= "name=password" #> SHtml.password(password, password = _)
    bindings &= "type=submit" #> SHtml.onSubmitUnit(process)

    bindings
  }

  def ajaxForm = {
    var username = ""
    var password = ""

    def process():JsCmd = {
      S.notice("username","username: " + username)
      S.notice("password","password: " + password)
      Noop
    }

    var bindings = "name=username" #> SHtml.text(username, username = _)
    bindings &= "name=password" #> (SHtml.password(password, password = _) ++ SHtml.hidden(process))

    bindings
  }

}
