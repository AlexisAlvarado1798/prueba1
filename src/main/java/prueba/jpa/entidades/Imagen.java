/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba.jpa.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author AdminAlexisAlvarado
 */
@Entity
@Table(name = "IMAGEN", catalog = "", schema = "ALEX")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Imagen.findAll", query = "SELECT i FROM Imagen i"),
    @NamedQuery(name = "Imagen.findByPkImagen", query = "SELECT i FROM Imagen i WHERE i.pkImagen = :pkImagen"),
    @NamedQuery(name = "Imagen.findByRuta", query = "SELECT i FROM Imagen i WHERE i.ruta = :ruta"),
    @NamedQuery(name = "Imagen.findByDescripcion", query = "SELECT i FROM Imagen i WHERE i.descripcion = :descripcion")})
public class Imagen implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "PK_IMAGEN", nullable = false, precision = 0, scale = -127)
    private BigDecimal pkImagen;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "RUTA", nullable = false, length = 256)
    private String ruta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "DESCRIPCION", nullable = false, length = 256)
    private String descripcion;
    @JoinColumn(name = "FK_PRODUCTO", referencedColumnName = "PK_PRODUCTO", nullable = false)
    @ManyToOne(optional = false)
    private Producto fkProducto;

    public Imagen() {
    }

    public Imagen(BigDecimal pkImagen) {
        this.pkImagen = pkImagen;
    }

    public Imagen(BigDecimal pkImagen, String ruta, String descripcion) {
        this.pkImagen = pkImagen;
        this.ruta = ruta;
        this.descripcion = descripcion;
    }

    public BigDecimal getPkImagen() {
        return pkImagen;
    }

    public void setPkImagen(BigDecimal pkImagen) {
        this.pkImagen = pkImagen;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Producto getFkProducto() {
        return fkProducto;
    }

    public void setFkProducto(Producto fkProducto) {
        this.fkProducto = fkProducto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkImagen != null ? pkImagen.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Imagen)) {
            return false;
        }
        Imagen other = (Imagen) object;
        if ((this.pkImagen == null && other.pkImagen != null) || (this.pkImagen != null && !this.pkImagen.equals(other.pkImagen))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "prueba.jpa.entidades.Imagen[ pkImagen=" + pkImagen + " ]";
    }
    
}
