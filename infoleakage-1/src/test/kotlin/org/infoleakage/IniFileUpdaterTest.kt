package org.infoleakage

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class IniFileUpdaterTest {
    @Test
    fun should_iniFileUpdater_update() {
        val iniFileUpdater = IniFileUpdater()
        val iniFile = IniFile()

        iniFileUpdater.update(iniFile, mutableMapOf("foo" to "bar"))

        Assertions.assertEquals("bar", iniFile.getParams()["foo"])
    }
}