package pe.com.tintegro.sigs.dao;

import java.math.BigDecimal;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pe.com.tintegro.sigs.config.ApplicationContextDAOConfig;
import pe.com.tintegro.sigs.dto.request.ActualizarCantidadFisicaRequest;
import pe.com.tintegro.sigs.dto.request.ActualizarEstadoAlmacenOrdenCompraRequest;
import pe.com.tintegro.sigs.dto.request.ListarAlmacenOrdenCompraMaterialRequest;
import pe.com.tintegro.sigs.dto.request.ListarAlmacenOrdenCompraRequest;
import pe.com.tintegro.sigs.dto.response.ActualizarCantidadFisicaResponse;
import pe.com.tintegro.sigs.dto.response.ActualizarEstadoAlmacenOrdenCompraResponse;
import pe.com.tintegro.sigs.dto.response.ListarAlmacenOrdenCompraMaterialResponse;
import pe.com.tintegro.sigs.dto.response.ListarAlmacenOrdenCompraResponse;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ApplicationContextDAOConfig.class })
public class AlmacenOrdenCompraDAOTest {

	@Autowired
	private AlmacenOrdenCompraDAO almacenOrdenCompraDAO;

	@Test
	@Ignore
	public void obtenerAlmacenOrdenCompra() {

		ListarAlmacenOrdenCompraRequest request = new ListarAlmacenOrdenCompraRequest();
		ListarAlmacenOrdenCompraResponse response = new ListarAlmacenOrdenCompraResponse();
		request.setIdAlmacenOrdenCompra(1);
		request.setEstado("P");
		request.setNuPagina(1);
		request.setNuRegisMostrar(10);

		try {
			System.out.println("LLEGO AQUI");
			response = almacenOrdenCompraDAO.listarAlmacenOrdenCompra(request);

			for (int i = 0; i < response.getAlmacenOrdenCompraList().size(); i++) {
				System.out.println(response.getAlmacenOrdenCompraList().get(i)
						.getIdAlmacenOrdenCompra());
				System.out.println(response.getAlmacenOrdenCompraList().get(i)
						.getDescripcionAlmacen());
				System.out.println(response.getAlmacenOrdenCompraList().get(i)
						.getIdOrdenCompra());
				System.out.println(response.getAlmacenOrdenCompraList().get(i)
						.getFecha());
				System.out.println(response.getAlmacenOrdenCompraList().get(i)
						.getEstado());
				System.out.println(response.getAlmacenOrdenCompraList().get(i)
						.getNombreProveedor());
				System.out.println(response.getAlmacenOrdenCompraList().get(i)
						.getNuTotalReg());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	@Ignore
	public void obtenerMateriales() {
		ListarAlmacenOrdenCompraMaterialResponse response = new ListarAlmacenOrdenCompraMaterialResponse();
		ListarAlmacenOrdenCompraMaterialRequest request = new ListarAlmacenOrdenCompraMaterialRequest();

		request.setIdAlmacenOrdenCompra(1);

		try {
			System.out.println("LLEGO AQUI");
			response = almacenOrdenCompraDAO
					.listarAlmacenOrdenCompraMaterial(request);

			for (int i = 0; i < response.getAlmacenOrdenCompraMaterialList()
					.size(); i++) {
				System.out.println(response.getAlmacenOrdenCompraMaterialList()
						.get(i).getIdAlmacenOrdenCompraMaterial());
				System.out.println(response.getAlmacenOrdenCompraMaterialList()
						.get(i).getIdMaterial());
				System.out.println(response.getAlmacenOrdenCompraMaterialList()
						.get(i).getNombreMaterial());
				System.out.println(response.getAlmacenOrdenCompraMaterialList()
						.get(i).getMarca());
				System.out.println(response.getAlmacenOrdenCompraMaterialList()
						.get(i).getIdAlmacenOrdenCompra());
				System.out.println(response.getAlmacenOrdenCompraMaterialList()
						.get(i).getCantidad());
				System.out.println(response.getAlmacenOrdenCompraMaterialList()
						.get(i).getCantidadFisica());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	@Ignore
	public void actualizarCantidadFisica() {
		ActualizarCantidadFisicaRequest request = new ActualizarCantidadFisicaRequest();
		ActualizarCantidadFisicaResponse response = new ActualizarCantidadFisicaResponse();

		BigDecimal b = new BigDecimal(15.50);

		request.setIdAlmacenOrdenCompraMaterial(1);
		request.setIdAlmacenOrdenCompra(1);
		request.setIdMaterial(1);
		request.setCantidadFisica(b);

		try {
			System.out.println("LLEGO AQUI");
			response = almacenOrdenCompraDAO.actualizarCantidadFisica(request);
			System.out.println(response.getConfirmacion().getId());
			System.out.println(response.getConfirmacion().getMensaje());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	@Ignore
	public void actualizarEstado() {
		ActualizarEstadoAlmacenOrdenCompraRequest request = new ActualizarEstadoAlmacenOrdenCompraRequest();
		ActualizarEstadoAlmacenOrdenCompraResponse response = new ActualizarEstadoAlmacenOrdenCompraResponse();

		request.setIdAlmacenOrdenCompra(1);

		try {
			System.out.println("LLEGO AQUI");
			response = almacenOrdenCompraDAO.actualizarEstado(request);
			System.out.println(response.getConfirmacion().getId());
			System.out.println(response.getConfirmacion().getMensaje());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
