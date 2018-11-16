/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto.facede;

import dto.entidad.Visita;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Patricio
 */
@Stateless
public class VisitaFacade extends AbstractFacade<Visita> {

    @PersistenceContext(unitName = "WebServicePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public VisitaFacade() {
        super(Visita.class);
    }

    public Visita buscar(String id) {
        Query q = em.createNamedQuery("Visita.findByIdVisita");
        q.setParameter("idVisita", id);
        return (Visita) q.getSingleResult();
    }
}
