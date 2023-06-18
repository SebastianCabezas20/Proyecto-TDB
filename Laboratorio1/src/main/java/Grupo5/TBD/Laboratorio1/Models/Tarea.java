package Grupo5.TBD.Laboratorio1.Models;

public class Tarea {
    private int id; 
    private String nombre;
    private String descripcion;
    private int cantd_voluntarios;
    private int id_eme;
    private int id_estado_tarea;
    private double longitude;
    private double latitude;
    


    public double getLongitude() {
        return longitude;
    }
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
    public double getLatitude() {
        return latitude;
    }
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getnombre() {
        return nombre;
    }
    public void setnombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCantd_voluntarios() {
        return cantd_voluntarios;
    }
    public void setCantd_voluntarios(int cantd_voluntarios) {
        this.cantd_voluntarios = cantd_voluntarios;
    }
    public int getId_eme() {
        return id_eme;
    }
    public void setId_eme(int id_eme) {
        this.id_eme = id_eme;
    }
    public int getId_estado_tarea() {
        return id_estado_tarea;
    }
    public void setId_estado_tarea(int id_estado_tarea) {
        this.id_estado_tarea = id_estado_tarea;
    }

    
}
