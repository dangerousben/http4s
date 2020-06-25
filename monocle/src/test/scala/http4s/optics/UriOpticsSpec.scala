/*
 * Copyright 2013-2020 http4s.org
 *
 * SPDX-License-Identifier: Apache-2.0
 */

package org.http4s
package optics

import cats.implicits._
import monocle.law.discipline._

class UriOpticsSpec extends Http4sSpec {
  checkAll("scheme", LensTests(UriOptics.scheme))
  checkAll("authority", LensTests(UriOptics.authority))
  checkAll("path", LensTests(UriOptics.path))
  checkAll("query", LensTests(UriOptics.query))
  checkAll("fragment", LensTests(UriOptics.fragment))
}
