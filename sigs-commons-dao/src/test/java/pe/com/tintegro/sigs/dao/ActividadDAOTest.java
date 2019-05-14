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
import pe.com.tintegro.sigs.dto.request.ActualizarActividadRequest;
import pe.com.tintegro.sigs.dto.request.EliminarActividadRequest;
import pe.com.tintegro.sigs.dto.request.EliminarSubActividadRequest;
import pe.com.tintegro.sigs.dto.request.InsertarActividadRequest;
import pe.com.tintegro.sigs.dto.request.InsertarSubActvidadesRequest;
import pe.com.tintegro.sigs.dto.request.ObtenerActividadDescripcionRequest;
import pe.com.tintegro.sigs.dto.request.ObtenerSubActividadesRequest;
import pe.com.tintegro.sigs.dto.request.ObtieneActividadRequest;
import pe.com.tintegro.sigs.dto.request.ObtieneActividadesRequest;
import pe.com.tintegro.sigs.dto.request.ObtieneSubActividadRequest;
import pe.com.tintegro.sigs.dto.request.ObtieneSubActividadesRequest;
import pe.com.tintegro.sigs.dto.response.ActualizarActividadResponse;
import pe.com.tintegro.sigs.dto.response.EliminarActividadResponse;
import pe.com.tintegro.sigs.dto.response.EliminarSubActividadResponse;
import pe.com.tintegro.sigs.dto.response.InsertarActividadResponse;
import pe.com.tintegro.sigs.dto.response.InsertarSubActividadesResponse;
import pe.com.tintegro.sigs.dto.response.ObtenerActividadDescripcionResponse;
import pe.com.tintegro.sigs.dto.response.ObtenerSubActividadResponse;
import pe.com.tintegro.sigs.entidad.Actividad;
import pe.com.tintegro.sigs.entidad.general.Confirmacion;
import pe.com.tintegro.sigs.entidad.general.Item;

/**
 * @author daniel - 12 set. 2017
 *
 */
@RunWith( SpringJUnit4ClassRunner.class )
@ContextConfiguration( classes = { ApplicationContextDAOConfig.class } )
public class ActividadDAOTest
{
	@Autowired
	private ActividadDAO actividadDAO;
	
	@Test
	@Ignore
	public void obtenerActividadesTest()
	{
		ObtieneActividadesRequest request = new ObtieneActividadesRequest();
		request.setIdIPRESS( "0000007733" );
		request.setIdArea( 1 );
		request.setIdEspecialidad( 1 );
		
		try
		{
			List<Item> actividadList = actividadDAO.obtenerActividades( request.getIdIPRESS(), request.getIdArea(), request.getIdEspecialidad(), null );
			actividadList.forEach( actividad -> { System.out.println( String.format( "%d %s", actividad.getID(), actividad.getValor() ) ); } );
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	@Test
	@Ignore
	public void obtenerActividadTest()
	{
		ObtieneActividadRequest request = new ObtieneActividadRequest();
		request.setIdIPRESS( "0000007733" );
		request.setIdArea( 1 );
		request.setIdEspecialidad( 1 );
		request.setIdActividad( 1 );
		
      try
		{
			List<Item> actividadList = actividadDAO.obtenerActividades( request.getIdIPRESS(), request.getIdArea(), request.getIdEspecialidad(), request.getIdActividad() );
			Item actividad = actividadList.isEmpty() ? null : actividadList.get( 0 );
			
			if( actividad != null )
			{
				System.out.println( String.format( "%d %s", actividad.getID(), actividad.getValor() ) );
			}
			else
			{
				System.out.println( "Actividad no encontrada." );
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}				
	}
	
	@Test
	@Ignore
	public void obtenerSubActividadesTest()
	{
		ObtieneSubActividadesRequest request = new ObtieneSubActividadesRequest();
		request.setIdIPRESS( "0000007733" );
		request.setIdArea( 1 );
		request.setIdEspecialidad( 1 );
		request.setIdActividad( 1 );
		
		try
		{
			List<Item> subActividadList = actividadDAO.obtenerSubActividades( request.getIdIPRESS(), request.getIdArea(), request.getIdEspecialidad(), request.getIdActividad(), null );
			subActividadList.forEach( subActividad -> { System.out.println( String.format( "%d %s", subActividad.getID(), subActividad.getValor() ) ); } );
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	@Test
	@Ignore
	public void obtenerSubActividad()
	{
		ObtieneSubActividadRequest request = new ObtieneSubActividadRequest();
		request.setIdIPRESS( "0000007733" );
		request.setIdArea( 1 );
		request.setIdEspecialidad( 1 );
		request.setIdActividad( 1 );
		request.setIdSubActividad( 1 );
		
		try
		{
			List<Item> subActividadList = actividadDAO.obtenerSubActividades( request.getIdIPRESS(), request.getIdArea(), request.getIdEspecialidad(), request.getIdActividad(), request.getIdSubActividad() );
			Item subActividad = subActividadList.isEmpty() ? null : subActividadList.get( 0 );
			
			if( subActividad != null )
			{
				System.out.println( String.format( "ID: %d Subactividad: %s", subActividad.getID(), subActividad.getValor() ) );
			}
			else
			{
				System.out.println( "Subactividad no encontrada." );
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	//Agregado
	@Test
	@Ignore
	public void insertarActividad () {
		InsertarActividadRequest request = new InsertarActividadRequest();
		InsertarActividadResponse response = new InsertarActividadResponse();
		request.setDescripcionActividad("cesarbarreto");
		request.setAbreviatura("cbh");
		request.setTipoProgramacion(1);
		request.setTipoActividad(2);
		request.setAmbiente("1");
		
		try {
			response = actividadDAO.insertarActividad(request);
			System.out.println(response.getConfirmacion().getId());
			System.out.println(response.getConfirmacion().getMensaje());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	//@Ignore
	public void obtenerActividadDescripcion() {
		ObtenerActividadDescripcionResponse response = new ObtenerActividadDescripcionResponse();
		ObtenerActividadDescripcionRequest request = new ObtenerActividadDescripcionRequest();
		
		request.setDescripcionActividad(null);
		request.setNuPagina(1);
		request.setNuRegisMostrar(100);
		
		try {
			response = actividadDAO.obtenerActividadDescripcion(request);
			//System.out.println(response.getActividadList().toString());
			if(response.getActividadList().size() !=0) {
				response.getActividadList().forEach(
						actividadDescripcion -> {
							System.out.println("ID: "+actividadDescripcion.getIdActividad()+
									", Nombre: "+actividadDescripcion.getDescripcionActividad()+
									", Abreviatura: "+actividadDescripcion.getAbreviatura()+
									", Tipo Programación: "+actividadDescripcion.getTipoProgramacion()+
									", Tipo Actividad: "+actividadDescripcion.getTipoActividad()+
									",  Ambiente:"+actividadDescripcion.getAmbiente());
					                
						});
			} else {
				System.out.println("No se encontro la Actividad buscada.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	@Ignore
	public void eliminarActividad() {
		EliminarActividadResponse response = new EliminarActividadResponse();
		EliminarActividadRequest request = new EliminarActividadRequest();
		
		request.setIdActividad(98);
		
		try {
			response = actividadDAO.eliminarActividad(request);
			System.out.println(response.getConfirmacion().getId());
			System.out.println(response.getConfirmacion().getMensaje());
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getCause());
		}
	}
	
	@Test
	@Ignore
	public void ObtenerSubActividad() {
		
		ObtenerSubActividadResponse response = new ObtenerSubActividadResponse();
		ObtenerSubActividadesRequest request = new ObtenerSubActividadesRequest();
		request.setDescripcionSubActividad("vaca");
		request.setNumPagina(1);
		request.setNumRegisMostrar(20);
		try {
			response = actividadDAO.obtenerSubActividad(request);
			for (int i = 0; i < response.getSubActividadList().size(); i++) {
					//System.out.println(response.getSubActividadList().size());
					if (response.getSubActividadList()!=null ) {
						System.out.println(response.getSubActividadList().get(i).getIdSubActividad());
						System.out.println(response.getSubActividadList().get(i).getDescripcionSubActividad());
					System.out.println(response.getSubActividadList().get(i).getAbreviatura());
					System.out.println(response.getSubActividadList().get(i).getActividad().getDescripcionActividad());
					System.out.println("------------------------------------------------");
		} else {  
				System.out.println("nada");
				}
			}
		}

		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	@Ignore
	public void IngresarSubActividad(){
		InsertarSubActividadesResponse response = new InsertarSubActividadesResponse();
		InsertarSubActvidadesRequest request = new InsertarSubActvidadesRequest();
		request.setDescripcionSubActividad("mmmm");
		request.setAbreviatura("mm");
		Actividad actividad = new Actividad();
		actividad.setIdActividad(59);		
		request.setActividad(actividad);
		//request.setIdActividad(57);
	
		try {
			response = actividadDAO.insertarSubActividad(request);
			System.out.print(response.getConfirmacion().getId());
			System.out.print(response.getConfirmacion().getMensaje());
						
			}

		catch (Exception e) 
			{
			e.printStackTrace();
			}
		
										}
	@Test
	@Ignore
	public void EliminarSubActividad(){
		EliminarSubActividadResponse response = new EliminarSubActividadResponse();
		EliminarSubActividadRequest request = new EliminarSubActividadRequest();
		request.setIdSubActividad(311);
		
		try {
			response = actividadDAO.eliminarSubActividad(request);
			System.out.print(response.getConfirmacion().getId());
			System.out.print(response.getConfirmacion().getMensaje());
			}

		catch (Exception e) 
			{
			e.printStackTrace();
			}
		
										}
	/////////////////////////////////////////////////////////////////////////////////////
	@Test
	@Ignore
	public void ActualizarActividad(){
		ActualizarActividadResponse response= new ActualizarActividadResponse();
		ActualizarActividadRequest request= new ActualizarActividadRequest();
		request.setIdActividad(59);
        request.setDescripcionActividad("milagros");	
        request.setAbreviatura("t");
        request.setTipoProgramacion(1);
        request.setTipoActividad(1);
        request.setAmbiente(0);
        
        try{
        	response=actividadDAO.actualizarActividad(request);
        	System.out.println(response.getConfirmacion().getId());
			System.out.println(response.getConfirmacion().getMensaje());
        }catch (Exception e) {
			e.printStackTrace();
		}
        
	}


	
}
