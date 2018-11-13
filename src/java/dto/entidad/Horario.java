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
@Table(name = "HORARIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Horario.findAll", query = "SELECT h FROM Horario h")
    , @NamedQuery(name = "Horario.findByIdHorario", query = "SELECT h FROM Horario h WHERE h.idHorario = :idHorario")
    , @NamedQuery(name = "Horario.findByDescripcionH", query = "SELECT h FROM Horario h WHERE h.descripcionH = :descripcionH")
    , @NamedQuery(name = "Horario.findByMinutos", query = "SELECT h FROM Horario h WHERE h.minutos = :minutos")})
public class Horario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_HORARIO")
    private Short idHorario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "DESCRIPCION_H")
    private String descripcionH;
    @Basic(optional = false)
    @NotNull
    @Column(name = "MINUTOS")
    private short minutos;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "horarioIdHorario")
    private List<Visita> visitaList;

    public Horario() {
    }

    public Horario(Short idHorario) {
        this.idHorario = idHorario;
    }

    public Horario(Short idHorario, String descripcionH, short minutos) {
        this.idHorario = idHorario;
        this.descripcionH = descripcionH;
        this.minutos = minutos;
    }

    public Short getIdHorario() {
        return idHorario;
    }

    public void setIdHorario(Short idHorario) {
        this.idHorario = idHorario;
    }

    public String getDescripcionH() {
        return descripcionH;
    }

    public void setDescripcionH(String descripcionH) {
        this.descripcionH = descripcionH;
    }

    public short getMinutos() {
        return minutos;
    }

    public void setMinutos(short minutos) {
        this.minutos = minutos;
    }

    @XmlTransient
    public List<Visita> getVisitaList() {
        return visitaList;
    }

    public void setVisitaList(List<Visita> visitaList) {
        this.visitaList = visitaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idHorario != null ? idHorario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Horario)) {
            return false;
        }
        Horario other = (Horario) object;
        if ((this.idHorario == null && other.idHorario != null) || (this.idHorario != null && !this.idHorario.equals(other.idHorario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dto.entidad.Horario[ idHorario=" + idHorario + " ]";
    }
    
}
