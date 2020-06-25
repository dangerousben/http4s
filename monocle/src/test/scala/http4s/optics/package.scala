/*
 * Copyright 2013-2020 http4s.org
 *
 * SPDX-License-Identifier: Apache-2.0
 */

package org.http4s

import cats.{Eq,Id}
import cats.effect.IO
import cats.implicits._
import fs2.Stream
import org.scalacheck._
import _root_.io.chrisdavenport.vault.{Key, Vault}

package object optics {
  val intKey = Key.newKey[IO, Int].unsafeRunSync
  val stringKey = Key.newKey[IO, String].unsafeRunSync

  implicit def eqEntityBody: Eq[EntityBody[Id]] =
    Eq.instance((a, b) =>
      (a.map(Option(_)) zipAll b.map(Option(_)))(None, None)
        .forall { case (a, b) => a === b }
        .compile.fold(true)(_ && _)
    )

  implicit val arbEntityBody: Arbitrary[EntityBody[Id]] =
    Arbitrary(Gen.chooseNum(0, 16).flatMap(n => Gen.listOfN(n, Arbitrary.arbitrary[Byte])).map(Stream(_: _*)))

  implicit def eqVault: Eq[Vault] =
    Eq.instance((a, b) => a.lookup(intKey) === b.lookup(intKey) && a.lookup(stringKey) === b.lookup(stringKey))

  implicit val arbVault: Arbitrary[Vault] =
    Arbitrary(
      for {
        intValue <- Gen.option(Gen.chooseNum(0, 15))
        stringValue <- Gen.option(Gen.oneOf(Seq("foo", "bar", "baz", "qux")))
      } yield {
        val v = Vault.empty
        intValue.foreach(v.insert(intKey, _))
        stringValue.foreach(v.insert(stringKey, _))
        v
      }
    )

  implicit val arbVault2Vault: Arbitrary[Vault => Vault] =
    Arbitrary(arbVault.arbitrary.flatMap(Function.const(_) _))

  implicit def arbThingToThing[A](implicit fa: Arbitrary[Int => A]): Arbitrary[A => A] =
    Arbitrary(fa.arbitrary.map(f => a => f(a.hashCode)))
}
