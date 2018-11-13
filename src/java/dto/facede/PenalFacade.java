/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto.facede;

import dto.entidad.Penal;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Patricio
 */
@Stateless
public class PenalFacade extends AbstractFacade<Penal> {

    @PersistenceContext(unitName = "WebServicePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PenalFacade() {
        super(Penal.class);
    }

    public Penal buscar(int id) {
        Query q = em.createNamedQuery("Penal.findByIdPenal");
        q.setParameter("idPenal", id);
        return (Penal) q.getSingleResult();

    }

}
