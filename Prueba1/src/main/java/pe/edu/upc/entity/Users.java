package pe.edu.upc.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
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
@Table(name = "users")
public class Users implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idUser;
	
	@Column(length = 30, unique = true)
	private String username;
	
	@Column(length = 200)
	private String password = "1";
	
	private boolean enabled;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private List<Role> roles;
	
	@NotEmpty(message = "Ingresa el nombre")
	@Column(name = "nombreUsuario", length = 30, nullable = false, unique = true)
	private String nombreUsuario;
	
	@NotEmpty(message = "Ingresa el apellido")
	@Column(name = "apellidoUsuario", length = 30, nullable = false, unique = true)
	private String apellidoUsuario;
	
	@Size(min = 8, max = 8)
	@NotEmpty(message = "Ingresa DNI")
	@Column(name = "dniUsuario", nullable = false, length = 8,unique = true)
	private String dniUsuario;
	
	@NotNull
	@Past(message = "La fecha debe estar en el pasado")
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fechaNacUsuario")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fechaNacUsuario;
	
	@NotEmpty(message = "Ingresa Email")
	@Email
	@Column(name = "emailUsuario", nullable = false)
	private String emailUsuario;

	private Users() {
		super();
		// TODO Auto-generated constructor stub
	}

	private Users(long idUser, String username, String password, boolean enabled, List<pe.edu.upc.entity.Role> roles,
			String nombreUsuario, String apellidoUsuario, String dniUsuario, Date fechaNacUsuario,
			String emailUsuario) {
		super();
		this.idUser = idUser;
		this.username = username;
		this.password = password;
		this.enabled = enabled;
		this.roles = roles;
		this.nombreUsuario = nombreUsuario;
		this.apellidoUsuario = apellidoUsuario;
		this.dniUsuario = dniUsuario;
		this.fechaNacUsuario = fechaNacUsuario;
		this.emailUsuario = emailUsuario;
	}

	public long getIdUser() {
		return idUser;
	}

	public void setIdUser(long idUser) {
		this.idUser = idUser;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getApellidoUsuario() {
		return apellidoUsuario;
	}

	public void setApellidoUsuario(String apellidoUsuario) {
		this.apellidoUsuario = apellidoUsuario;
	}

	public String getDniUsuario() {
		return dniUsuario;
	}

	public void setDniUsuario(String dniUsuario) {
		this.dniUsuario = dniUsuario;
	}

	public Date getFechaNacUsuario() {
		return fechaNacUsuario;
	}

	public void setFechaNacUsuario(Date fechaNacUsuario) {
		this.fechaNacUsuario = fechaNacUsuario;
	}

	public String getEmailUsuario() {
		return emailUsuario;
	}

	public void setEmailUsuario(String emailUsuario) {
		this.emailUsuario = emailUsuario;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((apellidoUsuario == null) ? 0 : apellidoUsuario.hashCode());
		result = prime * result + ((dniUsuario == null) ? 0 : dniUsuario.hashCode());
		result = prime * result + ((emailUsuario == null) ? 0 : emailUsuario.hashCode());
		result = prime * result + (enabled ? 1231 : 1237);
		result = prime * result + ((fechaNacUsuario == null) ? 0 : fechaNacUsuario.hashCode());
		result = prime * result + (int) (idUser ^ (idUser >>> 32));
		result = prime * result + ((nombreUsuario == null) ? 0 : nombreUsuario.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((roles == null) ? 0 : roles.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
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
		Users other = (Users) obj;
		if (apellidoUsuario == null) {
			if (other.apellidoUsuario != null)
				return false;
		} else if (!apellidoUsuario.equals(other.apellidoUsuario))
			return false;
		if (dniUsuario == null) {
			if (other.dniUsuario != null)
				return false;
		} else if (!dniUsuario.equals(other.dniUsuario))
			return false;
		if (emailUsuario == null) {
			if (other.emailUsuario != null)
				return false;
		} else if (!emailUsuario.equals(other.emailUsuario))
			return false;
		if (enabled != other.enabled)
			return false;
		if (fechaNacUsuario == null) {
			if (other.fechaNacUsuario != null)
				return false;
		} else if (!fechaNacUsuario.equals(other.fechaNacUsuario))
			return false;
		if (idUser != other.idUser)
			return false;
		if (nombreUsuario == null) {
			if (other.nombreUsuario != null)
				return false;
		} else if (!nombreUsuario.equals(other.nombreUsuario))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (roles == null) {
			if (other.roles != null)
				return false;
		} else if (!roles.equals(other.roles))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	
	
	
}
