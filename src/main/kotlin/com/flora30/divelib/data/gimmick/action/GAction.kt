package com.flora30.divelib.data.gimmick.action

import com.flora30.divelib.data.GData

interface GAction {
    fun execute(data: GData)
}