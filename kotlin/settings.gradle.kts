rootProject.name = "Exercism Kotlin Track"

file("./").listFiles()
  .filter { it.isDirectory }
  .filter { it.name !in listOf(".idea", ".gradle") }
  .forEach { include(it.name) }
