/*
 * Copyright 2013-2020 http4s.org
 *
 * SPDX-License-Identifier: Apache-2.0
 */

package org.http4s
package optics

import cats.implicits._
import monocle.law.discipline._

class AuthorityOpticsSpec extends Http4sSpec {
  checkAll("userInfo", LensTests(AuthorityOptics.userInfo))
  checkAll("host", LensTests(AuthorityOptics.host))
  checkAll("port", LensTests(AuthorityOptics.port))
}
