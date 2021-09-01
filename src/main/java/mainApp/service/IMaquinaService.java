package mainApp.service;

import java.util.List;

import mainApp.dto.Maquina;


public interface IMaquinaService {

	
	// Metodos del CRUD
		public List<Maquina> listarMaquinas(); // Listar All

		public Maquina guardarMaquina(Maquina maquina);// Guarda un maquina CREATE

		public List<Maquina> listarMaquinaPiso(int piso);// Listar maquinas por campo precio

		public Maquina maquinaXID(int id); // Leer datos de un maquina READ

		public Maquina actualizarMaquina(Maquina maquina); // Actualiza datos del maquina UPDATE

		public void eliminarMaquina(int id);// Elimina el maquina DELETE
}
