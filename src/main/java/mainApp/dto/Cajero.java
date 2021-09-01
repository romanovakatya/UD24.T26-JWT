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
@Table(name="cajeros")
public class Cajero {

	
	//atributos de la entidad cajero,
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int id;
		
		@Column(name="nom_apels")
		private String nomApels;
		
		
		@OneToMany()
		@JoinColumn(name="id")
		private List<Venta> venta;

		//constructores,
		//por defecto,
		public Cajero() {
			
		}
		
		
		//con todos los atributos,
		public Cajero(int id, String nombre) {
			super();
			this.id = id;
			this.nomApels = nombre;
		}

		
		//los getters y setters,
		public int getId() {
			return id;
		}

		
		public void setId(int id) {
			this.id = id;
		}

		
		public String getNomApels() {
			return nomApels;
		}

		
		public void setNomApels(String nombre) {
			this.nomApels = nombre;
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
			return "CAaero [id=" + id + ", nombre=" + nomApels + "]";
		}
		
		
		
}
