/*
 * Copyright 2013-2020 http4s.org
 *
 * SPDX-License-Identifier: Apache-2.0
 */

package org.http4s
package optics

import monocle._
import _root_.io.chrisdavenport.vault.Vault

class ResponseOptics[F[_]] {
  val httpVersion: Lens[Response[F], HttpVersion] =
    Lens[Response[F], HttpVersion](_.httpVersion)(v => _.withHttpVersion(v))

  val headers: Lens[Response[F], Headers] =
    Lens[Response[F], Headers](_.headers)(h => _.withHeaders(h))

  val cookies: Getter[Response[F], List[ResponseCookie]] =
    Getter[Response[F], List[ResponseCookie]](_.cookies)

  val body: Lens[Response[F], EntityBody[F]] =
    Lens[Response[F], EntityBody[F]](_.body)(b => _.withBodyStream(b))

  val attributes: Lens[Response[F], Vault] =
    Lens[Response[F], Vault](_.attributes)(a => _.withAttributes(a))

  val status: Lens[Response[F], Status] =
    Lens[Response[F], Status](_.status)(s => _.withStatus(s))
}
