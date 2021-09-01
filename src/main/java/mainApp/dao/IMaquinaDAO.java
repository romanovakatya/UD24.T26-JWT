package mainApp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import mainApp.dto.Maquina;

public interface IMaquinaDAO extends JpaRepository<Maquina, Integer> {

	// listar cajeros por el nombre+apellidos
	public List<Maquina> findByPiso(int piso);
}
