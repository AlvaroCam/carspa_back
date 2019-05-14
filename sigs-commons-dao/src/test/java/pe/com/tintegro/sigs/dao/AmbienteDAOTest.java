package pe.com.tintegro.sigs.dao;

import java.util.ArrayList;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pe.com.tintegro.sigs.config.ApplicationContextDAOConfig;
import pe.com.tintegro.sigs.dto.request.ActualizarAmbienteRequest;
import pe.com.tintegro.sigs.dto.request.EliminarAmbienteRequest;
import pe.com.tintegro.sigs.dto.request.InsertarAmbienteRequest;
import pe.com.tintegro.sigs.dto.request.ObtieneActividadAmbienteRequest;
import pe.com.tintegro.sigs.dto.request.ObtieneAmbienteEspecialidadRequest;
import pe.com.tintegro.sigs.dto.response.ActualizarAmbienteResponse;
import pe.com.tintegro.sigs.dto.response.EliminarAmbienteResponse;
import pe.com.tintegro.sigs.dto.response.InsertarAmbienteResponse;
import pe.com.tintegro.sigs.dto.response.ObtieneActividadAmbienteResponse;
import pe.com.tintegro.sigs.dto.response.ObtieneAmbienteEspecialidadResponse;
import pe.com.tintegro.sigs.entidad.Ambiente;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ApplicationContextDAOConfig.class })
public class AmbienteDAOTest {

	@Autowired
	private AmbienteDAO ambienteDAO;

	@Test
	@Ignore
	public void obtenerAmbienteEspecialidad() {
		ObtieneAmbienteEspecialidadRequest request = new ObtieneAmbienteEspecialidadRequest();
		ObtieneAmbienteEspecialidadResponse response = new ObtieneAmbienteEspecialidadResponse();

		request.setIdArea(1);
		request.setDescripcionAmbiente(null);
		request.setIdEspecialidad(107);
		request.setIdActividad(54);
		request.setNuPagina(1);
		request.setNuRegisMostrar(50);

		try {
			response = ambienteDAO.obtenerAmbienteEspecialidad(request);
			response.getAmbienteList().forEach(
					ambiente -> {
						System.out.println(ambiente.getIdAmbiente());
						System.out.println(ambiente.getDescripcionAmbiente());
						System.out.println(ambiente.getIdArea());
						System.out.println(ambiente.getDescripcionArea());
						System.out.println(ambiente
								.getDescripcionEspecialidadActividad());
						System.out.println("-------------------------------");
					});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	@Ignore
	public void insertaAmbiente() {
		InsertarAmbienteRequest request = new InsertarAmbienteRequest();
		InsertarAmbienteResponse response = new InsertarAmbienteResponse();

		request.setDescripcionAmbiente("PRUEBITA1");
		request.setAbreviaturaAmbiente("P1");
		request.setIdArea(1);
		request.setJsonAmbiente(null);
		request.setIdIPRESS("0000007733");

		try {
			response = ambienteDAO.insertaAmbiente(request);
			System.out.println(response.getConfirmacion().getId());
			System.out.println(response.getConfirmacion().getMensaje());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	@Ignore
	public void obtenerActividadAmbiente() {
		ObtieneActividadAmbienteRequest request = new ObtieneActividadAmbienteRequest();
		ObtieneActividadAmbienteResponse response = new ObtieneActividadAmbienteResponse();

		request.setIdArea(1);
		request.setIdEspecialidad(102);
		request.setIdIPRESS("0000007733");

		try {
			response = ambienteDAO.obtenerActividadAmbiente(request);
			response.getAmbienteList().forEach(ambiente -> {
				System.out.println(ambiente.getIdActividad());
				System.out.println(ambiente.getDescripcionActividad());
				System.out.println("-------------------------------");
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	@Ignore
	public void eliminaAmbiente() {
		EliminarAmbienteRequest request = new EliminarAmbienteRequest();
		EliminarAmbienteResponse response = new EliminarAmbienteResponse();

		request.setIdAmbiente(252);
		try {
			response = ambienteDAO.eliminaAmbiente(request);
			System.out.println(response.getConfirmacion().getId());
			System.out.println(response.getConfirmacion().getMensaje());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void actualizarAmbiente() {
		ActualizarAmbienteRequest request = new ActualizarAmbienteRequest();
		ActualizarAmbienteResponse response = new ActualizarAmbienteResponse();
		
		request.setIdAmbiente(270);
		request.setDescripcionAmbiente("NEW AMBIENTE REGIS NEW NEW");
		request.setAbreviaturaAmbiente("NARNN");
		request.setIdArea(1);
		
		Ambiente a = new Ambiente();
		a.setIdEspecialidad(102);
		a.setIdActividad(29);
		
		List<Ambiente> amList = new ArrayList<Ambiente>();
		amList.add(a);
		request.setAmbienteList(amList);
		
		request.setIdIPRESS("0000007733");

		try {
			response = ambienteDAO.actualizarAmbiente(request);
			System.out.println(response.getConfirmacion().getId());
			System.out.println(response.getConfirmacion().getMensaje());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
