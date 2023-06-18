package Grupo5.TBD.Laboratorio1.Repositories;

import java.util.List;

import Grupo5.TBD.Laboratorio1.Models.Habilidad;

public interface RepositorioHabilidad {
    public List<Habilidad> getAll();
    public Habilidad createHabilidad(Habilidad habilidad);
    public void updateHabilidad(Habilidad habilidad, int id, String nombre);
    public void deleteHabilidad(int idHabilidad);
}
