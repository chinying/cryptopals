package com.chinying.cryptopals

import com.chinying.cryptopals.utils.{Base64}

object Challenge1 {
  val str = "49276d206b696c6c696e6720796f757220627261696e206c696b65206120706f69736f6e6f7573206d757368726f6f6d"
  println(Base64.hexToBase64(str))
}
