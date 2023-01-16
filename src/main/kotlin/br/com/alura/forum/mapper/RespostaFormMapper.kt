package br.com.alura.forum.mapper

import br.com.alura.forum.dto.RespostaForm
import br.com.alura.forum.model.Resposta
import br.com.alura.forum.service.TopicoService
import br.com.alura.forum.service.UsuarioService
import org.springframework.stereotype.Component

@Component
class RespostaFormMapper(
    private val usuarioService: UsuarioService,
    private val topicoService: TopicoService,
) : Mapper<RespostaForm, Resposta> {
    override fun map(t: RespostaForm): Resposta {
        return Resposta(
            mensagem = t.mensagem,
            autor = usuarioService.buscarPorId(t.idAutor),
            topico = topicoService.buscaTopico(t.idTopico),
            solucao = false
        )
    }
}