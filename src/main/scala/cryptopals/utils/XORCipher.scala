package com.chinying.cryptopals.utils

import scala.collection.mutable.HashMap

object XORCipher {

}

object EnglishCharFrequencies {
  def getMap(): HashMap[String, Double] = {
    val lines = scala.io.Source.fromResource("char_frequencies.txt").getLines
    var frequencyMap = new HashMap[String, Double]
    for (line <- lines) {
      val (char, freq) = line.split("\t") match {
        case (a: Array[String]) => (a(0), a(1))
        case _ => throw new Exception("error parsing file")
      }
      frequencyMap += (char -> freq.toDouble)
    }
    frequencyMap
  }
}