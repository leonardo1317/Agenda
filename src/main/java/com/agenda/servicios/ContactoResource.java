package com.agenda.servicios;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.agenda.modelo.dao.ContactoDao;
import com.agenda.modelo.vo.Contacto;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Path("contact")
public class ContactoResource {

	@Inject
	private ContactoDao contactoDao;

	@GET
	@Path("contacts")
	@Produces(MediaType.APPLICATION_JSON)
	public String buscarTodos() {
		Gson gson = new Gson();
		return gson.toJson(contactoDao.buscarTodos());
	}

	@GET
	@Path("contacts2")
	@Produces(MediaType.APPLICATION_JSON)
	public String buscarTodos2() {
		//json bonito
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		return gson.toJson(contactoDao.buscarTodos());

	}

	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public String buscarPorId(@PathParam("id") String id) {
		Gson gson = new Gson();
		return gson.toJson(contactoDao.buscarPorId(Integer.parseInt(id)));
	}

	@POST
	@Path("post")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void guardar(String json) {
		Gson gson = new Gson();
		System.out.println(json);
		Contacto contacto = gson.fromJson(json, Contacto.class);
		contactoDao.crear(contacto);
	}

	@PUT
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String actualizar() {
		return "respuesta";
	}

	@DELETE
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public String eliminar(@PathParam("id") String id) {
		contactoDao.borrarContacto(Long.parseLong(id));
		return null;

	}

}
