package Grupo5.TBD.Laboratorio1.Repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import Grupo5.TBD.Laboratorio1.Models.Tarea;

@Repository
public class RepositorioTareaImp implements RepositorioTarea{
    @Autowired
    private Sql2o sql2o;

    @Override
    public List<Tarea> getAll() {
        String sql = "SELECT id, nombre,descripcion,cantd_voluntarios,id_eme,id_estado_tarea,st_x(st_astext( location)) AS longitude, st_y(st_astext(location)) AS latitude FROM tarea;";
        try(Connection conn = sql2o.open()){
            return conn.createQuery(sql).executeAndFetch(Tarea.class);
        } catch (Exception e) {
            System.out.println(e.getMessage() + e.getLocalizedMessage()+" no conecté \n");
        }
        return null;
    }

    @Override
    public List<String> getByRegion(int id) {
        String query = "SELECT nombre FROM tarea AS d INNER JOIN division_regional AS r ON ST_WITHIN(d.location, r.geom) WHERE r.cod_regi = :codigo;";
        try(Connection conn = sql2o.open()){
            return (List<String>) conn.createQuery(query)
            .addParameter("codigo", id)
            .executeScalarList(String.class);
        } catch (Exception e) {
            System.out.println(e.getMessage() + e.getLocalizedMessage()+" no conecté \n");
        }
        return null;
    }


    @Override
    public Tarea createTarea(Tarea tarea){
        String sql = "INSERT INTO tarea (nombre,location,descripcion,cantd_voluntarios,id_eme, id_estado_tarea) " +
        "VALUES (:nombre, ST_GeomFromText(:point, 4326), :descripcion ,:cantidadVoluntarios ,:idEmergencia, :idEstado)";
        String point = "POINT("+tarea.getLongitude()+" "+tarea.getLatitude()+")";
        System.out.println("point: "+point);
        
        try (Connection con = sql2o.open()) {
            int id =  (int) con.createQuery(sql,true)
            .addParameter("nombre", tarea.getnombre())
            .addParameter("point", point)
            .addParameter("descripcion", tarea.getDescripcion())
            .addParameter("cantidadVoluntarios", tarea.getCantd_voluntarios())
            .addParameter("idEmergencia", tarea.getId_eme())
            .addParameter("idEstado", tarea.getId_estado_tarea())
            .executeUpdate().getKey();

            tarea.setId(id);
            return tarea;

        }  
        catch (Exception e) {
            System.out.println(e.getCause() + e.getLocalizedMessage() + "\n");
        }
        return null;
    }

    @Override
    public void updateTarea(Tarea tarea, int idTarea){

        String updateSql = "UPDATE tarea SET nombre = :nombre,location = ST_GeomFromText(:point, 4326), descripcion = :descripcion, cantd_voluntarios = :cantidad, id_eme = :id, id_estado_tarea = :estado WHERE id = :idClave";
        String point = "POINT("+tarea.getLongitude()+" "+tarea.getLatitude()+")";
        System.out.println("point: "+point);
        try (Connection con = sql2o.open()) {
            con.createQuery(updateSql)
            .addParameter("nombre", tarea.getnombre())
            .addParameter("point", point)
            .addParameter("descripcion", tarea.getDescripcion())
            .addParameter("cantidad", tarea.getCantd_voluntarios())
                .addParameter("id", tarea.getId_eme())
                .addParameter("estado", tarea.getId_estado_tarea())
                .addParameter("idClave", idTarea).executeUpdate();

        }  
        catch (Exception e) {
            System.out.println(e.getCause() + e.getLocalizedMessage() + "\n");
        }
    }

    @Override
    public void deleteTarea(int idTarea){

        String deleteSql = "DELETE FROM tarea WHERE id = :idTarea";

        try (Connection con = sql2o.open()) {
            con.createQuery(deleteSql)
            .addParameter("idTarea", idTarea).executeUpdate();

        }  
        catch (Exception e) {
            System.out.println(e.getCause() + e.getLocalizedMessage() + "\n");
        }
    }
}
