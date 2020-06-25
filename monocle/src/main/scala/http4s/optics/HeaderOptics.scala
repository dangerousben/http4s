/*
 * Copyright 2013-2020 http4s.org
 *
 * SPDX-License-Identifier: Apache-2.0
 */

package org.http4s
package optics

import monocle._
import monocle.macros._
import org.typelevel.ci.CIString

object HeaderOptics {
  val raw: Prism[Header, Header.Raw] =
    GenPrism[Header, Header.Raw]

  def prism(k: HeaderKey): Prism[Header, k.HeaderT] =
    Prism[Header, k.HeaderT](k.matchHeader(_))((h: Header) => h)

  object Raw {
    val name: Lens[Header.Raw, CIString] =
      GenLens[Header.Raw](_.name)

    val value: Lens[Header.Raw, String] =
      GenLens[Header.Raw](_.value)
  }
}
