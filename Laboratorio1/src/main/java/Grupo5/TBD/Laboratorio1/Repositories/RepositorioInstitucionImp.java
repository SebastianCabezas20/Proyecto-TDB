package Grupo5.TBD.Laboratorio1.Repositories;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import Grupo5.TBD.Laboratorio1.Models.Institucion;

@Repository
public class RepositorioInstitucionImp implements  RepositorioInstitucion{
    @Autowired
    private Sql2o sql2o;

    @Override
    public List<Institucion> getAll() {
        String sql = "SELECT * from institucion";
        try(Connection conn = sql2o.open()){
            return conn.createQuery(sql).executeAndFetch(Institucion.class);
        } catch (Exception e) {
            System.out.println(e.getMessage() + e.getLocalizedMessage()+" no conecté \n");
        }
        return null;
    }

    @Override
    public Institucion createInstitucion(Institucion institucion){
        String sql = "INSERT INTO institucion (nombre, direccion) VALUES (:nombre,:direccion)";
        
        try (Connection con = sql2o.open()) {
            int id =  (int) con.createQuery(sql,true)
            .addParameter("nombre", institucion.getNombre())
            .addParameter("direccion", institucion.getDireccion())
            .executeUpdate().getKey();

            institucion.setId(id);
            return institucion;

        }  
        catch (Exception e) {
            System.out.println(e.getCause() + e.getLocalizedMessage() + "\n");
        }
        return null;
    }

    @Override
    public void updateInstitucion(Institucion institucion, int idInstitucion){

        String updateSql = "UPDATE institucion SET nombre = :name, direccion = :address WHERE id = :idClave";

        try (Connection con = sql2o.open()) {
            con.createQuery(updateSql)
                .addParameter("name", institucion.getNombre())
                .addParameter("address", institucion.getDireccion())
                .addParameter("idClave", idInstitucion).executeUpdate();

        }  
        catch (Exception e) {
            System.out.println(e.getCause() + e.getLocalizedMessage() + "\n");
        }
    }

    @Override
    public void deleteInstitucion(int idInstitucion){

        String deleteSql = "DELETE FROM institucion WHERE id = :idInstitucion";

        try (Connection con = sql2o.open()) {
            con.createQuery(deleteSql)
            .addParameter("idInstitucion", idInstitucion).executeUpdate();

        }  
        catch (Exception e) {
            System.out.println(e.getCause() + e.getLocalizedMessage() + "\n");
        }
    }
}
