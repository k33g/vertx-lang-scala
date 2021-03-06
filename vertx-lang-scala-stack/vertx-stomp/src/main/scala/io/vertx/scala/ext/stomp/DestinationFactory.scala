/*
 * Copyright 2014 Red Hat, Inc.
 *
 * Red Hat licenses this file to you under the Apache License, version 2.0
 * (the "License"); you may not use this file except in compliance with the
 * License.  You may obtain a copy of the License at:
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */

package io.vertx.scala.ext.stomp

import io.vertx.lang.scala.HandlerOps._
import scala.reflect.runtime.universe._
import io.vertx.lang.scala.Converter._
import io.vertx.ext.stomp.{DestinationFactory => JDestinationFactory}
import io.vertx.ext.stomp.{Destination => JDestination}
import io.vertx.scala.core.Vertx
import io.vertx.core.{Vertx => JVertx}

/**
  * Interface implemented to customize the destination creation.
  */
class DestinationFactory(private val _asJava: Object) {

  def asJava = _asJava

  /**
    * Creates a destination for the given <em>address</em>.
    * @param vertx the vert.x instance used by the STOMP server.
    * @param name the destination name.
    * @return the destination, `null` to reject the creation.
    */
  def create(vertx: Vertx, name: String): Destination = {
    Destination(asJava.asInstanceOf[JDestinationFactory].create(vertx.asJava.asInstanceOf[JVertx], name.asInstanceOf[java.lang.String]))
  }

}

object DestinationFactory {
  def apply(asJava: JDestinationFactory) = new DestinationFactory(asJava)  
}
