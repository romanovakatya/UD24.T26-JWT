package mainApp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import mainApp.dto.Producto;

public interface IProductoDAO extends JpaRepository<Producto, Integer> {

	// listar productos por el precio
	public List<Producto> findByPrecio(int precio);
}
