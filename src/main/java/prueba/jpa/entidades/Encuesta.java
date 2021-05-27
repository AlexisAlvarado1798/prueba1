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
@Table(name = "ENCUESTA", catalog = "", schema = "ALEX")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Encuesta.findAll", query = "SELECT e FROM Encuesta e"),
    @NamedQuery(name = "Encuesta.findByPkEncuesta", query = "SELECT e FROM Encuesta e WHERE e.pkEncuesta = :pkEncuesta"),
    @NamedQuery(name = "Encuesta.findByCodigoencuesta", query = "SELECT e FROM Encuesta e WHERE e.codigoencuesta = :codigoencuesta"),
    @NamedQuery(name = "Encuesta.findByFechaInicio", query = "SELECT e FROM Encuesta e WHERE e.fechaInicio = :fechaInicio"),
    @NamedQuery(name = "Encuesta.findByFechaFin", query = "SELECT e FROM Encuesta e WHERE e.fechaFin = :fechaFin"),
    @NamedQuery(name = "Encuesta.findByDescripcion", query = "SELECT e FROM Encuesta e WHERE e.descripcion = :descripcion")})
public class Encuesta implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "PK_ENCUESTA", nullable = false, precision = 0, scale = -127)
    private BigDecimal pkEncuesta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODIGOENCUESTA", nullable = false)
    private BigInteger codigoencuesta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_INICIO", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaInicio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_FIN", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFin;
    @Size(max = 256)
    @Column(name = "DESCRIPCION", length = 256)
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkEncuesta")
    private List<Pregunta> preguntaList;

    public Encuesta() {
    }

    public Encuesta(BigDecimal pkEncuesta) {
        this.pkEncuesta = pkEncuesta;
    }

    public Encuesta(BigDecimal pkEncuesta, BigInteger codigoencuesta, Date fechaInicio, Date fechaFin) {
        this.pkEncuesta = pkEncuesta;
        this.codigoencuesta = codigoencuesta;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public BigDecimal getPkEncuesta() {
        return pkEncuesta;
    }

    public void setPkEncuesta(BigDecimal pkEncuesta) {
        this.pkEncuesta = pkEncuesta;
    }

    public BigInteger getCodigoencuesta() {
        return codigoencuesta;
    }

    public void setCodigoencuesta(BigInteger codigoencuesta) {
        this.codigoencuesta = codigoencuesta;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public List<Pregunta> getPreguntaList() {
        return preguntaList;
    }

    public void setPreguntaList(List<Pregunta> preguntaList) {
        this.preguntaList = preguntaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkEncuesta != null ? pkEncuesta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Encuesta)) {
            return false;
        }
        Encuesta other = (Encuesta) object;
        if ((this.pkEncuesta == null && other.pkEncuesta != null) || (this.pkEncuesta != null && !this.pkEncuesta.equals(other.pkEncuesta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "prueba.jpa.entidades.Encuesta[ pkEncuesta=" + pkEncuesta + " ]";
    }
    
}
