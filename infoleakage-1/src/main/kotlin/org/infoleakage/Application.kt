package org.infoleakage

import java.io.File
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class Application {
    fun main() {
        File("config.ini").createNewFile()

        val iniFileReader = IniFileReader()
        val iniFile = iniFileReader.read("config.ini")

        val greetingMessage = iniFile.getParams()["greeting"]
        println(greetingMessage ?: "Greeting Message not available")

        println("Save your configuration? [yes/no]")
        val input = readln()

        if (input == "yes") {
            val iniFileWriter = IniFileWriter()
            val iniFileUpdater = IniFileUpdater()

            val lastUpdate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
            iniFileUpdater.update(iniFile, mapOf("last_update" to lastUpdate))

            iniFileWriter.write(iniFile, "config.ini")
        }
    }
}