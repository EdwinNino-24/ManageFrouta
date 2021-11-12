package presenters;

import java.time.LocalTime;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import models.CustomerPurchase;
import models.DocumentType;
import models.FruitList;
import models.FruitStore;
import models.PurchasedFruit;
import views.Console;

public class PresenterApp {
	
	private final FruitStore fruitStore;
	private final Console console;
	
	private static final String DEFAULT_USER     = "NIKO BELLIC";
	private static final String DEFAULT_PASSWORD = "HUERTO2404";
	private static final String OPTION_ONE       = "1";
	private static final String OPTION_TWO       = "2";
	private static final String OPTION_THREE     = "3";
	private static final String OPTION_FOUR      = "4";
	private static final String OPTION_FIVE      = "5";
	private static final String OPTION_SIX       = "6";
	private static final String OPTION_SEVEN     = "7";
	
	public PresenterApp() {
		fruitStore = new FruitStore();
		console    = new Console();
		printFruitList();
		login();
	}
	
	private void login(){
		boolean access;
		do{
			String username = console.readUsername();
			String userpassword = console.readUserPassword();
			
			if((username.equals(DEFAULT_USER)) && (userpassword.equals(DEFAULT_PASSWORD))){
				access=true;
				console.showLoginSuccess();
				openMenu();
			}
			else{
				console.showLoginFail();
				access=false;
			}
		}while(access==false);
	}
	
	
	private void openMenu(){	
		String startMenu = console.readStartMenu();
		switch(startMenu){
			case OPTION_ONE:
				showMainMenu();
			break;
			case OPTION_TWO:
				console.showOutputMessage(); 
			break;
			default:
				console.showFirstError();
				openMenu();
		}
	}
	
	
	private void showMainMenu(){
		String option;
		do{
			console.showMainMenu();
			option = console.getMenuOption();
			switch(option){
				case OPTION_ONE:
					this.openBox();
				break;
				case OPTION_TWO:
					this.showFruitList();
				break;
				case OPTION_THREE:
					this.showSalesList();
				break;
				case OPTION_FOUR:
					this.showReportFirstDiscount();
				break;
				case OPTION_FIVE:
					this.showReportSecondDiscount();
				break;
				case OPTION_SIX:
					this.manageFruitList(); 
				break;
				case OPTION_SEVEN:
					openMenu(); 
					return;
				default: 
					console.showFirstError();
			}
		} while( option == null ? OPTION_SEVEN != null : !option.equals(OPTION_SEVEN));
	}
	
	
        @SuppressWarnings("empty-statement")
	private void openBox() {
		float totalFruitValue   = 0, 
		totalPoundsPurchased    = 0, 
		totalValueFirstDiscount = 0, 
		subtotal                = 0;
		int documentType = 0;
		
			documentType = console.readDocumentType(); ;
			String documentNumber = console.readDocumentNumber();
			boolean loop = true;
			while(loop==true){
				console.showNewFruitList();
				console.showFruitList( fruitStore.toMatrixVectorFruitList() );	
				int fruitId = console.readTypeOfFruit();
				FruitList acquiredFruit = fruitStore.getFruitId(fruitId);
				float gramsPurchased = console.readWeightInGrams();
				PurchasedFruit purchasedFruit = new PurchasedFruit(acquiredFruit, gramsPurchased, this.documentType(documentType), documentNumber);
				float poundsPurchased         = purchasedFruit.calculatePounds(gramsPurchased);
				float fruitValue              = purchasedFruit.calculateFruitValue(poundsPurchased);
				float valueFirstDiscount      = purchasedFruit.calculateValueFirstDiscount(poundsPurchased, fruitValue);
				float amountToBePaid          = purchasedFruit.calculateAmountToBePaid(valueFirstDiscount, fruitValue );
				totalFruitValue              += fruitValue;
				totalPoundsPurchased         += poundsPurchased;
				totalValueFirstDiscount      += valueFirstDiscount;
				subtotal                     += amountToBePaid;
				fruitStore.addPurchasedFruit(purchasedFruit);
				float finishRecord = console.readContinueRecord();
				if(finishRecord!=1){
					loop = false;
				}
			}
			
			CustomerPurchase customerPurchase = new CustomerPurchase(subtotal, this.documentType(documentType), documentNumber);
			float valueSecondDiscount         = customerPurchase.calculateValueSecondDiscount(subtotal);
			float totalAmountToPay            = customerPurchase.calculateTotalAmountToPay(subtotal, valueSecondDiscount);
			fruitStore.addCustomerPurchase(customerPurchase);
			LocalDate localDate               = LocalDate.now();
			DateTimeFormatter formatter       = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			String formattedLocalDate         = localDate.format(formatter);
			LocalTime localTime               = LocalTime.now();
			DateTimeFormatter formater        = DateTimeFormatter.ofPattern("HH:mm");
			String formattedLocalTime         = localTime.format(formater);
			int optionReports = 0; 
			do{
				optionReports = console.readOptionReports();
				switch(optionReports){
					case 1:
						console.showUserReport();
						console.showUserData(formattedLocalDate, formattedLocalTime, documentNumber, totalAmountToPay);
					break;
					case 2:
						console.showPurchaseReport();
						console.showCustomerShoppingList(fruitStore.toMatrixVectorFruitListClient());
					break;
					case 3:
						console.showGeneralReport();
						console.showHeaderReport(DEFAULT_USER, documentNumber);
						console.showCustomerShoppingList(fruitStore.toMatrixVectorFruitListClient());
						console.showPurchase(totalFruitValue, totalValueFirstDiscount, totalPoundsPurchased);
						console.showGeneralPurchase(subtotal, valueSecondDiscount, totalAmountToPay);
					break;
					case 4:
						console.showCashReceipt();
						console.showHeaderReport(DEFAULT_USER);
						console.showUserData(formattedLocalDate, formattedLocalTime, documentNumber, totalFruitValue);
						console.showCustomerShoppingList( fruitStore.toMatrixVectorFruitListClient() );
						console.showInfoOfFirstDiscount();
						console.showPurchase(totalFruitValue, totalValueFirstDiscount, totalPoundsPurchased);
						console.showInfoOfSecondDiscount();
						console.showGeneralPurchase(subtotal, valueSecondDiscount, totalAmountToPay);
						console.showMessageGoodbye();
					break;
					case 5:
						String closeBox = console.closeBox(); 
						this.fruitStore.resetFruitListClient();
					break;
					default:
						console.showFirstError();
					break;
				}
			}while(optionReports!=5);
	}

	
	private void showFruitList(){
		console.showFruitListTitle();
		console.showFruitList(fruitStore.toMatrixVectorFruitList());	
		console.returnMenu();
	}
	
	
	private void showSalesList(){
		String optionSalesList = console.getOptionOfSalesLists();
		switch(optionSalesList){
			case OPTION_ONE:
				console.showTitleOfTheFirstSalesList();
				console.showFirstSalesList( fruitStore.toMatrixVectorFruitStoreSalesGeneral() );
				showSalesList();
			break;
			case OPTION_TWO:
				console.showTitleOfTheSecondSalesList();
				console.showSecondSalesList( fruitStore.toMatrixVectorPurchase() );
				showSalesList();
			break;
		}
	}
	
	
	private void showReportFirstDiscount(){
		console.showFirstDiscount();
		console.showInfoOfFirstDiscount();
		console.showFirstDiscountList(fruitStore.toMatrixVectorFirstDiscount());
		console.returnMenu();
	}
	
	
	private void showReportSecondDiscount(){
		console.showSecondDiscount();
		console.showInfoOfSecondDiscount();
		console.showSecondDiscountList(fruitStore.toMatrixVectorSecondDiscount());
		console.returnMenu();
	}
	
	
	private void manageFruitList(){
		String admin = console.readOptionToManage();
		switch(admin){
			case OPTION_ONE:
				float fatality;
				do{
					String fruitName = console.addNameOfFruit();
					float poundPrice = console.addPoundPrice();
					fruitStore.addFruit(new FruitList(fruitName, poundPrice));
					fatality = console.readContinueAdd();
				}while(fatality==1);
				console.showNewFruitList();
				console.showFruitList( fruitStore.toMatrixVectorFruitList() );	
				console.showAddFruit();
				manageFruitList();
			break;
			case OPTION_TWO:
				console.showFruitListTitle();
				console.showFruitList( fruitStore.toMatrixVectorFruitList() );	
				int idFruitToRemove = console.removeFruit();
				fruitStore.removeFruit(idFruitToRemove);
				console.showNewFruitList();
				console.showFruitList( fruitStore.toMatrixVectorFruitList() );	
				console.showRemoveFruit();
				manageFruitList();
			break;
			case OPTION_THREE:
				console.showFruitListTitle();
				console.showFruitList( fruitStore.toMatrixVectorFruitList() );	
				int idFruitToModify = console.modifyFruit();
				float newPoundPrice = console.addNewPoundPrice();
				fruitStore.modifyFruit(idFruitToModify, newPoundPrice);
				console.showNewFruitList();
				console.showFruitList( fruitStore.toMatrixVectorFruitList() );	
				console.showModifyFruit();
				manageFruitList();
				
			break;
			case OPTION_FOUR:
				console.showReportRemovedFruit();
				console.showRemovedFruitList( fruitStore.toMatrixVectorRemoved());
				manageFruitList();
			break;
			case OPTION_FIVE:
				console.showRecordFruit();
				console.showAggregateList( fruitStore.toMatrixVectorAddedFruit());
				manageFruitList();
			break;
		}
		
	}
	
	
	private DocumentType documentType(int documentType){
		DocumentType ret = null;
		switch(documentType){
			case 1:
				ret = DocumentType.IDENTITY_CARD;
			break;
			case 2:
				ret = DocumentType.CITIZENSHIP_CARD;
			break;
			case 3:
				ret = DocumentType.FOREIGNER_ID;
			break;
			case 4:
				ret = DocumentType.PASSPORT;
			break;			
		}			
		return ret;
	}
	
	
	private void printFruitList() {
		fruitStore.addFruit(new FruitList("MANZANA", 3500));
		fruitStore.addFruit(new FruitList("PIÑA", 1500));
		fruitStore.addFruit(new FruitList("PLATANO", 3000));
		fruitStore.addFruit(new FruitList("COCO", 2500));
		fruitStore.addFruit(new FruitList("NARANJA", 3250));
		fruitStore.addFruit(new FruitList("UVA", 3600));
		fruitStore.addFruit(new FruitList("DURAZNO", 5000));
		fruitStore.addFruit(new FruitList("GRANADILLA", 6300));
		fruitStore.addFruit(new FruitList("FRESA", 5650));
		fruitStore.addFruit(new FruitList("MORA", 6350));
		fruitStore.addFruit(new FruitList("MARACUYA", 2450));
		fruitStore.addFruit(new FruitList("MANDARINA", 1500));
		fruitStore.addFruit(new FruitList("GUANABANA", 2900));
	}
}