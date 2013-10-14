package code.snippet

import scala.xml.{NodeSeq, Text}
import net.liftweb.util._
import net.liftweb.common._
import java.util.Date
import Helpers._
import net.liftweb.http.{S, SHtml}

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
}
