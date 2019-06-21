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
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;




@Entity
@Table(name="productos")
public class Producto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idProducto;
	
	@NotEmpty(message="Ingresa el nombre del producto")
	@Column(name="nombreProducto",nullable=false,length=45,unique=true)
	private String nombreProducto;
	
	@NotEmpty(message="Ingresa la cantidad de stock")
	@Column(name="stockProducto",nullable=false,length=45)
	private String stockProducto;
	
	@Min(2)
	@Max(1500)
	private double precioProducto;
	
	@Temporal(TemporalType.DATE)
	@Column(name="fechaIngreso")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fechaIngreso;
	
	@NotNull(message="Seleccione una categoria")
	@ManyToOne
	@JoinColumn(name="idCategoria")
	private Categoria categoria;
	
	private String foto;

	public Producto(int idProducto, String nombreProducto,String stockProducto, double precioProducto, Date fechaIngreso,
			 Categoria categoria, String foto) {
		super();
		this.idProducto = idProducto;
		this.nombreProducto = nombreProducto;
		this.stockProducto = stockProducto;
		this.precioProducto = precioProducto;
		this.fechaIngreso = fechaIngreso;
		this.categoria = categoria;
		this.foto=foto;
	}
	public Producto() {
		super();
		// TODO Auto-generated constructor stub
	}
	@PrePersist
	public void prePersist() {
		fechaIngreso= new Date();
	}
	public int getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}
	public String getNombreProducto() {
		return nombreProducto;
	}
	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}
	public double getPrecioProducto() {
		return precioProducto;
	}
	public void setPrecioProducto(double precioProducto) {
		this.precioProducto = precioProducto;
	}
	

	public String getStockProducto() {
		return stockProducto;
	}
	public void setStockProducto(String stockProducto) {
		this.stockProducto = stockProducto;
	}
	public Date getFechaIngreso() {
		return fechaIngreso;
	}
	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((categoria == null) ? 0 : categoria.hashCode());
		result = prime * result + ((fechaIngreso == null) ? 0 : fechaIngreso.hashCode());
		result = prime * result + ((foto == null) ? 0 : foto.hashCode());
		result = prime * result + idProducto;
		result = prime * result + ((nombreProducto == null) ? 0 : nombreProducto.hashCode());
		long temp;
		temp = Double.doubleToLongBits(precioProducto);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((stockProducto == null) ? 0 : stockProducto.hashCode());
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
		Producto other = (Producto) obj;
		if (categoria == null) {
			if (other.categoria != null)
				return false;
		} else if (!categoria.equals(other.categoria))
			return false;
		if (fechaIngreso == null) {
			if (other.fechaIngreso != null)
				return false;
		} else if (!fechaIngreso.equals(other.fechaIngreso))
			return false;
		if (foto == null) {
			if (other.foto != null)
				return false;
		} else if (!foto.equals(other.foto))
			return false;
		if (idProducto != other.idProducto)
			return false;
		if (nombreProducto == null) {
			if (other.nombreProducto != null)
				return false;
		} else if (!nombreProducto.equals(other.nombreProducto))
			return false;
		if (Double.doubleToLongBits(precioProducto) != Double.doubleToLongBits(other.precioProducto))
			return false;
		if (stockProducto == null) {
			if (other.stockProducto != null)
				return false;
		} else if (!stockProducto.equals(other.stockProducto))
			return false;
		return true;
	}
	
	
}
