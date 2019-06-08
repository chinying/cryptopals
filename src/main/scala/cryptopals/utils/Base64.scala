package com.chinying.cryptopals.utils

import scala.collection.mutable.{ListBuffer}

object Base64 {
  val code = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/"
  def fromB64() = ???

  def leftPad(s: String, requiredLength: Int) = "0" * (requiredLength - s.length) + s

  def strToB64(s: String) = {
    /**
      1. convert to ascii,
      2. take every 6 bits
      3. pad end with equal signs
     */
    // val sextets = s.map(c => leftPad(c.toInt.toBinaryString, 8))
    //   .mkString
    //   .grouped(6)
    //   // .map(sextet => code(Integer.parseInt(sextet, 2)))
    //   .toList

    // sextets.last.length match {
    //   case 2 => sextets += "0000000"
    //   case 4 => sextets +=
    //   case 0 =>
    //   case _ => throw Exception("malformed sextet")
    // }
    val sextets = s.map(c => leftPad(c.toInt.toBinaryString, 8))
      .mkString
      .grouped(6)
      .toList

    val (unpadded, maybePad) = sextets.span(_.length % 6 == 0)

    val intermediate = ListBuffer(unpadded)
    var paddedSextets = intermediate
      .flatten
      .map(sextet => code(Integer.parseInt(sextet, 2)))
      .mkString

    paddedSextets += {
      if (maybePad.length > 0) {
        maybePad.head.length match {
          case 4 => "="
          case 2 => "=="
          case _ => throw new Exception("malformed input")
        }
      } else {
        ""
      }
    }

    paddedSextets
  }

  // converts hex value to binary
  def hexToBin(x : String) : String = {
    Integer.parseInt(x, 16)
      .toBinaryString
  }

  def hexToBase64(str : String) : String = {
    val code = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/="
    str.grouped(2)
      .map(g => leftPad(hexToBin(g), 8))
      .mkString
      .grouped(6)
      .map(x => code(Integer.parseInt(x, 2)))
      .mkString
  }

}