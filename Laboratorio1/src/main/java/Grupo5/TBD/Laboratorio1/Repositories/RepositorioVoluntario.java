package Grupo5.TBD.Laboratorio1.Repositories;

import java.util.List;

import Grupo5.TBD.Laboratorio1.Models.Voluntario;

public interface RepositorioVoluntario {
    public List<Voluntario> getAll();
    public Voluntario createVoluntario(Voluntario voluntario);
    public void updateVoluntario(Voluntario voluntario, int idVoluntario);
    public void deleteVoluntario(int idVoluntario);
}
