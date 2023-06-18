package Grupo5.TBD.Laboratorio1.Repositories;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import Grupo5.TBD.Laboratorio1.Models.Ranking;

@Repository
public class RepositorioRankingImp implements  RepositorioRanking{
    @Autowired
    private Sql2o sql2o;

    @Override
    public List<Ranking> getAll() {
        String sql = "SELECT * from ranking";
        try(Connection conn = sql2o.open()){
            return conn.createQuery(sql).executeAndFetch(Ranking.class);
        } catch (Exception e) {
            System.out.println(e.getMessage() + e.getLocalizedMessage()+" no conecté \n");
        }
        return null;
    }

    @Override
    public Ranking createRanking(Ranking ranking){
        String sql = "INSERT INTO ranking (puntos, id_voluntario, id_tarea) VALUES (:puntos,:idVoluntario,:idTarea)";
        
        try (Connection con = sql2o.open()) {
            int id =  (int) con.createQuery(sql,true)
            .addParameter("puntos", ranking.getPuntos())
            .addParameter("idVoluntario", ranking.getId_voluntario())
            .addParameter("idTarea", ranking.getId_tarea())
            .executeUpdate().getKey();

            ranking.setId(id);
            return ranking;

        }  
        catch (Exception e) {
            System.out.println(e.getCause() + e.getLocalizedMessage() + "\n");
        }
        return null;
    }

    @Override
    public void updateRanking(Ranking ranking, int idRanking){

        String updateSql = "UPDATE ranking SET puntos = :points, id_voluntario = :id_vol, id_tarea = :tarea WHERE id = :idClave";

        try (Connection con = sql2o.open()) {
            con.createQuery(updateSql)
                .addParameter("points", ranking.getPuntos())
                .addParameter("id_vol", ranking.getId_voluntario())
                .addParameter("tarea", ranking.getId_tarea())
                .addParameter("idClave", idRanking).executeUpdate();

        }  
        catch (Exception e) {
            System.out.println(e.getCause() + e.getLocalizedMessage() + "\n");
        }
    }

    @Override
    public void deleteRanking(int idRanking){

        String deleteSql = "DELETE FROM ranking WHERE id = :idRanking";

        try (Connection con = sql2o.open()) {
            con.createQuery(deleteSql)
            .addParameter("idRanking", idRanking).executeUpdate();

        }  
        catch (Exception e) {
            System.out.println(e.getCause() + e.getLocalizedMessage() + "\n");
        }
    }
}
