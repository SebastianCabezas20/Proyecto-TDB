package Grupo5.TBD.Laboratorio1.Repositories;

import java.util.List;

import Grupo5.TBD.Laboratorio1.Models.Emergencia_habilidad;

public interface RepositorioEmergencia_habilidad {
    public List<Emergencia_habilidad> getAll();
    public Emergencia_habilidad createEmergencia_habilidad(Emergencia_habilidad emergencia_habilidad);
    public void updateEmergencia_habilidad(Emergencia_habilidad emergencia_habilidad, int idEmergenciaHabilidad);
    public void deleteEmergencia_habilidad(int idEmergenciaHabilidad);
}
