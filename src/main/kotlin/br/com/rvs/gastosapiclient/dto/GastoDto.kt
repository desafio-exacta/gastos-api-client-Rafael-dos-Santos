package br.com.rvs.gastosapiclient.dto

import java.math.BigDecimal
import java.time.LocalDateTime

data class GastoDto (
    val id: Long?,
    val nomePessoa: String,
    val descricao: String,
    val data: LocalDateTime,
    val valor: BigDecimal,
    val tags: String?
)