package com.trufastore.trufa_store.controller;

import com.trufastore.trufa_store.entity.Venda;
import com.trufastore.trufa_store.service.VendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vendas")
@CrossOrigin(origins = "*")
public class VendaController {

    @Autowired
    private VendaService vendaService;

    @PostMapping
    public Venda criarVenda(@RequestBody Venda venda) {
        return vendaService.salvar(venda);
    }

    @GetMapping("/{id}")
    public Venda buscarPorId(@PathVariable Long id) {
        return vendaService.buscarPorId(id);
    }
}