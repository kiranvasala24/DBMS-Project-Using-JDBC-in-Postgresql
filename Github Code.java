import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class main {
    public static void main(String[] args) {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            // Handle the exception accordingly
        }

        try {
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "root");

	//Query 3 - The product p1 changes its name to pp1 in Product and Stock.
  // Update Product table
            Statement updateStatement = connection.createStatement();
            updateStatement.executeUpdate("UPDATE Product SET pname = 'pp1' WHERE pname = 'p1'");
            updateStatement.close();

            // Update Stock table
            Statement updateStockStatement = connection.createStatement();
            updateStockStatement.executeUpdate("UPDATE Stock SET prod = 'pp1' WHERE prod = 'p1'");
            updateStockStatement.close();
	
	//Query 4 - The depot d1 changes its name to dd1 in Depot and Stock.
	// Update Depot table
            Statement updateDepotStatement = connection.createStatement();
            updateDepotStatement.executeUpdate("UPDATE Depot SET dep = 'dd1' WHERE dep = 'd1'");
            updateDepotStatement.close();

            // Update Stock table
            Statement updateStockStatement = connection.createStatement();
            updateStockStatement.executeUpdate("UPDATE Stock SET dep = 'dd1' WHERE dep = 'd1'");
            updateStockStatement.close();

	//Query 5 - We add a product (p100, cd, 5) in Product and (p100, d2, 50) in Stock.
              // Insert into Product table
            Statement insertProductStatement = connection.createStatement();
            insertProductStatement.executeUpdate("INSERT INTO Product(prod, pname, price) VALUES ('p100', 'cd', 5)");
            insertProductStatement.close();

            // Insert into Stock table
            Statement insertStockStatement = connection.createStatement();
            insertStockStatement.executeUpdate("INSERT INTO Stock(prod, dep, quantity) VALUES ('p100', 'd2', 50)");
            insertStockStatement.close();


	//Query 6 - We add a depot (d100, Chicago, 100) in Depot and (p1, d100, 100) in Stock.
            // Insert into Depot table
            Statement insertDepotStatement = connection.createStatement();
            insertDepotStatement.executeUpdate("INSERT INTO Depot(dep, addr, volume) VALUES ('d100', 'Chicago', 100)");
            insertDepotStatement.close();

            // Insert into Stock table
            Statement insertStockStatement = connection.createStatement();
            insertStockStatement.executeUpdate("INSERT INTO Stock(prod, dep, quantity) VALUES ('p1', 'd100', 100)");
            insertStockStatement.close();

            // Fetch the updated content of the Depot table
            Statement fetchDepotStatement = connection.createStatement();
            ResultSet depotResultSet = fetchDepotStatement.executeQuery("SELECT * FROM Depot");

            // Display the updated contents of the Depot table
            System.out.println("Depot Table:");
            while (depotResultSet.next()) {
                String depotId = depotResultSet.getString("dep");
                String location = depotResultSet.getString("addr");
                int volume = depotResultSet.getInt("volume");
                System.out.println("Depot : " + depotId + ", Address: " + location + ", Volume: " + volume);
            }
            depotResultSet.close();
            fetchDepotStatement.close();

            // Fetch the updated content of the Stock table
            Statement fetchStockStatement = connection.createStatement();
            ResultSet stockResultSet = fetchStockStatement.executeQuery("SELECT * FROM Stock");

            // Display the updated contents of the Stock table
            System.out.println("\nStock Table:");
            while (stockResultSet.next()) {
                String product = stockResultSet.getString("prod");
                String department = stockResultSet.getString("dep");
                int quantity = stockResultSet.getInt("quantity");
                System.out.println("Product: " + product + ", Department: " + department + ", Quantity: " + quantity);
            }
            stockResultSet.close();
            fetchStockStatement.close();

	 // Fetch the updated content of the Product table
            Statement fetchProductStatement = connection.createStatement();
            ResultSet productResultSet = fetchProductStatement.executeQuery("SELECT * FROM Product");	

	// Display the updated contents of the Product table
            System.out.println("Product Table:");
            while (productResultSet.next()) {
            	String product = productResultSet.getString("prod");
                String productName = productResultSet.getString("pname");
                String price = productResultSet.getString("price");
                
                // You can add other columns here according to your Product table schema
                System.out.println("Product:" +product+ ", Product Name: " + productName+ ", Price: "+price);
            }
            productResultSet.close();
            fetchProductStatement.close();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
