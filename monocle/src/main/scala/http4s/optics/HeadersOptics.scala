/*
 * Copyright 2013-2020 http4s.org
 *
 * SPDX-License-Identifier: Apache-2.0
 */

package org.http4s
package optics

import cats.implicits._
import monocle._

object HeadersOptics {
  val headers: Iso[Headers, List[Header]] =
    Iso[Headers, List[Header]](_.toList)(Headers(_))

  val traversal: Traversal[Headers, Header] =
    headers composeTraversal Traversal.fromTraverse[List, Header]
}
