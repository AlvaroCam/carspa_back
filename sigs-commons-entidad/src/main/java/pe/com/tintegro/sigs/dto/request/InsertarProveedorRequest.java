package pe.com.tintegro.sigs.dto.request;

public class InsertarProveedorRequest {
	private String nombreProveedor;
	private String direccion;
	private String email;
	private String telefono;
	private String contacto;
	private  Integer idTipoPago;
	
	
	public String getNombreProveedor() {
		return nombreProveedor;
	}
	public void setNombreProveedor(String nombreProveedor) {
		this.nombreProveedor = nombreProveedor;
	}
	
	public String getDireccion() {
		return direccion;
	}
	public void setNombreDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	
	public String getContacto() {
		return contacto;
	}
	public void setContacto(String contacto) {
		this.contacto = contacto;
	}
	
	public Integer getIdTipoPago() {
		return idTipoPago;
	}
	public void setIdTipoPago(Integer idTipoPago) {
		this.idTipoPago = idTipoPago;
	}
}
