package controllers

import javax.inject.*
import play.api.mvc.*

import play.api.data.*
import play.api.data.Forms.*

case class UserData(name: String, age: Int)
object UserData:
  def unapply(data: UserData): Option[(String, Int)] = Some((data.name, data.age))

// NOTE: Add the following to conf/routes to enable compilation of this class:
/*
GET     /user        controllers.UserController.userGet()
POST    /user        controllers.UserController.userPost()
*/

/**
 * User form controller for Play Scala
 */
class UserController @Inject()(mcc: MessagesControllerComponents) extends MessagesAbstractController(mcc):

  val userForm = Form(
    mapping(
      "name" -> text,
      "age" -> number
    )(UserData.apply)(UserData.unapply)
  )

  def userGet() = Action { implicit request: MessagesRequest[AnyContent] =>
    Ok(views.html.user.form(userForm))
  }

  def userPost() = Action { implicit request: MessagesRequest[AnyContent] =>
    userForm.bindFromRequest().fold(
      formWithErrors =>
        // binding failure, you retrieve the form containing errors:
        BadRequest(views.html.user.form(formWithErrors)),

      userData =>
        /* binding success, you get the actual value. */       
        /* flashing uses a short lived cookie */ 
        Redirect(routes.UserController.userGet()).flashing("success" -> ("Successful " + userData.toString))
    )
  }
