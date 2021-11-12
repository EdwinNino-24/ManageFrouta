package models;

public class FruitList {
	
	private final int idFruitList;
	private static int autoIdFruitList;
	private String fruitName;
    private float poundPrice;
	public static final float WEIGHT_OF_POUND = 453.5f;
	
	public FruitList( String fruitName, float poundPrice) {
		this.idFruitList = autoIdFruitList++;
		this.fruitName   = fruitName;
		this.poundPrice  = poundPrice;
	}

	public int getIdFruitList(){
		return idFruitList;
	} 
	
	public String getFruitName() {
		return fruitName;
	}
	public void setFruitName(String fruitName) {
		this.fruitName = fruitName;
	}
	
	public float getPoundPrice() {
		return poundPrice;
	}
	public void setPoundPrice(float poundPrice) {
		this.poundPrice=poundPrice;
	}
	
	
	@Override
	public String toString() {
		return "Tipo de Fruta" + fruitName
			+ "Precio de Libra" + poundPrice;
	}
	
	public Object[] toObjectVector() {
		return new Object[] {getIdFruitList(),
							getFruitName(), 
							getPoundPrice(), 
							this.getGramPrice()};
	}	
	
	
	public float getGramPrice(){
		return poundPrice/WEIGHT_OF_POUND;
	}
}