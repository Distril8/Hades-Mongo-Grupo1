/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.hades.service;

import ec.edu.espe.distribuidas.hades.dao.UsuarioDAO;
import ec.edu.espe.distribuidas.hades.model.Usuario;
import ec.edu.espe.distribuidas.nosql.mongo.MongoPersistence;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 *
 * @author Hendrix
 */
@LocalBean
@Stateless
public class AutenticacionService {
    
    @EJB
    private MongoPersistence mp;
    private UsuarioDAO usuarioFacade;
    
     @PostConstruct
    public void init() {
        this.usuarioFacade = new UsuarioDAO(Usuario.class, mp.context());
    }
    
    public Usuario login(String codUsuario, String clave) {
        Usuario usuario = this.usuarioFacade.findOne("codUsuario",codUsuario);
        if (usuario!=null && usuario.getClave().equals(clave)) {
            return usuario;
        } else {
            return null;
        }
    }
    
}
