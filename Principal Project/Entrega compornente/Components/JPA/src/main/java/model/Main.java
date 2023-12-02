package model;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Airport;
import model.AirportService;
import model.Company;
import model.CompanyService;
import model.Flight;
import model.FlightService;
import model.Passenger;
import model.PassengerService;
import model.PrivateAirport;
import model.PrivateAirportService;
import model.PublicAirport;
import model.PublicAirportService;



public class Main {
	static Scanner input=new Scanner (System.in);
	static Airport airports[];
	private static final String PERSISTENCE_UNIT_NAME = "LibraryJPA";
	private static EntityManagerFactory factory;
	private static EntityManager emanager = null;
	
	
	public static EntityManager getEM() {
		if (emanager == null) {
			factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
			emanager = factory.createEntityManager();
		}
		return emanager;
	}
	
	public static void fill() {
		System.out.println("========");
		System.out.println("  FILL");
		System.out.println("========");
		EntityManager em = getEM();
		Query q = null;
		List<Airport> airports = null;
		List<Company> companys = null;
		// Remove the existing entries
		em.getTransaction().begin();
		AirportService as = new AirportService(getEM());
		List<Airport> airportList = as.findAllAirports();
		for (Airport a : airportList) {
			as.removeAirport(a.getIdAirport());
		}
		/*BookService bs = new BookService(getEM());
		List<Book> bookList = bs.findAllBooks();
		for (Book b : bookList) {
			bs.removeBook(b.getId());
		}
		em.getTransaction().commit();
		//
		System.out.println("Cleaned DB");
		System.out.println("------------------------");
		// Begin a new local transaction so that we can persist new entities
		em.getTransaction().begin();
		// create students
		Reader r1 = rs.updateReader(0,"Alice","111111111");
		Reader r2 = rs.updateReader(0,"Bruno","222222222");
		Reader r3 = rs.updateReader(0,"Carlos","333333333");
		Reader r4 = rs.updateReader(0,"Duarte","444444444");
		// create classes and assign them to students
		
		Book b1 = bs.updateBook(0, "IA", "autor 1", false);
		r1.getBooks().add(b1);
		r3.getBooks().add(b1);
		Book b2 = bs.updateBook(0, "POO", "author 2", false);
		r3.getBooks().add(b2);
		Book b3 = bs.updateBook(0, "SD", "author 3", false);
		r4.getBooks().add(b3);
		Book b4 = bs.updateBook(0, "PROJ", "author 2", false);
		r3.getBooks().add(b4);
		Book b5 = bs.updateBook(0, "Lusiadas", "Camões", true);
		Book b6 = bs.updateBook(0, "História", "author 4", true);
		Book b7 = bs.updateBook(0, "Os Maias", "Eça de Queirós", true);

		// Commit the transaction, which will cause the entity to
		// be stored in the database
		em.getTransaction().commit();
		//
		// print the data in the database
		//
		readers = rs.findAllReaders();
		System.out.println("------------------------");
		System.out.println("Readers table");
		for (Reader a : readers) {
			System.out.println(a);
		}
		//
		//books = bs.findAllBooks();
		//System.out.println("------------------------");
		//System.out.println("Books table");
		//for (Book t : books) {
			//System.out.println(t);
		//}
		System.out.println("------------------------");
		System.out.println("\n\nFinished!!!");*/
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	//**********************************************************************************************************************************************************************************************************************************
	public static void insertDataSet (Airport air[]) {
		try {
		air[0]= new PublicAirport(1020,"Airport International ElDorado","Bogota. D.C.","Colombia",5000000);
		air[0].insertCompany(new Company(2010,"Avianca"));
		air[0].insertCompany(new Company(2011,"LATAM"));
		air[0].insertCompany(new Company(2012,"AirEuropa"));
		air[0].insertCompany(new Company(2013,"Iberia"));
		air[0].getCompany("Avianca").insertFlight(new Flight(1,"AV123", "Bogota", "Ciudad de Mexico", 300.00, 200));
		air[0].getCompany("Avianca").insertFlight(new Flight(2,"AV211","Bogota","Ciudad de Mexico", 400.00, 200));
		air[0].getCompany("LATAM").insertFlight(new Flight(3,"LAT211","Bogota","Buenos Aires", 400.00, 200));
		air[0].getCompany("AirEuropa").insertFlight(new Flight(4,"AE365","Bogota","Madrid", 400.00, 200));
		air[0].getCompany("Iberia").insertFlight(new Flight(5,"IBE211","Bogota","Paris", 400.00, 200));
		air[0].getCompany("Avianca").getFlights("AV211").insertPassenger(new Passenger(8562248, "Daniel","Ruiz","Masculino", "DNI","Calle 44a #75e","319487556","dago@gmail.com","AY3985","Colombiano","09/12/2001"));
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
		air[1].getCompany("Avianca").insertFlight(new Flight(6,"AV123", "Bogota", "Ciudad de Mexico", 300.00, 200));
		air[1].getCompany("LATAM").insertFlight(new Flight(7,"LAT211","Bogota","Buenos Aires", 400.00, 200));
		air[1].getCompany("AirEuropa").insertFlight(new Flight(8,"AE365","Bogota","Madrid", 400.00, 200));
		air[1].getCompany("Iberia").insertFlight(new Flight(9, "IBE211","Bogota","Paris", 400.00, 200));
		air[1].getCompany("Avianca").getFlights("AV123").insertPassenger(new Passenger(123456, "Miguel","Caro","Masculino", "DNI","Calle 44a #75e","3194569877","migueloo@gmail.com","AY3244","Colombiano","02/10/2001"));
		air[1].getCompany("Avianca").getFlights("AV123").insertPassenger(new Passenger(456789, "Jose","Reiveira","Masculino", "DNI","Calle 78a #5","317885446","jriveira@gmail.com","AX45224","Colombiano","10/12/1985"));
		air[1].getCompany("LATAM").getFlights("LAT211").insertPassenger(new Passenger(987456, "Maria","Ruiz","Femenino", "DNI","Carrera 21 #89a","321775997","mariaruiz@gmail.com","RT34667","Colombiana","21/09/1999"));
		
		air[2]= new PublicAirport(1021,"Aeropuerto de Oporto-Francisco Sá Carneiro","Oporto","Portugal",5000000);
		air[2].insertCompany(new Company(2012,"AirEuropa"));
		air[2].insertCompany(new Company(2013,"Iberia"));
		air[2].getCompany("AirEuropa").insertFlight(new Flight(10,"AE987","Oporto","Roma", 400.00, 200));
		air[2].getCompany("Iberia").insertFlight(new Flight(11,"IBE211","Oporto","Monaco", 400.00, 200));
		air[2].getCompany("AirEuropa").getFlights("AE987").insertPassenger(new Passenger(123456, "Miguel","Caro","Masculino", "DNI","Calle 44a #75e","3194569877","migueloo@gmail.com","AY3244","Colombiano","02/10/2001"));
		
		air[3]= new PublicAirport(1022,"Aeropuerto Adolfo Suárez Madrid-Barajas","Madrid","Espanha",5000000);
		air[3].insertCompany(new Company(2012,"AirEuropa"));
		air[3].insertCompany(new Company(2013,"Iberia"));	
		air[3].getCompany("AirEuropa").insertFlight(new Flight(12, "AE365","Madrid","Miami", 400.00, 200));
		air[3].getCompany("Iberia").insertFlight(new Flight(13, "IBE852","Madrid","Belgica", 400.00, 200));
		air[3].getCompany("AirEuropa").getFlights("AE365").insertPassenger(new Passenger(123456, "Miguel","Caro","Masculino", "DNI","Calle 44a #75e","3194569877","migueloo@gmail.com","AY3244","Colombiano","02/10/2001"));
		air[3].getCompany("Iberia").getFlights("IBE852").insertPassenger(new Passenger(456789, "Jose","Reiveira","Masculino", "DNI","Calle 78a #5","317885446","jriveira@gmail.com","AX45224","Colombiano","10/12/1985"));
		} catch (Exception e) {
	        System.out.println("Error data Import: " + e.getMessage());
	    }
	}
	
	
	// MENUS 
	//**********************************************************************************************************************************************************************************************************************************
	//**********************************************************************************************************************************************************************************************************************************
		
	public static void menu1() {
		Scanner scanner = new Scanner(System.in);
        int op, numAirports;
        
        do {
        	try {
            showMenu1();
            System.out.print(">>: ");
            op = scanner.nextInt();

            switch (op) {
                case 1:
                	scanner.nextLine();
                	System.out.println("\nEnter the number of airports: ");
                	System.out.print(">>: ");
                    numAirports = scanner.nextInt();
                    airports = new Airport[numAirports];
                    System.out.println("\nDATA LOADED CORRECTLY!!.\n");
                    insertDataSet(airports);
                    break;
                case 2:
                	scanner.nextLine();
                	 System.out.println("\nINSERT MENU\n");
                	menuIntsertData();
                    break;
                case 3:
                	scanner.nextLine();
                    System.out.println("\nMANAGEMENT MENU\n");
                    menu2();
                    
                    break;             
                case 4:
                	scanner.nextLine();
                    System.out.println("Leaving the programme - see you later!");
                    break;
                default:
                    System.out.println("Invalid option. Please enter a valid option.");                 
            }
        	} catch (InputMismatchException e) {
                System.out.println("Error: Enter a valid value.");
                scanner.nextLine(); 
                op = 0; 
            } catch (Exception e) {
                System.out.println("Error ocurred: " + e.getMessage());
                op = 0; 
            }
            
        } while (op != 4);

        
	}
	
	public static void showMenu1() {
		System.out.println("\n*************************************");
        System.out.println("************* Main Menu *************");
        System.out.println("* 1. Insert pre-defined Data Set    *");
        System.out.println("* 2. Enter Manual Data              *");
        System.out.println("* 3. Management Menu                *");
        System.out.println("* 4. Log out of the system          *");
        System.out.println("*************************************");
    }
	//**********************************************************************************************************************************************************************************************************************************
	//**********************************************************************************************************************************************************************************************************************************
	
	public static void menuIntsertData() {
		Scanner scanner = new Scanner(System.in);
        int op3;
        String sNameAirport, sNameCompany, sCityOrigin, sCityDest;
        Airport airport;
        Company company;

        do {
        	try {
            showMenu3();
            System.out.print(">>: ");
            op3 = scanner.nextInt();
            scanner.nextLine();
            switch (op3) {
                case 1:
                	System.out.println("");
                    System.out.println("\nShow Management Airports\n");
                    showAirportData(airports);            	
                    break;
                case 2:               	
                	insertAirports();
                    break;
                case 3:
                	
                    
                    break;
                case 4:
                	
                    break;
                case 5:
                	
                    break;
                case 6:
                	
                    break;
                default:
                    System.out.println("Invalid option. Please enter a valid option.");
            }
		        } catch (InputMismatchException e) {
		            System.out.println("Error: Enter a valid value.");
		            scanner.nextLine(); 
		            op3 = 0; 
		        } catch (Exception e) {
		            System.out.println("Error Ocurred: " + e.getMessage());
		            op3 = 0; 
		        }
		        } while (op3 != 6);

       
	}
	
	public static void showMenu3() {
		System.out.println("\n*************************************");
        System.out.println("************ Insert Menu ************");
        System.out.println("* 1. Show RegisteredAirports        *");
        System.out.println("* 2. Insert new Airport             *");
        System.out.println("* 3. Insert new Airline             *");
        System.out.println("* 4. Insert new Flight              *");
        System.out.println("* 5. Insert new Passenger           *");
        System.out.println("* 6. Exit Insert Menu               *");
        System.out.println("*************************************");
    }
	
	public static void insertAirports() {
		Scanner scanner = new Scanner(System.in);
        int op4;
        String sNameAirport, sNameCompany, sCityOrigin, sCityDest;
        Airport airport;
        Company company;

        do {
        	try {
            showMenu4();
            System.out.print(">>: ");
            op4 = scanner.nextInt();
            scanner.nextLine();
            switch (op4) {
                case 1:
                	createPrivateAirport();         	
                    break;
                case 2:               	  	 
                   createPublicAirport(airports);
                    break;
                case 3:     
                    break;
                default:
                    System.out.println("Invalid option. Please enter a valid option.");
            }
		        } catch (InputMismatchException e) {
		            System.out.println("Error: Enter a valid value.");
		            scanner.nextLine(); 
		            op4 = 0; 
		        } catch (Exception e) {
		            System.out.println("Error Ocurred: " + e.getMessage());
		            op4 = 0; 
		        }
		        } while (op4 != 3);
	}
	public static void showMenu4() {
		System.out.println("\n*************************************");
        System.out.println("******* Insert Airports Menu ********");
        System.out.println("* 1. Insert New Airport Private     *");
        System.out.println("* 2. Insert New Airport Public      *");
        System.out.println("* 3. Exit Insert Airports Menu      *");
        System.out.println("*************************************");
    }
	
	public static void createPublicAirport(Airport air[]) {
	    Scanner scanner = new Scanner(System.in);
	    System.out.println("Ingrese los datos para el aeropuerto público:");

	    // Ingresar datos comunes para todos los aeropuertos
	    System.out.println("ID Airport: ");
	    System.out.print(">>: ");
	    int id = scanner.nextInt();
	    scanner.nextLine(); // Limpiar el buffer

	    System.out.println("Name: ");
	    System.out.print(">>: ");
	    String name = scanner.nextLine();

	    System.out.println("City: ");
	    System.out.print(">>: ");
	    String city = scanner.nextLine();

	    System.out.println("Country: ");
	    System.out.print(">>: ");
	    String country = scanner.nextLine();

	    System.out.println("Subsidio suministrado : ");
	    System.out.print(">>: ");
	    double subsidy = scanner.nextLong();
	    scanner.nextLine(); // Limpiar el buffer

	    // Crear el aeropuerto público y almacenarlo en el arreglo
	    air[air.length - 1] = new PublicAirport(id, name, city, country, subsidy);
	}
	  private static PrivateAirport createPrivateAirport() {
		    Scanner scanner = new Scanner(System.in);
	        System.out.println("Ingrese los datos para el aeropuerto privado:");

	        // Ingresar datos comunes para todos los aeropuertos
	        System.out.print("ID: ");
	        int id = scanner.nextInt();
	        scanner.nextLine(); // Limpiar el buffer

	        System.out.print("Nombre: ");
	        String name = scanner.nextLine();

	        System.out.print("Ciudad: ");
	        String city = scanner.nextLine();

	        System.out.print("País: ");
	        String country = scanner.nextLine();

	        // Crear el aeropuerto privado
	        PrivateAirport privateAirport = new PrivateAirport(id, name, city, country);

	        return privateAirport;
	    }

	//**********************************************************************************************************************************************************************************************************************************
	//**********************************************************************************************************************************************************************************************************************************
	
	public static void menu2() {
		Scanner scanner = new Scanner(System.in);
        int op2;
        String sNameAirport, sNameCompany, sCityOrigin, sCityDest;
        Airport airport;
        Company company;

        do {
        	try {
            showMenu2();
            System.out.print(">>: ");
            op2 = scanner.nextInt();
            scanner.nextLine();
            switch (op2) {
                case 1:
                	
                	System.out.println("");
                    System.out.println("\nShow Management Airports\n");
                    showAirportData(airports);
                    break;
                case 2:               	
                	System.out.println("\n------------------------------------------------------------");
                    System.out.println("\nShow Sponsors Airports\n");
                    showSponsorAirportPrivate(airports);
                    break;
                case 3:
                	System.out.println("\n------------------------------------------------------------");
                    System.out.println("\nShow Sponsors Airports\n");
                    showSponsorAirportPublic(airports);
                    
                    break;
                case 4:
                	scanner.nextLine();
                	System.out.println("");
                    System.out.println("\nPlease enter the name of the airport you wish to search for: ");
                    System.out.print(">>: ");
                    sNameAirport= scanner.nextLine();
                    airport=searchAirport(sNameAirport, airports);
                    if (airport==null) {
                    	System.out.println("The entered airport is not in the database.");
                    }
                    else {
                    	showCompanys(airport);
                    }
                    break;
                case 5:
                	scanner.nextLine();
                	System.out.println("");
                	System.out.println("\nPlease enter the name of the airport you wish to search for: ");
                	System.out.print(">>: ");
                    sNameAirport= scanner.nextLine();
                    airport=searchAirport(sNameAirport, airports);
                    if (airport==null) {
                    	System.out.println("\nThe entered airport is not in the database.");
                    }
                    else {
                    	showCompanys(airport);
                    	System.out.println("\nPlease enter the name of the company you wish to search for: ");
                    	System.out.print(">>: ");
                    	sNameCompany = scanner.nextLine();
                    	company =airport.getCompany(sNameCompany);
                    	showFlights(company);
                    }
                
                    break;
                case 6:
                	scanner.nextLine();
                	System.out.println("");
                	System.out.println("\nPlease enter the name of the Origin City: ");
                	System.out.print(">>: ");
                	sCityOrigin = scanner.nextLine();
                	System.out.println("\nPlease enter the name of the Destination City: ");
                	System.out.print(">>: ");
                	sCityDest = scanner.nextLine();
                	showFlightsOriginDest(sCityOrigin,sCityDest,airports);
                    break;
                case 7:
                	scanner.nextLine();
                    System.out.println("Exiting the Management Menu");
                    break;
                default:
                    System.out.println("Invalid option. Please enter a valid option.");
            }
		        } catch (InputMismatchException e) {
		            System.out.println("Error: Enter a valid value.");
		            scanner.nextLine(); 
		            op2 = 0; 
		        } catch (Exception e) {
		            System.out.println("Error Ocurred: " + e.getMessage());
		            op2 = 0; 
		        }
		        } while (op2 != 7);

       
	}
	
	
	public static void showMenu2() {
		System.out.println("\n************************************************************");
        System.out.println("******************* MANAGEMENT Menú ************************");
        System.out.println("* 1. View Managed Airports (Public and Private)            *");
        System.out.println("* 2. View Companies the Private Airports                   *");
        System.out.println("* 3. View government subsidy the Public Airports           *");
        System.out.println("* 4. List of airport companies                             *");
        System.out.println("* 5. List of flights by airline                            *");
        System.out.println("* 6. List Possible flights from Origin to Destination      *");
        System.out.println("* 7. Exit Management Menu                                  *");
        System.out.println("*************************************************************");
    }
	
	
	
	//**********************************************************************************************************************************************************************************************************************************
	//**********************************************************************************************************************************************************************************************************************************
		
	public static void showAirportData(Airport airports[] ){
		
		
		for (int i=0; i<airports.length;i++){
			if(airports[i] instanceof PrivateAirport) {
				System.out.println("\n------------------------------------------------------");
				System.out.println("|N: "+(i+1));
				System.out.println("------------------------------------------------------");
				System.out.println("|Type: Private Airport");
				System.out.println("|-ID Airport: "+airports[i].getIdAirport());
				System.out.println("|-Name Airport: "+airports[i].getName());
				System.out.println("|-City: "+airports[i].getCity());
				System.out.println("|-Country: "+airports[i].getCountry());
				System.out.println("------------------------------------------------------\n");
				System.out.println("");
			}
			else {
				System.out.println("\n------------------------------------------------------");
				System.out.println("|N: "+(i+1));
				System.out.println("------------------------------------------------------");
				System.out.println("|-Type: Public Airport");
				System.out.println("|-ID Airport: "+airports[i].getIdAirport());
				System.out.println("|-Name Airport: "+airports[i].getName());
				System.out.println("|-City: "+airports[i].getCity());
				System.out.println("|-Country: "+airports[i].getCountry());
				System.out.println("------------------------------------------------------\n");
				System.out.println("");
				
			}
		}
		
	}
	
	public static void showSponsorAirportPrivate(Airport airports[]) {
		
		String enterprises[];
		
		for (int i=0; i<airports.length;i++){
			if(airports[i] instanceof PrivateAirport) {
				System.out.println("\n------------------------------------------------------");
				System.out.println("N: "+(i+1));
				System.out.println("------------------------------------------------------");
				System.out.println("\nPrivate Airport");
				System.out.println("Name Airport: "+airports[i].getName());
				enterprises=((PrivateAirport)airports[i]).getListEnterprises();
				System.out.println("Enterprises: ");
				for(int j=0;j<enterprises.length;j++) {
					System.out.println((j+1)+"- "+enterprises[j]);
				}
				System.out.println("------------------------------------------------------\n");
			 }		
		}
	}
	
public static void showSponsorAirportPublic(Airport airports[]) {
				
		for (int i=0; i<airports.length;i++){
			if(airports[i] instanceof PrivateAirport) {		
			}
			else {
			System.out.println("\n------------------------------------------------------");
			System.out.println("N: "+(i+1));
			System.out.println("------------------------------------------------------");
			System.out.println("Public Airport");
			System.out.println("Name Airport: "+airports[i].getName());
			System.out.println("Subsidy: "+((PublicAirport)airports[i]).getSubsidy());
			System.out.println("");
			System.out.println("------------------------------------------------------\n");
			}
		}	
	}
	
	public static Airport searchAirport(String name, Airport airports[]) {
		boolean find=false;
		int i=0;
		Airport air=null;
		//secuential find
		while((!find) && (i<airports.length)) {
			if (name.equals(airports[i].getName())){
				find=true;
				air=airports[i];
			}
			i++;
		}
		return air;
	}
	public static void showCompanys(Airport airport) {
		System.out.println("Airport: "+airport.getName());
		for (int i=0; i<airport.getNumCompany();i++) {
			try {
			System.out.println(airport.getCompany(i).getName());
			}catch (ArrayIndexOutOfBoundsException e) {
	            System.out.println("Error: index out of bounds.");
	        }
		}
				
	}
	
	public static void showFlights(Company company) {
		Flight flight;
		System.out.println("the company's flights: "+company.getName());
		for (int i=0; i<company.getNumFlight();i++) {
			flight=company.getFlight(i);
			System.out.println("ID Flight: "+flight.getIdFlight());
			System.out.println("City of Origin: "+flight.getOriginCity());
			System.out.println("City of Destination: "+flight.getDestinationCity());
			System.out.println("Cost"+flight.getCost());
			System.out.println("");
					
		}
				
	}
    public static Flight[] searchFlightsOriginDest(String cityOrigin, String cityDest, Airport airports[])  {
    	
    	Flight flight,  listFlights[];
    	int cont=0;   
    	for(int i=0; i<airports.length;i++) {
    		for(int j=0; j<airports[i].getNumCompany();j++) {
    			for(int k=0; k<airports[i].getCompany(j).getNumFlight();k++) {
    				flight=airports[i].getCompany(j).getFlight(k);
        			if((cityOrigin.equals(flight.getOriginCity())) && (cityDest.equals(flight.getDestinationCity()))) {
        				cont++;
        			}           		
            	}  		
        	}
    	}
    	
    	listFlights=new Flight[cont];
    	int q=0;
    	for(int i=0; i<airports.length;i++) {
    		for(int j=0; j<airports[i].getNumCompany();j++) {
    			for(int k=0; k<airports[i].getCompany(j).getNumFlight();k++) {
    				flight=airports[i].getCompany(j).getFlight(k);
        			if((cityOrigin.equals(flight.getOriginCity())) && (cityDest.equals(flight.getDestinationCity()))) {
        				listFlights[q]=flight;
        				q++;
        			}          		
            	}  		
        	}
    	}
    	
		return listFlights;
	}
	public static void showFlightsOriginDest(String cityOrigin, String cityDest, Airport airports[]) {
		Flight flights[];
		flights=searchFlightsOriginDest(cityOrigin, cityDest, airports);
		if(flights.length==0) {
			System.out.println("There are no flights from that city of origin to destination.");
		}
		else {
			System.out.println("\nFlights found: \n");
			for(int i=0;i<flights.length;i++) {
				System.out.println("ID Flight: "+flights[i].getIdFlight());
				System.out.println("City of Origin: "+flights[i].getOriginCity());
				System.out.println("City of Destination: "+flights[i].getDestinationCity());
				System.out.println("Cost"+flights[i].getCost());
				System.out.println("");
			}
		}	
		
	}

	public static void main(String[] args) {
		menu1();
	}
	
}
