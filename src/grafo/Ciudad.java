package grafo;

public class Ciudad {
    private Integer idCiudad;
    private String nombre;
    private boolean tieneBalanza;
    private boolean tieneRadares;
    private Integer estacionesDeServicio;
    private Integer talleresMecanicos;

    public Ciudad(Integer idCiudad, String nombreCiudad, boolean tieneBalanza,
                  boolean tieneRadares, Integer estacionesDeServicio, Integer talleresMecanicos) {
        this.idCiudad = idCiudad;
        this.nombre = nombreCiudad;
        this.tieneBalanza = tieneBalanza;
        this.tieneRadares = tieneRadares;
        this.estacionesDeServicio = estacionesDeServicio;
        this.talleresMecanicos = talleresMecanicos;
    }
    //O(1)
    public Integer getIdCiudad() {
        return idCiudad;
    }
    //O(1)
    public String getNombre() {
        return nombre;
    }
    //O(1)
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    //O(1)
    public boolean isTieneBalanza() {
        return tieneBalanza;
    }
    //O(1)
    public void setTieneBalanza(boolean tieneBalanza) {
        this.tieneBalanza = tieneBalanza;
    }
    //O(1)
    public boolean isTieneRadares() {
        return tieneRadares;
    }
    //O(1)
    public void setTieneRadares(boolean tieneRadares) {
        this.tieneRadares = tieneRadares;
    }
    //O(1)
    public Integer getEstacionesDeServicio() {
        return estacionesDeServicio;
    }
    //O(1)
    public void setEstacionesDeServicio(Integer estacionesDeServicio) {
        this.estacionesDeServicio = estacionesDeServicio;
    }
    //O(1)
    public Integer getTalleresMecanicos() {
        return talleresMecanicos;
    }
    //O(1)
    public void setTalleresMecanicos(Integer talleresMecanicos) {
        this.talleresMecanicos = talleresMecanicos;
    }


}
