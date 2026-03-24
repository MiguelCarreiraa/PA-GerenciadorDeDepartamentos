package com.Carreira.PA_GerenciadorDeDepartamentos.controllers;



import com.Carreira.PA_GerenciadorDeDepartamentos.models.DepartamentoModel;
import com.Carreira.PA_GerenciadorDeDepartamentos.services.DepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping(path = "/departamentos")
public class DepartamentoController {

    @Autowired
    private DepartamentoService departamentoService;

    @GetMapping
    public ResponseEntity<List<DepartamentoModel>> findAll(){
        return ResponseEntity.ok(departamentoService.findAll());
    }

    @PostMapping
    public ResponseEntity<DepartamentoModel> criarDepartamento(@RequestBody DepartamentoModel departamentoModel){
        DepartamentoModel novo = departamentoService.criar(departamentoModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(novo);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DepartamentoModel> buscarDepartamento(@PathVariable Long id){
        Optional<DepartamentoModel> departamento = departamentoService.buscarPorId(id);

        if (departamento.isPresent()) {
            return ResponseEntity.ok(departamento.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<DepartamentoModel> atualizarDepartamento(@PathVariable Long id,
                                                                   @RequestBody DepartamentoModel departamentoModel){
        Optional<DepartamentoModel> existente = departamentoService.buscarPorId(id);

        if (existente.isPresent()) {
            DepartamentoModel atualizado = departamentoService.atualizar(id, departamentoModel);
            return ResponseEntity.ok(atualizado);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarDepartamento(@PathVariable Long id){
        Optional<DepartamentoModel> existente = departamentoService.buscarPorId(id);

        if (existente.isPresent()) {
            departamentoService.deletar(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
