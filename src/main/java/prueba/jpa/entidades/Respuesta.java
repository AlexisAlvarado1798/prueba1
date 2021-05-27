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
@Table(name = "RESPUESTA", catalog = "", schema = "ALEX")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Respuesta.findAll", query = "SELECT r FROM Respuesta r"),
    @NamedQuery(name = "Respuesta.findByPkRespuesta", query = "SELECT r FROM Respuesta r WHERE r.pkRespuesta = :pkRespuesta"),
    @NamedQuery(name = "Respuesta.findByRespuesta", query = "SELECT r FROM Respuesta r WHERE r.respuesta = :respuesta")})
public class Respuesta implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "PK_RESPUESTA", nullable = false, precision = 0, scale = -127)
    private BigDecimal pkRespuesta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "RESPUESTA", nullable = false, length = 200)
    private String respuesta;
    @JoinColumn(name = "FK_CLIENTEENCUESTA", referencedColumnName = "PK_CLIENTEENCUESTA")
    @ManyToOne
    private Clienteencuesta fkClienteencuesta;
    @JoinColumn(name = "FK_PREGUNTA", referencedColumnName = "PK_PREGUNTA", nullable = false)
    @ManyToOne(optional = false)
    private Pregunta fkPregunta;

    public Respuesta() {
    }

    public Respuesta(BigDecimal pkRespuesta) {
        this.pkRespuesta = pkRespuesta;
    }

    public Respuesta(BigDecimal pkRespuesta, String respuesta) {
        this.pkRespuesta = pkRespuesta;
        this.respuesta = respuesta;
    }

    public BigDecimal getPkRespuesta() {
        return pkRespuesta;
    }

    public void setPkRespuesta(BigDecimal pkRespuesta) {
        this.pkRespuesta = pkRespuesta;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public Clienteencuesta getFkClienteencuesta() {
        return fkClienteencuesta;
    }

    public void setFkClienteencuesta(Clienteencuesta fkClienteencuesta) {
        this.fkClienteencuesta = fkClienteencuesta;
    }

    public Pregunta getFkPregunta() {
        return fkPregunta;
    }

    public void setFkPregunta(Pregunta fkPregunta) {
        this.fkPregunta = fkPregunta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkRespuesta != null ? pkRespuesta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Respuesta)) {
            return false;
        }
        Respuesta other = (Respuesta) object;
        if ((this.pkRespuesta == null && other.pkRespuesta != null) || (this.pkRespuesta != null && !this.pkRespuesta.equals(other.pkRespuesta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "prueba.jpa.entidades.Respuesta[ pkRespuesta=" + pkRespuesta + " ]";
    }
    
}
