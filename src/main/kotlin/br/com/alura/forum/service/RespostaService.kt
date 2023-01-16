package br.com.alura.forum.service

import br.com.alura.forum.dto.RespostaForm
import br.com.alura.forum.dto.RespostaView
import br.com.alura.forum.mapper.RespostaFormMapper
import br.com.alura.forum.mapper.RespostaViewMapper
import br.com.alura.forum.repository.RespostaRepository
import org.springframework.stereotype.Service

@Service
class RespostaService(
    private val respostaFormMapper: RespostaFormMapper,
    private val respostaViewMapper: RespostaViewMapper,
    private val respostaRepository: RespostaRepository,
    private val emailService: EmailService,
) {

    fun salvar(form: RespostaForm): RespostaView {
        val resposta = respostaFormMapper.map(form)
        respostaRepository.save(resposta)
        val emailAutor = resposta.topico.autor.email
        emailService.notificar(emailAutor)
        return respostaViewMapper.map(resposta)

    }
}