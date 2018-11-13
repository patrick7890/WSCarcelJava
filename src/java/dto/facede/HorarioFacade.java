/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto.facede;

import dto.entidad.Horario;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Patricio
 */
@Stateless
public class HorarioFacade extends AbstractFacade<Horario> {

    @PersistenceContext(unitName = "WebServicePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public HorarioFacade() {
        super(Horario.class);
    }
    
    public Horario buscar(int id) {
        Query q = em.createNamedQuery("Horario.findByIdHorario");
        q.setParameter("idHorario", id);
        return (Horario) q.getSingleResult();
    }
    
}
