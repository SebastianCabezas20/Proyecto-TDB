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

import Grupo5.TBD.Laboratorio1.Models.Ranking;
import Grupo5.TBD.Laboratorio1.Repositories.RepositorioRanking;

@RestController
public class ServicioRanking {
    
    private final RepositorioRanking repositorioRanking;
    ServicioRanking(RepositorioRanking repositorioRanking){
        this.repositorioRanking = repositorioRanking;
    }
    @GetMapping("/Rankings")
    public List<Ranking> getAll(){
        return repositorioRanking.getAll();
    }
    @PostMapping("/Create/Ranking")
    @ResponseBody
    public Ranking createRanking(@RequestBody Ranking ranking){
        return repositorioRanking.createRanking(ranking);
    }
    @PutMapping("/Ranking/{id}")
    @ResponseBody
    public void actualizarRanking(@RequestBody Ranking ranking ,@PathVariable int id){
        repositorioRanking.updateRanking(ranking, id);
    }
    @DeleteMapping("/Delete/Ranking/{id}")
    public void borrarRanking(@PathVariable int id){
        repositorioRanking.deleteRanking(id);
    }
}