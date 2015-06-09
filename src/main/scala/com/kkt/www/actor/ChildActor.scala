package com.kkt.www.actor

import akka.actor.SupervisorStrategy.Escalate
import akka.actor.{OneForOneStrategy, Props, Actor}


/**
 * Created by kkt on 2015-06-06.
 */
class ChildActor extends Actor {
  override val supervisorStrategy =
  //    AllForOneStrategy(){
    OneForOneStrategy(){
      case _: Exception => {
        println("#########")
        Escalate
      }
    }

  val child2Actor = context.actorOf(Props[Child2Actor])

  def receive = {
    case x => {
      child2Actor ! "[1]" + x

    }
  }
}
