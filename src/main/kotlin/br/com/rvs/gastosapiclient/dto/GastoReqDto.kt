package br.com.rvs.gastosapiclient.dto

import java.math.BigDecimal
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

data class GastoReqDto (
    val id: Long?,
    val nomePessoa: String?,
    val descricao: String?,
    val data: String?,
    val valor: BigDecimal?,
    val tags: String?
) {
    constructor() : this(null, null, null, null, null, null)

    companion object{
        fun toGastoDto(gastoReqDto: GastoReqDto) = GastoDto(
                id = gastoReqDto.id,
                nomePessoa = gastoReqDto.nomePessoa!!,
                descricao = gastoReqDto.descricao!!,
                data = LocalDateTime.parse(gastoReqDto.data, DateTimeFormatter.ISO_DATE_TIME),
                valor = gastoReqDto.valor!!,
                tags = gastoReqDto.tags
        )
    }
}