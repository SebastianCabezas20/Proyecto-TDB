package Grupo5.TBD.Laboratorio1.Repositories;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import Grupo5.TBD.Laboratorio1.Models.Vol_habilidad;

@Repository
public class RepositorioVol_habilidadImp implements RepositorioVol_habilidad {
    @Autowired
    private Sql2o sql2o;

    @Override
    public List<Vol_habilidad> getAll() {
        String sql = "SELECT * from vol_habilidad";
        try(Connection conn = sql2o.open()){
            return conn.createQuery(sql).executeAndFetch(Vol_habilidad.class);
        } catch (Exception e) {
            System.out.println(e.getMessage() + e.getLocalizedMessage()+" no conecté \n");
        }
        return null;
    }

    @Override
    public Vol_habilidad createVol_habilidad(Vol_habilidad vol_habilidad){
        String sql = "INSERT INTO vol_habilidad (id_vol_habilidad) VALUES (:id_habilidad)";
        try (Connection con = sql2o.open()){
            int id =(int)con.createQuery(sql,true)
            .addParameter("id_vol_voluntario",vol_habilidad.getid_voluntario())
            .addParameter("id_habilidad",vol_habilidad.getid_habilidad())        
            .executeUpdate().getKey();
            vol_habilidad.setId(id);
            return vol_habilidad;
                   

        } catch (Exception e){
            System.out.println(e.getCause()+e.getLocalizedMessage()+"\n");
        }
        return null;
        
    }
    @Override
    public void updateVol_habilidad (Vol_habilidad vol_habilidad , int id){
        String updateSql = "UPDATE vol_habilidad SET id_voluntario =:id_voluntario , id_habilidad = :id_habilidad WHERE id=idClave )";
           try (Connection con = sql2o.open()) {
            con.createQuery(updateSql)
            .addParameter("id_habilidad", vol_habilidad.getid_habilidad())
            .addParameter("id_voluntario", vol_habilidad.getid_voluntario())
            .addParameter("idClave", id).executeUpdate();

        }catch (Exception e){
            System.out.println(e.getCause()+e.getLocalizedMessage()+"\n");
        }
           
                
    }
     @Override
    public void deleteVol_habilidad(int id){
        String deleteSql = "DELETE FROM vol_habilidad WHERE id = :id";

        try (Connection con = sql2o.open()) {
            con.createQuery(deleteSql)
            .addParameter("id", id).executeUpdate();

        }  
        catch (Exception e) {
            System.out.println(e.getCause() + e.getLocalizedMessage() + "\n");
        }
    }
    
}
