package br.com.rvs.gastosapiclient.controller

import br.com.rvs.gastosapiclient.dto.GastoReqDto
import br.com.rvs.gastosapiclient.service.GastoService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam


@Controller
class GastosController(
        private val gastoService: GastoService
) {
    @GetMapping
    fun findAll(model: Model): String{
        val gastos = gastoService.listar()
        model.addAttribute("gastos", gastos)
        return "index"
    }

    @GetMapping("/detalhes")
    fun findById(@RequestParam("id") id: Long?, model: Model): String{
        if (id == null){
            return "redirect:/"
        }
        val gastoDto = gastoService.consultarPorId(id)
        model.addAttribute("gasto", gastoDto)
        return "detalhes"
    }

    @GetMapping("/cadastro")
    fun cadastro(model: Model): String? {
        model.addAttribute("gasto", GastoReqDto())
        return "cadastro"
    }

    @PostMapping
    fun save(@ModelAttribute form: GastoReqDto, model: Model): String? {
        gastoService.cadatrar(GastoReqDto.toGastoDto(form))
        return "redirect:/"
    }
}