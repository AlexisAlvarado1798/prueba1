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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author AdminAlexisAlvarado
 */
@Entity
@Table(name = "CLIENTE", catalog = "", schema = "ALEX")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c"),
    @NamedQuery(name = "Cliente.findByPkCliente", query = "SELECT c FROM Cliente c WHERE c.pkCliente = :pkCliente")})
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "PK_CLIENTE", nullable = false, precision = 0, scale = -127)
    private BigDecimal pkCliente;
    @JoinColumn(name = "FK_PERSONA", referencedColumnName = "PK_PERSONA", nullable = false)
    @ManyToOne(optional = false)
    private Persona fkPersona;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkCliente")
    private List<Venta> ventaList;

    public Cliente() {
    }

    public Cliente(BigDecimal pkCliente) {
        this.pkCliente = pkCliente;
    }

    public BigDecimal getPkCliente() {
        return pkCliente;
    }

    public void setPkCliente(BigDecimal pkCliente) {
        this.pkCliente = pkCliente;
    }

    public Persona getFkPersona() {
        return fkPersona;
    }

    public void setFkPersona(Persona fkPersona) {
        this.fkPersona = fkPersona;
    }

    @XmlTransient
    public List<Venta> getVentaList() {
        return ventaList;
    }

    public void setVentaList(List<Venta> ventaList) {
        this.ventaList = ventaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkCliente != null ? pkCliente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.pkCliente == null && other.pkCliente != null) || (this.pkCliente != null && !this.pkCliente.equals(other.pkCliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "prueba.jpa.entidades.Cliente[ pkCliente=" + pkCliente + " ]";
    }
    
}
