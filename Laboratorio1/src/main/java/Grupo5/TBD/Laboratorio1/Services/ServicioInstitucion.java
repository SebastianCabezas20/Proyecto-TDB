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

import Grupo5.TBD.Laboratorio1.Models.Institucion;
import Grupo5.TBD.Laboratorio1.Repositories.RepositorioInstitucion;

@RestController
public class ServicioInstitucion {
    
    private final RepositorioInstitucion repositorioInstitucion;
    ServicioInstitucion(RepositorioInstitucion repositorioInstitucion){
        this.repositorioInstitucion = repositorioInstitucion;
    }
    @GetMapping("/Instituciones")
    public List<Institucion> getAll(){
        return repositorioInstitucion.getAll();
    }
    @PostMapping("/Create/Institucion")
    @ResponseBody
    public Institucion createInstitucion(@RequestBody Institucion institucion){
        return repositorioInstitucion.createInstitucion(institucion);
    }
    @PutMapping("/Institucion/{id}")
    @ResponseBody
    public void actualizarInstitucion(@RequestBody Institucion institucion ,@PathVariable int id){
        repositorioInstitucion.updateInstitucion(institucion, id);
    }
    @DeleteMapping("/Delete/Institucion/{id}")
    public void borrarInstitucion(@PathVariable int id){
        repositorioInstitucion.deleteInstitucion(id);
    }
}
