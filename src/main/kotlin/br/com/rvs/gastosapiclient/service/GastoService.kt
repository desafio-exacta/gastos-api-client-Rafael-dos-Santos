package br.com.rvs.gastosapiclient.service

import br.com.rvs.gastosapiclient.dto.GastoDto
import org.springframework.stereotype.Service

@Service
class GastoService(
        private val gastosApiService: GastoApiService
) {
    fun cadatrar(gastoDto: GastoDto): GastoDto{
        return gastosApiService.save(gastoDto)
    }

    fun listar(): List<GastoDto>{
        return gastosApiService.findAll()
    }

    fun consultarPorId(id: Long): GastoDto?{
        return gastosApiService.findById(id)
    }
}