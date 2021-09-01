package mainApp.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="productos")
public class Producto {

	
	//atributos de la entidad producto,
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int id;
		
		@Column(name="nombre")
		private String nombre;
		
		@Column(name="precio")
		private int precio;
		
		@OneToMany()
		@JoinColumn(name="id")
		private List<Venta> venta;

		//constructores,
		//por defecto,
		public Producto() {
			
		}
		
		
		//con todos los atributos,
		public Producto(int id, String nombre, int precio) {
			super();
			this.id = id;
			this.nombre = nombre;
			this.precio = precio;
		}

		
		//los getters y setters,
		public int getId() {
			return id;
		}

		
		public void setId(int id) {
			this.id = id;
		}

		
		public String getNombre() {
			return nombre;
		}

		
		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		
		public int getPrecio() {
			return precio;
		}

		
		public void setPrecio(int precio) {
			this.precio = precio;
		}
		
		
		@JsonIgnore
		@OneToMany(fetch = FetchType.LAZY, mappedBy = "Venta")
		public List<Venta> getVenta() {
			return venta;
		}

		
		public void setVenta(List<Venta> venta) {
			this.venta = venta;
		}

		
		//para mostrar los datos de un producto,
		@Override
		public String toString() {
			return "Producto [id=" + id + ", nombre=" + nombre + ", precio=" + precio + "]";
		}
		
		
		
}
