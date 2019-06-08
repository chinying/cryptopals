package com.chinying.cryptopals

import com.chinying.cryptopals.utils.{Base64}

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
