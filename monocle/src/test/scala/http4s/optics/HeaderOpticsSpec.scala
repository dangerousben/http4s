/*
 * Copyright 2013-2020 http4s.org
 *
 * SPDX-License-Identifier: Apache-2.0
 */

package org.http4s
package optics

import cats.Eq
import cats.implicits._
import monocle.law.discipline._
import org.typelevel.ci.testing.arbitraries._

class HeaderOpticsSpec extends Http4sSpec {
  import headers._

  val eqH = implicitly[Eq[Header]]
  // implicit def eqHeader[H <: Header]: Eq[H] = eqH.narrow[H]

  checkAll("raw", PrismTests(HeaderOptics.raw))
  checkAll("Accept-Charset", PrismTests(HeaderOptics.prism(`Accept-Charset`)))

  checkAll("Raw.name", LensTests(HeaderOptics.Raw.name))
  checkAll("Raw.value", LensTests(HeaderOptics.Raw.value))
}
