package mainApp.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ventas")
public class Venta {

	// atributos de la entidad venta,
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne
	@JoinColumn(name = "id_producto")
	Producto producto;

	@ManyToOne
	@JoinColumn(name = "id_cajero")
	Cajero cajero;

	@ManyToOne
	@JoinColumn(name = "id_maquina")
	Maquina maquina;

	
	//constructores,
	//por defecto,
	public Venta() {

	}

	//con todos los atributos,
	public Venta(int id, Producto producto, Cajero cajero, Maquina maquina) {
		super();
		this.id = id;
		this.producto = producto;
		this.cajero = cajero;
		this.maquina = maquina;
	}

	
	//los getters y setters,
	public int getId() {
		return id;
	}

	
	public void setId(int id) {
		this.id = id;
	}
	

	public Producto getProducto() {
		return producto;
	}

	
	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	
	public Cajero getCajero() {
		return cajero;
	}

	
	public void setCajero(Cajero cajero) {
		this.cajero = cajero;
	}

	
	public Maquina getMaquina() {
		return maquina;
	}

	
	public void setMaquina(Maquina maquina) {
		this.maquina = maquina;
	}

	
	//para mostrar los datos de una venta,
	@Override
	public String toString() {
		return "Venta [id=" + id + ", producto=" + producto + ", cajero=" + cajero + ", maquina=" + maquina + "]";
	}
	
	
	

}
