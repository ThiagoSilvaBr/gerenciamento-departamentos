package com.bn.departments.controllers;

import com.bn.departments.models.DepartamentoModel;
import com.bn.departments.services.DepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/departamentos")
public class DepartamentoController {

    @Autowired
    private DepartamentoService departamentoService;

    @GetMapping
    public ResponseEntity<List<DepartamentoModel>> findAll(){
        List<DepartamentoModel> request = departamentoService.listarTodosDepartamentos();
        return ResponseEntity.ok().body(request);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<DepartamentoModel>> buscarPorId(@PathVariable Long id){
        Optional<DepartamentoModel> request = departamentoService.buscarDepartamentoPorId(id);
        return ResponseEntity.ok().body(request);
    }

    @PostMapping
    public ResponseEntity<DepartamentoModel> inserirDepartamento(@RequestBody DepartamentoModel departamentoModel){
        DepartamentoModel request = departamentoService.inserirDepartamento(departamentoModel);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().
                path("/{id}").buildAndExpand(request.getId()).toUri();

        return ResponseEntity.created(uri).body(request);
    }

    /*
    @PutMapping("/{id}")
    public ResponseEntity<DepartamentoModel> atualizardepartamento(@PathVariable Long id,@RequestBody DepartamentoModel departamentoModel){
        DepartamentoModel request = departamentoService.atualizarDepartamento(id, departamentoModel);
        return ResponseEntity.ok().body(request);
    }
     */

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarDepartamento(@PathVariable Long id){
        departamentoService.deletarDepartamento(id);
        return ResponseEntity.noContent().build();
    }
}
