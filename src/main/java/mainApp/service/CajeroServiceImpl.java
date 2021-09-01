package mainApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mainApp.dao.ICajeroDAO;
import mainApp.dto.Cajero;


@Service
public class CajeroServiceImpl implements ICajeroService {

	@Autowired
	ICajeroDAO icajeroDAO;

	@Override
	public List<Cajero> listarCajeros() {
		
		return icajeroDAO.findAll();
	}

	@Override
	public Cajero guardarCajero(Cajero cajero) {
		
		return icajeroDAO.save(cajero);
	}

	@Override
	public List<Cajero> listarCajeroNomApels(String nomApels) {
		
		return icajeroDAO.findByNomApels(nomApels);
	}

	@Override
	public Cajero cajeroXID(int id) {
		
		return icajeroDAO.findById(id).get();
	}

	@Override
	public Cajero actualizarCajero(Cajero cajero) {
		
		return icajeroDAO.save(cajero);
	}

	@Override
	public void eliminarCajero(int id) {
		
		icajeroDAO.deleteById(id);
		
	}



}
