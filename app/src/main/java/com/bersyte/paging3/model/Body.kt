package com.bersyte.paging3.model

data class Body(
    val events_list: List<Events>,
    val tournament_id: Int,
    val tournament_name: String
)