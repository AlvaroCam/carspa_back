/**
 * 
 */
package pe.com.tintegro.sigs.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pe.com.tintegro.sigs.config.ApplicationContextDAOConfig;
import pe.com.tintegro.sigs.dto.request.ObtenerAreaEspecialidadActividadRequest;
import pe.com.tintegro.sigs.dto.request.ObtieneAreaRequest;
import pe.com.tintegro.sigs.dto.request.ObtieneAreasRequest;
import pe.com.tintegro.sigs.dto.request.ObtieneAreasSinAlmacenRequest;
import pe.com.tintegro.sigs.dto.response.ObtenerAreaEspecialidadActividadResponse;
import pe.com.tintegro.sigs.dto.response.ObtieneAreasSinAlmacenResponse;
import pe.com.tintegro.sigs.entidad.general.Item;

/**
 * @author daniel - 11 set. 2017
 *
 */
@RunWith( SpringJUnit4ClassRunner.class )
@ContextConfiguration( classes = { ApplicationContextDAOConfig.class } )
public class AreaDAOTest
{
	@Autowired
	private AreaDAO areaDAO;
	
	@Test
	@Ignore
	public void obtenerAreasTest()
	{
		ObtieneAreasRequest request = new ObtieneAreasRequest();
		request.setIdIPRESS( "0000007733" );
		
		try
		{
			List<Item> areaList = areaDAO.obtenerAreas( request.getIdIPRESS(), null, request.getCodUsuario() );
			areaList.forEach( area -> {
				System.out.println( area.getValor() );
			});
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	@Test
	@Ignore
	public void obtenerAreaTest()
	{
		ObtieneAreaRequest request = new ObtieneAreaRequest();
		request.setIdIPRESS( "0000007733" );
		
		try
		{
			Integer idArea = 2;
			request.setIdArea( idArea );
			
			List<Item> areaList = areaDAO.obtenerAreas( request.getIdIPRESS(), request.getIdArea(), request.getCodUsuario());
			Item area = areaList.isEmpty() ? null : areaList.get( 0 );
			
			if( area != null )
			{
				System.out.println( area.getValor() );
			}
			else
			{
				System.out.println( "Área no encontrada." );
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	@Test
	@Ignore
	public void obtenerAreasSinAlmacen()
	{
		ObtieneAreasSinAlmacenRequest request = new ObtieneAreasSinAlmacenRequest();
		ObtieneAreasSinAlmacenResponse response = new ObtieneAreasSinAlmacenResponse();
		request.setIdArea(1);
		try
		{
			response = areaDAO.obtenerAreasSinAlmacen(request);
			System.out.println(response.getAreaList().toString());
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
