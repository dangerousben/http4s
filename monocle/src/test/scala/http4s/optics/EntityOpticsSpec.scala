/*
 * Copyright 2013-2020 http4s.org
 *
 * SPDX-License-Identifier: Apache-2.0
 */

package org.http4s
package optics

import cats.Id
import cats.implicits._
import monocle.law.discipline._

class EntityOpticsSpec extends Http4sSpec {
  val optics = new EntityOptics[Id]

  checkAll("body", LensTests(optics.body))
  checkAll("length", LensTests(optics.length))
}
