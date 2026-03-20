package com.bn.departments.services;

import com.bn.departments.models.DepartamentoModel;
import com.bn.departments.repositories.DepartamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartamentoService {

    @Autowired
    private DepartamentoRepository departamentoRepository;

    public List<DepartamentoModel> listarTodosDepartamentos(){
        return departamentoRepository.findAll();
    }

    public Optional<DepartamentoModel> buscarDepartamentoPorId(Long id){
        return departamentoRepository.findById(id);
    }

    public DepartamentoModel inserirDepartamento(DepartamentoModel departamentoModel){
        return departamentoRepository.save(departamentoModel);
    }

    /*
    public DepartamentoModel atualizarDepartamento(Long id, DepartamentoModel departamentoModel){
        DepartamentoModel departamento = departamentoRepository.findById(id).get();
        departamento.setNome(departamentoModel.getNome());

        return departamentoRepository.save(departamentoModel);
    }
     */

    public void deletarDepartamento(Long id){
        departamentoRepository.deleteById(id);
    }
}
