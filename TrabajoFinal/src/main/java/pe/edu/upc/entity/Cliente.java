package pe.edu.upc.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="clientes")
public class Cliente implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idCliente;
	@Size(min=8,max=8)
	@NotEmpty(message= "Ingresa tu numero de DNI")
	@Column(name="dniCliente",length=45,nullable=false,unique=true)
	private String dniCliente;
	
	@NotEmpty(message="Ingresa tu nombre")
	@Column(name="nombreCliente",nullable=false,length=45)
	private String nombreCliente;
	
	@NotEmpty(message="Ingresa tu apellido")
	@Column(name="apellidoCliente",nullable=false,length=45)
	private String apellidoCliente;
	
	@NotNull
	@Past(message="La fecha debe estar en pasado")
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="nacimientoCliente")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date nacimientoCliente;
	
	@NotEmpty(message="Ingrese su direccion exacta")
	@Column(name="direccionCliente",nullable=false,length=45)
	private String direccionCliente;
	
	@Email
	@NotEmpty(message="Ingrese un email valido")
	@Column(name="emailCliente",nullable=false,length=45)
	private String emailCliente;
	
	@Size(min=9,max=9)
	@NotEmpty(message="Ingrese el numero de su telefono movil")
	@Column(name="telefonoCliente",nullable=false,length=45)
	private String telefonoCliente;
	
	@NotEmpty(message="Ingrese su usuario")
	@Column(name="usuarioCliente",nullable=false,length=45)
    private String usuarioCliente;
	
	@NotEmpty(message="Ingrese su password")
	@Column(name="passwordCliente",nullable=false,length=200)
    private String passwordCliente;
	
	public Cliente() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Cliente(int idCliente, String dniCliente, String nombreCliente, String apellidoCliente,
			Date nacimientoCliente, String direccionCliente, String emailCliente, String telefonoCliente,
			String usuarioCliente, String passwordCliente) {
		super();
		this.idCliente = idCliente;
		this.dniCliente = dniCliente;
		this.nombreCliente = nombreCliente;
		this.apellidoCliente = apellidoCliente;
		this.nacimientoCliente = nacimientoCliente;
		this.direccionCliente = direccionCliente;
		this.emailCliente = emailCliente;
		this.telefonoCliente = telefonoCliente;
		this.usuarioCliente = usuarioCliente;
		this.passwordCliente = passwordCliente;
	}
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	public String getDniCliente() {
		return dniCliente;
	}
	public void setDniCliente(String dniCliente) {
		this.dniCliente = dniCliente;
	}
	public String getNombreCliente() {
		return nombreCliente;
	}
	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}
	public String getApellidoCliente() {
		return apellidoCliente;
	}
	public void setApellidoCliente(String apellidoCliente) {
		this.apellidoCliente = apellidoCliente;
	}
	public Date getNacimientoCliente() {
		return nacimientoCliente;
	}
	public void setNacimientoCliente(Date nacimientoCliente) {
		this.nacimientoCliente = nacimientoCliente;
	}
	public String getDireccionCliente() {
		return direccionCliente;
	}
	public void setDireccionCliente(String direccionCliente) {
		this.direccionCliente = direccionCliente;
	}
	public String getEmailCliente() {
		return emailCliente;
	}
	public void setEmailCliente(String emailCliente) {
		this.emailCliente = emailCliente;
	}
	public String getTelefonoCliente() {
		return telefonoCliente;
	}
	public void setTelefonoCliente(String telefonoCliente) {
		this.telefonoCliente = telefonoCliente;
	}
	public String getUsuarioCliente() {
		return usuarioCliente;
	}
	public void setUsuarioCliente(String usuarioCliente) {
		this.usuarioCliente = usuarioCliente;
	}
	public String getPasswordCliente() {
		return passwordCliente;
	}
	public void setPasswordCliente(String passwordCliente) {
		this.passwordCliente = passwordCliente;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((apellidoCliente == null) ? 0 : apellidoCliente.hashCode());
		result = prime * result + ((direccionCliente == null) ? 0 : direccionCliente.hashCode());
		result = prime * result + ((dniCliente == null) ? 0 : dniCliente.hashCode());
		result = prime * result + ((emailCliente == null) ? 0 : emailCliente.hashCode());
		result = prime * result + idCliente;
		result = prime * result + ((nacimientoCliente == null) ? 0 : nacimientoCliente.hashCode());
		result = prime * result + ((nombreCliente == null) ? 0 : nombreCliente.hashCode());
		result = prime * result + ((passwordCliente == null) ? 0 : passwordCliente.hashCode());
		result = prime * result + ((telefonoCliente == null) ? 0 : telefonoCliente.hashCode());
		result = prime * result + ((usuarioCliente == null) ? 0 : usuarioCliente.hashCode());
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
		if (apellidoCliente == null) {
			if (other.apellidoCliente != null)
				return false;
		} else if (!apellidoCliente.equals(other.apellidoCliente))
			return false;
		if (direccionCliente == null) {
			if (other.direccionCliente != null)
				return false;
		} else if (!direccionCliente.equals(other.direccionCliente))
			return false;
		if (dniCliente == null) {
			if (other.dniCliente != null)
				return false;
		} else if (!dniCliente.equals(other.dniCliente))
			return false;
		if (emailCliente == null) {
			if (other.emailCliente != null)
				return false;
		} else if (!emailCliente.equals(other.emailCliente))
			return false;
		if (idCliente != other.idCliente)
			return false;
		if (nacimientoCliente == null) {
			if (other.nacimientoCliente != null)
				return false;
		} else if (!nacimientoCliente.equals(other.nacimientoCliente))
			return false;
		if (nombreCliente == null) {
			if (other.nombreCliente != null)
				return false;
		} else if (!nombreCliente.equals(other.nombreCliente))
			return false;
		if (passwordCliente == null) {
			if (other.passwordCliente != null)
				return false;
		} else if (!passwordCliente.equals(other.passwordCliente))
			return false;
		if (telefonoCliente == null) {
			if (other.telefonoCliente != null)
				return false;
		} else if (!telefonoCliente.equals(other.telefonoCliente))
			return false;
		if (usuarioCliente == null) {
			if (other.usuarioCliente != null)
				return false;
		} else if (!usuarioCliente.equals(other.usuarioCliente))
			return false;
		return true;
	}
    
	
    
}
