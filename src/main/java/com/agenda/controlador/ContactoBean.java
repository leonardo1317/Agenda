package com.agenda.controlador;

import com.agenda.modelo.dao.ContactoDao;
import com.agenda.modelo.vo.Contacto;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

@Named
@RequestScoped
public class ContactoBean {

	public ContactoBean() {
	}

	@Inject
	private ContactoDao contactoDao;

	private String nombre;
	private String telefono;
	private String id;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void crear() {
		Contacto contacto;

		try {
			contacto = new Contacto();

			contacto.setNombre(nombre);
			contacto.setTelefono(telefono);
			contactoDao.crear(contacto);

		} catch (Exception e) {

		}
	}

	public void buscarId() {
		try {
			System.out.println(contactoDao.buscarPorId(Integer.parseInt(id)).getNombre());
		} catch (Exception e) {

		}
	}

	public void buscarTodos() {
		try {
			int i = 0;
			while (contactoDao.buscarTodos().size() > 0) {

				System.out.println(contactoDao.buscarTodos().get(i).getNombre());
				i++;
			}
		} catch (Exception e) {

		}
	}

}
