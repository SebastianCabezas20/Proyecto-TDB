package Grupo5.TBD.Laboratorio1.Repositories;
import java.util.List;
import Grupo5.TBD.Laboratorio1.Models.Vol_habilidad;

public interface RepositorioVol_habilidad {
    public List<Vol_habilidad> getAll();
    public Vol_habilidad createVol_habilidad(Vol_habilidad vol_habilidad);
    public void updateVol_habilidad (Vol_habilidad vol_habilidad , int id);
    public void deleteVol_habilidad(int id);
    
}
