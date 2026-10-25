package org.infoleakage

import org.junit.jupiter.api.Test
import java.io.File
import kotlin.test.assertTrue

class IniFileWriterTest {
    @Test
    fun should_write_iniFile() {
        val iniFileWriter = IniFileWriter()

        val iniFile = IniFile()
        val iniFileUpdater = IniFileUpdater()

        iniFileUpdater.update(iniFile, mapOf("parameter_name" to "value"))

        iniFileWriter.write(iniFile, "src/test/resources/example_iniFile.txt")

        val content = File("src/test/resources/example_iniFile.txt").readText()

        assertTrue { content.contains("parameter_name:value") }
    }
}