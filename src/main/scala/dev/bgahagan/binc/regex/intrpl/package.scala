package dev.bgahagan.regex

import scala.util.matching.Regex

package object intrpl {

  /**
   * Class to define un/unapply methods for expressions and matching
   * Extend AnyVal to avoid object allocations
   */
  class RegexStringContext private[regex](private val sc: StringContext) extends AnyVal {
    // Use when doing interpolation in an expression
    def apply(exprs: Any*): Regex = sc.s(exprs:_*).r

    // Used when in a match statement
    def unapplySeq(s: CharSequence): Option[Seq[String]] = {
      val r: Regex = new Regex(sc.parts.mkString)
      r.unapplySeq(s)
    }
  }

  implicit class RegexInterplation(private val sc: StringContext) extends AnyVal {
    def r = new RegexStringContext(sc)
  }
}

