package pe.com.tintegro.sigs.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pe.com.tintegro.sigs.config.ApplicationContextDAOConfig;
import pe.com.tintegro.sigs.dto.request.ObtieneTipoDocumentoRequest;
import pe.com.tintegro.sigs.dto.response.ObtieneTipoDocumentoResponse;

@RunWith( SpringJUnit4ClassRunner.class)
@ContextConfiguration( classes = { ApplicationContextDAOConfig.class} )
public class TipoDocumentoDAOTest {
	
	@Autowired
	private TipoDocumentoDAO tipoDocumentoDAO;
	
	@Test
	public void obtenerTipoDocumentoTest ()
	{
		try {
			ObtieneTipoDocumentoRequest request = new ObtieneTipoDocumentoRequest();
			ObtieneTipoDocumentoResponse respone = tipoDocumentoDAO.obtieneTipoDocumento(request);
			
			respone.getTipoDocumentoList().forEach(tipoDocumento -> {System.out.println( tipoDocumento.getID()+"/"+tipoDocumento.getValor());});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}