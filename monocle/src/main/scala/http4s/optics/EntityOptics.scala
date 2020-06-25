/*
 * Copyright 2013-2020 http4s.org
 *
 * SPDX-License-Identifier: Apache-2.0
 */

package org.http4s
package optics

import monocle.Lens
import monocle.macros.GenLens

class EntityOptics[F[_]] {
  val body: Lens[Entity[F], EntityBody[F]] =
    GenLens[Entity[F]](_.body)

  val length: Lens[Entity[F], Option[Long]] =
    GenLens[Entity[F]](_.length)
}
