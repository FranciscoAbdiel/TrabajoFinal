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
@Table(name = "clientes")
public class Cliente implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCliente;
	
	@Column(name = "saldoCliente", length = 70)
	private long saldoCliente;
	
	@NotEmpty(message = "Ingresa el telefono")
	@Column(name = "telefCliente", nullable = false, length = 70)
	private String telefCliente;
	
	@NotEmpty(message = "Ingresa la direccion")
	@Column(name = "dirCliente", nullable = false, length = 70)
	private String dirCliente;
	
	@OneToOne
	@JoinColumn(name ="idUser")
	private Users users;

	public Cliente() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cliente(int idCliente, long saldoCliente, String telefCliente, String dirCliente, Users users) {
		super();
		this.idCliente = idCliente;
		this.saldoCliente = saldoCliente;
		this.telefCliente = telefCliente;
		this.dirCliente = dirCliente;
		this.users = users;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public long getSaldoCliente() {
		return saldoCliente;
	}

	public void setSaldoCliente(long saldoCliente) {
		this.saldoCliente = saldoCliente;
	}

	public String getTelefCliente() {
		return telefCliente;
	}

	public void setTelefCliente(String telefCliente) {
		this.telefCliente = telefCliente;
	}

	public String getDirCliente() {
		return dirCliente;
	}

	public void setDirCliente(String dirCliente) {
		this.dirCliente = dirCliente;
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
		result = prime * result + ((dirCliente == null) ? 0 : dirCliente.hashCode());
		result = prime * result + idCliente;
		result = prime * result + (int) (saldoCliente ^ (saldoCliente >>> 32));
		result = prime * result + ((telefCliente == null) ? 0 : telefCliente.hashCode());
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
		Cliente other = (Cliente) obj;
		if (dirCliente == null) {
			if (other.dirCliente != null)
				return false;
		} else if (!dirCliente.equals(other.dirCliente))
			return false;
		if (idCliente != other.idCliente)
			return false;
		if (saldoCliente != other.saldoCliente)
			return false;
		if (telefCliente == null) {
			if (other.telefCliente != null)
				return false;
		} else if (!telefCliente.equals(other.telefCliente))
			return false;
		if (users == null) {
			if (other.users != null)
				return false;
		} else if (!users.equals(other.users))
			return false;
		return true;
	}
	
}
