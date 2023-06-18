package Grupo5.TBD.Laboratorio1.Repositories;



import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import Grupo5.TBD.Laboratorio1.Models.Tarea_habilidad;

@Repository
public class RepositorioTarea_habilidadImp implements  RepositorioTarea_habilidad{
    @Autowired
    private Sql2o sql2o;

    @Override
    public List<Tarea_habilidad> getAll() {
        String sql = "SELECT * from tarea_habilidad";
        try(Connection conn = sql2o.open()){
            return conn.createQuery(sql).executeAndFetch(Tarea_habilidad.class);
        } catch (Exception e) {
            System.out.println(e.getMessage() + e.getLocalizedMessage()+" no conecté \n");
        }
        return null;
    }
    @Override
    public Tarea_habilidad createTarea_habilidad(Tarea_habilidad tarea_habilidad){
        String sql = "INSERT INTO tarea_habilidad (id_eme_habilidad) VALUES (:id_eme_habilidad)";
        
        try (Connection con = sql2o.open()) {
            int id =  (int) con.createQuery(sql,true)
            .addParameter("id_eme_habilidad", tarea_habilidad.getId_eme_habilidad())
            .addParameter("id_tarea", tarea_habilidad.getId_tarea())
            .executeUpdate().getKey();

            tarea_habilidad.setId(id);
            return tarea_habilidad;

        }  
        catch (Exception e) {
            System.out.println(e.getCause() + e.getLocalizedMessage() + "\n");
        }
        return null;
    }
    @Override
    public void updateTarea_habilidad(Tarea_habilidad tarea_habilidad,int id, int id_eme_habilidad, int id_tarea){

        String updateSql = "UPDATE tarea_habiliad SET id_eme_habilidad = :id_eme_habilidad, id_tarea = :id_tarea WHERE id = :idClave";

        try (Connection con = sql2o.open()) {
            con.createQuery(updateSql)
            .addParameter("id_eme_habilidad", tarea_habilidad.getId_eme_habilidad())
            .addParameter("id_tarea", tarea_habilidad.getId_tarea())
            .addParameter("idClave", id).executeUpdate();

        }  
        catch (Exception e) {
            System.out.println(e.getCause() + e.getLocalizedMessage() + "\n");
        }
    }
    @Override
    public void deleteTarea_habilidad(int id){
        String deleteSql = "DELETE FROM tarea_habilidad WHERE id = :id";

        try (Connection con = sql2o.open()) {
            con.createQuery(deleteSql)
            .addParameter("id", id).executeUpdate();

        }  
        catch (Exception e) {
            System.out.println(e.getCause() + e.getLocalizedMessage() + "\n");
        }
    }
}
