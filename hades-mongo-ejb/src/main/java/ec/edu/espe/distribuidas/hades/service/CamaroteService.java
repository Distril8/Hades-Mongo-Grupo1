/*
 * Hades Cruise
 * Aplicaciones Distribuidas
 * NRC: 2434 
 * Tutor: HENRY RAMIRO CORAL CORAL 
 * 2017 (c) Hades Cruise Corp.
 */
package ec.edu.espe.distribuidas.hades.service;

import ec.edu.espe.distribuidas.hades.dao.CamaroteDAO;
import ec.edu.espe.distribuidas.hades.model.Camarote;
import ec.edu.espe.distribuidas.nosql.mongo.MongoPersistence;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author Hades Cruise Corp.
 */
@Stateless
@LocalBean
public class CamaroteService {

    @EJB
    private MongoPersistence mp;
    private CamaroteDAO camaroteFacade;

    @PostConstruct
    public void init() {
        this.camaroteFacade = new CamaroteDAO(Camarote.class, mp.context());
    }

//    public List<Camarote> buscarPorTipo(Integer codCruceroBusqueda, String codTipoCamaroteBusqueda) {
//        //return this.camaroteFacade.findfindByCruceroTipo(codCruceroBusqueda, codTipoCamaroteBusqueda);
//    }
//
//    public List<Camarote> obtenerPorCrucero(Integer codCrucero) {
//       // return this.camaroteFacade.findByCrucero(codCrucero);
//    }

//    public Camarote obtenerInfoCamarote(Integer codCrucero, Integer numCamarote) {
//        return this.camaroteFacade.findCodTipCamarote(codCrucero, numCamarote);
//    }

}
