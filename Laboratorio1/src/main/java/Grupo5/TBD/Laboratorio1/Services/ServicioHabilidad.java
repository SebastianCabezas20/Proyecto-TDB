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

import Grupo5.TBD.Laboratorio1.Models.Habilidad;
import Grupo5.TBD.Laboratorio1.Repositories.RepositorioHabilidad;
@RestController
public class ServicioHabilidad {
    private final RepositorioHabilidad repositorioHabilidad;
    ServicioHabilidad(RepositorioHabilidad repositorioHabilidad){
        this.repositorioHabilidad = repositorioHabilidad;
    }
    @GetMapping("/Habilidades")
    public List<Habilidad> getAll(){
        return repositorioHabilidad.getAll();
    
    }
    @PostMapping("/Create/Habilidad")
    @ResponseBody
    public Habilidad createHabilidad(@RequestBody Habilidad habilidad){
        return repositorioHabilidad.createHabilidad(habilidad);
    }
    @PutMapping("/Habilidad/{id}")
    @ResponseBody
    public void updateHabilidad(@RequestBody Habilidad habilidad ,@PathVariable int id, @PathVariable String nombre){
        repositorioHabilidad.updateHabilidad(habilidad, id,nombre);
    }
    @DeleteMapping("/Delete/Habilidad/{id}")
    public void deleteHabilidad(@PathVariable int id){
        repositorioHabilidad.deleteHabilidad(id);
    }
}
