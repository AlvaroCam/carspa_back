package pe.com.tintegro.sigs.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pe.com.tintegro.sigs.config.ApplicationContextDAOConfig;
import pe.com.tintegro.sigs.dao.ActividadDAO;
import pe.com.tintegro.sigs.dto.request.ActualizarActividadRequest;
import pe.com.tintegro.sigs.dto.response.ActualizarActividadResponse;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ApplicationContextDAOConfig.class })
public class ActividadServiceTest {
	@Autowired
	private ActividadService actividadService;
@Autowired
private ActividadDAO actividadDAO;

@Test
public void actualizarActividadService(){
	ActualizarActividadResponse response=new ActualizarActividadResponse();
	ActualizarActividadRequest request=new ActualizarActividadRequest();
	request.setIdActividad(59);
	request.setDescripcionActividad("milo");
    request.setAbreviatura("mili");
    request.setTipoProgramacion(1);
    request.setTipoActividad(1);
    request.setAmbiente(1);
    try{
    	response=actividadService.actualizarActividad(request);
    	System.out.println("Codigo de Error: " + response.getCodigoError());
		System.out.println("Estado: " + response.getEstado());
		System.out.println("Mensaje: " + response.getMensaje());
		
	
    }catch (Exception e)
	{
		e.printStackTrace();
	}
}
}
