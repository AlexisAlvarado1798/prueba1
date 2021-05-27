/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba.jpa.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author AdminAlexisAlvarado
 */
@Entity
@Table(name = "DETALLE_VENTA", catalog = "", schema = "ALEX")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetalleVenta.findAll", query = "SELECT d FROM DetalleVenta d"),
    @NamedQuery(name = "DetalleVenta.findByPkDetalleVenta", query = "SELECT d FROM DetalleVenta d WHERE d.pkDetalleVenta = :pkDetalleVenta"),
    @NamedQuery(name = "DetalleVenta.findByCantidad", query = "SELECT d FROM DetalleVenta d WHERE d.cantidad = :cantidad"),
    @NamedQuery(name = "DetalleVenta.findBySubtotal", query = "SELECT d FROM DetalleVenta d WHERE d.subtotal = :subtotal")})
public class DetalleVenta implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "PK_DETALLE_VENTA", nullable = false, precision = 0, scale = -127)
    private BigDecimal pkDetalleVenta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CANTIDAD", nullable = false)
    private BigInteger cantidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SUBTOTAL", nullable = false)
    private double subtotal;
    @JoinColumn(name = "FK_STOCK", referencedColumnName = "PK_STOCK", nullable = false)
    @ManyToOne(optional = false)
    private Stock fkStock;
    @JoinColumn(name = "FK_VENTA", referencedColumnName = "PK_VENTA", nullable = false)
    @ManyToOne(optional = false)
    private Venta fkVenta;

    public DetalleVenta() {
    }

    public DetalleVenta(BigDecimal pkDetalleVenta) {
        this.pkDetalleVenta = pkDetalleVenta;
    }

    public DetalleVenta(BigDecimal pkDetalleVenta, BigInteger cantidad, double subtotal) {
        this.pkDetalleVenta = pkDetalleVenta;
        this.cantidad = cantidad;
        this.subtotal = subtotal;
    }

    public BigDecimal getPkDetalleVenta() {
        return pkDetalleVenta;
    }

    public void setPkDetalleVenta(BigDecimal pkDetalleVenta) {
        this.pkDetalleVenta = pkDetalleVenta;
    }

    public BigInteger getCantidad() {
        return cantidad;
    }

    public void setCantidad(BigInteger cantidad) {
        this.cantidad = cantidad;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public Stock getFkStock() {
        return fkStock;
    }

    public void setFkStock(Stock fkStock) {
        this.fkStock = fkStock;
    }

    public Venta getFkVenta() {
        return fkVenta;
    }

    public void setFkVenta(Venta fkVenta) {
        this.fkVenta = fkVenta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkDetalleVenta != null ? pkDetalleVenta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleVenta)) {
            return false;
        }
        DetalleVenta other = (DetalleVenta) object;
        if ((this.pkDetalleVenta == null && other.pkDetalleVenta != null) || (this.pkDetalleVenta != null && !this.pkDetalleVenta.equals(other.pkDetalleVenta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "prueba.jpa.entidades.DetalleVenta[ pkDetalleVenta=" + pkDetalleVenta + " ]";
    }
    
}
