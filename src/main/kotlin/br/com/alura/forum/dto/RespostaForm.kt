package br.com.alura.forum.dto

import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull

data class RespostaForm(
    @field:NotEmpty(message = "Resposta não pode estar em branco")
    val mensagem: String,
    @field:NotNull
    val idAutor: Long,
    @field:NotNull
    val idTopico: Long,
)