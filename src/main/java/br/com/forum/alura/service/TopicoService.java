package br.com.forum.alura.service;

import br.com.forum.alura.infra.exception.TopicoNotFoundException;
import br.com.forum.alura.model.StatusTopico;
import br.com.forum.alura.model.Topico;
import br.com.forum.alura.repository.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicoService {

    @Autowired
    private TopicoRepository topicoRepository;

    public void mudarStatusTopico(Topico topico) {
        topico.setStatus(StatusTopico.NAO_SOLUCIONADO);
        topicoRepository.save(topico);
    }

    public Topico buscarTopicoPorId(Long id) {
        System.out.println("TopicoService.buscarTopicoPorId");
        return topicoRepository.findById(id)
                .orElseThrow(() -> new TopicoNotFoundException("Tópico não encontrado com o ID: " + id));
    }

    public Page<Topico> listarTopicos(Pageable paginacao) {
        return topicoRepository.findAll(paginacao);
    }

    public List<Topico> listarTopicosPorUsuario(Long id) {
        return topicoRepository.findAllByAutorId(id);
    }

    public Topico fecharTopico(Long id) {
        Topico topico = buscarTopicoPorId(id);
        topico.setStatus(StatusTopico.FECHADO);
        return topicoRepository.save(topico);
    }

    public void excluirTopico(Long id) {
        Topico topico = buscarTopicoPorId(id);
        topicoRepository.delete(topico);
    }

    public void salvarTopico(Topico topico) {
        topicoRepository.save(topico);
    }
}
