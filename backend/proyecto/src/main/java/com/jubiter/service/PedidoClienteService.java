package com.jubiter.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.jubiter.logica.RegistrarCantidadProducto;
import com.jubiter.logica.RegistroCentral;
import com.jubiter.modelo.ClienteCRM;
import com.jubiter.modelo.ClienteProductoAlmacenEmpresa;
import com.jubiter.modelo.PedidoCliente;
import com.jubiter.modelo.Producto;
import com.jubiter.repository.ClienteProductoAlmacenEmpresaRepository;
import com.jubiter.repository.PedidoClienteRepository;
import com.jubiter.repository.ProductoRepository;


@Service
public class PedidoClienteService {

	
	@Autowired
	private PedidoClienteRepository pedidoClienteRepository; 
	
	@Autowired
	private ProductoRepository productoRepository;
	
	@Autowired
	private ClienteProductoAlmacenEmpresaRepository clienteProductoAlmacenEmpresaRepository;
	
	private RegistroCentral registroCentral;
	
	private RegistrarCantidadProducto registrarCantidadProducto;
	
	private JdbcTemplate jdbcTemplate;
	

	
	/*
	// Obtiene todos los productos de todos los pedidos
	public List<PedidoCliente> getAllPedidoCliente(ClienteCRM clienteCRM) {
		List<PedidoCliente> pedidosCliente = new ArrayList<>();
		pedidoClienteRepository.findAllPedidoClienteByClienteCRM(clienteCRM)
						 	.forEach(pedidosCliente::add);    
		return pedidosCliente;
	}
	
	
	// Obtiene todos los productos de un pedido
	public List<PedidoCliente> getPedidoCliente(UUID pedidoClienteId){
		List<PedidoCliente> productosPedidoCliente = new ArrayList<>();
		pedidoClienteRepository.findPedidoClienteById(pedidoClienteId)
						 	.forEach(productosPedidoCliente::add); 
		
		return productosPedidoCliente;
		
	}
	
		public void deletePedidoCliente(UUID idPedidoCliente) {
		pedidoClienteRepository.deleteById(idPedidoCliente);
	}
	
	*/
	
	//@Transactional
	public void addPedidoCliente(PedidoCliente pedidoCliente) {
		
		int cantidadProducto = pedidoCliente.getProducto().getCantidad();
		UUID idPedidoCliente = pedidoCliente.getIdPedidoCliente();
		int idAlmacen = 1;
		int idProducto = pedidoCliente.getProducto().getIdProducto();

		
		// Este código iría a fuera, pero no sé porqué no me llama al otro
		// método y me da error en tiempo de ejecución (lo dejo como prueba 
		// y para reflexinar yo). Está abajo
		Producto producto = productoRepository.findById(idProducto);
		
		int totalProducto = producto.getCantidad() - cantidadProducto;
		producto.setCantidad(totalProducto);
		productoRepository.save(producto);
		
		
		
		try {
			pedidoClienteRepository.save(pedidoCliente);
		} catch(Exception e) {
			e.getStackTrace();
			throw new  RuntimeException("error al guardar pedido");
		}
		
		/*
		
		//ClienteProductoAlmacenEmpresa cpaer = new ClienteProductoAlmacenEmpresa(idAlmacen, idProducto, idPedidoCliente, cantidadProducto);
		//ClienteProductoAlmacenEmpresa cpaer = new ClienteProductoAlmacenEmpresa(idAlmacen, idProducto, idPedidoCliente);
		//clienteProductoAlmacenEmpresaRepository.save(cpaer);
		
		/*
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.update("INSERT INTO cliente_producto_almacen "
				+ "(fk_id_producto, fk_id_pedido_cliente, fk_id_almacen_empresa,"
				+ "cantidad) VALUES(?,?,?,?)", 
				idProducto, idPedidoCliente, idAlmacen, cantidadProducto);
		
		
		
		/*
		
		try {
			// Lo registra en la tabla central
			
			
			registroCentral.registrarRegistro(idProducto, idPedidoCliente, idAlmacen, cantidadProducto);
		
		} catch(Exception e) {
			e.getStackTrace();
			throw new  RuntimeException("error al guardar central");
		}
		*/
		
		/*
		try {
			// Resta el los producto de la tabla
			
			registrarCantidadProducto = new RegistrarCantidadProducto();
			registrarCantidadProducto.restarCantidadDeProducto(idProducto, cantidadProducto);
		
			
			
		} catch ( RuntimeException e){ 
			e.getCause();
			e.getMessage();
			e.fillInStackTrace();
			throw new RuntimeException("hola? runtime");
		
		} catch(Exception  e ) {
			
			e.getCause();
			e.getMessage();
			e.fillInStackTrace();
			throw new RuntimeException("hola? exception");
		}*/
		
		

		

		
	}
	


}
