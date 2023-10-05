package com.example.fetchsample.model.domain

data class Item(val id:Int, val listId: Int, val name:String)


fun List<Item>.splitByGroupId(listId:Int):List<Item> {
    return this.filter { item -> item.listId == listId && !item.name.isNullOrBlank() }
        .sortedWith(compareBy({ it.name.length }, { it.name }))
}

fun List<Item>.getUniqueGroupId():List<Int> {
    return this.distinctBy { item -> item.listId }.map { it.listId }.sorted()
}