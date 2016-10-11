package com.agenda.modelo.vo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;



@Entity
@Table(name = "agenda_contacto")
@NamedQueries({
    @NamedQuery(name="Contacto.findAll",
                query="SELECT n FROM Contacto n"),
  /*  @NamedQuery(name="Country.findByName",
                query="SELECT n FROM Country n WHERE c.name = :name"),*/
})
public class Contacto implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long Id;
    private String nombre;
    private String telefono;

    public long getId() {
        return Id;
    }

    public void setId(long Id) {
        this.Id = Id;
    }

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

}