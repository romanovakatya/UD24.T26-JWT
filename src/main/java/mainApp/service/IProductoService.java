package mainApp.service;

import java.util.List;

import mainApp.dto.Producto;

public interface IProductoService {

	
	// Metodos del CRUD
		public List<Producto> listarProductos(); // Listar All

		public Producto guardarProducto(Producto producto);// Guarda un producto CREATE

		public List<Producto> listarProductoPrecio(int precio);// Listar productos por campo precio

		public Producto productoXID(int id); // Leer datos de un producto READ

		public Producto actualizarProducto(Producto producto); // Actualiza datos del producto UPDATE

		public void eliminarProducto(int id);// Elimina el producto DELETE
}
