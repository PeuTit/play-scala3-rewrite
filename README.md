# Minimal Play application

This application was generated with g8 and the [play-scala-seed.g8 template](https://github.com/playframework/play-scala-seed.g8).

```sh
sbt new playframework/play-scala-seed.g8 --branch 2.9.x
```
The branch flag specify to use a different branch than the default one (2.8.x). This provide a more up-to-date template with the latest release of play (2.9.0-M4).

By default, the code will use the bracket syntax. If we want to convert the code to the new indentation based syntax, we need to add the following compiler flags:

```scala
scalacOptions ++= Seq(
  "-rewrite",
  "-indent",
)
```

Launching a sbt shell & compiling the project, we face the following errors:

```
[info] compiling 7 Scala sources and 1 Java source to /Users/titouan/Documents/work/perso/scala/test-tmp-play-scala3/target/scala-3.3.0-RC5/classes ...
[error] /Users/titouan/Documents/work/perso/scala/test-tmp-play-scala3/app/views/index.scala.html:4:28: Illegal start of toplevel definition
[error]   <h1>Welcome to Play!</h1>
[error]                            ^
[error] /Users/titouan/Documents/work/perso/scala/test-tmp-play-scala3/app/views/main.scala.html:12:11: Illegal start of toplevel definition
[error]         @* Here's where we render the page title `String`. *@
[error]           ^
[error] /Users/titouan/Documents/work/perso/scala/test-tmp-play-scala3/app/views/main.scala.html:25:8: render is already defined as method render in /Users/titouan/Documents/work/perso/scala/test-tmp-play-scala3/target/scala-3.3.0-RC5/twirl/main/views/html/index.template.scala
[error]
[error] Note that overloaded methods must all be defined in the same group of toplevel definitions
[error] </html>
[error]        ^
[error] /Users/titouan/Documents/work/perso/scala/test-tmp-play-scala3/app/views/index.scala.html:4:15: Not found: _display_:
[error]   <h1>Welcome to Play!</h1>
[error]               ^
[error] /Users/titouan/Documents/work/perso/scala/test-tmp-play-scala3/app/views/index.scala.html:5:2: Not found: apply
[error] }
[error]  ^
[error] /Users/titouan/Documents/work/perso/scala/test-tmp-play-scala3/app/views/main.scala.html:11:9: Not found: _display_:
[error]     <head>
[error]         ^
[error] 6 errors found
[error] (Compile / compileIncremental) Compilation failed
[error] Total time: 1 s, completed May 10, 2023, 10:40:04 AM
```
