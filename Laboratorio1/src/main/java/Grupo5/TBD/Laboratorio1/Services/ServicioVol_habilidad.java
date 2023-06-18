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

import Grupo5.TBD.Laboratorio1.Models.Vol_habilidad;
import Grupo5.TBD.Laboratorio1.Repositories.RepositorioVol_habilidad;
@RestController
public class ServicioVol_habilidad {
    private final RepositorioVol_habilidad repositorioVol_habilidad;
    ServicioVol_habilidad(RepositorioVol_habilidad repositorioVol_habilidad){
        this.repositorioVol_habilidad = repositorioVol_habilidad;
    }
    @GetMapping("/Vol_habilidads")
    public List<Vol_habilidad> getAll(){
        return repositorioVol_habilidad.getAll();
    }
    @PostMapping("/Create/Vol_habilidad")
    @ResponseBody
    public Vol_habilidad create(@RequestBody Vol_habilidad Vol_habilidad){
        return repositorioVol_habilidad.createVol_habilidad(Vol_habilidad);
    }
    @PutMapping("/Vol_habilidad/{id}")
    @ResponseBody
    public void actualizarTarea(@RequestBody Vol_habilidad Vol_habilidad ,@PathVariable int id){
        repositorioVol_habilidad.updateVol_habilidad(Vol_habilidad, id);
    }
    @DeleteMapping("/Delete/Vol_habilidad/{id}")
    public void borrarTarea(@PathVariable int id){
        repositorioVol_habilidad.deleteVol_habilidad(id);
    }
}
