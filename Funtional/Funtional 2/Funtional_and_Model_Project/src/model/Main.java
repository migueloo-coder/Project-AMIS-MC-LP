package model;

import java.util.Scanner;



public class Main {
	static Scanner input=new Scanner (System.in);
	final static int num=4;//numero de aereopuertos
	static Airport airports[]=new Airport[num];
	

	public static void main(String[] args) {
		menu1();
	}

	public static void insertDataAirport (Airport air[]) {
		air[0]= new PublicAirport(1020,"Airport International ElDorado","Bogota. D.C.","Colombia",5000000);
		air[0].insertCompany(new Company(2010,"Avianca"));
		air[0].insertCompany(new Company(2011,"LATAM"));
		air[0].insertCompany(new Company(2012,"AirEuropa"));
		air[0].insertCompany(new Company(2013,"Iberia"));
		air[0].getCompany("Avianca").insertFlight(new Flight("AV123", "Bogota", "Ciudad de Mexico", 300.00, 200));
		air[0].getCompany("LATAM").insertFlight(new Flight("LAT211","Bogota","Buenos Aires", 400.00, 200));
		air[0].getCompany("AirEuropa").insertFlight(new Flight("AE365","Bogota","Madrid", 400.00, 200));
		air[0].getCompany("Iberia").insertFlight(new Flight("IBE211","Bogota","Paris", 400.00, 200));
		air[0].getCompany("Avianca").getFlights("AV123").insertPassenger(new Passenger(123456, "Miguel","Caro","Masculino", "DNI","Calle 44a #75e","3194569877","migueloo@gmail.com","AY3244","Colombiano","02/10/2001"));
		air[0].getCompany("Avianca").getFlights("AV123").insertPassenger(new Passenger(456789, "Jose","Reiveira","Masculino", "DNI","Calle 78a #5","317885446","jriveira@gmail.com","AX45224","Colombiano","10/12/1985"));
		air[0].getCompany("LATAM").getFlights("LAT211").insertPassenger(new Passenger(987456, "Maria","Ruiz","Femenino", "DNI","Carrera 21 #89a","321775997","mariaruiz@gmail.com","RT34667","Colombiana","21/09/1999"));
		
		air[1]= new PrivateAirport(2020,"Central International Enterprise","Medellin","Colombia");
		air[1].insertCompany(new Company(2010,"Avianca"));
		air[1].insertCompany(new Company(2011,"LATAM"));
		air[1].insertCompany(new Company(2012,"AirEuropa"));
		air[1].insertCompany(new Company(2013,"Iberia"));
		String enterprise[]= {"AIRBUS","AVINCIS"};
		((PrivateAirport)air[1]).insertEnterprises(enterprise);
		air[1].getCompany("Avianca").insertFlight(new Flight("AV123", "Bogota", "Ciudad de Mexico", 300.00, 200));
		air[1].getCompany("LATAM").insertFlight(new Flight("LAT211","Bogota","Buenos Aires", 400.00, 200));
		air[1].getCompany("AirEuropa").insertFlight(new Flight("AE365","Bogota","Madrid", 400.00, 200));
		air[1].getCompany("Iberia").insertFlight(new Flight("IBE211","Bogota","Paris", 400.00, 200));
		air[1].getCompany("Avianca").getFlights("AV123").insertPassenger(new Passenger(123456, "Miguel","Caro","Masculino", "DNI","Calle 44a #75e","3194569877","migueloo@gmail.com","AY3244","Colombiano","02/10/2001"));
		air[1].getCompany("Avianca").getFlights("AV123").insertPassenger(new Passenger(456789, "Jose","Reiveira","Masculino", "DNI","Calle 78a #5","317885446","jriveira@gmail.com","AX45224","Colombiano","10/12/1985"));
		air[1].getCompany("LATAM").getFlights("LAT211").insertPassenger(new Passenger(987456, "Maria","Ruiz","Femenino", "DNI","Carrera 21 #89a","321775997","mariaruiz@gmail.com","RT34667","Colombiana","21/09/1999"));
		
		air[2]= new PublicAirport(1021,"Aeropuerto de Oporto-Francisco Sá Carneiro","Oporto","Portugal",5000000);
		air[2].insertCompany(new Company(2012,"AirEuropa"));
		air[2].insertCompany(new Company(2013,"Iberia"));
		air[2].getCompany("AirEuropa").insertFlight(new Flight("AE987","Oporto","Roma", 400.00, 200));
		air[2].getCompany("Iberia").insertFlight(new Flight("IBE211","Oporto","Monaco", 400.00, 200));
		air[2].getCompany("AirEuropa").getFlights("AE987").insertPassenger(new Passenger(123456, "Miguel","Caro","Masculino", "DNI","Calle 44a #75e","3194569877","migueloo@gmail.com","AY3244","Colombiano","02/10/2001"));
		
		air[3]= new PublicAirport(1022,"Aeropuerto Adolfo Suárez Madrid-Barajas","Madrid","Espanha",5000000);
		air[3].insertCompany(new Company(2012,"AirEuropa"));
		air[3].insertCompany(new Company(2013,"Iberia"));	
		air[3].getCompany("AirEuropa").insertFlight(new Flight("AE365","Madrid","Miami", 400.00, 200));
		air[3].getCompany("Iberia").insertFlight(new Flight("IBE852","Madrid","Belgica", 400.00, 200));
		air[3].getCompany("AirEuropa").getFlights("AE365").insertPassenger(new Passenger(123456, "Miguel","Caro","Masculino", "DNI","Calle 44a #75e","3194569877","migueloo@gmail.com","AY3244","Colombiano","02/10/2001"));
		air[3].getCompany("Iberia").getFlights("IBE852").insertPassenger(new Passenger(456789, "Jose","Reiveira","Masculino", "DNI","Calle 78a #5","317885446","jriveira@gmail.com","AX45224","Colombiano","10/12/1985"));
		
	}
	
	
	// MENUS 
	
	public static void menu1() {
		Scanner scanner = new Scanner(System.in);
        int op;

        do {
            showMenu1();
            System.out.print("Ingrese su opción: ");
            op = scanner.nextInt();

            switch (op) {
                case 1:
                    System.out.println("DADOS CARREGADOS CORRETAMENTE.");
                    insertDataAirport(airports);
                    break;
                case 2:
                    System.out.println("MENU DE EJECUÇAO");
                    menu2();
                    break;
                case 3:
                    System.out.println("NA");
                    break;
                case 4:
                    System.out.println("NA");
                    break;
                case 5:
                    System.out.println("Na");
                    break;
                case 6:
                    System.out.println("Saliendo del programa. ¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, ingrese una opción válida.");
                    
            }

        } while (op != 6);

        scanner.close();
	}
	
	public static void showMenu1() {
		System.out.println("-----------------------------");
        System.out.println("----- Main Menu -----");
        System.out.println("1. Carregar Dados por sistema");
        System.out.println("2. Menu 2");
        System.out.println("3. NA");
        System.out.println("4. Na");
        System.out.println("5. Na");
        System.out.println("6. Salir");
        System.out.println("------------------------------");
    }
	
	public static void menu2() {
		Scanner scanner = new Scanner(System.in);
        int op2;

        do {
            showMenu2();
            System.out.print("Ingrese su opción: ");
            op2 = scanner.nextInt();

            switch (op2) {
                case 1:
                	System.out.println("");
                    System.out.println("show Management Airports");
                    showAirportData(airports);
                    break;
                case 2:
                	System.out.println("");
                    System.out.println("Show Sponsors Airports");
                    showSponsorAirport(airports);
                    break;
                case 3:
                	System.out.println("");
                    System.out.println("Opción 3 seleccionada.");
                    
                    break;
                case 4:
                	System.out.println("");
                    System.out.println("op4");
                    break;
                case 5:
                	System.out.println("");
                    System.out.println("op5");
                    break;
                case 6:
                    System.out.println("Saliendo del programa. ¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, ingrese una opción válida.");
            }

        } while (op2 != 6);

        scanner.close();
	}
	
	public static void showMenu2() {
		System.out.println("-----------------------------");
        System.out.println("----- Menú -----");
        System.out.println("1. Ver los Aereopuertos gestionados (Publicos y Privados)");
        System.out.println("2. Ver Empresas (Privado) o Subvencion (Publico) ");
        System.out.println("3. Lista de companias de un aereopuerto");
        System.out.println("4. Lista de Vuelos por compania");
        System.out.println("5. Listar Posibles vuelos de origen a Destino");
        System.out.println("6. Salir");
        System.out.println("------------------------------");
    }
	
	public static void showAirportData(Airport airports[] ){
		for (int i=0; i<airports.length;i++){
			if(airports[i] instanceof PrivateAirport) {
				System.out.println("");
				System.out.println("N Airport: "+i);
				System.out.println("-------------------------------------");
				System.out.println("This selection is Private Airport");
				System.out.println("Name Airport: "+airports[i].getName());
				System.out.println("City: "+airports[i].getCity());
				System.out.println("Country: "+airports[i].getCountry());
				System.out.println("-------------------------------------");
				System.out.println("");
			}
			else {
				System.out.println("");
				System.out.println("N Airport: "+i);
				System.out.println("-------------------------------------");
				System.out.println("This selection is Public Airport");
				System.out.println("Name Airport: "+airports[i].getName());
				System.out.println("City: "+airports[i].getCity());
				System.out.println("Country: "+airports[i].getCountry());
				System.out.println("-------------------------------------");
				System.out.println("");
				
			}
			
		}
		
	}
	
	public static void showSponsorAirport(Airport airports[]) {
		
		String enterprises[];
		
		for (int i=0; i<airports.length;i++){
			if(airports[i] instanceof PrivateAirport) {
				System.out.println("");
				System.out.println("N Airport: "+i);
				System.out.println("-------------------------------------");
				System.out.println("Private Airport");
				System.out.println("Name Airport: "+airports[i].getName());
				enterprises=((PrivateAirport)airports[i]).getListEnterprises();
				System.out.println("Enterprises: ");
				for(int j=0;j<enterprises.length;j++) {
					System.out.println(enterprises[j]);
				}
			 }
			else {
				System.out.println("");
				System.out.println("N Airport: "+i);
				System.out.println("-------------------------------------");
				System.out.println("Public Airport");
				System.out.println("Name Airport: "+airports[i].getName());
				System.out.println("Subsidy: "+((PublicAirport)airports[i]).getSubsidy());
			}
			System.out.println("");
			
		}
		
	}
}
