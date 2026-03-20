package com.Carreira.PA_GerenciadorDeDepartamentos.controllers;



import com.Carreira.PA_GerenciadorDeDepartamentos.models.DepartamentoModel;
import com.Carreira.PA_GerenciadorDeDepartamentos.services.DepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/departamentos")
public class DepartamentoController {

    @Autowired
    private DepartamentoService departamentoService;

    @GetMapping
    public List<DepartamentoModel> findAll(){
        return departamentoService.findAll();
    }

    @PostMapping
    public DepartamentoModel criarDepartamento(@RequestBody DepartamentoModel departamentoModel){
        return departamentoService.criar(departamentoModel);
    }

    @GetMapping("/{id}")
    public Optional<DepartamentoModel> buscarDepartamento(@PathVariable Long id){
        return departamentoService.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public DepartamentoModel atualizarDepartamento(@PathVariable Long id, @RequestBody DepartamentoModel departamentoModel){
        return departamentoService.atualizar(id, departamentoModel);
    }

    @DeleteMapping("/{id}")
    public void deletarDepartamento(@PathVariable Long id){
        departamentoService.deletar(id);
    }

}
