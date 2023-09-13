package com.utn.persistenciajpa;

import com.utn.persistenciajpa.entidades.*;
import com.utn.persistenciajpa.enums.EstadoPedido;
import com.utn.persistenciajpa.enums.FormaPago;
import com.utn.persistenciajpa.enums.TipoEnvio;
import com.utn.persistenciajpa.enums.TipoProducto;
import com.utn.persistenciajpa.repositorios.ClienteRepository;
import com.utn.persistenciajpa.repositorios.DomicilioRepository;
import com.utn.persistenciajpa.repositorios.RubroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.sql.SQLOutput;
import java.util.List;

@SpringBootApplication
public class PersistenciajpaApplication {

	@Autowired
	ClienteRepository clienteRepository;
	@Autowired
	DomicilioRepository domicilioRepository;
	@Autowired
	RubroRepository rubroRepository;

	public static void main(String[] args) {
		SpringApplication.run(PersistenciajpaApplication.class, args);
		System.out.println("Estoy funcionando hoy");
	}


	@Bean
	CommandLineRunner init(ClienteRepository clienteRepo){
		return args -> {
			System.out.println("===========ALELUYA GLORIA ALELUYA=============");

			Cliente	cliente= new Cliente();
			cliente.setNombre("Esteban");
			cliente.setApellido("Picapiedra");
			cliente.setEmail("algunmail@gmail.com");

			Domicilio domicilio1=Domicilio.builder()
					.calle("Calle Falsa")
					.localidad("Peru")
					.numero("unodostre")
					.build();

			Pedido pedido1= Pedido.builder()
					.total(20000.00)
					.estado(EstadoPedido.INICIADO)
					.tipoEnvio(TipoEnvio.DELIVERY)
					.build();

			Factura factura1=Factura.builder()
					.total(20302000)
					.descuento(23.01)
					.formaPago(FormaPago.EFECTIVO)
					.build();

			pedido1.setFactura(factura1);
			cliente.agregarPedido(pedido1);
			cliente.agregarDomicilio(domicilio1);

			Producto producto1=Producto.builder()
					.precioCompra(20.00)
					.precioVenta(300.00)
					.denominacion("Dignidad")
					.tipo(TipoProducto.MANUFACTURADO)
					.build();

			Producto producto2=Producto.builder()
					.precioCompra(220.00)
					.precioVenta(3030.00)
					.denominacion("Felicidad")
					.tipo(TipoProducto.MANUFACTURADO)
					.build();

			Rubro rubro1=Rubro.builder()
					.denominacion("Articulos de oficina")
					.build();

			rubro1.agregarProducto(producto1);
			rubro1.agregarProducto(producto2);

			clienteRepo.save(cliente);


			Cliente clienteRecuperado = clienteRepository.findById(cliente.getId()).orElse(null);
			if (clienteRecuperado != null){
				System.out.println("Nombre: "+ clienteRecuperado.getNombre());
				System.out.println("Apellido: "+ clienteRecuperado.getApellido());
				System.out.println("Email: "+ clienteRecuperado.getEmail());
			}


		};
	}
}



