/*
 * Copyright 2013-2020 http4s.org
 *
 * SPDX-License-Identifier: Apache-2.0
 */

package org.http4s
package optics

import cats.Id
import monocle.law.discipline._

class ResponseOpticsSpec extends Http4sSpec {
  val optics = new ResponseOptics[Id]

  checkAll("httpVersion", LensTests(optics.httpVersion))
  checkAll("headers", LensTests(optics.headers))
  checkAll("body", LensTests(optics.body))
  checkAll("attributes", LensTests(optics.attributes))
  checkAll("status", LensTests(optics.status))
}
