package org.infoleakage

import java.io.FileReader

class IniFileReader {
    fun read(path: String): IniFile {
        val reader = FileReader(path)
        var char: Int
        val builder = StringBuilder()

        while (reader.read().also { char = it } != -1) {
            builder.append(char.toChar())
        }

        reader.close()

        val iniFile = IniFile()

        builder.split("\n").forEach {
            val line = it.split(":")
            if (line.size > 1) {
                iniFile.putParam(line[0], line[1])
            }
        }

        return iniFile
    }
}
