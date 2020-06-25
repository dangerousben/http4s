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

object HostOptics {
  import Uri._

  val ipv4Address: Prism[Host, Ipv4Address] =
    GenPrism[Host, Ipv4Address]

  val ipv6Address: Prism[Host, Ipv6Address] =
    GenPrism[Host, Ipv6Address]

  val regName: Prism[Host, RegName] =
    GenPrism[Host, RegName]

  object Ipv4Address {
    val a: Lens[Ipv4Address, Byte] =
      GenLens[Ipv4Address](_.a)

    val b: Lens[Ipv4Address, Byte] =
      GenLens[Ipv4Address](_.b)

    val c: Lens[Ipv4Address, Byte] =
      GenLens[Ipv4Address](_.c)

    val d: Lens[Ipv4Address, Byte] =
      GenLens[Ipv4Address](_.d)

    val bytes: Iso[Ipv4Address, (Byte, Byte, Byte, Byte)] =
      GenIso.fields[Ipv4Address]

    val traversal: Traversal[Ipv4Address, Byte] =
      Traversal.applyN(a, b, c, d)
  }

  object RegName {
    val host: Lens[RegName, CIString] =
      GenLens[RegName](_.host)
  }
}
