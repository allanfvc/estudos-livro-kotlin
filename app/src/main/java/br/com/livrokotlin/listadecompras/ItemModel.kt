package br.com.livrokotlin.listadecompras


data class ItemModel(val name: String, val onRemove: (ItemModel) -> Unit)

