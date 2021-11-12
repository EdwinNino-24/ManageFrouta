package views;

import models.CustomerPurchase;
import models.DocumentType;
import models.FruitList;
import models.PurchasedFruit;
import java.time.format.DateTimeFormatter;
import java.time.LocalTime;
import java.time.LocalDate;
import java.util.Scanner;

public class Console{
	private static final String FIRST_LINE         = " ________________________________________________________________________________________________________________\n";
	private static final String SECOND_LINE        = " ________________________________________________________________________________________________________________";
	private static final String LOG_IN_LINE        = " ________________                                                                                                |\n";
	private static final String LOG_IN             = "| INICIAR SESION | ----------------------------------------------------------------------------------------------|";
	private static final String READ_USERNAME      = "|-USUARIO:                                                                                                       |";
	private static final String READ_USERPASSWORD  = "|-CONTRASEÑA:                                                                                                   |";
	private static final String LOGIN_SUCESS       = "|-EL INICIO DE SESION SE HA REALIZADO CON EXITO.                                                                 |";
	private static final String LOGIN_FAIL         = "|-USUARIO O CONTRASEÑA INCORRECTA. | VUELVA A INTENTAR DE NUEVO.                                                |";
	private static final String MENU_START_MESSAGE = "|-Ingrese si desea: 1. Abrir menu. | 2. Cerrar el programa.                                                      |";
	
	private static final String FRUIT_TITLE_LINE                       = "|                                             ____________________                              [ManagerFrouta®]|\n";
	private static final String FRUIT_TITLE                            = "|------------------------------------------- | FRUTERIA EL HUERTO | ---------------------------------------------|\n";
	
    private static final String MENU_TITLE_LINE                        = "|                                                     ______                                                     |\n";
	private static final String MENU_TITLE                             = "|--------------------------------------------------- | MENU | ---------------------------------------------------|\n";
    private static final String MENU_MESSAGE                           = "|                            ****** INGRESE EL NUMERO DE  LA OPCION A ESCOGER: ******                            |\n";
	private static final String OPEN_BOX_OPTION                        = "|                               [-->] 1. Abrir caja---------------------------->(1)                              |\n";
	private static final String OPTION_TO_SHOW_FRUIT_LIST              = "|                               [-->] 2. Mostrar lista de frutas--------------->(2)                              |\n";
    private static final String OPTION_TO_PRINT_SALES_LIST             = "|                               [-->] 3. Mostrar reporte/informe de ventas----->(3)                              |\n";
	private static final String OPTION_TO_SHOW_INFO_OF_FIRST_DISCOUNT  = "|                               [-->] 4. Mostrar reporte del primer descuento-->(4)                              |\n";
	private static final String OPTION_TO_SHOW_INFO_OF_SECOND_DISCOUNT = "|                               [-->] 5. Mostrar reporte del segundo descuento->(5)                              |\n";
	private static final String OPTION_TO_MANAGE_THE_FRUIT_LIST        =  "|                               [-->] 6. Administrar lista de frutas----------->(6)                              |\n";
	private static final String MENU_EXIT_OPTION                       = "|                               [-->] 7. Cerrar Menu--------------------------->(7)                              |\n";
	private static final String GET_MENU_OPTION_MESSAGE                = "|-OPCION DE MENU:                                                                                                |";
	
	private static final String READ_DOCUMENT_TYPE                 = "|-Ingrese la opcion correspondiente al tipo de documento de identidad del cliente:                               |";
    private static final String READ_ONE_DOCUMENT_TYPE             = "|        1. TARJETA DE IDENTIDAD. | 2. CEDULA DE CIUDADANIA. | 3. CEDULA DE EXTRANJERIA. | 4. PASAPORTE.         |";
	private static final String READ_DOCUMENT_NUMBER               = "|-Ingrese el numero de documento de identidad del cliente:                                                       |";
	private static final String READ_TYPE_OF_FRUIT                 = "|-Ingrese el ID de la fruta a registrar:                                                                         |";
	private static final String READ_WEIGHT_IN_GRAMS               = "|-Ingrese el peso en gramos a registrar:                                                                         |";
	private static final String READ_THE_REGISTRATION_CONTINUATION = "|-INGRESE SI DESEA: 1. CONTINUAR CON EL REGISTRO | DIGITE CUALQUIER OTRO NUMERO PARA REVISAR LOS REPORTES.       |";
	
	private static final String READ_OPTION_REPORTS = "|         DIGITE SI DESEA IMPRIMIR: 1. REPORTE DE USUARIO | 2. REPORTE DE COMPRA | 3. REPORTE GENERAL            |";
	private static final String READ_OPTION_REPORT  = "|                                       4. RECIBO DE CAJA | 5. CERRAR CAJA                                       |";
	
	private static final String TITLE_OF_BOX_RECEIPT_LINE = "|----------------------------------------------- ________________ -----------------------------------------------|";
    private static final String CASH_RECEIPT_TITLE        = "|---------------------------------------------- | RECIBO DE CAJA | ----------------------------------------------|";
	private static final String PRINT_WELCOME_MESSAGE     = "|-Bienvenido sea a FRUTERIA EL HUERTO, a continuacion se mostrara su recibo de compra.                           | ";
	
	private static final String LINE_USER_REPORT    = " ____________________                                                                                            |";
	private static final String PRINT_USER_REPORT   = "| REPORTE DE USUARIO | ------------------------------------------------------------------------------------------|";
	private static final String PRINT_DATE          = "|-FECHA DE LA COMPRA: ";
	private static final String PRINT_HOUR          = "|-HORA DE LA COMPRA: ";
	private static final String PRINT_TYPE_DOCUMENT = "|-DOCUMENTO DE IDENTIDAD DEL CLIENTE: ";
	private static final String PRINT_AMOUNT_TO_PAY = "|-VALOR TOTAL A PAGAR: ";
	
	private static final String LINE_PURCHASE_REPORT              = " ___________________                                                                                             |";
	private static final String PRINT_PURCHASE_REPORT             = "| REPORTE DE COMPRA | -------------------------------------------------------------------------------------------|";
	private static final String PRINT_POUNDS_OF_PURCHASED_FRUIT   = "|-LIBRAS DE FRUTA TOTAL: ";
	private static final String PRINT_VALUE_TO_PAY                = "|-VALOR A PAGAR: ";
	private static final String PRINT_VALUE_OF_THE_FIRST_DISCOUNT = "|-VALOR DEL PRIMER DESCUENTO: ";
	
	private static final String LINE_GENERAL_REPORT                = " _________________                                                                                               |";
	private static final String PRINT_GENERAL_REPORT               = "| REPORTE GENERAL | ---------------------------------------------------------------------------------------------|";
	private static final String PRINT_NAME_CASHIER                 = "|-CAJERO: ";
	private static final String PRINT_NET_VALUE_TO_PAY             = "|-SUBTOTAL: ";
	private static final String PRINT_VALUE_OF_THE_SECOND_DISCOUNT = "|-SEGUNDO DESCUENTO: ";
	private static final String PRINT_TOTAL_VALUE_TO_PAY           = "|-VALOR TOTAL A PAGAR: ";
	private static final String PRINT_GOODBYE_MESSAGE              = "|-Muchas gracias por haber hecho su compra con nosotros, vuelva pronto.                                          | ";
	private static final String PRINT_CLOSE_BOX                    = "|-PRESIONE CUALQUIER TECLA PARA CERRAR CAJA.                                                                     | ";
	
	private static final String FRUIT_LIST_TITLE_LINE = "|                                                _________________                                               |\n";
    private static final String FRUIT_LIST_TITLE      = "|---------------------------------------------- | LISTA DE FRUTAS | ---------------------------------------------|";
    private static final String INFO_FRUIT_LIST       = "|-A continuacion se muestra en pantalla las frutas que estan disponibles para su venta.                          |";
	private static final String PRINT_RETURN_MENU     = "|-PRESIONE CUALQUIER TECLA PARA REGRESAR AL MENU PRINCIPAL.                                                      | ";
	private static final String FRUIT_LIST_FORMAT     = "%1$-25s %2$-30s %3$-35s %4$-35s ";
    private static final String FRUIT_LIST_ID         = "| ID";
	private static final String TYPE_OF_FRUIT         = "FRUTA";
    private static final String POUND_PRICE           = "PRECIO DE LIBRA($)";
    private static final String GRAM_PRICE            = "PRECIO DE GRAMO($)  |";
	private static final Object[] FRUIT_LIST_HEADER = { FRUIT_LIST_ID, TYPE_OF_FRUIT, POUND_PRICE, GRAM_PRICE };
	
	private static final String READ_OPTION_SALES_LIST             = "|-Digite si desea mostrar en pantalla: 1. Reporte de ventas de fruta. | 2. Informe de compras de clientes.       |";
	private static final String TITLE_LINE_OF_THE_FIRST_SALES_LIST = "|                                               ___________________                                              |\n";
    private static final String TITLE_OF_FIRST_SALES_LIST          = "|--------------------------------------------- | REPORTE DE VENTAS | --------------------------------------------|";
    private static final String MESSAGE_FROM_THE_FIRST_SALES_LIST  = "|-A continuacion se muestra en pantalla el reporte de ventas de fruta:                                           |";
	private static final String FIRST_SALES_LIST_FORMAT            = "%1$-12s %2$-20s %3$-20s %4$-20s %5$-20s %6$-20s";
    private static final String FIRST_SALES_LIST_ID                = "| ID";
	private static final String FRUIT_SOLD                         = "FRUTA";
    private static final String POUNDS_SOLD                        = "LIBRAS";
    private static final String FRUIT_SALE_PRICE                   = "VALOR($)";
    private static final String DISCOUNT_FRUIT                     = "DESCUENTO($)";
	private static final String TOTAL_SALE_PRICE_OF_FRUIT          = "VALOR TOTAL($)  |";
	private static final Object[] HEADER_OF_FIRST_SALES_LIST       = { FIRST_SALES_LIST_ID, FRUIT_SOLD, POUNDS_SOLD, FRUIT_SALE_PRICE, DISCOUNT_FRUIT, TOTAL_SALE_PRICE_OF_FRUIT };
	
	private static final String TITLE_LINE_OF_THE_SECOND_SALES_LIST = "|                                               ___________________                                              |\n";
    private static final String TITLE_OF_SECOND_SALES_LIST          = "|--------------------------------------------- | INFORME DE VENTAS | --------------------------------------------|";
	private static final String MESSAGE_FROM_THE_SECOND_SALES_LIST  = "|-A continuacion se muestra en pantalla el informe de compras de clientes:                                       |";
	private static final String SECOND_SALES_LIST_FORMAT            = "%1$-8s %2$-24s %3$-26s %4$-16s %5$-18s %6$-18s";
    private static final String SECOND_SALES_LIST_ID                = "| ID";
	private static final String DOCUMENT_TYPE                       = "TIPO DE DOCUMENTO";
	private static final String DOCUMENT_NUMBER                     = "NUMERO DE DOCUMENTO";
    private static final String PURCHASE_PRICE                      = "VALOR($)";
    private static final String PURCHASE_DISCOUNT                   = "DESCUENTO($)";
	private static final String TOTAL_PURCHASE_PRICE                = "VALOR TOTAL($)  |";
	private static final Object[] HEADER_OF_SECOND_SALES_LIST       = { SECOND_SALES_LIST_ID,DOCUMENT_TYPE, DOCUMENT_NUMBER, PURCHASE_PRICE, PURCHASE_DISCOUNT, TOTAL_PURCHASE_PRICE };
	
	private static final String READ_OPTION_TO_MANAGE_LIST_OF_FRUITS     = "|         -Ingrese si desea: 1. Agregar frutas. | 2. Remover frutas. | 3. Modificar el precio de frutas.         |";  
	private static final String READ_OPTION_TO_MANAGE_LIST_OF_FRUITS_TWO = "|                       4. Mostrar reporte de frutas eliminadas. | 5. Mostrar historial de frutas.               |";
	private static final String READ_OPTION_TO_MANAGE                    = "|                              PRESIONE CUALQUIER OTRA TECLA PARA REGRESAR AL MENU.                              |";
	private static final String READ_NAME_OF_FRUIT_TO_ADD                = "|-Digite el nombre de la fruta a agregar.                                                                        |";
	private static final String READ_POUND_PRICE_TO_ADD                  = "|-Digite el precio de libra a agregar.                                                                           |";
	private static final String READ_ADD_CONTINUE                        = "|-INGRESE SI DESEA: 1. CONTINUAR AGREGANDO FRUTAS. | DIGITE CUALQUIER OTRO NUMERO PARA REGRESAR.                 |";
	private static final String READ_ADD_FRUIT_SUCCESS                   = "|-LAS FRUTAS SE HAN AGREGADO CON EXITO A LA LISTA DE PRODUCTOS.                                                  | ";
	
	private static final String READ_ID_MODIFY_PRODUCT    = "|-Digite el ID de la fruta a modificar.                                                                          | ";
	private static final String READ_NEW_POUND_PRICE      = "|-Digite el nuevo precio de libra.                                                                               |";
	private static final String READ_MODIFY_PRICE_SUCCESS = "|-LA FRUTA SE HA MODIFICADO CON EXITO DE LA LISTA DE PRODUCTOS.                                                  | ";
	
	private static final String READ_NAME_OF_FRUIT_TO_REMOVE = "|-Digite el ID de la fruta a remover.                                                                            | ";
	private static final String READ_REMOVE_FRUIT_SUCCESS    = "|-LA FRUTA SE HA REMOVIDO CON EXITO DE LA LISTA DE PRODUCTOS.                                                    |";
	
	private static final String PRINT_PESO_SIGN              = "$";
	
	private static final String FIRST_DISCOUNT_TITLE_LINE  = "|                                           ______________________________                                       |\n";
	private static final String TITLE_OF_FIRST_DISCOUNT    = "|----------------------------------------- | REPORTE DEL PRIMER DESCUENTO | -------------------------------------|";	
	private static final String PRINT_INFO_ONE             = "|-Si el cliente supera un monto mayor a 5 libras en la compra de una misma fruta,                                |";
	private static final String PRINT_INFO_TWO             = "| se le realiza un descuento del 2,5% del valor total de la fruta.                                               |";
	                                 
	private static final String SECOND_DISCOUNT_TITLE_LINE  = "|                                          _______________________________                                       |\n";
	private static final String TITLE_OF_SECOND_DISCOUNT    = "|---------------------------------------- | REPORTE DEL SEGUNDO DESCUENTO | -------------------------------------|";
    private static final String PRINT_INFO_THREE            = "|-Si el cliente supera un monto mayor a $100.000 de la compra total, se le realiza                               |";
	private static final String PRINT_INFO_FOUR             = "| un descuento del 5% del valor total de su compra.                                                              |";
	private static final String MESSAGE_SECOND_DISCOUNT     = "|-A continuacion se muestra en pantalla el reporte de descuentos de clientes:                                    |";
	private static final String DISCOUNT_PURCHASE           = "DESCUENTO($)   |";
	private static final String SECOND_DISCOUNT_LIST        = "%1$-20s %2$-37s %3$-38s %4$-35s";
	private static final Object[] HEADER_OF_SECOND_DISCOUNT = { SECOND_SALES_LIST_ID, DOCUMENT_TYPE, DOCUMENT_NUMBER, DISCOUNT_PURCHASE };
	
    private static final String SEPARATOR           = "|----------------------------------------------------------------------------------------------------------------|\n";
	private static final String SEPARATOR_TABLET    = "__________________________________________________________________________________________________________________";
    private static final String LINE                = "------------------------------------------------------------------------------------------------------------------";
	private static final String CHARACTER_LINE_JUMP = "\n";
	private static final String SEPARATOR_LINE      = " ---------------------------------------------------------------------------------------------------------------- ";
	
	private static final String PRINT_LINE_TITLE_REMOVED_FRUIT = "|                                          _____________________________                                         |";
	private static final String PRINT_REPORT_REMOVED_FRUIT     = "|---------------------------------------- | REPORTE DE FRUTAS REMOVIDAS | ---------------------------------------|";
	private static final String PRINT_INFO_REPORT_REMOVED      = "|-A continuacion se detalla en pantalla el informe de frutas que han sido eliminadas del sistema:                |";
	private static final String PRINT_LINE_TITLE_RECORD_FRUIT  = "|                                                _____________________                                           |";
	private static final String PRINT_TITLE_RECORD_FRUIT       = "|---------------------------------------------- | HISTORIAL DE FRUTAS | -----------------------------------------|";
	private static final String PRINT_INFO_RECORD_FRUIT        = "|-A continuacion se muestra en pantalla el reporte de frutas que han sido registradas en el sistema:             |";
	                                                             
	private static final String PRINT_FIRST_ERROR_MESSAGE      = "|-LA OPCION QUE INGRESO ES INEXISTENTE. | POR FAVOR INGRESE DE NUEVO.                                          |";
	private static final String PRINT_SECOND_ERROR_MESSAGE     = "|-ESTE GRAMAJE NO ESTA DISPONIBLE. | POR FAVOR REPITA EL PROCESO.                                                |";
	private static final String PRINT_ERROR_MESSAGE_WITHOUT_DATA = "|-NO SE HAN ENCONTRADO DATOS DE COMPRAS.                                                                    	 | ";
	private static final String OUTPUT_MESSAGE = "__________________________________________________________________________________________________________________";
	private static final String MESSAGE        = "|                                                                                                                |";

	private final Scanner scObj;
	private final Scanner scannerObj;
	private final Scanner drakeObj;
	private final Scanner sullyObj;
	private final Scanner coleObj;
	private final Scanner leviatanObj;
	private final Scanner raidenObj;
	private final Scanner bellicObj;

	public Console(){
		scObj       = new Scanner( System.in );
		scannerObj  = new Scanner( System.in );
		sullyObj    = new Scanner(System.in);
		drakeObj    = new Scanner(System.in);
		coleObj     = new Scanner(System.in);
		leviatanObj = new Scanner(System.in);
		raidenObj   = new Scanner(System.in);
		bellicObj   = new Scanner(System.in);
	}	
	
	public String readUsername(){
		System.out.println( SEPARATOR_TABLET );
		System.out.println(FIRST_LINE + FRUIT_TITLE_LINE + FRUIT_TITLE + SEPARATOR + LOG_IN_LINE + LOG_IN);
		System.out.println( LINE );
		System.out.println( SEPARATOR_LINE );
		System.out.println( READ_USERNAME);
		System.out.println( SEPARATOR_LINE );
		System.out.println( LINE );
		return scObj.nextLine();
    }
	
	
	public String readUserPassword(){
		System.out.println( LINE );
		System.out.println( SEPARATOR_LINE );
		System.out.println( READ_USERPASSWORD );
		System.out.println( SEPARATOR_LINE );
		System.out.println( LINE );
		return scObj.nextLine();
    }
	
	
	public String readStartMenu(){
		System.out.println( SEPARATOR_TABLET );
		System.out.println( LINE );
		System.out.println( SEPARATOR_LINE );
		System.out.println( MENU_START_MESSAGE);
		System.out.println( SEPARATOR_LINE );
		System.out.println( LINE );
		return drakeObj.nextLine();
    }

	public void showMainMenu(){
        System.out.println( LINE );
		System.out.println( FIRST_LINE + FRUIT_TITLE_LINE + FRUIT_TITLE + SEPARATOR + MENU_TITLE_LINE + MENU_TITLE + SEPARATOR + MENU_MESSAGE + SEPARATOR + OPEN_BOX_OPTION + OPTION_TO_SHOW_FRUIT_LIST + OPTION_TO_PRINT_SALES_LIST + OPTION_TO_SHOW_INFO_OF_FIRST_DISCOUNT + OPTION_TO_SHOW_INFO_OF_SECOND_DISCOUNT + OPTION_TO_MANAGE_THE_FRUIT_LIST + MENU_EXIT_OPTION + SEPARATOR_TABLET);
    }
	
	public String getMenuOption(){
		System.out.println( LINE );
		System.out.println( SEPARATOR_LINE );
		System.out.println(GET_MENU_OPTION_MESSAGE);
		System.out.println( SEPARATOR_LINE );
		System.out.println( LINE );
		return sullyObj.nextLine();
    }
    
	
	public int readDocumentType(){
		System.out.println( OUTPUT_MESSAGE );
		System.out.println( LINE );
		System.out.println( SEPARATOR_LINE );
		System.out.println( READ_DOCUMENT_TYPE );
		System.out.println( SEPARATOR_LINE );
		System.out.println( SEPARATOR_LINE );
		System.out.println( READ_ONE_DOCUMENT_TYPE );
		System.out.println( SEPARATOR_LINE );
		System.out.println( LINE );
		return bellicObj.nextInt();
	}
	
	public String readDocumentNumber(){
		System.out.println( LINE );
		System.out.println( SEPARATOR_LINE );
		System.out.println( READ_DOCUMENT_NUMBER );
		System.out.println( SEPARATOR_LINE );
		System.out.println( LINE );
		return drakeObj.nextLine();
    }

	public int readTypeOfFruit(){
		System.out.println( LINE );
		System.out.println( SEPARATOR_LINE );
		System.out.println( READ_TYPE_OF_FRUIT );
		System.out.println( SEPARATOR_LINE );
		System.out.println( LINE );
		return scannerObj.nextInt();
    }
	
	public float readWeightInGrams(){
		System.out.println( LINE );
		System.out.println( SEPARATOR_LINE );
		System.out.println( READ_WEIGHT_IN_GRAMS );
		System.out.println( SEPARATOR_LINE );
		System.out.println( LINE );
		return scannerObj.nextFloat();
    }
	
	
	public int readOptionReports(){
		System.out.println( OUTPUT_MESSAGE );
		System.out.println( LINE );
		System.out.println( SEPARATOR_LINE );
		System.out.println( READ_OPTION_REPORTS );
		System.out.println( SEPARATOR_LINE );
		System.out.println( READ_OPTION_REPORT );
		System.out.println( SEPARATOR_LINE );
		System.out.println( LINE );
		return bellicObj.nextInt();
    }
	
	
	public void showCashReceipt(){
		System.out.println( LINE );
		System.out.println( FIRST_LINE + TITLE_OF_BOX_RECEIPT_LINE );
		System.out.println( CASH_RECEIPT_TITLE );
		System.out.println( LINE );
		System.out.println( SEPARATOR_LINE );
		System.out.println( PRINT_WELCOME_MESSAGE );
		System.out.println( SEPARATOR_LINE );
	}
	
	
	public void showUserReport(){
		System.out.println(SEPARATOR_TABLET);
		System.out.println( LINE );
		System.out.println( LINE_USER_REPORT );
		System.out.println( PRINT_USER_REPORT );
		System.out.println( LINE );
	}
	
	
	public void showUserData( String formattedLocalDate, String formattedLocalTime, String documentNumber, float totalAmountToPay ){
		System.out.println( SEPARATOR_LINE);
		System.out.println( PRINT_DATE + formattedLocalDate);
		System.out.println( PRINT_HOUR + formattedLocalTime);
		System.out.println( PRINT_TYPE_DOCUMENT+ documentNumber);
		System.out.println( PRINT_AMOUNT_TO_PAY + totalAmountToPay);
		System.out.println( SEPARATOR_LINE );
	}
	
	public void showInfoOfFirstDiscount (){
		System.out.println( LINE );
		System.out.println( SEPARATOR_LINE);
		System.out.println( PRINT_INFO_ONE );
		System.out.println( PRINT_INFO_TWO );
		System.out.println( SEPARATOR_LINE );
		System.out.println( LINE );
	}
	
	
	public void showPurchaseReport(){
		System.out.println(SEPARATOR_TABLET);
		System.out.println( LINE );
		System.out.println( LINE_PURCHASE_REPORT );
		System.out.println( PRINT_PURCHASE_REPORT );
		System.out.println( LINE );
	}
	
	
	public void showPurchase ( float totalFruitValue, float totalValueFirstDiscount, float totalPoundsPurchased ){
		System.out.println( SEPARATOR_LINE);
		System.out.println( PRINT_POUNDS_OF_PURCHASED_FRUIT + totalPoundsPurchased  );	
		System.out.println( PRINT_VALUE_TO_PAY + PRINT_PESO_SIGN + totalFruitValue  );
		System.out.println( PRINT_VALUE_OF_THE_FIRST_DISCOUNT + PRINT_PESO_SIGN + totalValueFirstDiscount );
		System.out.println( SEPARATOR_LINE);
	}
	

	public void showInfoOfSecondDiscount (){
		System.out.println( LINE );
		System.out.println( SEPARATOR_LINE);
		System.out.println( PRINT_INFO_THREE );
		System.out.println( PRINT_INFO_FOUR );
		System.out.println( SEPARATOR_LINE );
		System.out.println( LINE );
	}
	
	
	public void showGeneralReport(){
		System.out.println(SEPARATOR_TABLET);
		System.out.println( LINE );
		System.out.println( LINE_GENERAL_REPORT );
		System.out.println( PRINT_GENERAL_REPORT );
		System.out.println( LINE );
	}
	
	
	public void showHeaderReport(String DEFAULT_USER){
		System.out.println( SEPARATOR_LINE);
		System.out.println( PRINT_NAME_CASHIER + DEFAULT_USER );
		System.out.println( SEPARATOR_LINE);
	}
	
	public void showHeaderReport(String DEFAULT_USER, String documentNumber){
		System.out.println( SEPARATOR_LINE);
		System.out.println( PRINT_NAME_CASHIER + DEFAULT_USER );
		System.out.println( PRINT_TYPE_DOCUMENT + documentNumber);
		System.out.println( SEPARATOR_LINE);
	}
	
	
	public void showGeneralPurchase( float subtotal, float valueSecondDiscount, float totalAmountToPay ){
		System.out.println( SEPARATOR_LINE);
		System.out.println( PRINT_NET_VALUE_TO_PAY + PRINT_PESO_SIGN+ subtotal );
		System.out.println( PRINT_VALUE_OF_THE_SECOND_DISCOUNT + PRINT_PESO_SIGN + valueSecondDiscount );
		System.out.println( PRINT_TOTAL_VALUE_TO_PAY + PRINT_PESO_SIGN + totalAmountToPay );
		System.out.println( SEPARATOR_LINE);
	}
	
	
	public void showMessageGoodbye(  ){
		System.out.println( LINE );
		System.out.println( SEPARATOR_LINE );
		System.out.println( PRINT_GOODBYE_MESSAGE );
		System.out.println( SEPARATOR_LINE );
		System.out.println( LINE );
	}
	
	
	public String closeBox(){
		System.out.println( OUTPUT_MESSAGE );
		System.out.println( LINE );
		System.out.println( SEPARATOR_LINE );
		System.out.println( PRINT_CLOSE_BOX );
		System.out.println( SEPARATOR_LINE );
		System.out.println( LINE );
		return coleObj.nextLine();
    }
	
	
	public void showFruitListTitle(){
		System.out.println( LINE);
		System.out.println( FIRST_LINE + FRUIT_LIST_TITLE_LINE + FRUIT_LIST_TITLE );
		System.out.println( LINE );
		System.out.println( SEPARATOR_LINE );
		System.out.println( INFO_FRUIT_LIST );
		System.out.println( SEPARATOR_LINE );
		System.out.println( SEPARATOR_TABLET );
	}
	
	public void showNewFruitList(){
		System.out.println( LINE);
		System.out.println( FIRST_LINE + FRUIT_LIST_TITLE_LINE + FRUIT_LIST_TITLE );
		System.out.println( LINE );
		System.out.println( SEPARATOR_LINE );
		System.out.println( SEPARATOR_TABLET );
		
	}
	
	public void generateHeaderFruitList() {
		System.out.println( LINE);
		System.out.println( SEPARATOR_LINE);
		System.out.println( String.format(FRUIT_LIST_FORMAT, FRUIT_LIST_HEADER));
		System.out.println( SEPARATOR_LINE);
		System.out.println( LINE);
	}
	
	public void showFruitList( FruitList[] datasList ) {
		generateHeaderFruitList();
            for (FruitList datasList1 : datasList) {
                System.out.println(String.format(FRUIT_LIST_FORMAT, datasList1.getIdFruitList(), datasList1.getFruitName(), datasList1.getPoundPrice(), datasList1.getGramPrice()));
            }
	}
	
	
	public void showRecordFruit(){
		System.out.println( LINE);
		System.out.println( SECOND_LINE );
		System.out.println( PRINT_LINE_TITLE_RECORD_FRUIT );
		System.out.println( PRINT_TITLE_RECORD_FRUIT );
		System.out.println( LINE );
		System.out.println( SEPARATOR_LINE );
		System.out.println( PRINT_INFO_RECORD_FRUIT );
		System.out.println( SEPARATOR_LINE );
		System.out.println( SEPARATOR_TABLET );
	}
	
	public void showAggregateList( FruitList[] datasList ) {
		if(datasList != null){	
			generateHeaderFruitList();
			for (int i = 0; i < datasList.length; i++ ){
				System.out.println( String.format( 
				FRUIT_LIST_FORMAT, 
				datasList[i].getIdFruitList(), 
				datasList[i].getFruitName(), 
				datasList[i].getPoundPrice(), 
				datasList[i].getGramPrice() 
				));
			}
		}
		else{
			showMessageUnrecordedData();
		}
	
	}
	
	
	public void showReportRemovedFruit(){
		System.out.println( LINE);
		System.out.println( SECOND_LINE );
		System.out.println( PRINT_LINE_TITLE_REMOVED_FRUIT );
		System.out.println( PRINT_REPORT_REMOVED_FRUIT );
		System.out.println( LINE );
		System.out.println( SEPARATOR_LINE );
		System.out.println( PRINT_INFO_REPORT_REMOVED );
		System.out.println( SEPARATOR_LINE );
		System.out.println( SEPARATOR_TABLET );
	}
	
	public void showRemovedFruitList( FruitList[] datasList ) {
		generateHeaderFruitList();
            for (FruitList datasList1 : datasList) {
                System.out.println(String.format(FRUIT_LIST_FORMAT, datasList1.getIdFruitList(), datasList1.getFruitName(), datasList1.getPoundPrice(), datasList1.getGramPrice()));
            }
	
	}
	
	public String returnMenu(){
		System.out.println( OUTPUT_MESSAGE );
		System.out.println( LINE );
		System.out.println( SEPARATOR_LINE );
		System.out.println( PRINT_RETURN_MENU );
		System.out.println( SEPARATOR_LINE );
		System.out.println( LINE );
		return coleObj.nextLine();
    }
	
	
	public String getOptionOfSalesLists(){
		System.out.println( OUTPUT_MESSAGE );
		System.out.println( LINE );
		System.out.println( SEPARATOR_LINE );
		System.out.println(READ_OPTION_SALES_LIST);
		System.out.println( SEPARATOR_LINE );
		System.out.println( SEPARATOR_LINE );
		System.out.println( READ_OPTION_TO_MANAGE );
		System.out.println( SEPARATOR_LINE );
		System.out.println( LINE );
		return leviatanObj.nextLine();
    }
	
	
	public void showTitleOfTheFirstSalesList(){
		System.out.println( LINE );
		System.out.println( FIRST_LINE + TITLE_LINE_OF_THE_FIRST_SALES_LIST + TITLE_OF_FIRST_SALES_LIST );
		System.out.println( LINE );
		System.out.println( SEPARATOR_LINE );
		System.out.println( MESSAGE_FROM_THE_FIRST_SALES_LIST );
		System.out.println( SEPARATOR_LINE );
		System.out.println( SEPARATOR_TABLET );
	}
	
	public void generateFirstHeaderSalesList() {
		System.out.println( LINE);
		System.out.println( SEPARATOR_LINE );
		System.out.println( String.format( FIRST_SALES_LIST_FORMAT, HEADER_OF_FIRST_SALES_LIST ));
		System.out.println( SEPARATOR_LINE );
		System.out.println( LINE);
	} 
	
	public void showFirstSalesList(PurchasedFruit[] datasList) {
		if(datasList != null){	
			generateFirstHeaderSalesList();
                    for (PurchasedFruit datasList1 : datasList) {
                        System.out.println(String.format(FIRST_SALES_LIST_FORMAT, datasList1.getIdPurchasedFruit(), datasList1.fruitList.getFruitName(), datasList1.getPoundsPurchased(), datasList1.getFruitValue(), datasList1.getValueFirstDiscount(), datasList1.getAmountToBePaid()));
                    }
	    }
		else{
			showMessageUnrecordedData();
		}
	}
	
	public void showCustomerShoppingList(PurchasedFruit[] datasList) {	
		generateFirstHeaderSalesList();
            for (PurchasedFruit datasList1 : datasList) {
                System.out.println(String.format(FIRST_SALES_LIST_FORMAT, datasList1.getIdPurchasedFruit(), datasList1.fruitList.getFruitName(), datasList1.getPoundsPurchased(), datasList1.getFruitValue(), datasList1.getValueFirstDiscount(), datasList1.getAmountToBePaid()));
            }
	}
	
	
	public void showTitleOfTheSecondSalesList(){
		System.out.println( LINE );
		System.out.println( FIRST_LINE + TITLE_LINE_OF_THE_SECOND_SALES_LIST + TITLE_OF_SECOND_SALES_LIST );
		System.out.println( LINE );
		System.out.println( SEPARATOR_LINE );
		System.out.println( MESSAGE_FROM_THE_SECOND_SALES_LIST );
		System.out.println( SEPARATOR_LINE );
		System.out.println( SEPARATOR_TABLET );
	}
	
	public void generateSecondHeaderSalesList() {
		System.out.println( LINE);
		System.out.println( SEPARATOR_LINE );
		System.out.println( String.format( SECOND_SALES_LIST_FORMAT, HEADER_OF_SECOND_SALES_LIST ));
		System.out.println( SEPARATOR_LINE );
		System.out.println( LINE);
	} 
	
	public void showSecondSalesList(CustomerPurchase[] datasList){
		if(datasList != null){	
		generateSecondHeaderSalesList();
                    for (CustomerPurchase datasList1 : datasList) {
                        System.out.println(String.format(SECOND_SALES_LIST_FORMAT, datasList1.getIdCustomerPurchase(), datasList1.documentType.getTypeDocument(), datasList1.getDocumentNumber(), datasList1.getSubtotal(), datasList1.getValueSecondDiscount(), datasList1.getTotalAmountToPay()));
                    }
	    }
		else{
			showMessageUnrecordedData();
		}
	}
	
	
	public void generateHeaderSecondDiscountList() {
		System.out.println( SEPARATOR_LINE );
		System.out.println( MESSAGE_SECOND_DISCOUNT );
		System.out.println( SEPARATOR_LINE );
		System.out.println( LINE);
		System.out.println( SEPARATOR_LINE );
		System.out.println( String.format( SECOND_DISCOUNT_LIST, HEADER_OF_SECOND_DISCOUNT ));
		System.out.println( SEPARATOR_LINE );
		System.out.println( LINE);
	} 
	
	public void showSecondDiscountList( CustomerPurchase[] datasList ) {
		if(datasList != null){	
		generateHeaderSecondDiscountList();
                    for (CustomerPurchase datasList1 : datasList) {
                        System.out.println(String.format(SECOND_DISCOUNT_LIST, datasList1.getIdCustomerPurchase(), datasList1.documentType.getTypeDocument(), datasList1.getDocumentNumber(), datasList1.getValueSecondDiscount()));
                    }
	    }
		else{
			showMessageUnrecordedData();
		}
	}
	
	public void showFirstDiscountList( PurchasedFruit[] datasList ) {
		if(datasList != null){	
		generateHeaderSecondDiscountList();
                    for (PurchasedFruit datasList1 : datasList) {
                        System.out.println(String.format(SECOND_DISCOUNT_LIST, datasList1.getIdPurchasedFruit(), datasList1.documentType.getTypeDocument(), datasList1.getDocumentNumber(), datasList1.getValueFirstDiscount()));
                    }
	    }
		else{
			showMessageUnrecordedData();
		}
	}
	
	public String readOptionToManage(){
		System.out.println( OUTPUT_MESSAGE );
		System.out.println( LINE );
		System.out.println( SEPARATOR_LINE );
		System.out.println( READ_OPTION_TO_MANAGE_LIST_OF_FRUITS );
		System.out.println( SEPARATOR_LINE );
		System.out.println( SEPARATOR_LINE );
		System.out.println( READ_OPTION_TO_MANAGE_LIST_OF_FRUITS_TWO );
		System.out.println( SEPARATOR_LINE );
		System.out.println( SEPARATOR_LINE );
		System.out.println( READ_OPTION_TO_MANAGE );
		System.out.println( SEPARATOR_LINE );
		System.out.println( LINE );
		return leviatanObj.nextLine();
    }
	
	
	public String addNameOfFruit(){
		System.out.println( OUTPUT_MESSAGE );
		System.out.println( LINE );
		System.out.println( SEPARATOR_LINE );
		System.out.println( READ_NAME_OF_FRUIT_TO_ADD );
		System.out.println( SEPARATOR_LINE );
		System.out.println( LINE );
		return raidenObj.nextLine();
    }
	
	public float addPoundPrice(){
		System.out.println( LINE );
		System.out.println( SEPARATOR_LINE );
		System.out.println( READ_POUND_PRICE_TO_ADD );
		System.out.println( SEPARATOR_LINE );
		System.out.println( LINE );
		return scannerObj.nextFloat();
    }
	
	public void showAddFruit(){
		System.out.println( LINE );
		System.out.println( SEPARATOR_LINE );
		System.out.println(READ_ADD_FRUIT_SUCCESS);
		System.out.println( SEPARATOR_LINE );
		System.out.println( LINE );
	}
	
	
	public int modifyFruit(){
		System.out.println( LINE );
		System.out.println( SEPARATOR_LINE );
		System.out.println(READ_ID_MODIFY_PRODUCT);
		System.out.println( SEPARATOR_LINE );
		System.out.println( LINE );
		return scannerObj.nextInt();
    }
	
	public float addNewPoundPrice(){
		System.out.println( LINE );
		System.out.println( SEPARATOR_LINE );
		System.out.println( READ_NEW_POUND_PRICE );
		System.out.println( SEPARATOR_LINE );
		System.out.println( LINE );
		return scannerObj.nextFloat();
    }
	
	public void showModifyFruit(){
		System.out.println( LINE );
		System.out.println( SEPARATOR_LINE );
		System.out.println(READ_MODIFY_PRICE_SUCCESS);
		System.out.println( SEPARATOR_LINE );
		System.out.println( LINE );
	}
	
	
	public int removeFruit(){
		System.out.println( LINE );
		System.out.println( SEPARATOR_LINE );
		System.out.println(READ_NAME_OF_FRUIT_TO_REMOVE);
		System.out.println( SEPARATOR_LINE );
		System.out.println( LINE );
		return scannerObj.nextInt();
    }
	
	public void showRemoveFruit(){
		System.out.println( LINE );
		System.out.println( SEPARATOR_LINE );
		System.out.println(READ_REMOVE_FRUIT_SUCCESS);
		System.out.println( SEPARATOR_LINE );
		System.out.println( LINE );
    }
	
	
	public void showFirstDiscount (){
		System.out.println( SEPARATOR_LINE);
	System.out.println( FIRST_LINE + FIRST_DISCOUNT_TITLE_LINE + TITLE_OF_FIRST_DISCOUNT );
		System.out.println( SEPARATOR_LINE );
	}
	
	
	public void showSecondDiscount (){
		System.out.println( SEPARATOR_LINE);
		System.out.println( FIRST_LINE + SECOND_DISCOUNT_TITLE_LINE + TITLE_OF_SECOND_DISCOUNT );
		System.out.println( SEPARATOR_LINE );
	}
	

	public float readContinueRecord(){
		System.out.println( LINE );
		System.out.println( SEPARATOR_LINE );
		System.out.println( READ_THE_REGISTRATION_CONTINUATION );
		System.out.println( SEPARATOR_LINE );
		System.out.println( LINE );
		return scannerObj.nextFloat();
	}
	
	public float readContinueAdd(){
		System.out.println( LINE );
		System.out.println( SEPARATOR_LINE );
		System.out.println( READ_ADD_CONTINUE );
		System.out.println( SEPARATOR_LINE );
		System.out.println( LINE );
		return scannerObj.nextFloat();
	}

	public void showMessageUnrecordedData(){
		System.out.println( LINE );
		System.out.println( SEPARATOR_LINE);
		System.out.println(PRINT_ERROR_MESSAGE_WITHOUT_DATA);
		System.out.println( SEPARATOR_LINE );	
		System.out.println( LINE );
	}
	
	public void showFirstError(){
		System.out.println( LINE );
		System.out.println( SEPARATOR_LINE );
		System.out.println( PRINT_FIRST_ERROR_MESSAGE);
		System.out.println( SEPARATOR_LINE );
		System.out.println( LINE );
	}
	
	public void showSecondError(){
		System.out.println( LINE );
		System.out.println( SEPARATOR_LINE );
		System.out.println( PRINT_SECOND_ERROR_MESSAGE );
		System.out.println( SEPARATOR_LINE );
		System.out.println( LINE );
	}
	
	public void showLoginSuccess(){
		System.out.println( LINE );
		System.out.println( SEPARATOR_LINE );
		System.out.println( LOGIN_SUCESS );
		System.out.println( SEPARATOR_LINE );
		System.out.println( LINE );
	}
	
	public void showLoginFail(){
		System.out.println( LINE );
		System.out.println( SEPARATOR_LINE );
		System.out.println( LOGIN_FAIL );
		System.out.println( SEPARATOR_LINE );
		System.out.println( LINE );
	}
	
	public void showOutputMessage(){
		System.out.println( LINE);
        System.out.println( OUTPUT_MESSAGE );
    }
}