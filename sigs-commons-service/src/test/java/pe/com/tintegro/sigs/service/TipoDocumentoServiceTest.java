package pe.com.tintegro.sigs.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pe.com.tintegro.sigs.config.ApplicationContextDAOConfig;
import pe.com.tintegro.sigs.dto.request.ObtieneTipoDocumentoRequest;
import pe.com.tintegro.sigs.dto.response.ObtieneTipoDocumentoResponse;
import pe.com.tintegro.sigs.entidad.general.Item;

@RunWith( SpringJUnit4ClassRunner.class )
@ContextConfiguration( classes = { ApplicationContextDAOConfig.class } )
public class TipoDocumentoServiceTest {
	
	@Autowired
	private TipoDocumentoService tipoDocumentoService;

	@Test
	public void obtenerTipoDocumentoTest() {
		ObtieneTipoDocumentoRequest request = new ObtieneTipoDocumentoRequest();
		ObtieneTipoDocumentoResponse response = new ObtieneTipoDocumentoResponse();
		
		try {
			response = tipoDocumentoService.obtenerTipoDocumento(request);
			List<Item> tipoDocumentoList = response.getTipoDocumentoList();
			tipoDocumentoList.forEach((a) -> {
				System.out.println( a.getID());
				System.out.println( a.getValor());
			});
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
}
