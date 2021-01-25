package VO;

public class DatoImg {

/*Todo los atributos*/
    int idRegistro;
    String nombre;
    double latitud;
    double longitud;
    byte[] foto;

public DatoImg(){}

/*Todo los codigos get*/
    public int getIdRegistro(){
        return idRegistro;
    }
    public String getNombre(){
        return nombre;
    }
    public double getLatitud(){
        return latitud;
    }
    public double getLongitud(){
        return longitud;
    }


/*Todo los codigos set*/
    public void setIdRegistro(int idRegistro){
        this.idRegistro = idRegistro;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public void setLatitud(double latitud){
        this.latitud = latitud;
    }
    public void setLongitud(double longitud){
        this.longitud = longitud;
    }

    /**
     * @return the foto
     */
    public byte[] getFoto() {
        return foto;
    }

    /**
     * @param foto the foto to set
     */
    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

}
