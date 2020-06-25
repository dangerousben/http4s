/*
 * Copyright 2013-2020 http4s.org
 *
 * SPDX-License-Identifier: Apache-2.0
 */

package org.http4s
package optics

import cats.Id
import monocle.law.discipline._

class RequestOpticsSpec extends Http4sSpec {
  val optics = new RequestOptics[Id]

  checkAll("httpVersion", LensTests(optics.httpVersion))
  checkAll("headers", LensTests(optics.headers))
  checkAll("body", LensTests(optics.body))
  checkAll("attributes", LensTests(optics.attributes))
  checkAll("method", LensTests(optics.method))
  checkAll("uri", LensTests(optics.uri))
}
