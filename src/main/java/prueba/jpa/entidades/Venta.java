/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba.jpa.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "VENTA", catalog = "", schema = "ALEX", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"CODIGO"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Venta.findAll", query = "SELECT v FROM Venta v"),
    @NamedQuery(name = "Venta.findByPkVenta", query = "SELECT v FROM Venta v WHERE v.pkVenta = :pkVenta"),
    @NamedQuery(name = "Venta.findByFecha", query = "SELECT v FROM Venta v WHERE v.fecha = :fecha"),
    @NamedQuery(name = "Venta.findByPreciototal", query = "SELECT v FROM Venta v WHERE v.preciototal = :preciototal"),
    @NamedQuery(name = "Venta.findByCodigo", query = "SELECT v FROM Venta v WHERE v.codigo = :codigo")})
public class Venta implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "PK_VENTA", nullable = false, precision = 0, scale = -127)
    private BigDecimal pkVenta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRECIOTOTAL", nullable = false)
    private double preciototal;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "CODIGO", nullable = false, length = 50)
    private String codigo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkVenta")
    private List<DetalleVenta> detalleVentaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkVenta")
    private List<Clienteencuesta> clienteencuestaList;
    @JoinColumn(name = "FK_CLIENTE", referencedColumnName = "PK_CLIENTE", nullable = false)
    @ManyToOne(optional = false)
    private Cliente fkCliente;
    @JoinColumn(name = "FK_VENDEDOR", referencedColumnName = "PK_VENDEDOR", nullable = false)
    @ManyToOne(optional = false)
    private Vendedor fkVendedor;

    public Venta() {
    }

    public Venta(BigDecimal pkVenta) {
        this.pkVenta = pkVenta;
    }

    public Venta(BigDecimal pkVenta, Date fecha, double preciototal, String codigo) {
        this.pkVenta = pkVenta;
        this.fecha = fecha;
        this.preciototal = preciototal;
        this.codigo = codigo;
    }

    public BigDecimal getPkVenta() {
        return pkVenta;
    }

    public void setPkVenta(BigDecimal pkVenta) {
        this.pkVenta = pkVenta;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getPreciototal() {
        return preciototal;
    }

    public void setPreciototal(double preciototal) {
        this.preciototal = preciototal;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @XmlTransient
    public List<DetalleVenta> getDetalleVentaList() {
        return detalleVentaList;
    }

    public void setDetalleVentaList(List<DetalleVenta> detalleVentaList) {
        this.detalleVentaList = detalleVentaList;
    }

    @XmlTransient
    public List<Clienteencuesta> getClienteencuestaList() {
        return clienteencuestaList;
    }

    public void setClienteencuestaList(List<Clienteencuesta> clienteencuestaList) {
        this.clienteencuestaList = clienteencuestaList;
    }

    public Cliente getFkCliente() {
        return fkCliente;
    }

    public void setFkCliente(Cliente fkCliente) {
        this.fkCliente = fkCliente;
    }

    public Vendedor getFkVendedor() {
        return fkVendedor;
    }

    public void setFkVendedor(Vendedor fkVendedor) {
        this.fkVendedor = fkVendedor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkVenta != null ? pkVenta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Venta)) {
            return false;
        }
        Venta other = (Venta) object;
        if ((this.pkVenta == null && other.pkVenta != null) || (this.pkVenta != null && !this.pkVenta.equals(other.pkVenta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "prueba.jpa.entidades.Venta[ pkVenta=" + pkVenta + " ]";
    }
    
}
