Regex String Interpolation Utility
==================================

A small library that allows [interpolation](https://www.scala-lang.org/files/archive/spec/2.13/08-pattern-matching.html#interpolated-string-patterns) of regex capture groups in `match` statements.

The nth interpolant (e.g. `$group1`) will match against the nth capture group in the regex.


Example
-------
```
import dev.bgahagan.regex.intrpl._

"hello world" match {
  case r"(\w+)$group1 (\w+)$group2" => 
    println(group2)
}
```

Outputs:

```
world
```


Design Notes
------------

* The regex is parsed and compiled on each `match` invocation.
