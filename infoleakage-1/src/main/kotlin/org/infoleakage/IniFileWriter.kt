package org.infoleakage

import java.io.FileWriter

class IniFileWriter {
    fun write(iniFile: IniFile, path: String) {
        val fileWriter = FileWriter(path)

        iniFile.getParams().forEach {
            val line = "${it.key}=${it.value}"
            fileWriter.appendLine(line)
        }

        fileWriter.close()
    }
}
