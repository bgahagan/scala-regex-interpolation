package dev.bgahagan.regextest

import org.scalatest._

import dev.bgahagan.regex.intrpl._

class RegexStringContextSpec extends FlatSpec with Matchers {
  
  it should "work as an expression" in {
    val b = "c"
    val result = r"a.*${b}"
    assert(result.toString == "a.*c")
  }

  it should "work in a match" in {
    val result = 
      "abc" match {
        case r"a(b*)$b(c*)$c" => b + c
        case _ => fail()
      }
    assert(result == "bc")
  }

}
