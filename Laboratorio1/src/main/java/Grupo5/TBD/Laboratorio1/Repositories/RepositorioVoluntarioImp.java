package Grupo5.TBD.Laboratorio1.Repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import Grupo5.TBD.Laboratorio1.Models.Voluntario;

@Repository
public class RepositorioVoluntarioImp implements  RepositorioVoluntario{
    @Autowired
    private Sql2o sql2o;

    @Override
    public List<Voluntario> getAll() {
        String sql = "SELECT * from voluntario";
        try(Connection conn = sql2o.open()){
            return conn.createQuery(sql).executeAndFetch(Voluntario.class);
        } catch (Exception e) {
            System.out.println(e.getMessage() + e.getLocalizedMessage()+" no conecté \n");
        }
        return null;
    }
    @Override
    public Voluntario createVoluntario(Voluntario voluntario){
        String sql = "INSERT INTO Voluntario (nombre, apellido,fecha,edad,rut,numero) VALUES (:nombre,:apellido,:fecha,:edad,:rut,:numero)";
        
        try (Connection con = sql2o.open()) {
            int id =  (int) con.createQuery(sql,true)
            .addParameter("nombre", voluntario.getNombre())
            .addParameter("apellido", voluntario.getApellido())
            .addParameter("fecha", voluntario.getFecha_nacimiento())
            .addParameter("edad", voluntario.getEdad())
            .addParameter("rut", voluntario.getRut())
            .addParameter("numero", voluntario.getNumero())
            .executeUpdate().getKey();

            voluntario.setId(id);
            return voluntario;

        }  
        catch (Exception e) {
            System.out.println(e.getCause() + e.getLocalizedMessage() + "\n");
        }
        return null;
    }

    @Override
    public void updateVoluntario(Voluntario voluntario, int idVoluntario){
        
        String updateSql = "UPDATE Voluntario SET nombre = :nombre, apellido = :apellido, fecha = :fecha, edad = :edad, rut = :rut, numero = :numero WHERE id = :idClave";

        try (Connection con = sql2o.open()) {
            con.createQuery(updateSql)
                .addParameter("nombre", voluntario.getNombre())
                .addParameter("apellido", voluntario.getApellido())
                .addParameter("fecha", voluntario.getFecha_nacimiento())
                .addParameter("edad", voluntario.getEdad())
                .addParameter("rut", voluntario.getRut())
                .addParameter("numero", voluntario.getNumero())
                .addParameter("idClave", idVoluntario).executeUpdate();
        }  
        catch (Exception e) {
            System.out.println(e.getCause() + e.getLocalizedMessage() + "\n");
        }
    }
    @Override
    public void deleteVoluntario(int idVoluntario){

        String deleteSql = "DELETE FROM voluntario WHERE id = :idVoluntario";

        try (Connection con = sql2o.open()) {
            con.createQuery(deleteSql)
            .addParameter("idVoluntario", idVoluntario).executeUpdate();

        }  
        catch (Exception e) {
            System.out.println(e.getCause() + e.getLocalizedMessage() + "\n");
        }
    }
}
