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

import Grupo5.TBD.Laboratorio1.Models.Emergencia_habilidad;
import Grupo5.TBD.Laboratorio1.Repositories.RepositorioEmergencia_habilidad;
@RestController


public class ServicioEmergencia_habilidad{
    private final RepositorioEmergencia_habilidad repositorioEmergencia_habilidad;
    ServicioEmergencia_habilidad(RepositorioEmergencia_habilidad repositorioEmergencia_habilidad){
        this.repositorioEmergencia_habilidad = repositorioEmergencia_habilidad;
    }
    @GetMapping("/Emergencias_habilidad")
    public List<Emergencia_habilidad> getAll(){
        return repositorioEmergencia_habilidad.getAll();
    }
    @PostMapping("/Create/Emergencia_habilidad")
    @ResponseBody
    public Emergencia_habilidad createEmergencia_habilidad(@RequestBody Emergencia_habilidad emergencia_habilidad){
        return repositorioEmergencia_habilidad.createEmergencia_habilidad(emergencia_habilidad);
    }
    @PutMapping("/Emergencia_habilidad/{id}")
    @ResponseBody
    public void actualizarAlgo(@RequestBody Emergencia_habilidad emergencia_habilidad ,@PathVariable int id){
        repositorioEmergencia_habilidad.updateEmergencia_habilidad(emergencia_habilidad, id);
    }
    @DeleteMapping("/Delete/Emergencia_habilidad/{id}")
    public void borrarEmergenciaHabilidad(@PathVariable int id){
        repositorioEmergencia_habilidad.deleteEmergencia_habilidad(id);
    }
}