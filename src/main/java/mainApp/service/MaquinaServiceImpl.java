package mainApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mainApp.dao.IMaquinaDAO;
import mainApp.dto.Maquina;


@Service
public class MaquinaServiceImpl implements IMaquinaService {

	@Autowired
	IMaquinaDAO iMaquinaDAO;

	@Override
	public List<Maquina> listarMaquinas() {
		
		return iMaquinaDAO.findAll();
	}

	@Override
	public Maquina guardarMaquina(Maquina maquina) {
		
		return iMaquinaDAO.save(maquina);
	}

	@Override
	public List<Maquina> listarMaquinaPiso(int piso) {
		
		return iMaquinaDAO.findByPiso(piso);
	}

	@Override
	public Maquina maquinaXID(int id) {
		
		return iMaquinaDAO.findById(id).get();
	}

	@Override
	public Maquina actualizarMaquina(Maquina maquina) {
		
		return iMaquinaDAO.save(maquina);
	}

	@Override
	public void eliminarMaquina(int id) {
		
		iMaquinaDAO.deleteById(id);
		
	}

}
