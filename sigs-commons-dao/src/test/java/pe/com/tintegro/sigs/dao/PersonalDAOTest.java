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
import pe.com.tintegro.sigs.dto.request.ObtienePersonalesRequest;
import pe.com.tintegro.sigs.entidad.Personal;

/**
 * @author daniel - 18 set. 2017
 *
 */
@RunWith( SpringJUnit4ClassRunner.class )
@ContextConfiguration( classes = { ApplicationContextDAOConfig.class } )
public class PersonalDAOTest
{
	@Autowired
	private PersonalDAO personalDAO;
	
	@Test
	public void obtenerPersonalesTest()
	{
		ObtienePersonalesRequest request = new ObtienePersonalesRequest();
		request.setIdArea( 1 );
		request.setIdEspecialidad( 17 );
		request.setIdActividad( 17 );
		request.setIdSubActividad( 4 );
		request.setIdIPRESS("0000007733");
		
//		System.out.println(request.getIdPersonal());
//		System.out.println(request.getIdIPRESS());
//		System.out.println(request.getIdArea());
//		System.out.println(request.getIdEspecialidad());
//		System.out.println(request.getIdActividad());
//		System.out.println(request.getIdSubActividad());
		
		try
		{
			List<Personal> personalList = personalDAO.obtenerPersonales( request.getIdIPRESS(), 
																		 request.getIdArea(), 
																		 request.getIdEspecialidad(), 
																		 request.getIdActividad(), 
																		 request.getIdSubActividad(), 
																		 request.getIdPersonal() );
			personalList.forEach( a -> {
				System.out.println( "idPersonal: " + a.getIdPersonal()+" "+
									"nombre: "+ a.getNombre()+" "+
									"sexo: "+ a.getSexo().getID()+ " "+	
									"descSexo: "+ a.getSexo().getValor());
			});
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
