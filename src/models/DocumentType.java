package models;

public enum DocumentType {
	IDENTITY_CARD("TARJETA DE IDENTIDAD"),
	CITIZENSHIP_CARD("CEDULA DE CIUDADANIA"),
	FOREIGNER_ID("CEDULA DE EXTRANJERIA"),
	PASSPORT("PASAPORTE");
			
	private final String typeDocument;
			
	DocumentType(String typeDocument){
	     this.typeDocument = typeDocument;
	}
	
	public String getTypeDocument() {
		return this.typeDocument;
	}
}
