package org.infoleakage

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.io.File
import kotlin.test.assertTrue

class EditorConfigFileManagerIntegrationTests {
    @Test
    fun should_update_and_saving_configurations() {
        File("src/test/resources/example.ini").createNewFile()

        val iniFile = openingFile()
        updateConfigurations(iniFile)
        savingConfiguration(iniFile)
    }

    private fun openingFile(): IniFile {
        val iniFileReader = IniFileReader()

        val iniFile = iniFileReader.read("src/test/resources/example.ini")

        assertEquals("value", iniFile.getParams()["parameter_name"])

        return iniFile
    }

    private fun updateConfigurations(iniFile: IniFile) {
        val iniFileUpdater = IniFileUpdater()

        iniFileUpdater.update(iniFile, mutableMapOf("other_parameter" to "other_value"))

        assertEquals("other_value", iniFile.getParams()["other_parameter"])
    }

    private fun savingConfiguration(iniFile: IniFile) {
        val iniFileWriter = IniFileWriter()

        iniFileWriter.write(iniFile, "src/test/resources/example.ini")

        val content = File("src/test/resources/example.ini").readText()

        assertTrue(content.contains("parameter_name:value"))
        assertTrue(content.contains("other_parameter:other_value"))
    }
}