package Grupo5.TBD.Laboratorio1.Repositories;

import java.util.List;

import Grupo5.TBD.Laboratorio1.Models.Ranking;

public interface RepositorioRanking {
    public List<Ranking> getAll();
    public Ranking createRanking(Ranking ranking);
    public void updateRanking(Ranking ranking, int idRanking);
    public void deleteRanking(int idRanking);
}
