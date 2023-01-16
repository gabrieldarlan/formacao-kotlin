package br.com.alura.forum.controller

import br.com.alura.forum.dto.RespostaForm
import br.com.alura.forum.dto.RespostaView
import br.com.alura.forum.service.RespostaService
import io.swagger.v3.oas.annotations.security.SecurityRequirement
import org.springframework.http.ResponseEntity
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.util.UriComponentsBuilder
import javax.validation.Valid

@RestController
@SecurityRequirement(name = "bearerAuth")
@RequestMapping("/respostas")
class RespostaController(
    private val respostaService: RespostaService,
) {

    @PostMapping
    @Transactional
    fun salvar(
        @RequestBody @Valid form: RespostaForm,
        uriBuilder: UriComponentsBuilder,
    ): ResponseEntity<RespostaView> {
        val respostaView = respostaService.salvar(form)
        val uri = uriBuilder.path("/respostas/${respostaView.id}").build().toUri()
        return ResponseEntity.created(uri).body(respostaView)

    }

}