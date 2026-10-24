package org.infoleakage

import org.junit.jupiter.api.Test
import java.io.File
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class IniFileReaderTest {
    @Test
    fun should_read_empty_iniFile() {
        File("src/test/resources/empty.ini").createNewFile()

        val iniFileReader = IniFileReader()
        val data = iniFileReader.read("src/test/resources/empty.ini")

        assertTrue { data.getParams().isEmpty() }
    }

    @Test
    fun should_read_iniFile_with_one_line() {
        val iniFileReader = IniFileReader()
        val data = iniFileReader.read("src/test/resources/one_line.ini")

        assertTrue { data.getParams().size == 1 }
        assertEquals("1", data.getParams()["example"])
    }
}