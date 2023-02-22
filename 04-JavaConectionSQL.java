import java.sql.*;


public class JavaConectionSQL {
    static final String DB_URL = "jdbc:mysql://localhost/restaurant";
    static final String USER = "root";
    static final String PASS = " ";
    static final String QUERY = "SELECT Customer_Id, Customer_ForeName, Customer_SurName, Customer_Telephone, Email  FROM customer";
    static final String QUERYDELETE = "SELECT Orders_Id, Merchandices_Id, Quantity  FROM order_merchandices";

    public static void main(String[] args) {

        System.out.println("------------------ JAVA CONNECTION FOR SQL ------------------- ");
        System.out.println("*************** ERLING EDUARDO MUNGUIA URBINA **************** ");

        showValues();
        insertValues();
        updateValues();
        deleteValues();

    }

    private static void showValues() {

        System.out.println("method to SHOW values FROM the table customer at the Restaurant DataBase");

        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(QUERY);
        ) {
            while(rs.next()){
                //Display values
                System.out.print("Customer_Id: " + rs.getInt("Customer_Id"));
                System.out.print(", Customer_ForeName: " + rs.getString("Customer_ForeName"));
                System.out.print(", Customer_SurName: " + rs.getString("Customer_SurName"));
                System.out.println(", Customer_Telephone: " + rs.getString("Customer_Telephone"));
                System.out.println(", Email: " + rs.getString("Email"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    private static void deleteValues() {

        System.out.println("method to DELETE values FROM the table customer at the Restaurant DataBase");

        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();
        ) {
            String sql = "DELETE FROM order_merchandices WHERE Orders_Id = 305";
            stmt.executeUpdate(sql);
            ResultSet rs = stmt.executeQuery(QUERYDELETE);
            while(rs.next()){
                //Display values
                System.out.print("Orders_Id: " + rs.getInt("Orders_Id"));
                System.out.print(", Merchandices_Id: " + rs.getInt("Merchandices_Id"));
                System.out.print(", Quantity: " + rs.getInt("Quantity"));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    private static void updateValues() {

        System.out.println("method to UPDATE values to the table customer at the Restaurant DataBase");

        // Open a connection
                try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
                    Statement stmt = conn.createStatement();
                ) {
                    String sql = "UPDATE customer " +
                            "SET Customer_SurName = 'FERNANDEZ' WHERE Customer_Id in (50)";
                    stmt.executeUpdate(sql);
                    ResultSet rs = stmt.executeQuery(QUERY);
                    while(rs.next()){
                        //Display values
                        System.out.print("Customer_Id: " + rs.getInt("Customer_Id"));
                        System.out.print(", Customer_ForeName: " + rs.getString("Customer_ForeName"));
                        System.out.print(", Customer_SurName: " + rs.getString("Customer_SurName"));
                        System.out.println(", Customer_Telephone: " + rs.getString("Customer_Telephone"));
                        System.out.println(", Email: " + rs.getString("Email"));
                    }
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

    }


    private static void insertValues() {

        System.out.println("method to INSERT values to the table customer at the Restaurant DataBase");

        // Open a connection
        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();
        ) {
            // Execute a query
            System.out.println("Inserting records into the table...");
            String sql = "INSERT INTO customer VALUES (50, 'Aaaa', 'Aaaaa', '87671999', 'json@gmail.com')";
            stmt.executeUpdate(sql);
            sql = "INSERT INTO customer VALUES (51, 'Aaaa', 'Aaaaa', '87671999', 'json@gmail.com')";
            stmt.executeUpdate(sql);

            System.out.println("Inserted records into the table...");
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }


}

