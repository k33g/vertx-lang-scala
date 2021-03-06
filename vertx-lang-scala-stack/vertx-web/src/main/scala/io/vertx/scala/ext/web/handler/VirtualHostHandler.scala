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

package io.vertx.scala.ext.web.handler

import io.vertx.lang.scala.HandlerOps._
import scala.reflect.runtime.universe._
import io.vertx.lang.scala.Converter._
import io.vertx.ext.web.{RoutingContext => JRoutingContext}
import io.vertx.ext.web.handler.{VirtualHostHandler => JVirtualHostHandler}
import io.vertx.scala.ext.web.RoutingContext
import io.vertx.core.Handler

/**
  * Handler that will filter requests based on the request Host name.
  */
class VirtualHostHandler(private val _asJava: Object)
    extends io.vertx.core.Handler[RoutingContext] {

  def asJava = _asJava

  override def handle(arg0: RoutingContext): Unit = {
    asJava.asInstanceOf[JVirtualHostHandler].handle(arg0.asJava.asInstanceOf[JRoutingContext])
  }

}

object VirtualHostHandler {
  def apply(asJava: JVirtualHostHandler) = new VirtualHostHandler(asJava)  
  /**
    * Create a handler
    * @return the handler
    */
  def create(hostname: String, handler: Handler[RoutingContext]): VirtualHostHandler = {
    VirtualHostHandler(JVirtualHostHandler.create(hostname.asInstanceOf[java.lang.String], {x: JRoutingContext => handler.handle(RoutingContext(x))}))
  }

}
