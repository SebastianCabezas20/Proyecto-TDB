package Grupo5.TBD.Laboratorio1.Repositories;

import java.util.List;

import Grupo5.TBD.Laboratorio1.Models.Tarea;

public interface RepositorioTarea {
    public List<Tarea> getAll();
    public Tarea createTarea(Tarea tarea);
    public void updateTarea(Tarea tarea, int idTarea);
    public void deleteTarea(int idTarea);
    public List<String> getByRegion(int id);
}
