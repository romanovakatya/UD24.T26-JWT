package mainApp.service;

import java.util.List;

import mainApp.dto.Cajero;


public interface ICajeroService {

	
	// Metodos del CRUD
		public List<Cajero> listarCajeros(); // Listar All

		public Cajero guardarCajero(Cajero cajero);// Guarda un cajero CREATE

		public List<Cajero> listarCajeroNomApels(String nomApels);// Listar cajerVentaos por campo nomApels

		public Cajero cajeroXID(int id); // Leer datos de un cajero READ

		public Cajero actualizarCajero(Cajero cajero); // Actualiza datos del cajero UPDATE

		public void eliminarCajero(int id);// Elimina el cajero DELETE
}
