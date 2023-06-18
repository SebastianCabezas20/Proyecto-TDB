package Grupo5.TBD.Laboratorio1.Repositories;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import Grupo5.TBD.Laboratorio1.Models.Emergencia_habilidad;

@Repository
public class RepositorioEmergencia_habilidadImp implements  RepositorioEmergencia_habilidad{
    @Autowired
    private Sql2o sql2o;

    @Override
    public List<Emergencia_habilidad> getAll() {
        String sql = "SELECT * from emergencia_habilidad";
        try(Connection conn = sql2o.open()){
            return conn.createQuery(sql).executeAndFetch(Emergencia_habilidad.class);
        } catch (Exception e) {
            System.out.println(e.getMessage() + e.getLocalizedMessage()+" no conecté \n");
        }
        return null;
    }

    @Override
    public Emergencia_habilidad createEmergencia_habilidad(Emergencia_habilidad emergencia_habilidad) {
        String sql = "INSERT INTO emergencia_habilidad (id_emergencia, id_habilidad ) VALUES (:id_emergencia_habilidad,:id_habilidad_emergencia)";
        
        try (Connection con = sql2o.open()) {
            int id =  (int) con.createQuery(sql,true)
            .addParameter("id_emergencia_habilidad", emergencia_habilidad.getid_emergencia())
            .addParameter("id_habilidad_emergencia", emergencia_habilidad.getid_habilidad())
            .executeUpdate().getKey();

            emergencia_habilidad.setId(id);
            return emergencia_habilidad;

        }  
        catch (Exception e) {
            System.out.println(e.getCause() + e.getLocalizedMessage() + "\n");
        }
        return null;
    }

    @Override
    public void updateEmergencia_habilidad(Emergencia_habilidad emergencia_habilidad, int idEmergenciaHabilidad) {
        String updateSql = "UPDATE emergencia_habilidad SET id_emergencia = :id_emergencia_habilidad, id_habilidad = :id_habilidad_emergencia WHERE id = :idClave";

        try (Connection con = sql2o.open()) {
            con.createQuery(updateSql)
            .addParameter("id_emergencia_habilidad", emergencia_habilidad.getid_emergencia())
                .addParameter("id_habilidad_emergencia", emergencia_habilidad.getid_habilidad())
                .addParameter("idClave", idEmergenciaHabilidad).executeUpdate();

        }  
        catch (Exception e) {
            System.out.println(e.getCause() + e.getLocalizedMessage() + "\n");
        }
        
    }

    @Override
    public void deleteEmergencia_habilidad(int idEmergenciaHabilidad) {
        String deleteSql = "DELETE FROM emergencia_habilidad WHERE id = :idEmergenciaHabilidad";

        try (Connection con = sql2o.open()) {
            con.createQuery(deleteSql)
            .addParameter("idEmergenciaHabilidad", idEmergenciaHabilidad).executeUpdate();

        }  
        catch (Exception e) {
            System.out.println(e.getCause() + e.getLocalizedMessage() + "\n");
        }
        
    }
}
