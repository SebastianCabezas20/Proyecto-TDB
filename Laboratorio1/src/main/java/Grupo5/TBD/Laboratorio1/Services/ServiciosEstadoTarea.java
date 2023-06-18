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

import Grupo5.TBD.Laboratorio1.Models.Estado_tarea;
import Grupo5.TBD.Laboratorio1.Repositories.RepositorioEstadoTarea;

@RestController
public class ServiciosEstadoTarea {
    private final RepositorioEstadoTarea repositorioEstadoTarea;
    
    ServiciosEstadoTarea(RepositorioEstadoTarea repositorioEstadoTarea){
        this.repositorioEstadoTarea = repositorioEstadoTarea;
    }
    @GetMapping("/Estado")
    public List<Estado_tarea> getAll(){
        return repositorioEstadoTarea.getAll();
    }
    @PostMapping("/Create/Estado")
    @ResponseBody
    public Estado_tarea createEstado_tarea(@RequestBody Estado_tarea estado_tarea){
        return repositorioEstadoTarea.createEstado_tarea(estado_tarea);
    }
    @PutMapping("/Estado/{id}")
    @ResponseBody
    public void actualizarEstado(@RequestBody Estado_tarea estado_tarea ,@PathVariable int id){
        repositorioEstadoTarea.updateEstado(estado_tarea,id);
    }
    @DeleteMapping("/Delete/Estado_tarea/{id}")
    public void borrarTarea(@PathVariable int id){
        repositorioEstadoTarea.deleteEstadoTarea(id);
    }
}
