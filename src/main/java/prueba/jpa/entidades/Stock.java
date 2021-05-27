/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba.jpa.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author AdminAlexisAlvarado
 */
@Entity
@Table(name = "STOCK", catalog = "", schema = "ALEX")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Stock.findAll", query = "SELECT s FROM Stock s"),
    @NamedQuery(name = "Stock.findByPkStock", query = "SELECT s FROM Stock s WHERE s.pkStock = :pkStock"),
    @NamedQuery(name = "Stock.findByCantidad", query = "SELECT s FROM Stock s WHERE s.cantidad = :cantidad"),
    @NamedQuery(name = "Stock.findByPrecioUnitario", query = "SELECT s FROM Stock s WHERE s.precioUnitario = :precioUnitario"),
    @NamedQuery(name = "Stock.findByCodigo", query = "SELECT s FROM Stock s WHERE s.codigo = :codigo"),
    @NamedQuery(name = "Stock.findByFecha", query = "SELECT s FROM Stock s WHERE s.fecha = :fecha")})
public class Stock implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "PK_STOCK", nullable = false, precision = 0, scale = -127)
    private BigDecimal pkStock;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CANTIDAD", nullable = false)
    private BigInteger cantidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRECIO_UNITARIO", nullable = false)
    private double precioUnitario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "CODIGO", nullable = false, length = 50)
    private String codigo;
    @Column(name = "FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @JoinColumn(name = "FK_PRODUCTO", referencedColumnName = "PK_PRODUCTO", nullable = false)
    @ManyToOne(optional = false)
    private Producto fkProducto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkStock")
    private List<DetalleVenta> detalleVentaList;

    public Stock() {
    }

    public Stock(BigDecimal pkStock) {
        this.pkStock = pkStock;
    }

    public Stock(BigDecimal pkStock, BigInteger cantidad, double precioUnitario, String codigo) {
        this.pkStock = pkStock;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.codigo = codigo;
    }

    public BigDecimal getPkStock() {
        return pkStock;
    }

    public void setPkStock(BigDecimal pkStock) {
        this.pkStock = pkStock;
    }

    public BigInteger getCantidad() {
        return cantidad;
    }

    public void setCantidad(BigInteger cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Producto getFkProducto() {
        return fkProducto;
    }

    public void setFkProducto(Producto fkProducto) {
        this.fkProducto = fkProducto;
    }

    @XmlTransient
    public List<DetalleVenta> getDetalleVentaList() {
        return detalleVentaList;
    }

    public void setDetalleVentaList(List<DetalleVenta> detalleVentaList) {
        this.detalleVentaList = detalleVentaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkStock != null ? pkStock.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Stock)) {
            return false;
        }
        Stock other = (Stock) object;
        if ((this.pkStock == null && other.pkStock != null) || (this.pkStock != null && !this.pkStock.equals(other.pkStock))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "prueba.jpa.entidades.Stock[ pkStock=" + pkStock + " ]";
    }
    
}
