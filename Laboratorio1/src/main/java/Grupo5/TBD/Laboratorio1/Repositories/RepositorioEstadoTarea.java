package Grupo5.TBD.Laboratorio1.Repositories;

import java.util.List;

import Grupo5.TBD.Laboratorio1.Models.Estado_tarea;

public interface RepositorioEstadoTarea {
    public List<Estado_tarea> getAll();
    public void updateEstado(Estado_tarea estado_tarea, int idClave);
    public Estado_tarea createEstado_tarea(Estado_tarea estado_tarea);
    public void deleteEstadoTarea(int idEstadoTarea);
}
