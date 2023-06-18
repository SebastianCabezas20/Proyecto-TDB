package Grupo5.TBD.Laboratorio1.Models;

public class Emergencia {
    private int id;
    private String nombre;
    private double longitude;
    private double latitude;
    private String estado;
    private int id_institucion;

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
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getid_institucion(){
        return id_institucion;
    }
    public void setid_institucion(int id_institucion){
        this.id_institucion = id_institucion;
    }
}
