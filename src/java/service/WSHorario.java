/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dto.entidad.Horario;
import dto.facede.HorarioFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *
 * @author Patricio
 */
@WebService(serviceName = "WSHorario")
public class WSHorario {

    @EJB
    private HorarioFacade ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Web Service Operation")

    @WebMethod(operationName = "create")
    public boolean create(@WebParam(name = "entity") Horario entity) {
        return ejbRef.create(entity);
    }

    @WebMethod(operationName = "edit")
    public boolean edit(@WebParam(name = "entity") Horario entity) {
        return ejbRef.edit(entity);
    }

    @WebMethod(operationName = "remove")
    public boolean remove(@WebParam(name = "entity") Horario entity) {
        return ejbRef.remove(entity);
    }

    @WebMethod(operationName = "find")
    public Horario find(@WebParam(name = "id") Object id) {
        return ejbRef.find(id);
    }

    @WebMethod(operationName = "findAll")
    public List<Horario> findAll() {
        return ejbRef.findAll();
    }

    @WebMethod(operationName = "findRange")
    public List<Horario> findRange(@WebParam(name = "range") int[] range) {
        return ejbRef.findRange(range);
    }

    @WebMethod(operationName = "count")
    public int count() {
        return ejbRef.count();
    }

    @WebMethod(operationName = "buscar")
    public Horario buscar(@WebParam(name = "id") int id) {
        return ejbRef.buscar(id);
    }
    
}
