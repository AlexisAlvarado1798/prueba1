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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author AdminAlexisAlvarado
 */
@Entity
@Table(name = "CLIENTEENCUESTA", catalog = "", schema = "ALEX")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Clienteencuesta.findAll", query = "SELECT c FROM Clienteencuesta c"),
    @NamedQuery(name = "Clienteencuesta.findByPkClienteencuesta", query = "SELECT c FROM Clienteencuesta c WHERE c.pkClienteencuesta = :pkClienteencuesta"),
    @NamedQuery(name = "Clienteencuesta.findByFecha", query = "SELECT c FROM Clienteencuesta c WHERE c.fecha = :fecha")})
public class Clienteencuesta implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "PK_CLIENTEENCUESTA", nullable = false, precision = 0, scale = -127)
    private BigDecimal pkClienteencuesta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @JoinColumn(name = "FK_VENTA", referencedColumnName = "PK_VENTA", nullable = false)
    @ManyToOne(optional = false)
    private Venta fkVenta;
    @OneToMany(mappedBy = "fkClienteencuesta")
    private List<Respuesta> respuestaList;

    public Clienteencuesta() {
    }

    public Clienteencuesta(BigDecimal pkClienteencuesta) {
        this.pkClienteencuesta = pkClienteencuesta;
    }

    public Clienteencuesta(BigDecimal pkClienteencuesta, Date fecha) {
        this.pkClienteencuesta = pkClienteencuesta;
        this.fecha = fecha;
    }

    public BigDecimal getPkClienteencuesta() {
        return pkClienteencuesta;
    }

    public void setPkClienteencuesta(BigDecimal pkClienteencuesta) {
        this.pkClienteencuesta = pkClienteencuesta;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Venta getFkVenta() {
        return fkVenta;
    }

    public void setFkVenta(Venta fkVenta) {
        this.fkVenta = fkVenta;
    }

    @XmlTransient
    public List<Respuesta> getRespuestaList() {
        return respuestaList;
    }

    public void setRespuestaList(List<Respuesta> respuestaList) {
        this.respuestaList = respuestaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkClienteencuesta != null ? pkClienteencuesta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Clienteencuesta)) {
            return false;
        }
        Clienteencuesta other = (Clienteencuesta) object;
        if ((this.pkClienteencuesta == null && other.pkClienteencuesta != null) || (this.pkClienteencuesta != null && !this.pkClienteencuesta.equals(other.pkClienteencuesta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "prueba.jpa.entidades.Clienteencuesta[ pkClienteencuesta=" + pkClienteencuesta + " ]";
    }
    
}
