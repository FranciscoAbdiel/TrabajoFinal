package pe.edu.upc.entity;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Future;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "tarjetas")
public class Tarjeta implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idTarjeta;

	@NotEmpty(message = "Ingresa el numero de la tarjeta")
	@Column(name = "numeroTarjeta", nullable = false, length = 45, unique = true)
	private String numeroTarjeta;

	

	@Min(2)
	@Max(1500)
	@Column(name = "montoTarjeta", nullable = false)
	private double montoTarjeta;

	@NotNull(message = "La fecha es obligatoria")
	@Future(message = "La fecha debe estar en el futuro")
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fechaVencimiento")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fechaVencimiento;

	private String cvc;

	@ManyToOne // una union con categoria trae el id de categoria hacia el
	@JoinColumn(name = "idTipotarjeta")
	private Tipotarjeta tipotarjeta;

	public Tarjeta() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public Tarjeta(int idTarjeta, String numeroTarjeta,
			 double montoTarjeta,
			Date fechaVencimiento,
			String cvc, Tipotarjeta tipotarjeta) {
		super();
		this.idTarjeta = idTarjeta;
		this.numeroTarjeta = numeroTarjeta;
		this.montoTarjeta = montoTarjeta;
		this.fechaVencimiento = fechaVencimiento;
		this.cvc = cvc;
		this.tipotarjeta = tipotarjeta;
	}


	public int getIdTarjeta() {
		return idTarjeta;
	}

	public void setIdTarjeta(int idTarjeta) {
		this.idTarjeta = idTarjeta;
	}

	public String getNumeroTarjeta() {
		return numeroTarjeta;
	}

	public void setNumeroTarjeta(String numeroTarjeta) {
		this.numeroTarjeta = numeroTarjeta;
	}

	public double getMontoTarjeta() {
		return montoTarjeta;
	}

	public void setMontoTarjeta(double montoTarjeta) {
		this.montoTarjeta = montoTarjeta;
	}

	public Date getFechaVencimiento() {
		return fechaVencimiento;
	}

	public void setFechaVencimiento(Date fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}

	public Tipotarjeta getTipotarjeta() {
		return tipotarjeta;
	}

	public void setTipotarjeta(Tipotarjeta tipotarjeta) {
		this.tipotarjeta = tipotarjeta;
	}


	public String getCvc() {
		return cvc;
	}


	public void setCvc(String cvc) {
		this.cvc = cvc;
	}

	
}
