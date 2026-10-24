package org.infoleakage

class IniFile {
    private var parameters: MutableMap<String, String> = HashMap()

    fun putParam(key: String, value: String) {
        parameters[key] = value
    }

    fun getParams(): Map<String, String> {
        return parameters
    }
}
