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
@Table(name = "VENDEDOR", catalog = "", schema = "ALEX")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vendedor.findAll", query = "SELECT v FROM Vendedor v"),
    @NamedQuery(name = "Vendedor.findByPkVendedor", query = "SELECT v FROM Vendedor v WHERE v.pkVendedor = :pkVendedor")})
public class Vendedor implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "PK_VENDEDOR", nullable = false, precision = 0, scale = -127)
    private BigDecimal pkVendedor;
    @JoinColumn(name = "FK_PERSONA", referencedColumnName = "PK_PERSONA", nullable = false)
    @ManyToOne(optional = false)
    private Persona fkPersona;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkVendedor")
    private List<Venta> ventaList;

    public Vendedor() {
    }

    public Vendedor(BigDecimal pkVendedor) {
        this.pkVendedor = pkVendedor;
    }

    public BigDecimal getPkVendedor() {
        return pkVendedor;
    }

    public void setPkVendedor(BigDecimal pkVendedor) {
        this.pkVendedor = pkVendedor;
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
        hash += (pkVendedor != null ? pkVendedor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vendedor)) {
            return false;
        }
        Vendedor other = (Vendedor) object;
        if ((this.pkVendedor == null && other.pkVendedor != null) || (this.pkVendedor != null && !this.pkVendedor.equals(other.pkVendedor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "prueba.jpa.entidades.Vendedor[ pkVendedor=" + pkVendedor + " ]";
    }
    
}
