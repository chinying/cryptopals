package com.chinying.cryptopals

import com.chinying.cryptopals.utils.{Base64, EnglishCharFrequencies}

object Challenge1 {
  val str = "49276d206b696c6c696e6720796f757220627261696e206c696b65206120706f69736f6e6f7573206d757368726f6f6d"
  println(Base64.hexToBase64(str))
}

object Challenge2 {
  val string1 = "1c0111001f010100061a024b53535009181c"
  val string2 = "686974207468652062756c6c277320657965"

  val decoded1 = string1.map(x => Integer.parseInt(x.toString, 16))
  val decoded2 = string2.map(x => Integer.parseInt(x.toString, 16))

  println(decoded1)

  val ouput = decoded1.zip(decoded2)
    .map(x => Integer.toHexString(x._1 ^ x._2))
    .mkString
  println(ouput)
}

object Challenge3 {
  val string = "1b37373331363f78151b7f2b783431333d78397828372d363c78373e783a393b3736"
  // decode string
  val hexDecoded = string.grouped(2)
    .map(x => Integer.parseInt(x.toString, 16).toChar)
    .toList // toList is necessary since grouped(2) makes it an iterator
  val frequencies = EnglishCharFrequencies.getMap
  var guess = (0.0, "", "")
  // for (c <- ('a' to 'z')) {
  for (c <- (0 to 255)) {
    // println(f"xoring with $c")
    val decoded = (
      hexDecoded.map(_ ^ c)
        .map(_.toChar)
    )
    // println(decoded.groupBy(identity).mapValues(_.size))
    val score = decoded.foldLeft(0.0) { (acc, char) =>
      acc + frequencies.getOrElse(char.toString, 0.0)
    } / decoded.length
    if (score > guess._1) {
      guess = (score, c.toString, decoded.mkString)
    }
  }
  println(guess)
}