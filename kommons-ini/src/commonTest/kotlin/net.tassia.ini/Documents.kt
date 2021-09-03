package net.tassia.ini

val iniTestDocument1 = """
# This is a comment.
;; This is also a comment. And below is an empty line.

ROOT_PROPERTY=Hello World!
ROOT_EMPTY_PROPERTY

[Section1]

SOME_PROP=1

[Section 2]



SOME_PROP = 2
""".trim()
