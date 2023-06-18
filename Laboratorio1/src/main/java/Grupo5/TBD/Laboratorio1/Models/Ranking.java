package Grupo5.TBD.Laboratorio1.Models;

public class Ranking {
    private int id;
    private int puntos;
    private int id_voluntario;
    private int id_tarea;

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public int getPuntos(){
        return puntos;
    }

    public void setPuntos(int puntos){
        this.puntos = puntos;
    }

    public int getId_voluntario(){
        return id_voluntario;
    }

    public void setId_voluntario(int id_vol){
        this.id_voluntario = id_vol;
    }

    public int getId_tarea(){
        return id_tarea;
    }

    public void setId_tarea(int id_tarea){
        this.id_tarea = id_tarea;
    }
}
