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
@Table(name = "VISITA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Visita.findAll", query = "SELECT v FROM Visita v")
    , @NamedQuery(name = "Visita.findByIdVisita", query = "SELECT v FROM Visita v WHERE v.idVisita = :idVisita")
    , @NamedQuery(name = "Visita.findByObservacion", query = "SELECT v FROM Visita v WHERE v.observacion = :observacion")
    , @NamedQuery(name = "Visita.findByNombreV", query = "SELECT v FROM Visita v WHERE v.nombreV = :nombreV")
    , @NamedQuery(name = "Visita.findByEdad", query = "SELECT v FROM Visita v WHERE v.edad = :edad")
    , @NamedQuery(name = "Visita.findByTiempoVisita", query = "SELECT v FROM Visita v WHERE v.tiempoVisita = :tiempoVisita")})
public class Visita implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "ID_VISITA")
    private String idVisita;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "OBSERVACION")
    private String observacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "NOMBRE_V")
    private String nombreV;
    @Basic(optional = false)
    @NotNull
    @Column(name = "EDAD")
    private short edad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TIEMPO_VISITA")
    private short tiempoVisita;
    @JoinColumn(name = "HORARIO_ID_HORARIO", referencedColumnName = "ID_HORARIO")
    @ManyToOne(optional = false)
    private Horario horarioIdHorario;
    @JoinColumn(name = "PRESO_ID_PRESO", referencedColumnName = "ID_PRESO")
    @ManyToOne(optional = false)
    private Preso presoIdPreso;

    public Visita() {
    }

    public Visita(String idVisita) {
        this.idVisita = idVisita;
    }

    public Visita(String idVisita, String observacion, String nombreV, short edad, short tiempoVisita) {
        this.idVisita = idVisita;
        this.observacion = observacion;
        this.nombreV = nombreV;
        this.edad = edad;
        this.tiempoVisita = tiempoVisita;
    }

    public String getIdVisita() {
        return idVisita;
    }

    public void setIdVisita(String idVisita) {
        this.idVisita = idVisita;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getNombreV() {
        return nombreV;
    }

    public void setNombreV(String nombreV) {
        this.nombreV = nombreV;
    }

    public short getEdad() {
        return edad;
    }

    public void setEdad(short edad) {
        this.edad = edad;
    }

    public short getTiempoVisita() {
        return tiempoVisita;
    }

    public void setTiempoVisita(short tiempoVisita) {
        this.tiempoVisita = tiempoVisita;
    }

    public Horario getHorarioIdHorario() {
        return horarioIdHorario;
    }

    public void setHorarioIdHorario(Horario horarioIdHorario) {
        this.horarioIdHorario = horarioIdHorario;
    }

    public Preso getPresoIdPreso() {
        return presoIdPreso;
    }

    public void setPresoIdPreso(Preso presoIdPreso) {
        this.presoIdPreso = presoIdPreso;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idVisita != null ? idVisita.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Visita)) {
            return false;
        }
        Visita other = (Visita) object;
        if ((this.idVisita == null && other.idVisita != null) || (this.idVisita != null && !this.idVisita.equals(other.idVisita))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dto.entidad.Visita[ idVisita=" + idVisita + " ]";
    }
    
}
