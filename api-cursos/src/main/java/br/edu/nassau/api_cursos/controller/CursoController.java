package br.edu.nassau.api_cursos.controller;

import br.edu.nassau.api_cursos.model.Curso;
import br.edu.nassau.api_cursos.service.CursoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    // Injeção de dependência do Service
    private final CursoService cursoService;

    public CursoController(CursoService cursoService) {
        this.cursoService = cursoService;
    }

    // GET /cursos - Listar todos
    @GetMapping
    public ResponseEntity<List<Curso>> listar() {
        List<Curso> cursos = cursoService.listar();
        return ResponseEntity.ok(cursos);
    }

    // POST /cursos - Cadastrar
    @PostMapping
    public ResponseEntity<Curso> cadastrar(@RequestBody Curso curso) {
        try {
            Curso novoClurso = cursoService.cadastrar(curso);
            return ResponseEntity.status(HttpStatus.CREATED).body(novoClurso);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    // GET /cursos/{id} - Buscar por ID
    @GetMapping("/{id}")
    public ResponseEntity<Curso> buscarPorId(@PathVariable Long id) {
        Curso curso = cursoService.buscarPorId(id);
        if (curso == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(curso);
    }

    // PUT /cursos/{id} - Atualizar
    @PutMapping("/{id}")
    public ResponseEntity<Curso> atualizar(@PathVariable Long id, @RequestBody Curso dados) {
        try {
            Curso curso = cursoService.atualizar(id, dados);
            if (curso == null) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(curso);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    // DELETE /cursos/{id} - Remover
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        Curso curso = cursoService.buscarPorId(id);
        if (curso == null) {
            return ResponseEntity.notFound().build();
        }
        cursoService.remover(id);
        return ResponseEntity.noContent().build();
    }
}