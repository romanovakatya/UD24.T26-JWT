package mainApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mainApp.dto.Maquina;
import mainApp.service.MaquinaServiceImpl;


@RestController
@RequestMapping("/api")
public class MaquinaController {
	
	@Autowired
	MaquinaServiceImpl maquinaServiceImpl; 
	
	@GetMapping("/maquinas")
	public List<Maquina> listarMaquinas(){
		
		return maquinaServiceImpl.listarMaquinas();
	}
	
	
	@PostMapping("/maquinas")
	public Maquina guardarMaquina(@RequestBody Maquina maquina) {
		
		return maquinaServiceImpl.guardarMaquina(maquina);
		
	}
	
	
	@GetMapping("/maquinas/piso/{piso}")
	
	public List<Maquina> listarMaquinaPiso(@PathVariable(name="piso") int piso){
		
		return maquinaServiceImpl.listarMaquinaPiso(piso);
	}
	
	
	@GetMapping("/maquinas/{id}")
	public Maquina maquinaXID(@PathVariable(name="id") int id) {
		
		Maquina maquina_xid = new Maquina();
		
		maquina_xid = maquinaServiceImpl.maquinaXID(id);
		
		System.out.println("maquina_xid: " + maquina_xid);
		
		return maquina_xid;
	}
	
	
	@PutMapping("/maquinas/{id}")
	public Maquina actualizarMaquina(@PathVariable(name="id") int id, @RequestBody Maquina maquina) {
		
		Maquina maquina_seleccionada = new Maquina();
		Maquina maquina_actualizada = new Maquina();
		
		maquina_seleccionada = maquinaServiceImpl.maquinaXID(id);
		maquina_seleccionada.setPiso(maquina.getPiso());
		
		maquina_actualizada = maquinaServiceImpl.actualizarMaquina(maquina_seleccionada);
		
		
		System.out.println( "maquina_actualizada: " + maquina_actualizada);
		return maquina_actualizada;
		
	}
	
	
	@DeleteMapping("/maquinas/{id}")
		public void eliminarMaquina(@PathVariable(name="id") int id) {
		
		maquinaServiceImpl.eliminarMaquina(id);
	}

}
