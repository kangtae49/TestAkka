package com.kkt.www

import akka.actor.{Props, ActorSystem}
import com.kkt.www.actor.SuperActor
import com.typesafe.config.ConfigFactory

/**
 * Created by ktkim on 2015-06-08.
 */
object MyApp {

  val config = ConfigFactory.load("MyAkka");
  val system = ActorSystem("MyAkka", config )

  def test_config(): Unit = {

        val aa = config.getString("akka.aa")
        println("aa:" + aa) // aa:123


  }

  def test_watch() = {

    val superActor = system.actorOf(Props[SuperActor])
    superActor ! "test123"

    Thread sleep 5000

    superActor ! "kill"


  }

  def main(args: Array[String]) {

//    test_config()
      test_watch()

  }


}
