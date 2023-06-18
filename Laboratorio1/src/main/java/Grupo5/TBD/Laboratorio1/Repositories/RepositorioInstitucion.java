package Grupo5.TBD.Laboratorio1.Repositories;

import java.util.List;


import Grupo5.TBD.Laboratorio1.Models.Institucion;

public interface RepositorioInstitucion {
    public List<Institucion> getAll();
    public Institucion createInstitucion(Institucion institucion);
    public void updateInstitucion(Institucion institucion, int idInstitucion);
    public void deleteInstitucion(int idInstitucion);
}
