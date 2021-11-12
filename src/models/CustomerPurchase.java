package models;

public final class CustomerPurchase {
	
	private final int idCustomerPurchase;
	private static int autoIdCustomerPurchase; 
	public DocumentType documentType;
	private String documentNumber;
	private float subtotal;
	private float valueSecondDiscount;
	private float totalAmountToPay;
	public static final int NECESSARY_VALUE= 100000;
	public static final float PERCENTAGE_DISCOUNT_TOTAL_PAY = 0.05f;
	
	public CustomerPurchase(float subtotal, DocumentType documentType, String documentNumber){	
		this.idCustomerPurchase  = ++autoIdCustomerPurchase;
		this.documentType        = documentType;
		this.documentNumber      = documentNumber;
		this.subtotal            = subtotal;
		this.valueSecondDiscount = this.calculateValueSecondDiscount(subtotal);
		this.totalAmountToPay    = this.calculateTotalAmountToPay(subtotal, valueSecondDiscount);
	}
	
	public int getIdCustomerPurchase(){
		return idCustomerPurchase;
	}
	
	public DocumentType getTypeDocument(){
		return documentType;
	}
	public void setDocumentType(DocumentType documentType){
		this.documentType = documentType;
	}
	
	public String getDocumentNumber(){
		return documentNumber;
	}
	public void setDocumentNumber (String documentNumber){
		this.documentNumber = documentNumber;
	}
	
	public float getSubtotal(){
		return subtotal;
	}
	public void setSubtotal (float subtotal){
		this.subtotal = subtotal;
	}
	
	public float getValueSecondDiscount(){
		return valueSecondDiscount;
	}
	public void setValueSecondDiscount(float valueSecondDiscount){
		this.valueSecondDiscount = valueSecondDiscount;
	}
	
	public float getTotalAmountToPay(){
		return totalAmountToPay;
	}
	public void setTotalAmountToPay(float totalAmountToPay){
		this.totalAmountToPay = totalAmountToPay;
	}
	
	
	@Override
	public String toString() {			
		return "Tipo de documento" + documentType 
			+ "Numero de documento" + documentNumber 
			+"Valor" + subtotal 
			+ "Descuento" + valueSecondDiscount 
			+ "Valor total" + totalAmountToPay;
	}
	
	public Object[] toObjectVector(){
		return new Object[]{getIdCustomerPurchase(), 
							documentType.getTypeDocument(), 
							getDocumentNumber(), 
							getSubtotal(), 
							getValueSecondDiscount(), 
							getTotalAmountToPay()};
	}
	
	
	public float calculateValueSecondDiscount(float subtotal){
		if ( subtotal > NECESSARY_VALUE ){
			return subtotal * PERCENTAGE_DISCOUNT_TOTAL_PAY ;
		}
		else {
			return 0;
		}
	}
	
	
	public float calculateTotalAmountToPay(float subtotal, float valueSecondDiscount){
		return subtotal - valueSecondDiscount;
	}
}