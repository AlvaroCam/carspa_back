/**
 * 
 */
package pe.com.tintegro.sigs.service;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pe.com.tintegro.sigs.config.ApplicationContextDAOConfig;
import pe.com.tintegro.sigs.dto.request.ObtenerAreaEspecialidadActividadGrupoOcupacionalJRequest;
import pe.com.tintegro.sigs.dto.request.ObtenerAreaEspecialidadActividadRequest;
import pe.com.tintegro.sigs.dto.request.ObtieneAreaRequest;
import pe.com.tintegro.sigs.dto.request.ObtieneAreasRequest;
import pe.com.tintegro.sigs.dto.request.ObtieneAreasSinAlmacenRequest;
import pe.com.tintegro.sigs.dto.response.ObtenerAreaEspecialidadActividadGrupoOcupacionalJResponse;
import pe.com.tintegro.sigs.dto.response.ObtenerAreaEspecialidadActividadResponse;
import pe.com.tintegro.sigs.dto.response.ObtieneAreaResponse;
import pe.com.tintegro.sigs.dto.response.ObtieneAreasResponse;
import pe.com.tintegro.sigs.dto.response.ObtieneAreasSinAlmacenResponse;
import pe.com.tintegro.sigs.entidad.AreaEspecialidadActividadGrupoOcupacional;
import pe.com.tintegro.sigs.entidad.general.Item;

/**
 * @author daniel - 11 set. 2017
 *
 */
@RunWith( SpringJUnit4ClassRunner.class )
@ContextConfiguration( classes = { ApplicationContextDAOConfig.class } )
public class AreaServiceTest
{
	@Autowired
	private AreaService areaService;
	@Autowired
	private AreaEspecialidadActividadGrupoOcupacionalService areaEService;
	
	@Test
	@Ignore
	public void obtenerAreasTest()
	{
		ObtieneAreasRequest request = new ObtieneAreasRequest();
		request.setIdIPRESS( "gONZnF9vN/bocT+JhfnMGw==" );
		ObtieneAreasResponse response = new ObtieneAreasResponse();
		
		try
		{
			response = areaService.obtenerAreas( request );
			List<Item> areaList = response.getAreaList();
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
		request.setIdIPRESS( "gONZnF9vN/bocT+JhfnMGw==" );
		ObtieneAreaResponse response = new ObtieneAreaResponse();
		
		try
		{
			Integer idArea = null;
			request.setIdArea( idArea );
			
			response = areaService.obtenerArea( request );
			
			Item area = response.getArea();
			System.out.println( area.getValor() );
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
		ObtieneAreasSinAlmacenResponse response = new ObtieneAreasSinAlmacenResponse();
		ObtieneAreasSinAlmacenRequest request = new ObtieneAreasSinAlmacenRequest();
		request.setIdArea(null);
		request.setIdIPRESS( "gONZnF9vN/bocT+JhfnMGw==" );
		try
		{
			response = areaService.obtenerAreasSinAlmacen(request);
			System.out.println(response.getAreaList());
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
