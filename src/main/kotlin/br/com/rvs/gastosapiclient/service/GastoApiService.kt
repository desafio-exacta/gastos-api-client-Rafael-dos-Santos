package br.com.rvs.gastosapiclient.service

import br.com.rvs.gastosapiclient.dto.GastoDto
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody

@FeignClient(name = "gastoApiService", url = "\${api-gastos.url}")
interface GastoApiService {
    @GetMapping(value = ["/v1/{id}"], consumes = ["application/json"], produces = ["application/json"])
    fun findById(@PathVariable("id") id: Long): GastoDto?

    @GetMapping(value = ["/v1"], consumes = ["application/json"], produces = ["application/json"])
    fun findAll(): List<GastoDto>

    @PostMapping(value = ["/v1"], consumes = ["application/json"], produces = ["application/json"])
    fun save(@RequestBody gastoDto: GastoDto): GastoDto
}