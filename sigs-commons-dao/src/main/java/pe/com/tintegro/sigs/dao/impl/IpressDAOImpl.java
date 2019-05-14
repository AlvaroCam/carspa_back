package pe.com.tintegro.sigs.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pe.com.tintegro.sigs.dao.IpressDAO;
import pe.com.tintegro.sigs.dto.request.ObtenerComboIpressByUsuarioRequest;
import pe.com.tintegro.sigs.dto.response.ObtenerComboIpressByUsuarioResponse;
import pe.com.tintegro.sigs.entidad.Ipress;
import pe.com.tintegro.sigs.mapper.IpressMapper;

@Repository("ipressDAO")
public class IpressDAOImpl implements IpressDAO{
	
	@Autowired
	private IpressMapper ipressMapper;
	
	@Override
	public ObtenerComboIpressByUsuarioResponse obtenerIpress(
			ObtenerComboIpressByUsuarioRequest request) throws Exception {
		ObtenerComboIpressByUsuarioResponse response = new ObtenerComboIpressByUsuarioResponse();
		List<Ipress> listIpress = ipressMapper.obtenerIpress(request.getCodUsuario());
		response.setIpress(listIpress);
		return response;
	}

}
