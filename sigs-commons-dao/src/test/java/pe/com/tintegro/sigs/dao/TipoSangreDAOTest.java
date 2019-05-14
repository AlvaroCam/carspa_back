package pe.com.tintegro.sigs.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pe.com.tintegro.sigs.config.ApplicationContextDAOConfig;
import pe.com.tintegro.sigs.dto.request.ObtieneTipoSangreResquest;
import pe.com.tintegro.sigs.dto.response.ObtieneTipoSangreResponse;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes =
{ ApplicationContextDAOConfig.class })
public class TipoSangreDAOTest {

	
	@Autowired
	private TipoSangreDAO tipoSangreDAO;
	
	@Test
	public void obtenerOcupacionTest()
	{
		try
		{
			ObtieneTipoSangreResquest request = new ObtieneTipoSangreResquest();
			ObtieneTipoSangreResponse response = tipoSangreDAO.obtenerTipoSangre(request);
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
