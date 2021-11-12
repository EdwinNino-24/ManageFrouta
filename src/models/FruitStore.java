package models;


public class FruitStore {
	
	private final FruitList        [] fruitList;
	private final FruitList        [] listOfRemovedFruits;
	private final FruitList        [] fruitHistory;
	private final PurchasedFruit   [] customerShoppingList;
	private final PurchasedFruit   [] greengrocerSalesList; 
	private final PurchasedFruit   [] firstDiscountList; 
	private final CustomerPurchase [] generalSalesList;
	private final CustomerPurchase [] secondDiscountList;
	
	public FruitStore() {
		fruitList            = new FruitList[50];
		listOfRemovedFruits  = new FruitList[50];
		fruitHistory         = new FruitList[50];
		customerShoppingList = new PurchasedFruit[50];
		greengrocerSalesList = new PurchasedFruit[50];
		firstDiscountList    = new PurchasedFruit[50];
		generalSalesList     = new CustomerPurchase[50];
		secondDiscountList   = new CustomerPurchase[50];
	}
	
	public boolean addFruit(FruitList fruitObj) {
		for (int i = 0; i < fruitList.length; i++) {
			if ( fruitList[i] == null ) {
				fruitList[i] = fruitObj;
				this.addFruitToAddedList(fruitList[i]);
				return true;
			}
		}
		return false;		
	}
	
	public boolean modifyFruit(int idFruitToModify, float newPoundPrice) {
            for (FruitList fruitList1 : fruitList) {
                if (fruitList1.getIdFruitList() == idFruitToModify) {
                    fruitList1.setPoundPrice(newPoundPrice);
                    return true;
                }
            }
		return false;		
	}
	
	public boolean removeFruit(int idFruitToRemove) {
		for (int i = 0; i < fruitList.length; i++) {
			if ( fruitList[i].getIdFruitList() == idFruitToRemove ) {
				this.addFruitToRemovedList(fruitList[i]);
				fruitList[i] = null;
				return true;
			}
		}
		return false;		
	}
	
	public FruitList getFruitId(int fruitId) {
            for (FruitList fruitList1 : fruitList) {
                if (fruitList1.getIdFruitList() == fruitId) {
                    return fruitList1;
                }
            }
		return null;		
	}
	
	public int getSizeFruitList() {
		int counter = 0;
            for (FruitList fruitList1 : fruitList) {
                if (fruitList1 != null) {
                    counter++;
                }
            }
		return counter;
	}
	
	public FruitList[] toMatrixVectorFruitList(){
		FruitList[] datasMatrix = new FruitList[getSizeFruitList()];
		if ( getSizeFruitList() > 0 ) {
			int counter = 0;
                    for (FruitList fruitList1 : fruitList) {
                        if (fruitList1 != null) {
                            datasMatrix[counter] = fruitList1;
                            counter++;
                        }
                    }
		}
		return datasMatrix;
	}
	
	
	public boolean addPurchasedFruit(PurchasedFruit fruitObj) {// Método que llena el vector con los productos comprados
		for (int i = 0; i < greengrocerSalesList.length; i++) {
			if ( greengrocerSalesList[i] == null ) {
				greengrocerSalesList[i] = fruitObj;
				customerShoppingList[i] = fruitObj;
				firstDiscountList[i]    = fruitObj;
				return true;
			}
		}
		return false;		
	}
	
	public int getSizeListPurchased() {
	int counter = 0;
            for (PurchasedFruit greengrocerSalesList1 : greengrocerSalesList) {
                if (greengrocerSalesList1 != null) {
                    counter++;
                }
            }
		return counter;
	}
	
	public PurchasedFruit[] toMatrixVectorFruitStoreSalesGeneral(){
		PurchasedFruit[] datasMatrix = new PurchasedFruit[getSizeListPurchased()];
		if ( getSizeListPurchased() > 0 ) {
			int counter = 0;
                    for (PurchasedFruit greengrocerSalesList1 : greengrocerSalesList) {
                        if (greengrocerSalesList1 != null) {
                            datasMatrix[counter] = greengrocerSalesList1;
                            counter++;
                        }
                    }
		}
		return datasMatrix;
	}
	
	
	public int getSizeListClient() {
	int counter = 0;
            for (PurchasedFruit customerShoppingList1 : customerShoppingList) {
                if (customerShoppingList1 != null) {
                    counter++;
                }
            }
		return counter;
	}
	
	public void resetFruitListClient(){
		for(int i = 0; i < customerShoppingList.length; i++){
			customerShoppingList[i] = null;
		}
	}

	public PurchasedFruit[] toMatrixVectorFruitListClient(){
		PurchasedFruit[] datasMatrix = new PurchasedFruit[getSizeListClient()];
		if ( getSizeListClient() > 0 ) {
			int counter = 0;
                    for (PurchasedFruit customerShoppingList1 : customerShoppingList) {
                        if (customerShoppingList1 != null) {
                            datasMatrix[counter] = customerShoppingList1;
                            counter++;
                        }
                    }
		}
		return datasMatrix;
	}
	
	
	public int getSizeFirstDiscountList() {
	int counter = 0;
            for (PurchasedFruit firstDiscountList1 : firstDiscountList) {
                if (firstDiscountList1 != null) {
                    counter++;
                }
            }
		return counter;
	}
	
	public PurchasedFruit[] toMatrixVectorFirstDiscount(){
		PurchasedFruit[] datasMatrix = new PurchasedFruit[getSizeFirstDiscountList()];
		if ( getSizeFirstDiscountList() > 0 ) {
			int counter = 0;
                    for (PurchasedFruit firstDiscountList1 : firstDiscountList) {
                        if (firstDiscountList1 != null) {
                            datasMatrix[counter] = firstDiscountList1;
                            counter++;
                        }
                    }
		}
		return datasMatrix;
	}
	
	
	
	public boolean addCustomerPurchase(CustomerPurchase fruitObj) {
		for (int i = 0; i < generalSalesList.length; i++) {
			if ( generalSalesList[i] == null ) {
				generalSalesList[i] = fruitObj;
				secondDiscountList[i] = fruitObj;
				return true;
			}
		}
		return false;		
	}
	
	public int getSizeSalesList() {
	int counter = 0;
            for (CustomerPurchase generalSalesList1 : generalSalesList) {
                if (generalSalesList1 != null) {
                    counter++;
                }
            }
		return counter;
	}
	
	public CustomerPurchase[] toMatrixVectorPurchase(){
		CustomerPurchase[] datasMatrix = new CustomerPurchase[getSizeSalesList()];
		if ( getSizeSalesList() > 0 ) {
			int counter = 0;
                    for (CustomerPurchase generalSalesList1 : generalSalesList) {
                        if (generalSalesList1 != null) {
                            datasMatrix[counter] = generalSalesList1;
                        }
                        counter++;
                    }
		}
		return datasMatrix;
	}
	
	
	public int getSizeSecondDiscountList() {
	int counter = 0;
            for (CustomerPurchase secondDiscountList1 : secondDiscountList) {
                if (secondDiscountList1 != null) {
                    counter++;
                }
            }
		return counter;
	}
	
	public CustomerPurchase[] toMatrixVectorSecondDiscount(){
		CustomerPurchase[] datasMatrix = new CustomerPurchase[getSizeSecondDiscountList()];
		if ( getSizeSecondDiscountList() > 0 ) {
			int counter = 0;
                    for (CustomerPurchase secondDiscountList1 : secondDiscountList) {
                        if (secondDiscountList1 != null) {
                            datasMatrix[counter] = secondDiscountList1;
                        }
                        counter++;
                    }
		}
		return datasMatrix;
	}
	
	
	private boolean addFruitToRemovedList(FruitList getSizeListAddedFruit) {
		for (int i = 0; i < listOfRemovedFruits.length; i++) {
			if ( listOfRemovedFruits[i] == null ) {
				listOfRemovedFruits[i] = getSizeListAddedFruit;
				return true;
			}
		}
		return false;		
	}
	
	public int getSizeListRemoved() {
	int counter = 0;
            for (FruitList listOfRemovedFruit : listOfRemovedFruits) {
                if (listOfRemovedFruit != null) {
                    counter++;
                }
            }
		return counter;
	}
	
	public FruitList[] toMatrixVectorRemoved(){
		FruitList[] datasMatrix = new FruitList[getSizeListRemoved()];
		if ( getSizeListRemoved() > 0 ) {
			int counter = 0;
                    for (FruitList listOfRemovedFruit : listOfRemovedFruits) {
                        if (listOfRemovedFruit != null) {
                            datasMatrix[counter] = listOfRemovedFruit;
                        }
                        counter++;
                    }
		}
		return datasMatrix;
	}
	
	
	
	private boolean addFruitToAddedList(FruitList fruitObj) {
		for (int i = 0; i < fruitHistory.length; i++) {
			if ( fruitHistory[i] == null ) {
				fruitHistory[i] = fruitObj;
				return true;
			}
		}
		return false;		
	}
	
	public int getSizeListAddedFruit() {
	int counter = 0;
            for (FruitList fruitHistory1 : fruitHistory) {
                if (fruitHistory1 != null) {
                    counter++;
                }
            }
		return counter;
	}
	
	public FruitList[] toMatrixVectorAddedFruit(){
		FruitList[] datasMatrix = new FruitList[getSizeListAddedFruit()];
		if ( getSizeListAddedFruit() > 0 ) {
			int counter = 0;
                    for (FruitList fruitHistory1 : fruitHistory) {
                        if (fruitHistory1 != null) {
                            datasMatrix[counter] = fruitHistory1;
                        }
                        counter++;
                    }
		}
		return datasMatrix;
	}
}
