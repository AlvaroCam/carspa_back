package pe.com.tintegro.sigs.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pe.com.tintegro.sigs.config.ApplicationContextDAOConfig;
import pe.com.tintegro.sigs.dto.request.ListarProveedorRequest;
import pe.com.tintegro.sigs.dto.response.ListarProveedorResponse;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ApplicationContextDAOConfig.class })
public class ProveedorTest {

	@Autowired
	private ProveedorDAO proveedorDAO;

	@Test
	public void listarProveedor() {

		ListarProveedorRequest request = new ListarProveedorRequest();
		ListarProveedorResponse response = new ListarProveedorResponse();

		request.setNuPagina(1);
		request.setNuRegisMostrar(10);

		try {
			response = proveedorDAO.listarProveedor(request);

			for (int i = 0; i < response.getProveedorList().size(); i++) {
				System.out.println("--------------------");
				System.out.println(response.getProveedorList().get(i).getNombreProveedor());
				System.out.println("--------------------");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
