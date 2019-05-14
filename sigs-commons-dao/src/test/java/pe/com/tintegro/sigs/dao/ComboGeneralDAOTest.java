package pe.com.tintegro.sigs.dao;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pe.com.tintegro.sigs.config.ApplicationContextDAOConfig;
import pe.com.tintegro.sigs.dto.request.ObtenerComboGeneralRequest;
import pe.com.tintegro.sigs.dto.request.ObtenerComboTipoDocumentoIdentidadRequest;
import pe.com.tintegro.sigs.dto.response.ObtenerComboGeneralResponse;
import pe.com.tintegro.sigs.dto.response.ObtenerComboTipoDocumentoIdentidadResponse;
import pe.com.tintegro.sigs.entidad.ComboGeneral;


/**
 * @author Miguel - 12 ene. 2018
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ApplicationContextDAOConfig.class })
public class ComboGeneralDAOTest
{
	@Autowired
	private ComboGeneralDAO comboGeneralDAO;

	@Test
	// @Ignore
	public void obtenerComboGeneral()
	{
		ObtenerComboGeneralResponse response = new ObtenerComboGeneralResponse();
		ObtenerComboGeneralRequest request = new ObtenerComboGeneralRequest();
		request.setIdIPRESS("0000007733");
		request.setIdGrupoOpcion("1,2,3,4,5,6,7,8,9,10,11,12,13");
		try
		{
			response = comboGeneralDAO.obtenerComboGeneral(request);
			if (response.getLsComboGeneral().size() != 0)
			{
				response.getLsComboGeneral().forEach(
						comboGeneral -> {
							System.out.println(
									"\n codigoGrupo :" + comboGeneral.getIdGrupoOpcion()+
									"\n nombreGrupo :" + comboGeneral.getValorGrupoOpcion()+
									"\n ------------------Valor opcion --------------------------");
									comboGeneral.getLsOpcionValorCombo().forEach(opcion->{
										System.out.println("\n idOpcion :" + opcion.getIdOpcion() + 
												"Opcion: "+opcion.getValorOpcion());
									});
									
						});
			}
			else
			{
				System.out.println("No se encontraron esa opcion en combo general");
			}

		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

	}
	
	@Test
	@Ignore
	public void obtenerComboTipoDocumentoTest () {
		ObtenerComboTipoDocumentoIdentidadResponse response = new ObtenerComboTipoDocumentoIdentidadResponse();
		ObtenerComboTipoDocumentoIdentidadRequest request = new ObtenerComboTipoDocumentoIdentidadRequest();
		try {
			for(ComboGeneral lsComboTipoDocumento : response.getLsComboTipoDoc()){
				System.out.println("IdDocumento:: "+ lsComboTipoDocumento.getIdTipoDocumento() + "\n DescripcionDocumento:: " + lsComboTipoDocumento.getDescripcionTipoDocumento());
			}
		} catch (Exception e){
			e.getStackTrace();
			System.out.println(e.getCause());
		}
	}
}
