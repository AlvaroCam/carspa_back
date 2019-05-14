package pe.com.tintegro.sigs.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pe.com.tintegro.sigs.config.ApplicationContextDAOConfig;
import pe.com.tintegro.sigs.dao.TipoSangreDAO;
import pe.com.tintegro.sigs.dto.request.ObtieneTipoSangreResquest;
import pe.com.tintegro.sigs.dto.response.ObtieneTipoSangreResponse;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes =
{ ApplicationContextDAOConfig.class })
public class TipoSangreServiceTest {


	@Autowired
	private TipoSangreService tipoSangreService;
	
	@Test
	public void obtenerSangreTest()
	{
		try
		{
			ObtieneTipoSangreResquest request = new ObtieneTipoSangreResquest();
//			request.setCodUsuario("sdasdasdsa");
//			request.setIdIPRESS("sdassasdsd");
			ObtieneTipoSangreResponse response = tipoSangreService.obtenerTipoSangre(request);
			response.getTipoSangre().forEach(a ->
			{
				System.out.print(a.getID());
				System.out.println(a.getValor());
			});
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
