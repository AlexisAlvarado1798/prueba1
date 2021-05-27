/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba.ejb.fachadas;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import prueba.jpa.entidades.Estadousuario;

/**
 *
 * @author AdminAlexisAlvarado
 */
@Stateless
public class EstadousuarioFacade extends AbstractFacade<Estadousuario> {

    @PersistenceContext(unitName = "sena.ccys.proyectosalud_PRUEBA_war_1.0PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EstadousuarioFacade() {
        super(Estadousuario.class);
    }
    
}
