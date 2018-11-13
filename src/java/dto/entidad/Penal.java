/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto.entidad;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Patricio
 */
@Entity
@Table(name = "PENAL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Penal.findAll", query = "SELECT p FROM Penal p")
    , @NamedQuery(name = "Penal.findByIdPenal", query = "SELECT p FROM Penal p WHERE p.idPenal = :idPenal")
    , @NamedQuery(name = "Penal.findByDescripcion", query = "SELECT p FROM Penal p WHERE p.descripcion = :descripcion")})
public class Penal implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_PENAL")
    private Short idPenal;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "penalIdPenal")
    private List<Preso> presoList;

    public Penal() {
    }

    public Penal(Short idPenal) {
        this.idPenal = idPenal;
    }

    public Penal(Short idPenal, String descripcion) {
        this.idPenal = idPenal;
        this.descripcion = descripcion;
    }

    public Short getIdPenal() {
        return idPenal;
    }

    public void setIdPenal(Short idPenal) {
        this.idPenal = idPenal;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public List<Preso> getPresoList() {
        return presoList;
    }

    public void setPresoList(List<Preso> presoList) {
        this.presoList = presoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPenal != null ? idPenal.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Penal)) {
            return false;
        }
        Penal other = (Penal) object;
        if ((this.idPenal == null && other.idPenal != null) || (this.idPenal != null && !this.idPenal.equals(other.idPenal))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dto.entidad.Penal[ idPenal=" + idPenal + " ]";
    }
    
}
