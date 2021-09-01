package mainApp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import mainApp.dto.Venta;



public interface IVentaDAO extends JpaRepository<Venta, Integer>{

	public List<Venta> findByProductoNombre(String nombre);
}
