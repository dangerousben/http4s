/*
 * Copyright 2013-2020 http4s.org
 *
 * SPDX-License-Identifier: Apache-2.0
 */

package org.http4s
package optics

import monocle.Lens
import monocle.macros.GenLens

object UriOptics {
  val scheme: Lens[Uri, Option[Uri.Scheme]] =
    GenLens[Uri](_.scheme)
  val authority: Lens[Uri, Option[Uri.Authority]] =
    GenLens[Uri](_.authority)
  val path: Lens[Uri, Uri.Path] =
    GenLens[Uri](_.path)
  val query: Lens[Uri, Query] =
    GenLens[Uri](_.query)
  val fragment: Lens[Uri, Option[Uri.Fragment]] =
    GenLens[Uri](_.fragment)

  // consider ISO or Prism to java.net.URI
}
