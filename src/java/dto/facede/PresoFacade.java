/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto.facede;

import dto.entidad.Preso;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Patricio
 */
@Stateless
public class PresoFacade extends AbstractFacade<Preso> {

    @PersistenceContext(unitName = "WebServicePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PresoFacade() {
        super(Preso.class);
    }
    
    public Preso buscar(int id){
        Query q = em.createNamedQuery("Preso.findByIdPreso");
        q.setParameter("idPreso", id);
        return (Preso) q.getSingleResult();
    }
    
    
    public List<Preso>listartodo(){
        Query q = em.createNamedQuery("Preso.findAll");
        return q.getResultList();
    }
}
