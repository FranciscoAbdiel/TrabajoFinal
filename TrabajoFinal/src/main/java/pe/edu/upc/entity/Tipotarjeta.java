package pe.edu.upc.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "tipotarjetas")
public class Tipotarjeta implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idTipotarjeta;

	@NotEmpty(message = "Ingresa el Tipo de tarjeta")
	@Column(name = "nameTipotarjeta", nullable = false, length = 45,unique=true)
	private String nameTipotarjeta;
	
	public Tipotarjeta() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Tipotarjeta(int idTipotarjeta, String nameTipotarjeta) {
		super();
		this.idTipotarjeta = idTipotarjeta;
		this.nameTipotarjeta = nameTipotarjeta;
	}

	public int getIdTipotarjeta() {
		return idTipotarjeta;
	}

	public void setIdTipotarjeta(int idTipotarjeta) {
		this.idTipotarjeta = idTipotarjeta;
	}

	public String getNameTipotarjeta() {
		return nameTipotarjeta;
	}

	public void setNameTipotarjeta(String nameTipotarjeta) {
		this.nameTipotarjeta = nameTipotarjeta;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idTipotarjeta;
		result = prime * result + ((nameTipotarjeta == null) ? 0 : nameTipotarjeta.hashCode());
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
		Tipotarjeta other = (Tipotarjeta) obj;
		if (idTipotarjeta != other.idTipotarjeta)
			return false;
		if (nameTipotarjeta == null) {
			if (other.nameTipotarjeta != null)
				return false;
		} else if (!nameTipotarjeta.equals(other.nameTipotarjeta))
			return false;
		return true;
	}
	
	
}
