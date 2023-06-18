package Grupo5.TBD.Laboratorio1.Repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import Grupo5.TBD.Laboratorio1.Models.Estado_tarea;

@Repository
public class RepositorioEstadoTareaImp implements RepositorioEstadoTarea{
    @Autowired
    private Sql2o sql2o;

    @Override
    public List<Estado_tarea> getAll() {
        String sql = "SELECT * from estado_tarea";
        try(Connection conn = sql2o.open()){
            return conn.createQuery(sql).executeAndFetch(Estado_tarea.class);
        } catch (Exception e) {
            System.out.println(e.getMessage() + e.getLocalizedMessage()+" no conecté \n");
        }
        return null;
    }
    @Override
    public Estado_tarea createEstado_tarea(Estado_tarea estado_tarea){
        String sql = "INSERT INTO estado_tarea (estado) VALUES (:estado)";
        
        try (Connection con = sql2o.open()) {
            int id =  (int) con.createQuery(sql,true)
            .addParameter("estado", estado_tarea.getEstado())
            .executeUpdate().getKey();

            estado_tarea.setId(id);
            return estado_tarea;

        }  
        catch (Exception e) {
            System.out.println(e.getCause() + e.getLocalizedMessage() + "\n");
        }
        return null;
    }

    @Override
    public void updateEstado(Estado_tarea estado_tarea, int idClave){

        String updateSql = "UPDATE estado_tarea SET estado = :estado WHERE id = :idClave";

        try (Connection con = sql2o.open()) {
            con.createQuery(updateSql)
                .addParameter("estado", estado_tarea.getEstado())
                .addParameter("idClave", idClave).executeUpdate();

        }  
        catch (Exception e) {
            System.out.println(e.getCause() + e.getLocalizedMessage() + "\n");
        }
    }

    @Override
    public void deleteEstadoTarea(int idEstadoTarea){

        String deleteSql = "DELETE FROM estado_tarea WHERE id = :idEstadoTarea";

        try (Connection con = sql2o.open()) {
            con.createQuery(deleteSql)
            .addParameter("idEstadoTarea", idEstadoTarea).executeUpdate();

        }  
        catch (Exception e) {
            System.out.println(e.getCause() + e.getLocalizedMessage() + "\n");
        }
    }
}
