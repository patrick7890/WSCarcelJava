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

    @WebMethod(operationName = "createHorario")
    public boolean createHorario(@WebParam(name = "entity") Horario entity) {
        return ejbRef.create(entity);
    }

    @WebMethod(operationName = "editHorario")
    public boolean editHorario(@WebParam(name = "entity") Horario entity) {
        return ejbRef.edit(entity);
    }

    @WebMethod(operationName = "removeHorario")
    public boolean removeHorario(@WebParam(name = "entity") Horario entity) {
        return ejbRef.remove(entity);
    }

    @WebMethod(operationName = "findHorario")
    public Horario findHorario(@WebParam(name = "id") Object id) {
        return ejbRef.find(id);
    }

    @WebMethod(operationName = "findAllHorario")
    public List<Horario> findAllHorario() {
        return ejbRef.findAll();
    }

    @WebMethod(operationName = "findRangeHorario")
    public List<Horario> findRangeHorario(@WebParam(name = "range") int[] range) {
        return ejbRef.findRange(range);
    }

    @WebMethod(operationName = "countHorario")
    public int countHorario() {
        return ejbRef.count();
    }

    @WebMethod(operationName = "buscarHorario")
    public Horario buscarHorario(@WebParam(name = "id") int id) {
        return ejbRef.buscar(id);
    }
    
}
