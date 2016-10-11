
package com.agenda.modelo.dao;

import com.agenda.modelo.vo.Contacto;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Stateless
public class ContactoDao {

	@PersistenceContext(unitName = "agenda")
	private EntityManager em;

	// inserta un objeto en la base de datos
	public void crear(Contacto contacto) {
		em.persist(contacto);
	}

	// recupera un objeto de la base de datos por su clave primaria
	public Contacto buscarPorId(long id) {
		Contacto contacto = em.find(Contacto.class, id);
		return contacto;
	}

	// busca todos los objetos de la base de datos
	public List<Contacto> buscarTodos() {
		TypedQuery<Contacto> query = em.createNamedQuery("Contacto.findAll", Contacto.class);
		List<Contacto> results = query.getResultList();
		return results;
	}

	// actualiza objeto en la base de datos
	public void actualizar(Contacto contacto) {
		em.merge(contacto);
	}

	// elimina objeto de la base de datos
	public void borrarContacto(long id) {
		Contacto contacto = em.find(Contacto.class, id);
		if(contacto !=null){
		em.remove(contacto);
		}
	}

}
