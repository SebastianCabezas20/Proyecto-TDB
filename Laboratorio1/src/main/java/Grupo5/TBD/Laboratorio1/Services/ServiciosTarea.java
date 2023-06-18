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

import Grupo5.TBD.Laboratorio1.Models.Tarea;
import Grupo5.TBD.Laboratorio1.Repositories.RepositorioTarea;

@RestController
public class ServiciosTarea {

    private final RepositorioTarea repositorioTarea;
    ServiciosTarea(RepositorioTarea repositorioTarea){
        this.repositorioTarea = repositorioTarea;
    }
    @GetMapping("/Tareas")
    public List<Tarea> getAll(){
        return repositorioTarea.getAll();
    }
    @GetMapping("/Region/Tarea/{id}")
    public List<String> getByRegion(@PathVariable int id){
        return repositorioTarea.getByRegion(id);
    }
    @PostMapping("/Create/Tarea")
    @ResponseBody
    public Tarea createTarea(@RequestBody Tarea tarea){
        return repositorioTarea.createTarea(tarea);
    }
    @PutMapping("/Tarea/{id}")
    @ResponseBody
    public void actualizarTarea(@RequestBody Tarea tarea ,@PathVariable int id){
        repositorioTarea.updateTarea(tarea, id);
    }
    @DeleteMapping("/Delete/Tarea/{id}")
    public void borrarTarea(@PathVariable int id){
        repositorioTarea.deleteTarea(id);
    }
}
