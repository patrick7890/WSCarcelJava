/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dto.entidad.Preso;
import dto.facede.PenalFacade;
import dto.facede.PresoFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *
 * @author Patricio
 */
@WebService(serviceName = "WSPreso")
public class WSPreso {

    @EJB
    private PenalFacade penalfacade;
    @EJB
    private PresoFacade ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Web Service Operation")

    @WebMethod(operationName = "create")
    public boolean create(@WebParam(name = "entity") Preso entity) {
        return ejbRef.create(entity);
    }

    @WebMethod(operationName = "edit")
    public boolean edit(@WebParam(name = "entity") Preso entity) {
        return ejbRef.edit(entity);
    }

    @WebMethod(operationName = "remove")
    public boolean remove(@WebParam(name = "entity") Preso entity) {
        return ejbRef.remove(entity);
    }

    @WebMethod(operationName = "find")
    public Preso find(@WebParam(name = "id") Object id) {
        return ejbRef.find(id);
    }

    @WebMethod(operationName = "findAll")
    public List<Preso> findAll() {
        return ejbRef.findAll();
    }

    @WebMethod(operationName = "findRange")
    public List<Preso> findRange(@WebParam(name = "range") int[] range) {
        return ejbRef.findRange(range);
    }

    @WebMethod(operationName = "count")
    public int count() {
        return ejbRef.count();
    }

    @WebMethod(operationName = "buscar")
    public Preso buscar(@WebParam(name = "id") int id) {
        return ejbRef.buscar(id);
    }

    @WebMethod(operationName = "Agregar")
    public boolean Agregar(@WebParam(name = "id") String id, @WebParam(name = "nombre") String nombre, @WebParam(name = "sexo") char sexo, @WebParam(name = "visita") char visita, @WebParam(name = "penal") int penal) {
        Preso p = new Preso(Short.parseShort(id), nombre, sexo, visita);
        p.setPenalIdPenal(penalfacade.buscar(penal));
        return ejbRef.create(p);
    }
}
