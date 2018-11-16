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

    @WebMethod(operationName = "createPreso")
    public boolean createPreso(@WebParam(name = "entity") Preso entity) {
        return ejbRef.create(entity);
    }

    @WebMethod(operationName = "editPreso")
    public boolean editPreso(@WebParam(name = "entity") Preso entity) {
        return ejbRef.edit(entity);
    }

    @WebMethod(operationName = "removePreso")
    public boolean removePreso(@WebParam(name = "entity") Preso entity) {
        return ejbRef.remove(entity);
    }

    @WebMethod(operationName = "findPreso")
    public Preso findPreso(@WebParam(name = "id") Object id) {
        return ejbRef.find(id);
    }

    @WebMethod(operationName = "findAllPreso")
    public List<Preso> findAllPreso() {
        return ejbRef.findAll();
    }

    @WebMethod(operationName = "findRangePreso")
    public List<Preso> findRangePreso(@WebParam(name = "range") int[] range) {
        return ejbRef.findRange(range);
    }

    @WebMethod(operationName = "countPreso")
    public int countPreso() {
        return ejbRef.count();
    }

    @WebMethod(operationName = "buscarPreso")
    public Preso buscarPreso(@WebParam(name = "id") int id) {
        return ejbRef.buscar(id);
    }

    @WebMethod(operationName = "AgregarPreso")
    public boolean AgregarPreso(@WebParam(name = "id") String id, @WebParam(name = "nombre") String nombre, @WebParam(name = "sexo") char sexo, @WebParam(name = "visita") char visita, @WebParam(name = "penal") int penal) {
        Preso p = new Preso(Short.parseShort(id), nombre, sexo, visita);
        p.setPenalIdPenal(penalfacade.buscar(penal));
        return ejbRef.create(p);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "listarTodo")
    public List<Preso> listarTodo() {
        return ejbRef.listartodo();
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "actualizarpreso")
    public boolean actualizarpreso(@WebParam(name = "id") short id, @WebParam(name = "nombre") String nombre, @WebParam(name = "sexo") char sexo, @WebParam(name = "visita") char visita, @WebParam(name = "penal") int penal) {
        Preso p = new Preso(id, nombre, sexo, visita);
         p.setPenalIdPenal(penalfacade.buscar(penal));
        return ejbRef.edit(p);
    }
}
