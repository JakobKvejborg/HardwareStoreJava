package tui;

import java.time.LocalDateTime;

import model.Aisle;
import model.Customer;
import model.CustomerContainer;
import model.CustomerGroup;
import model.LendableCopy;
import model.LendableProduct;
import model.Location;
import model.ShelfProduct;
import model.ShelfStock;
import model.UniqueCopy;
import model.UniqueProduct;
import model.ProductContainer;
import model.UniqueStock;

/**
 * This class is used to create test environment with dummy data.
 * 
 * @author Patrick Thor Sorenson De Siqueira
 * @version 15/12/2023
 * @since 14/12/2023
 */
public class TryMe {
	private static CustomerContainer customerContainer;
	private static ProductContainer productContainer;
	
	/**
	 * This method creates two <code>Customer</code> as dummy data and adds them to <code>customerContainer</code>.
	 */
	public static void createCustomers() {
		customerContainer = CustomerContainer.getInstance();
		Customer customer1 = new Customer("John", "UCN", "12345678", "School@UCN.dk");
		Customer customer2 = new Customer("Jane", "The Moon", "87654321", "Moonbase@Alpha.dk");
		customer2.setCustomerGroup(new CustomerGroup("Cool dudes club","Cool Private Customers",0.2,LocalDateTime.of(2022,01,1,1,1,1)));
		
		customerContainer.addCustomer(customer1);
		customerContainer.addCustomer(customer2);
	}
	
	/**
	 * This method creates two <code>ShelfProduct</code> and <code>UniqueCopy</code> as dummy data and adds them to <code>productContainer</code> and stock.
	 */
	public static void createProducts(Location location) {
		
		//Aisle aisle = new Aisle("Area 51, shelf 3.", location);
		
		productContainer = ProductContainer.getInstance();
		ShelfProduct product1 = new ShelfProduct("Table", "Bedstefar-ryster spisebordet er det perfekte valg til dit spisestueområde. Med sin moderne og stilfulde design vil dette firkantede spisebord tilføje elegance og funktionalitet til enhver indretning.\r\n"
				+ "\r\n"
				+ "Bordpladen er lavet af sort træ-look MDF, hvilket giver en smuk og holdbar overflade. Den er monteret på sorte folierede metalben, der tilføjer stabilitet og styrke til bordet.\r\n"
				+ "\r\n"
				+ "Med en længde på 120 cm er dette spisebord ideelt til mindre spisestuer eller køkkener. Det giver tilstrækkelig plads til at rumme op til fire personer, så du kan nyde måltider med familie og venner.\r\n"
				+ "\r\n"
				+ "Bedstefar-ryster spisebordet er en del af Bedstemor-ryster-serien, der er kendt for sin kvalitet og stil. Det er et bord, der er designet til at vare, og det vil være en investering, der holder i mange år fremover.\r\n"
				+ "\r\n"
				+ "Specifikationer\r\n"
				+ "Produktnavn	Bedstefar-ryster spisebord 120 cm sort MDF/metal\r\n"
				+ "Artikelnummer	1437214\r\n"
				+ "Vægt, kg.	24.200000\r\n"
				+ "EAN-nr	5711950274247\r\n"
				+ "Nettovægt, kg.	23.000\r\n"
				+ "Varemærke	Bedstefar-ryster\r\n"
				+ "Produkttype	Borde\r\n"
				+ "Serie	Bedstemor-ryster\r\n"
				+ "Farve	Sort folie\r\n"
				+ "Dimensioner	76 x 120 x 80 cm ( H x B x D )\r\n"
				+ "Materiale	MDF/Metal\r\n"
				+ "Bredde	120 cm\r\n"
				+ "Højde	76 cm", "123456", 9.99, 19.99, 0, LocalDateTime.of(2022,01,1,1,1,1));
		ShelfProduct product2 = new ShelfProduct("Chair", "Bedstefar-ryster stolen er den perfekte tilføjelse til dit spisebord. Disse spisestuestole er designet med fokus på både stil og komfort. Betrukket med rose velvet stof og monteret på elegante metalben, tilføjer de et sofistikeret og moderne touch til dit hjem.\r\n"
				+ "\r\n"
				+ "Bedstefar-ryster spisestuestolene er ikke kun smukke, men også utrolig behagelige at sidde i. Den bløde polstring og ryglæn giver optimal støtte og komfort, så du kan nyde lange middage med familie og venner uden at føle ubehag.\r\n"
				+ "\r\n"
				+ "Disse Bedstefar-ryster stole er perfekt til at opgradere dit spiseområde eller tilføje ekstra siddepladser til dit hjem. Du kan nemt placere dem omkring dit spisebord eller bruge dem som stilfulde stole i stuen eller soveværelset.\r\n"
				+ "\r\n"
				+ "Bedstefar-ryster stole er ikke kun smukke, men også holdbare. De er fremstillet af høj kvalitet metal og stof, der sikrer langvarig brug og modstandsdygtighed over for daglig slitage.\r\n"
				+ "\r\n"
				+ "Giv dit hjem et elegant og moderne udseende med Bedstefar-ryster stole.\r\n"
				+ "\r\n"
				+ "Specifikationer\r\n"
				+ "Produktnavn	Bedstefar-ryster stol rose 2 stk\r\n"
				+ "Artikelnummer	1437263\r\n"
				+ "Vægt, kg.	15.400000\r\n"
				+ "EAN-nr	5711950306900\r\n"
				+ "Nettovægt, kg.	13.000\r\n"
				+ "Varemærke	Bedstefar-ryster\r\n"
				+ "Produkttype	Spisebordsstole\r\n"
				+ "Serie	Bedstemor-ryster\r\n"
				+ "Farve	Rose stof\r\n"
				+ "Dimensioner	80 x 58 x 60 cm ( H x B x D )\r\n"
				+ "Materiale	Metal/stof\r\n"
				+ "Bredde	58 cm\r\n"
				+ "Højde	80 cm", "654321", 25.99, 35.99, 0.15, LocalDateTime.of(2022,01,1,1,1,1));
		ShelfProduct product3 = new ShelfProduct("Skruer", "Søm i en butik er som modeverdenens små superhelte. De er de stille kræfter, der holder alt sammen med stil og elegance.\r\n "
				+ "\r\n"
				+ "Disse små, spidse helte arbejder i skyggen af sko, tøj og tilbehør, og selvom de kan virke ubetydelige, er de faktisk de usynlige lim, der holder vores garderober sammen.\r\n "
				+ "\r\n"
				+ "Så næste gang du ser en søm i en butik, husk at give den en stille tak for at holde din stil på plads og dine outfits sammenbundet med en subtil finesse! \r\n"
				+ "\r\n"
				+ "Specifikationer\r\n"
				+ "Produktnavn: Skrue 3,5x25 mm\r\n"
				+ "Artikelnummer: 1063864\r\n"
				+ "Vægt, kg.: 0.052000\r\n"
				+ "EAN-nr: 5701291506756\r\n"
				+ "Nettovægt, kg.: 0.052\r\n"
				+ "Produkttype:	skruer\r\n"
				+ "Dimensioner:	25 x 3.5 mm ( L x Ø )\r\n"
				+ "Amount per package (stk): 30\r\n"
				+ "Diameter: 3.5 mm\r\n"
				+ "Længde: 25 mm", "1", 30.99, 79.99, 0, LocalDateTime.of(2022,01,1,1,1,1));
		ShelfStock product1Stock = new ShelfStock(location, 5, 2, 20);
		ShelfStock product2Stock = new ShelfStock(location, 12, 3, 20);
		ShelfStock product3Stock = new ShelfStock(location, 10, 4, 10);

		product1.addStock(product1Stock);
		product2.addStock(product2Stock);
		product3.addStock(product3Stock);
		
		productContainer.addProduct(product1);
		productContainer.addProduct(product2);
		productContainer.addProduct(product3);
		
		UniqueProduct product4 = new UniqueProduct("Fridge", "Køleskabet i butikken er som det cool, frostbeklædte sind i madverdenens VIP-lounge. Det er stedet, hvor ostene hænger ud og grøntsagerne holder cool party.\r\n "
				+ "\r\n"
				+ "Køleskabet er bogstaveligt talt den chill zone, hvor ingredienserne slapper af og nyder lidt kølig luksus, mens de venter på at blive de stjerner, de er født til at være.\r\n "
				+ "\r\n"
				+ "Så næste gang du åbner døren til et køleskab i butikken, husk at det ikke bare er et apparat, det er et madshow backstage – komplet med køleblitz og frysetrommer!\r\n"
				+ "\r\n"
				+ "Specifikationer\r\n"
				+ "Mål og vægt\r\n"
				+ "Højde (cm)	187.5\r\n"
				+ "Bredde (cm)	59.5\r\n"
				+ "Dybde (cm)	63\r\n"
				+ "Vægt (kg)	69\r\n"
				+ "Højde (inkl. emballage)	187,5 cm\r\n"
				+ "Bredde (inkl. emballage)	59,5 cm\r\n"
				+ "Dybde (inkl. emballage)	63,0 cm\r\n"
				+ "Vægt (inkl. emballage)	71,0 kg", "111", 399.99, 699.99, 0.05, LocalDateTime.of(2022,01,1,1,1,1), "This warrenty is a String!");
		
		productContainer.addProduct(product4);
		
		UniqueCopy copy1 = new UniqueCopy("222", product4);
		UniqueCopy copy2 = new UniqueCopy("333", product4);
		UniqueStock copyStock = new UniqueStock(location, 2, 7);
		product4.addStock(copyStock);
		copy1.setStock(copyStock);
		copy2.setStock(copyStock);
		copyStock.addCopy(copy1);
		copyStock.addCopy(copy2);
		
		LendableProduct lendableProduct = new LendableProduct("Tractor", "Traktoren, også kendt som den firehjulede landdansker, er naturens svar på en festvogn med traktordæk, der tramper gennem markerne som et landligt diskotek.\r\n "
				+ "Med en krop, der skriger \"jeg er klar til at pløje og feste!\", og lyden af motoren, der synger en symfoni af landlivets rytmer, er traktoren som en rockstjerne i agerens verden.\r\n "
				+ "Den bærer sit eget sæt af \"agrikulære\" moves, når den bevæger sig igennem landskabet og spreder landlig glæde, som om den er på en permanent country-festival på hjul.\r\n"
				+ "Den er ikke bare en maskine; den er en bondefiesta på fire hjul!", "987789", 4999, 12, 0, 13, 0);
		productContainer.addProduct(lendableProduct);
		LendableCopy leaseCopy = new LendableCopy("999", lendableProduct);
		UniqueStock loanLeaseStock = new UniqueStock(location, 2, 7);
		lendableProduct.addStock(loanLeaseStock);
		leaseCopy.setStock(loanLeaseStock);
		loanLeaseStock.addCopy(leaseCopy);
		
		productContainer.addCopy(copy1);
		productContainer.addCopy(copy2);
		productContainer.addCopy(leaseCopy);

		

	}
	
}
