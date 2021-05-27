/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba.jpa.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author AdminAlexisAlvarado
 */
@Entity
@Table(name = "PRODUCTO", catalog = "", schema = "ALEX")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Producto.findAll", query = "SELECT p FROM Producto p"),
    @NamedQuery(name = "Producto.findByPkProducto", query = "SELECT p FROM Producto p WHERE p.pkProducto = :pkProducto"),
    @NamedQuery(name = "Producto.findByCodigo", query = "SELECT p FROM Producto p WHERE p.codigo = :codigo"),
    @NamedQuery(name = "Producto.findByNombre", query = "SELECT p FROM Producto p WHERE p.nombre = :nombre")})
public class Producto implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "PK_PRODUCTO", nullable = false, precision = 0, scale = -127)
    private BigDecimal pkProducto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "CODIGO", nullable = false, length = 256)
    private String codigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "NOMBRE", nullable = false, length = 200)
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkProducto")
    private List<Stock> stockList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkProducto")
    private List<Imagen> imagenList;
    @JoinColumn(name = "FK_TIPOPRODUCTO", referencedColumnName = "PK_TIPO_PRODUCTO", nullable = false)
    @ManyToOne(optional = false)
    private TipoProducto fkTipoproducto;

    public Producto() {
    }

    public Producto(BigDecimal pkProducto) {
        this.pkProducto = pkProducto;
    }

    public Producto(BigDecimal pkProducto, String codigo, String nombre) {
        this.pkProducto = pkProducto;
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public BigDecimal getPkProducto() {
        return pkProducto;
    }

    public void setPkProducto(BigDecimal pkProducto) {
        this.pkProducto = pkProducto;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public List<Stock> getStockList() {
        return stockList;
    }

    public void setStockList(List<Stock> stockList) {
        this.stockList = stockList;
    }

    @XmlTransient
    public List<Imagen> getImagenList() {
        return imagenList;
    }

    public void setImagenList(List<Imagen> imagenList) {
        this.imagenList = imagenList;
    }

    public TipoProducto getFkTipoproducto() {
        return fkTipoproducto;
    }

    public void setFkTipoproducto(TipoProducto fkTipoproducto) {
        this.fkTipoproducto = fkTipoproducto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkProducto != null ? pkProducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Producto)) {
            return false;
        }
        Producto other = (Producto) object;
        if ((this.pkProducto == null && other.pkProducto != null) || (this.pkProducto != null && !this.pkProducto.equals(other.pkProducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "prueba.jpa.entidades.Producto[ pkProducto=" + pkProducto + " ]";
    }
    
}
