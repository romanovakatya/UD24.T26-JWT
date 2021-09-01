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

import mainApp.dto.Producto;
import mainApp.service.ProductoServiceImpl;

@RestController
@RequestMapping("/api")
public class ProductoController {
	
	@Autowired
	ProductoServiceImpl productoServiceImpl;
	
	@GetMapping("/productos")
	public List<Producto> listarProductos(){
		
		return productoServiceImpl.listarProductos();
	}
	
	
	@PostMapping("/productos")
	public Producto guardarProducto(@RequestBody Producto producto) {
		
		return productoServiceImpl.guardarProducto(producto);
		
	}
	
	
	@GetMapping("/productos/precio/{precio}")
	
	public List<Producto> listarProductoPrecio(@PathVariable(name="precio") int precio){
		
		return productoServiceImpl.listarProductoPrecio(precio);
	}
	
	
	@GetMapping("/productos/{id}")
	public Producto productoXID(@PathVariable(name="id") int id) {
		
		Producto producto_xid = new Producto();
		
		producto_xid = productoServiceImpl.productoXID(id);
		
		System.out.println("producto_xid: " + producto_xid);
		
		return producto_xid;
	}
	
	
	@PutMapping("/productos/{id}")
	public Producto actualizarProducto(@PathVariable(name="id") int id, @RequestBody Producto producto) {
		
		Producto producto_seleccionado = new Producto();
		Producto producto_actualizado = new Producto();
		
		producto_seleccionado = productoServiceImpl.productoXID(id);
		producto_seleccionado.setNombre(producto.getNombre());
		producto_seleccionado.setPrecio(producto.getPrecio());
		
		producto_actualizado = productoServiceImpl.actualizarProducto(producto_seleccionado);
		
		
		System.out.println( "producto_actualizado: " + producto_actualizado);
		return producto_actualizado;
		
	}
	
	
	@DeleteMapping("/productos/{id}")
		public void eliminarProducto(@PathVariable(name="id") int id) {
		
		productoServiceImpl.eliminarProducto(id);
	}

}
