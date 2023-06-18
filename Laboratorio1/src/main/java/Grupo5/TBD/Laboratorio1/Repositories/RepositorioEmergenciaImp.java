package Grupo5.TBD.Laboratorio1.Repositories;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import Grupo5.TBD.Laboratorio1.Models.Emergencia;

@Repository
public class RepositorioEmergenciaImp implements  RepositorioEmergencia{
    @Autowired
    private Sql2o sql2o;

    @Override
    public List<Emergencia> getAll() {
        String query = "SELECT id, nombre,estado, id_institucion, st_x(st_astext( location)) AS longitude, st_y(st_astext(location)) AS latitude FROM emergencia;";
        try(Connection conn = sql2o.open()){
            return conn.createQuery(query).executeAndFetch(Emergencia.class);
        } catch (Exception e) {
            System.out.println(e.getMessage() + e.getLocalizedMessage()+" no conecté \n");
        }
        return null;
    }
    
    @Override
    public List<String> getByRegion(int id) {
        String query = "SELECT nombre FROM emergencia AS d INNER JOIN division_regional AS r ON ST_WITHIN(d.location, r.geom) WHERE r.cod_regi = :codigo;";
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
    public Emergencia createEmergencia(Emergencia emergencia) {
            String query = "INSERT INTO emergencia (nombre, location,estado, id_institucion) " +
            "VALUES (:nombre, ST_GeomFromText(:point, 4326), :estado_emergencia, :id_institucion_emergencia)";
            String point = "POINT("+emergencia.getLongitude()+" "+emergencia.getLatitude()+")";
            System.out.println("point: "+point);

    
        try (Connection con = sql2o.open()) {
            int id =  (int) con.createQuery(query,true)
            .addParameter("nombre", emergencia.getnombre())
            .addParameter("point", point)
            .addParameter("estado_emergencia", emergencia.getEstado())
            .addParameter("id_institucion_emergencia", emergencia.getid_institucion())
            .executeUpdate().getKey();

            emergencia.setId(id);
            return emergencia;

        }  
        catch (Exception e) {
            System.out.println(e.getCause() + e.getLocalizedMessage() + "\n");
        }
        return null;
    }

    @Override
    public void updateEmergencia(Emergencia emergencia, int idEmergencia) {
        String updateSql = "UPDATE emergencia SET nombre = :nombre_emergencia, location = ST_GeomFromText(:point, 4326), estado = :estado_emergencia, id_institucion = :id_institucion_emergencia WHERE id = :idClave";
        String point = "POINT("+emergencia.getLongitude()+" "+emergencia.getLatitude()+")";
            System.out.println("point: "+point);
        try (Connection con = sql2o.open()) {
            con.createQuery(updateSql)
            .addParameter("nombre_emergencia", emergencia.getnombre())
                .addParameter("point", point)
                .addParameter("estado_emergencia", emergencia.getEstado())
                .addParameter("id_institucion_emergencia", emergencia.getid_institucion())
                .addParameter("idClave", idEmergencia).executeUpdate();

        }  
        catch (Exception e) {
            System.out.println(e.getCause() + e.getLocalizedMessage() + "\n");
        }
        
    }

    @Override
    public void deleteEmergencia(int idEmergencia) {
        String deleteSql = "DELETE FROM emergencia WHERE id = :idEmergencia";

        try (Connection con = sql2o.open()) {
            con.createQuery(deleteSql)
            .addParameter("idEmergencia", idEmergencia).executeUpdate();

        }  
        catch (Exception e) {
            System.out.println(e.getCause() + e.getLocalizedMessage() + "\n");
        }
        
    }
    
}
