package Grupo5.TBD.Laboratorio1.Repositories;

import java.util.List;

import Grupo5.TBD.Laboratorio1.Models.Emergencia;

public interface RepositorioEmergencia {
    public List<Emergencia> getAll();
    public Emergencia createEmergencia(Emergencia emergencia);
    public void updateEmergencia(Emergencia emergencia, int idEmergencia);
    public void deleteEmergencia(int idEmergencia);
    public List<String> getByRegion(int id);
}
