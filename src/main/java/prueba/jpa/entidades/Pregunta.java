/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba.jpa.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
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
@Table(name = "PREGUNTA", catalog = "", schema = "ALEX", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"CODIGO"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pregunta.findAll", query = "SELECT p FROM Pregunta p"),
    @NamedQuery(name = "Pregunta.findByPkPregunta", query = "SELECT p FROM Pregunta p WHERE p.pkPregunta = :pkPregunta"),
    @NamedQuery(name = "Pregunta.findByCodigo", query = "SELECT p FROM Pregunta p WHERE p.codigo = :codigo"),
    @NamedQuery(name = "Pregunta.findByPregunta", query = "SELECT p FROM Pregunta p WHERE p.pregunta = :pregunta")})
public class Pregunta implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "PK_PREGUNTA", nullable = false, precision = 0, scale = -127)
    private BigDecimal pkPregunta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODIGO", nullable = false)
    private BigInteger codigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "PREGUNTA", nullable = false, length = 256)
    private String pregunta;
    @JoinColumn(name = "FK_ENCUESTA", referencedColumnName = "PK_ENCUESTA", nullable = false)
    @ManyToOne(optional = false)
    private Encuesta fkEncuesta;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkPregunta")
    private List<Respuesta> respuestaList;

    public Pregunta() {
    }

    public Pregunta(BigDecimal pkPregunta) {
        this.pkPregunta = pkPregunta;
    }

    public Pregunta(BigDecimal pkPregunta, BigInteger codigo, String pregunta) {
        this.pkPregunta = pkPregunta;
        this.codigo = codigo;
        this.pregunta = pregunta;
    }

    public BigDecimal getPkPregunta() {
        return pkPregunta;
    }

    public void setPkPregunta(BigDecimal pkPregunta) {
        this.pkPregunta = pkPregunta;
    }

    public BigInteger getCodigo() {
        return codigo;
    }

    public void setCodigo(BigInteger codigo) {
        this.codigo = codigo;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public Encuesta getFkEncuesta() {
        return fkEncuesta;
    }

    public void setFkEncuesta(Encuesta fkEncuesta) {
        this.fkEncuesta = fkEncuesta;
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
        hash += (pkPregunta != null ? pkPregunta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pregunta)) {
            return false;
        }
        Pregunta other = (Pregunta) object;
        if ((this.pkPregunta == null && other.pkPregunta != null) || (this.pkPregunta != null && !this.pkPregunta.equals(other.pkPregunta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "prueba.jpa.entidades.Pregunta[ pkPregunta=" + pkPregunta + " ]";
    }
    
}
