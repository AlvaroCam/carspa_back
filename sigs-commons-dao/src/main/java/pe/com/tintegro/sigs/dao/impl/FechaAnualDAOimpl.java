package pe.com.tintegro.sigs.dao.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pe.com.tintegro.sigs.dao.FechaAnualDAO;
import pe.com.tintegro.sigs.dto.request.ObtieneFechaRequest;
import pe.com.tintegro.sigs.dto.response.ObtieneFechaResponse;
import pe.com.tintegro.sigs.entidad.general.Item;

@Transactional
@Repository("fechaAnualDAO")
public class FechaAnualDAOimpl implements FechaAnualDAO
{

	@Override
	public ObtieneFechaResponse obtieneFecha(ObtieneFechaRequest request) throws Exception
	{
		ObtieneFechaResponse response = new ObtieneFechaResponse();
		List<Item> itemPro = new ArrayList<Item>();
		Calendar fecha = Calendar.getInstance();
		int fechaActual;
		fechaActual = fecha.get(Calendar.YEAR);
		for (int i = request.getInferiorFecha(); i < fechaActual + 1; i++)
		{
			Item var = new Item();
			var.setID(i);
			var.setValor(String.valueOf(i));
			itemPro.add(var);
		}
		response.setLsFechaGeneradas(itemPro);
		return response;
	}
}
