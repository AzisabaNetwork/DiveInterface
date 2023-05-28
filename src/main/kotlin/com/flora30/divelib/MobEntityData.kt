package com.flora30.diveapin

import java.util.*
import kotlin.collections.HashSet

class MobEntityData (
    var remain: Int
){
    val playerIdSet: Set<UUID> = HashSet()
}