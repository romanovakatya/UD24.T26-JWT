package mainApp.service;

import java.util.List;

import mainApp.dto.Venta;


public interface IVentaService {

	// Metodos del CRUD
			public List<Venta> listarVentas(); // Listar All

			public Venta guardarVenta(Venta venta);// Guarda una venta CREATE

			public List<Venta> listarVentaProductoNombre(String nombre);// Listar ventas por campo nombre del producto

			public Venta ventaXID(int id); // Leer datos de una venta READ

			public Venta actualizarVenta(Venta venta); // Actualiza datos de la venta UPDATE

			public void eliminarVenta(int id);// Elimina una venta DELETE
}
