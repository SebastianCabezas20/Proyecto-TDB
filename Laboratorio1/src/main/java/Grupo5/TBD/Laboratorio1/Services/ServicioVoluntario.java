package Grupo5.TBD.Laboratorio1.Services;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import Grupo5.TBD.Laboratorio1.Models.Voluntario;
import Grupo5.TBD.Laboratorio1.Repositories.RepositorioVoluntario;
@RestController
public class ServicioVoluntario {
    private final RepositorioVoluntario repositorioVoluntario;
    ServicioVoluntario(RepositorioVoluntario repositorioVoluntario){
        this.repositorioVoluntario = repositorioVoluntario;
    }
    @GetMapping("/Voluntarios")
    public List<Voluntario> getAll(){
        return repositorioVoluntario.getAll();
    }
    @PostMapping("/Create/Voluntario")
    @ResponseBody
    public Voluntario createVoluntario(@RequestBody Voluntario voluntario){
        return repositorioVoluntario.createVoluntario(voluntario);
    }
    @PutMapping("/Voluntario/{id}")
    @ResponseBody
    public void actualizarTarea(@RequestBody Voluntario voluntario ,@PathVariable int id){
        repositorioVoluntario.updateVoluntario(voluntario, id);
    }
    @DeleteMapping("/Delete/Voluntario/{id}")
    public void borrarTarea(@PathVariable int id){
        repositorioVoluntario.deleteVoluntario(id);
    }
}
