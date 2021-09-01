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

import mainApp.dto.Cajero;
import mainApp.service.CajeroServiceImpl;


@RestController
@RequestMapping("/api")
public class CajeroController {
	
	@Autowired
	CajeroServiceImpl cajeroServiceImpl; 
	
	@GetMapping("/cajeros")
	public List<Cajero> listarCajeros(){
		
		return cajeroServiceImpl.listarCajeros();
	}
	
	
	@PostMapping("/cajeros")
	public Cajero guardarCajero(@RequestBody Cajero cajero) {
		
		return cajeroServiceImpl.guardarCajero(cajero);
		
	}
	
	
	@GetMapping("/cajeros/nombre/{nombre}")
	
	public List<Cajero> listarCajeroNomApels(@PathVariable(name="nombre") String nomApels){
		
		return cajeroServiceImpl.listarCajeroNomApels(nomApels);
	}
	
	
	@GetMapping("/cajeros/{id}")
	public Cajero cajeroXID(@PathVariable(name="id") int id) {
		
		Cajero cajero_xid = new Cajero();
		
		cajero_xid = cajeroServiceImpl.cajeroXID(id);
		
		System.out.println("cajero_xid: " + cajero_xid);
		
		return cajero_xid;
	}
	
	
	@PutMapping("/cajeros/{id}")
	public Cajero actualizarCajero(@PathVariable(name="id") int id, @RequestBody Cajero cajero) {
		
		Cajero cajero_seleccionado = new Cajero();
		Cajero cajero_actualizado = new Cajero();
		
		cajero_seleccionado = cajeroServiceImpl.cajeroXID(id);
		cajero_seleccionado.setNomApels(cajero.getNomApels());
		
		cajero_actualizado = cajeroServiceImpl.actualizarCajero(cajero_seleccionado);
		
		
		System.out.println( "cajero_actualizado: " + cajero_actualizado);
		return cajero_actualizado;
		
	}
	
	
	@DeleteMapping("/cajeros/{id}")
		public void eliminarCajero(@PathVariable(name="id") int id) {
		
		cajeroServiceImpl.eliminarCajero(id);
	}

}
