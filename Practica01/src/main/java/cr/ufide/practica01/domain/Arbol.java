// src/main/java/cr/ufide/practica01/domain/Arbol.java
package cr.ufide.practica01.domain;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "arbol")
public class Arbol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="nombre_comun", nullable=false, length=120)
    private String nombreComun;

    @Column(name="nombre_cientifico", length=160)
    private String nombreCientifico;

    @Column(name="tipo_flor", length=80)
    private String tipoFlor;

    @Column(name="dureza_madera", length=60)
    private String durezaMadera;

    @Column(name="altura_promedio_m", nullable=false, precision=10, scale=2)
    private BigDecimal alturaPromedioM;

    @Column(name="imagen_ruta", nullable=false, length=255)
    private String imagenRuta;

    // === Getters/Setters ===
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombreComun() { return nombreComun; }
    public void setNombreComun(String nombreComun) { this.nombreComun = nombreComun; }

    public String getNombreCientifico() { return nombreCientifico; }
    public void setNombreCientifico(String nombreCientifico) { this.nombreCientifico = nombreCientifico; }

    public String getTipoFlor() { return tipoFlor; }
    public void setTipoFlor(String tipoFlor) { this.tipoFlor = tipoFlor; }

    public String getDurezaMadera() { return durezaMadera; }
    public void setDurezaMadera(String durezaMadera) { this.durezaMadera = durezaMadera; }

    public BigDecimal getAlturaPromedioM() { return alturaPromedioM; }
    public void setAlturaPromedioM(BigDecimal alturaPromedioM) { this.alturaPromedioM = alturaPromedioM; }

    public String getImagenRuta() { return imagenRuta; }
    public void setImagenRuta(String imagenRuta) { this.imagenRuta = imagenRuta; }
}
