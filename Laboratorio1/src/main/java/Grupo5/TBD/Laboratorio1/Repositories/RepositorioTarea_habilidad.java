package Grupo5.TBD.Laboratorio1.Repositories;

import java.util.List;

import Grupo5.TBD.Laboratorio1.Models.Tarea_habilidad;

public interface RepositorioTarea_habilidad {
    public List<Tarea_habilidad> getAll();
    public Tarea_habilidad createTarea_habilidad(Tarea_habilidad tarea_habilidad);
    public void updateTarea_habilidad(Tarea_habilidad tarea_habilidad,int id, int id_eme_habilidad, int id_tarea);
    public void deleteTarea_habilidad(int id);

}
