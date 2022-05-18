package br.com.rvs.gastosapiclient

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients

@EnableFeignClients
@SpringBootApplication
class GastosApiClientApplication

fun main(args: Array<String>) {
	runApplication<GastosApiClientApplication>(*args)
}
