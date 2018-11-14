/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto.entidad;

import java.io.Serializable;
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
 * @author Patricio
 */
@Entity
@Table(name = "PRESO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Preso.findAll", query = "SELECT p FROM Preso p")
    , @NamedQuery(name = "Preso.findByIdPreso", query = "SELECT p FROM Preso p WHERE p.idPreso = :idPreso")
    , @NamedQuery(name = "Preso.findByNombreV", query = "SELECT p FROM Preso p WHERE p.nombreV = :nombreV")
    , @NamedQuery(name = "Preso.findBySexoV", query = "SELECT p FROM Preso p WHERE p.sexoV = :sexoV")
    , @NamedQuery(name = "Preso.findByVisitaV", query = "SELECT p FROM Preso p WHERE p.visitaV = :visitaV")})
public class Preso implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_PRESO")
    private Short idPreso;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "NOMBRE_V")
    private String nombreV;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SEXO_V")
    private Character sexoV;
    @Basic(optional = false)
    @NotNull
    @Column(name = "VISITA_V")
    private Character visitaV;
    @JoinColumn(name = "PENAL_ID_PENAL", referencedColumnName = "ID_PENAL")
    @ManyToOne(optional = false)
    private Penal penalIdPenal;

    public Preso() {
    }

    public Preso(Short idPreso) {
        this.idPreso = idPreso;
    }

    public Preso(Short idPreso, String nombreV, Character sexoV, Character visitaV) {
        this.idPreso = idPreso;
        this.nombreV = nombreV;
        this.sexoV = sexoV;
        this.visitaV = visitaV;
    }

    public Short getIdPreso() {
        return idPreso;
    }

    public void setIdPreso(Short idPreso) {
        this.idPreso = idPreso;
    }

    public String getNombreV() {
        return nombreV;
    }

    public void setNombreV(String nombreV) {
        this.nombreV = nombreV;
    }

    public Character getSexoV() {
        return sexoV;
    }

    public void setSexoV(Character sexoV) {
        this.sexoV = sexoV;
    }

    public Character getVisitaV() {
        return visitaV;
    }

    public void setVisitaV(Character visitaV) {
        this.visitaV = visitaV;
    }

    public Penal getPenalIdPenal() {
        return penalIdPenal;
    }

    public void setPenalIdPenal(Penal penalIdPenal) {
        this.penalIdPenal = penalIdPenal;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPreso != null ? idPreso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Preso)) {
            return false;
        }
        Preso other = (Preso) object;
        if ((this.idPreso == null && other.idPreso != null) || (this.idPreso != null && !this.idPreso.equals(other.idPreso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dto.entidad.Preso[ idPreso=" + idPreso + " ]";
    }
    
}
