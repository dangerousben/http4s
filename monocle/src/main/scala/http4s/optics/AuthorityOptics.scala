/*
 * Copyright 2013-2020 http4s.org
 *
 * SPDX-License-Identifier: Apache-2.0
 */

package org.http4s
package optics

import monocle.Lens
import monocle.macros.GenLens

object AuthorityOptics {
  import Uri._

  val userInfo: Lens[Authority, Option[UserInfo]] =
    GenLens[Authority](_.userInfo)

  val host: Lens[Authority, Host] =
    GenLens[Authority](_.host)

  val port: Lens[Authority, Option[Int]] =
    GenLens[Authority](_.port)
}
