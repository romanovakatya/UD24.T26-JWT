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
@Table(name="maquinas")
public class Maquina {

	
	//atributos de la entidad máquina,
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int id;
		
		@Column(name="piso")
		private int piso;
		
		
		@OneToMany()
		@JoinColumn(name="id")
		private List<Venta> venta;

		//constructores,
		//por defecto,
		public Maquina() {
			
		}
		
		
		//con todos los atributos,
		public Maquina(int id, int piso) {
			super();
			this.id = id;
			this.piso = piso;
		}

		
		//los getters y setters,
		public int getId() {
			return id;
		}

		
		public void setId(int id) {
			this.id = id;
		}

		
		public int getPiso() {
			return piso;
		}

		
		public void setPiso(int piso) {
			this.piso = piso;
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
			return "CAaero [id=" + id + ", piso=" + piso + "]";
		}
		
		
		
}
