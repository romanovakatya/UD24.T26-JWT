package mainApp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import mainApp.dto.Cajero;

public interface ICajeroDAO extends JpaRepository<Cajero, Integer> {

	// listar cajeros por el nombre+apellidos
	public List<Cajero> findByNomApels(String nomApels);
}
