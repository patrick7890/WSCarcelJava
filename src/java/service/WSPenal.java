/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dto.entidad.Penal;
import dto.facede.PenalFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *
 * @author Patricio
 */
@WebService(serviceName = "WSPenal")
public class WSPenal {

    @EJB
    private PenalFacade ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Web Service Operation")

    @WebMethod(operationName = "createPenal")
    public boolean createPenal(@WebParam(name = "entity") Penal entity) {
        return ejbRef.create(entity);
    }

    @WebMethod(operationName = "editPenal")
    public boolean editPenal(@WebParam(name = "entity") Penal entity) {
        return ejbRef.edit(entity);
    }

    @WebMethod(operationName = "removePenal")
    public boolean removePenal(@WebParam(name = "entity") Penal entity) {
        return ejbRef.remove(entity);
    }

    @WebMethod(operationName = "findPenal")
    public Penal findPenal(@WebParam(name = "id") Object id) {
        return ejbRef.find(id);
    }

    @WebMethod(operationName = "findAllPenal")
    public List<Penal> findAllPenal() {
        return ejbRef.findAll();
    }

    @WebMethod(operationName = "findRangePenal")
    public List<Penal> findRangePenal(@WebParam(name = "range") int[] range) {
        return ejbRef.findRange(range);
    }

    @WebMethod(operationName = "countPenal")
    public int countPenal() {
        return ejbRef.count();
    }

    @WebMethod(operationName = "buscarPenal")
    public Penal buscarPenal(@WebParam(name = "id") int id) {
        return ejbRef.buscar(id);
    }
    
}
