package com.Carreira.PA_GerenciadorDeDepartamentos.services;

import com.Carreira.PA_GerenciadorDeDepartamentos.models.DepartamentoModel;
import com.Carreira.PA_GerenciadorDeDepartamentos.repositories.DepartamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartamentoService {

    @Autowired
    private DepartamentoRepository departamentoRepository;

    public List<DepartamentoModel> findAll(){
        return departamentoRepository.findAll();
    }

    public DepartamentoModel criar(DepartamentoModel departamentoModel){
        return departamentoRepository.save(departamentoModel);
    }

    public Optional<DepartamentoModel> buscarPorId(Long id){
        return departamentoRepository.findById(id);
    }
    public DepartamentoModel atualizar(Long id, DepartamentoModel departamentoModel){
        DepartamentoModel model = departamentoRepository.findById(id).get();
        model.setNome(departamentoModel.getNome());
        model.setLocalização(departamentoModel.getLocalização());
        return departamentoRepository.save(model);
    }

    public void deletar(Long id){
        departamentoRepository.deleteById(id);
    }
}
