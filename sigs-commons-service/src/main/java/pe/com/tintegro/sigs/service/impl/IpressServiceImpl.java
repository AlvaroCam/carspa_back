package pe.com.tintegro.sigs.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.tintegro.sigs.dao.IpressDAO;
import pe.com.tintegro.sigs.dto.request.ObtenerComboIpressByUsuarioRequest;
import pe.com.tintegro.sigs.dto.response.ObtenerComboIpressByUsuarioResponse;
import pe.com.tintegro.sigs.service.IpressService;
import pe.com.tintegro.sigs.util.EncriptacionUtil;

@Service("ipressService")
public class IpressServiceImpl implements IpressService{
	
	@Autowired
	private IpressDAO ipressDAO;
	
	@Override
	public ObtenerComboIpressByUsuarioResponse obtenerIpress(
			ObtenerComboIpressByUsuarioRequest request) throws Exception {
		ObtenerComboIpressByUsuarioResponse response = ipressDAO.obtenerIpress(request);
		for(int i=0; i<response.getIpress().size();i++){
			response.getIpress().get(i).setIdIPRESS(EncriptacionUtil.encriptar(response.getIpress().get(i).getIdIPRESS()));
			response.getIpress().get(i).setIdPersonal(EncriptacionUtil.encriptar(response.getIpress().get(i).getIdPersonal()));
		}
		return response;
	}

}
