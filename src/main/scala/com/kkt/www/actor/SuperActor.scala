package com.kkt.www.actor

import akka.actor.SupervisorStrategy.Escalate
import akka.actor._
import com.kkt.www.MyApp


/**
 * Created by kkt on 2015-06-06.
 */

class SuperActor extends Actor with ActorLogging{

  override val supervisorStrategy =
//    AllForOneStrategy(){
    OneForOneStrategy(){
      case _: Exception => {
        println("!!!!!!!!!!!!!!!!!!")
        Escalate
      }
    }

  val childAct1 = context.actorOf(Props[ChildActor], "childAct1")
  context.watch(childAct1)
  var lastSender = MyApp.system.deadLetters
  println("lastSender:" + lastSender)

  def receive  = {
    case "kill" => {
      context.stop(childAct1)
      lastSender = sender()
    }
    case x => {
      childAct1 ! "***" + x
    }
    case Terminated(`childAct1`)  => {
      println("!lastSender:" + lastSender)
      lastSender ! "finished"
    }
  }




}
