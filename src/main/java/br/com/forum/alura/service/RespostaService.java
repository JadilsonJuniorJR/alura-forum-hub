package br.com.forum.alura.service;

import br.com.forum.alura.dto.RespostaResponse;
import br.com.forum.alura.model.Resposta;
import br.com.forum.alura.repository.RespostaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RespostaService {

    @Autowired
    private RespostaRepository respostaRepository;

    public List<RespostaResponse> listarRespostasPorAutorId(Long autorId) {
        List<Resposta> respostas = respostaRepository.findAllByAutorId(autorId);
        return RespostaResponse.converter(respostas);
    }

    public void excluirResposta(Long id) {
        respostaRepository.deleteById(id);
    }

    public void salvarResposta(Resposta resposta) {
        respostaRepository.save(resposta);
    }

    public Optional<Resposta> BuscarRespostaPorId(Long id) {
        return respostaRepository.findById(id);
    }
}