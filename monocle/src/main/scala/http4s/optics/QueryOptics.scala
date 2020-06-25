/*
 * Copyright 2013-2020 http4s.org
 *
 * SPDX-License-Identifier: Apache-2.0
 */

package org.http4s
package optics

import cats.implicits._
import monocle._

object QueryOptics {
  import Query._

  val pairs: Iso[Query, Vector[KeyValue]] =
    Iso[Query, Vector[KeyValue]](_.pairs)(fromVector)

  val traversal: Traversal[Query, KeyValue] =
    pairs composeTraversal Traversal.fromTraverse[Vector, KeyValue]
}

