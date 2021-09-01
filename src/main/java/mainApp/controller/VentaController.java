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

import mainApp.dto.Venta;
import mainApp.service.VentaServiceImpl;

@RestController
@RequestMapping("/api")
public class VentaController {

	@Autowired
	VentaServiceImpl ventaServiceImpl;

	@GetMapping("/ventas")
	public List<Venta> listarVentas() {

		return ventaServiceImpl.listarVentas();
	}

	@PostMapping("/ventas")
	public Venta guardarVenta(@RequestBody Venta venta) {

		return ventaServiceImpl.guardarVenta(venta);
	}

	@GetMapping("/ventas/producto_nombre/{producto_nombre}")
	public List<Venta> listarVentaProductoNombre(@PathVariable(name = "producto_nombre") String nombre) {

		return ventaServiceImpl.listarVentaProductoNombre(nombre);
	}

	@GetMapping("/ventas/{id}")
	public Venta ventaXID(@PathVariable(name = "id") int id) {

		Venta venta_xid = new Venta();

		venta_xid = ventaServiceImpl.ventaXID(id);

		System.out.println("venta_xid: " + venta_xid);

		return venta_xid;
	}

	@PutMapping("/ventas/{id}")
	public Venta actualizarVenta(@PathVariable(name = "id") int id, @RequestBody Venta venta) {

		Venta venta_seleccionada = new Venta();
		Venta venta_actualizada = new Venta();
		
		venta_seleccionada = ventaServiceImpl.ventaXID(id);
		venta_seleccionada.setProducto(venta.getProducto());
		venta_seleccionada.setCajero(venta.getCajero());
		venta_seleccionada.setMaquina(venta.getMaquina());
		
		venta_actualizada = ventaServiceImpl.actualizarVenta(venta_seleccionada);
		
		
		System.out.println( "venta_actualizada: " + venta_actualizada);
		return venta_actualizada;
	}

	@DeleteMapping("/ventas/{id}")
	public void eliminarVenta(@PathVariable(name = "id") int id) {

		ventaServiceImpl.eliminarVenta(id);
	}

}
