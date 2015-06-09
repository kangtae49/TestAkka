package com.kkt.www.actor

import akka.actor.Actor


/**
 * Created by kkt on 2015-06-06.
 */

class Child2Actor extends Actor{
  def receive = {
    case x => {
      println("---------------")
      println("[2]" + x)
      println("---------------")
    }
  }
}
