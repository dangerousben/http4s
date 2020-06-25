/*
 * Copyright 2013-2020 http4s.org
 *
 * SPDX-License-Identifier: Apache-2.0
 */

package org.http4s
package optics

import cats.implicits._
import monocle.law.discipline._

class HostOpticsSpec extends Http4sSpec {
  checkAll("ipv4Address", PrismTests(HostOptics.ipv4Address))
  checkAll("ipv6Address", PrismTests(HostOptics.ipv6Address))
  checkAll("regName", PrismTests(HostOptics.regName))

  checkAll("Ipv4Address.a", LensTests(HostOptics.Ipv4Address.a))
  checkAll("Ipv4Address.b", LensTests(HostOptics.Ipv4Address.b))
  checkAll("Ipv4Address.c", LensTests(HostOptics.Ipv4Address.c))
  checkAll("Ipv4Address.d", LensTests(HostOptics.Ipv4Address.d))
  checkAll("Ipv4Address.bytes", IsoTests(HostOptics.Ipv4Address.bytes))
  checkAll("Ipv4Address.traversal", TraversalTests(HostOptics.Ipv4Address.traversal))


}
