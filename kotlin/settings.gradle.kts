rootProject.name = "My Exercism Kotlin Track"

file("./").listFiles()
  .filter { it.isDirectory }
  .filter { it.name !in listOf(".idea", ".gradle", "gradle", "build", "out") }
  .forEach { include(it.name) }
