package pe.edu.upc.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;


@Entity
@Table(name = "administradores")
public class Administrador implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idAdministrador;
	
	@NotEmpty(message = "Ingresa el sueldo")
	@Column(name = "ingresosAdmin", nullable = false, length = 70)
	private long ingresosAdmin;
	
	@OneToOne
	@JoinColumn(name ="idUser")
	private Users users;

	private Administrador() {
		super();
		// TODO Auto-generated constructor stub
	}

	private Administrador(int idAdministrador, long ingresosAdmin, Users users) {
		super();
		this.idAdministrador = idAdministrador;
		this.ingresosAdmin = ingresosAdmin;
		this.users = users;
	}

	public int getIdAdministrador() {
		return idAdministrador;
	}

	public void setIdAdministrador(int idAdministrador) {
		this.idAdministrador = idAdministrador;
	}

	public long getIngresosAdmin() {
		return ingresosAdmin;
	}

	public void setIngresosAdmin(long ingresosAdmin) {
		this.ingresosAdmin = ingresosAdmin;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idAdministrador;
		result = prime * result + (int) (ingresosAdmin ^ (ingresosAdmin >>> 32));
		result = prime * result + ((users == null) ? 0 : users.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Administrador other = (Administrador) obj;
		if (idAdministrador != other.idAdministrador)
			return false;
		if (ingresosAdmin != other.ingresosAdmin)
			return false;
		if (users == null) {
			if (other.users != null)
				return false;
		} else if (!users.equals(other.users))
			return false;
		return true;
	}
	
		

}
