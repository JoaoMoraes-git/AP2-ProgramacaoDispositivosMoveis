package br.com.ulbra.ap2.ui

import kotlinx.serialization.Serializable

@Serializable
object Lista

@Serializable
data class Detalhe(val jogoId: Int)