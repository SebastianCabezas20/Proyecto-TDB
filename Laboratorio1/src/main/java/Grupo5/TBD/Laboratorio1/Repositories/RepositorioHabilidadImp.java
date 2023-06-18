package Grupo5.TBD.Laboratorio1.Repositories;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import Grupo5.TBD.Laboratorio1.Models.Habilidad;

@Repository
public class RepositorioHabilidadImp implements  RepositorioHabilidad{
    @Autowired
    private Sql2o sql2o;

    @Override
    public List<Habilidad> getAll() {
        String sql = "SELECT * from habilidad";
        try(Connection conn = sql2o.open()){
            return conn.createQuery(sql).executeAndFetch(Habilidad.class);
        } catch (Exception e) {
            System.out.println(e.getMessage() + e.getLocalizedMessage()+" no conecté \n");
        }
        return null;
    }

    @Override
    public Habilidad createHabilidad(Habilidad habilidad){
        String sql = "INSERT INTO habilidad (nombre) VALUES (:nombre)";
        
        try (Connection con = sql2o.open()) {
            int id =  (int) con.createQuery(sql,true)
            .addParameter("nombre", habilidad.getNombre())
            .executeUpdate().getKey();

            habilidad.setId(id);
            return habilidad;

        }  
        catch (Exception e) {
            System.out.println(e.getCause() + e.getLocalizedMessage() + "\n");
        }
        return null;
    }
    @Override
    public void updateHabilidad(Habilidad habilidad, int id, String nombre){

        String updateSql = "UPDATE habilidad SET nombre = :nombre WHERE id = :id";

        try (Connection con = sql2o.open()) {
            con.createQuery(updateSql)
                .addParameter("nombre", habilidad.getNombre())
                .addParameter("idClave", id).executeUpdate();
        }  
        catch (Exception e) {
            System.out.println(e.getCause() + e.getLocalizedMessage() + "\n");
        }
    }
    @Override
    public void deleteHabilidad(int idHabilidad){

        String deleteSql = "DELETE FROM habilidad WHERE id = :idHabilidad";

        try (Connection con = sql2o.open()) {
            con.createQuery(deleteSql)
            .addParameter("idHabilidad", idHabilidad).executeUpdate();

        }  
        catch (Exception e) {
            System.out.println(e.getCause() + e.getLocalizedMessage() + "\n");
        }
    }
  
}
