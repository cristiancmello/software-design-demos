package org.infoleakage

class IniFileUpdater {
    fun update(iniFile: IniFile, parameters: Map<String, String>) {
        parameters.forEach { (key, value) ->  iniFile.putParam(key, value) }
    }
}
