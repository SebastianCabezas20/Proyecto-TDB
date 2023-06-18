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

import Grupo5.TBD.Laboratorio1.Models.Tarea_habilidad;
import Grupo5.TBD.Laboratorio1.Repositories.RepositorioTarea_habilidad;
@RestController
public class ServicioTarea_habilidad {
    private final RepositorioTarea_habilidad repositorioTarea_habilidad;
    ServicioTarea_habilidad(RepositorioTarea_habilidad repositorioTarea_habilidad){
        this.repositorioTarea_habilidad = repositorioTarea_habilidad;
    }
    @GetMapping("/Tarea_habilidad")
    public List<Tarea_habilidad> getAll(){
        return repositorioTarea_habilidad.getAll();
    }
    @PostMapping("/create/tarea_habilidad")
    @ResponseBody
    public Tarea_habilidad createHabilidad(@RequestBody Tarea_habilidad tarea_habilidad){
        return repositorioTarea_habilidad.createTarea_habilidad(tarea_habilidad);
    }
    @PutMapping("/Tarea_habilidad/{id}")
    @ResponseBody
    public void updateTarea_habilidad(@RequestBody Tarea_habilidad tarea_habilidad ,@PathVariable int id,@PathVariable int id_eme_habilidad, @PathVariable int id_tarea){
        repositorioTarea_habilidad.updateTarea_habilidad(tarea_habilidad, id,id_eme_habilidad, id_tarea);
    }
    @DeleteMapping("delete/Tarea_habilidad/{id}")
    @ResponseBody
    public void deleteTarea_habilidad(@PathVariable int id){
        repositorioTarea_habilidad.deleteTarea_habilidad(id);
    }
}
