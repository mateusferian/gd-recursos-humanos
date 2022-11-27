package br.com.geradordedevs.gdrecursoshumanos.controllers;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping ("/departamentos")
public class DepartamentoController {
    @GetMapping
    public List<Departamento> listar() {
        return mockListaDepartamento();

    }

    @GetMapping("/{id}")
    public Departamento consultar(@PathVariable int id) {
        return mockListaDepartamento().get(id);


    }


    @PostMapping
    public Departamento cadastrar(@RequestBody Departamento departamento) {
      // return  getverifica();

        return departamento;

    }

    @PutMapping("/{id}")
    public List<Departamento> alterar(@PathVariable int id, @RequestBody Departamento departamento) {
        List<Departamento> departamentos = mockListaDepartamento();
        departamentos.remove(id);
        departamentos.add(departamento);
        return departamentos;
    }

    @DeleteMapping("/{id}")
    public void remover(@PathVariable int id) {
        List<Departamento> departamentos = mockListaDepartamento();
        departamentos.remove(id);
    }

    private List<Departamento> mockListaDepartamento() {
        List<Departamento> listaDepartamento = new ArrayList<>();
        listaDepartamento.add(new Departamento(1, "Analise de Sistema"));
        listaDepartamento.add(new Departamento(2, "Desenvolvimento web"));
        listaDepartamento.add(new Departamento(3, "Desenvolvimento de aplicativos"));
        return listaDepartamento;
    }

    public Departamento getDepartamentos(int id) {
        List<Departamento> departamentos = this.mockListaDepartamento();
        for (Departamento departamento : departamentos) {
            if (departamento.getId() == id) {
                return departamento;
            }
        }
        return null;
    }

}
