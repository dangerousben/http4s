/*
 * Copyright 2013-2020 http4s.org
 *
 * SPDX-License-Identifier: Apache-2.0
 */

package org.http4s
package optics

import monocle._
import _root_.io.chrisdavenport.vault.Vault

class RequestOptics[F[_]] {
  val httpVersion: Lens[Request[F], HttpVersion] =
    Lens[Request[F], HttpVersion](_.httpVersion)(v => _.withHttpVersion(v))

  val headers: Lens[Request[F], Headers] =
    Lens[Request[F], Headers](_.headers)(h => _.withHeaders(h))

  val cookies: Getter[Request[F], List[RequestCookie]] =
    Getter[Request[F], List[RequestCookie]](_.cookies)

  val body: Lens[Request[F], EntityBody[F]] =
    Lens[Request[F], EntityBody[F]](_.body)(b => _.withBodyStream(b))

  val attributes: Lens[Request[F], Vault] =
    Lens[Request[F], Vault](_.attributes)(a => _.withAttributes(a))

  val method: Lens[Request[F], Method] =
    Lens[Request[F], Method](_.method)(m => _.withMethod(m))

  val uri: Lens[Request[F], Uri] =
    Lens[Request[F], Uri](_.uri)(u => _.withUri(u))
}
