package com.register.service.enums;
import com.register.service.utils.StringValues;


public enum Estados implements IEnumCodigo {
	
	INICIADO("IN", "iniciado", StringValues.EMPTY );
	
	
	
	private String codigo;
	private String descripcion;
	private String clave;
	
	
	

	private Estados(String codigo, String descripcion, String clave) {
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.clave = clave;
	}

	@Override
	public String getCodigo() {
		
		return this.codigo;
	}

	@Override
	public String getDescripcion() {
		
		return this.descripcion;
	}

	@Override
	public String getClave() {
		
		return this.clave;
	}

}
