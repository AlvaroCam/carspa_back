/**
 * 
 */
package pe.com.tintegro.sigs.dao;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pe.com.tintegro.sigs.config.ApplicationContextDAOConfig;
import pe.com.tintegro.sigs.dto.request.ObtieneTurnoRequest;
import pe.com.tintegro.sigs.entidad.general.Item;
import pe.com.tintegro.sigs.mapper.TurnoMapper;

@RunWith( SpringJUnit4ClassRunner.class )
@ContextConfiguration( classes = { ApplicationContextDAOConfig.class } )
public class TurnoDAOTest
{
	@Autowired
	private TurnoMapper turnoMapper;
	
	@Test
	public void obtenerPersonalesTest()
	{
		ObtieneTurnoRequest request = new ObtieneTurnoRequest();
		
		request.setIdActividad(16);
		
		try{
			List<Item> turnoList = turnoMapper.obtenerTurnos(request.getIdTurno(),request.getIdActividad());
			turnoList.forEach( a -> {
				System.out.println( "ID : " + a.getID()+" "+
									"descripction : "+ a.getValor());
			});
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
