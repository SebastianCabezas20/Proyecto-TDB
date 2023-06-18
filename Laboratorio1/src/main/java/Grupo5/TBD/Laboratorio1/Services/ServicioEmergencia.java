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

import Grupo5.TBD.Laboratorio1.Models.Emergencia;
import Grupo5.TBD.Laboratorio1.Repositories.RepositorioEmergencia;
@RestController


public class ServicioEmergencia{
    private final RepositorioEmergencia repositorioEmergencia;
    ServicioEmergencia(RepositorioEmergencia repositorioEmergencia){
        this.repositorioEmergencia= repositorioEmergencia;
    }
    @GetMapping("/Emergencias")
    public List<Emergencia> getAll(){
        return repositorioEmergencia.getAll();
    }
    @GetMapping("/Region/{id}")
    public List<String> getByRegion(@PathVariable int id){
        return repositorioEmergencia.getByRegion(id);
    }
    @PostMapping("/Create/Emergencia")
    @ResponseBody
    public Emergencia createEmergencia(@RequestBody Emergencia emergencia){
        return repositorioEmergencia.createEmergencia(emergencia);
    }
    @PutMapping("/Emergencia/{id}")
    @ResponseBody
    public void actualizarAlgo(@RequestBody Emergencia emergencia ,@PathVariable int id){
        repositorioEmergencia.updateEmergencia(emergencia, id);
    }
    @DeleteMapping("/Delete/Emergencia/{id}")
    public void borrarEmergenciaHabilidad(@PathVariable int id){
        repositorioEmergencia.deleteEmergencia(id);
    }
    
}
