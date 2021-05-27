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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author AdminAlexisAlvarado
 */
@Entity
@Table(name = "TIPO_PRODUCTO", catalog = "", schema = "ALEX", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"CODIGO"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoProducto.findAll", query = "SELECT t FROM TipoProducto t"),
    @NamedQuery(name = "TipoProducto.findByPkTipoProducto", query = "SELECT t FROM TipoProducto t WHERE t.pkTipoProducto = :pkTipoProducto"),
    @NamedQuery(name = "TipoProducto.findByCodigo", query = "SELECT t FROM TipoProducto t WHERE t.codigo = :codigo"),
    @NamedQuery(name = "TipoProducto.findByNombre", query = "SELECT t FROM TipoProducto t WHERE t.nombre = :nombre")})
public class TipoProducto implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "PK_TIPO_PRODUCTO", nullable = false, precision = 0, scale = -127)
    private BigDecimal pkTipoProducto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "CODIGO", nullable = false, length = 256)
    private String codigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "NOMBRE", nullable = false, length = 256)
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkTipoproducto")
    private List<Producto> productoList;

    public TipoProducto() {
    }

    public TipoProducto(BigDecimal pkTipoProducto) {
        this.pkTipoProducto = pkTipoProducto;
    }

    public TipoProducto(BigDecimal pkTipoProducto, String codigo, String nombre) {
        this.pkTipoProducto = pkTipoProducto;
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public BigDecimal getPkTipoProducto() {
        return pkTipoProducto;
    }

    public void setPkTipoProducto(BigDecimal pkTipoProducto) {
        this.pkTipoProducto = pkTipoProducto;
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
    public List<Producto> getProductoList() {
        return productoList;
    }

    public void setProductoList(List<Producto> productoList) {
        this.productoList = productoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkTipoProducto != null ? pkTipoProducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoProducto)) {
            return false;
        }
        TipoProducto other = (TipoProducto) object;
        if ((this.pkTipoProducto == null && other.pkTipoProducto != null) || (this.pkTipoProducto != null && !this.pkTipoProducto.equals(other.pkTipoProducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "prueba.jpa.entidades.TipoProducto[ pkTipoProducto=" + pkTipoProducto + " ]";
    }
    
}
