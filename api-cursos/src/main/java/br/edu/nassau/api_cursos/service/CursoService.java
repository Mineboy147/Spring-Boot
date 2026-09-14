package br.edu.nassau.api_cursos.service;

import br.edu.nassau.api_cursos.model.Curso;
import br.edu.nassau.api_cursos.repository.CursoRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CursoService {

    private final CursoRepository cursoRepository;

    public CursoService(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    public Curso cadastrar(Curso curso) {
        if (curso.getNome() == null || curso.getNome().isBlank()) {
            throw new IllegalArgumentException("Nome não pode estar vazio");
        }

        if (curso.getCargaHoraria() == null || curso.getCargaHoraria() <= 0) {
            throw new IllegalArgumentException("Carga horária deve ser maior que zero");
        }

        return cursoRepository.save(curso);
    }

    public List<Curso> listar() {
        return cursoRepository.findAll();
    }

    public Curso buscarPorId(Long id) {
        Optional<Curso> curso = cursoRepository.findById(id);
        return curso.orElse(null);
    }

    public Curso atualizar(Long id, Curso dados) {
        if (dados.getNome() == null || dados.getNome().isBlank()) {
            throw new IllegalArgumentException("Nome não pode estar vazio");
        }

        if (dados.getCargaHoraria() == null || dados.getCargaHoraria() <= 0) {
            throw new IllegalArgumentException("Carga horária deve ser maior que zero");
        }

        Optional<Curso> existente = cursoRepository.findById(id);
        if (existente.isPresent()) {
            Curso curso = existente.get();
            curso.setNome(dados.getNome());
            curso.setCargaHoraria(dados.getCargaHoraria());
            return cursoRepository.save(curso);
        }
        return null;
    }

    public void remover(Long id) {
        cursoRepository.deleteById(id);
    }
}