package models;

public final class PurchasedFruit {// NUEVA CLASE PARA PRODUCTOS COMPRADOS
	
	private final int idPurchasedFruit;
	private static int autoIdPurchasedFruit; 
	public FruitList fruitList;
	public DocumentType documentType;
	private String documentNumber;
	private float gramsPurchased;
	private float poundsPurchased;
	private float fruitValue;
	private float valueFirstDiscount;
	private float amountToBePaid;
	public static final float WEIGHT_OF_POUND = 453.5f;
	public static final byte POUNDS_NEEDED = 5;
	public static final float PERCENTAGE_DISCOUNT_TYPE_FRUIT = 0.025f;
	
	public PurchasedFruit(FruitList fruitList, float gramsPurchased, DocumentType documentType, String documentNumber) {	
		this.idPurchasedFruit   = ++autoIdPurchasedFruit;
		this.fruitList          = fruitList;
		this.documentType       = documentType;
		this.documentNumber     = documentNumber;
		this.gramsPurchased     = gramsPurchased;
		this.poundsPurchased    = this.calculatePounds(gramsPurchased);
		this.fruitValue         = this.calculateFruitValue(poundsPurchased);
		this.valueFirstDiscount = this.calculateValueFirstDiscount( poundsPurchased, fruitValue);
		this.amountToBePaid     = this.calculateAmountToBePaid(valueFirstDiscount, fruitValue);
	}
	
	public int getIdPurchasedFruit(){
		return idPurchasedFruit;
	} 
	
	public FruitList getFruitList() {
		return fruitList;
	}
	public void setFruitList(FruitList fruitList) {
		this.fruitList = fruitList;
	}
	
	public DocumentType getTypeDocument() {
		return documentType;
	}
	public void setDocumentType(DocumentType documentType) {
		this.documentType = documentType;
	}
	
	public String getDocumentNumber() {
		return documentNumber;
	}
	public void setDocumentNumber (String documentNumber) {
		this.documentNumber = documentNumber;
	}
	
	public float getGramsPurchased() {
		return gramsPurchased;
	}
	public void setGramsPurchased(float gramsPurchased) {
		this.gramsPurchased = gramsPurchased;
	}
	
	public float getPoundsPurchased() {
		return poundsPurchased;
	}
	public void setPoundsPurchased(float poundsPurchased) {
		this.poundsPurchased = poundsPurchased;
	}
	
	public float getFruitValue() {
		return fruitValue;
	}
	public void setFruitValue(float fruitValue) {
		this.fruitValue = fruitValue;
	}
	
	public float getValueFirstDiscount() {
		return valueFirstDiscount;
	}
	public void setValueFirstDiscount(float valueFirstDiscount) {
		this.valueFirstDiscount = valueFirstDiscount;
	}
	
	public float getAmountToBePaid() {
		return amountToBePaid;
	}
	public void setAmountToBePaid(float amountToBePaid) {
		this.amountToBePaid = amountToBePaid;
	}
	
	
	@Override
	public String toString() {			
		return "Fruta" + fruitList
			+"Tipo de documento" + documentType 
			+ "Numero de documento" + documentNumber 
			+ "Libras vendidas" + poundsPurchased 
			+ "Precio" + fruitValue 
			+ "Descuento" + valueFirstDiscount 
			+ "Precio total" + amountToBePaid;
	}
	
	public Object[] toObjectVector() {
		return new Object[]{getIdPurchasedFruit(),
							documentType.getTypeDocument(), 
							getDocumentNumber(),
							fruitList.getFruitName(), 
							getPoundsPurchased(), 
							getFruitValue(), 
							getValueFirstDiscount(), 
							getAmountToBePaid()};
	}
	
	
	public float calculatePounds(float gramsPurchased){
		return gramsPurchased / WEIGHT_OF_POUND;
	}
	
	
	public float calculateFruitValue(float poundsPurchased){
		return this.fruitList.getPoundPrice() * poundsPurchased;
	}
	
	
	public float calculateValueFirstDiscount(float poundsPurchased, float fruitValue){
		if ( poundsPurchased > POUNDS_NEEDED){
			return fruitValue * PERCENTAGE_DISCOUNT_TYPE_FRUIT ;
			}
		else{
			return 0;
		}
	}
	
	
	public float calculateAmountToBePaid(float valueFirstDiscount, float fruitValue){
		return fruitValue - valueFirstDiscount;
	}
}