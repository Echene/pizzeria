/**
 * 
 */
package pizzeria.bdd;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.ResourceBundle;

/**
 * @author Emmanuel
 *
 */
public class ConnectionBDD {

	private ConnectionBDD() {

	}

	public static Connection getConnection() {

		System.out.println("Create jdbc connection using properties file");

		Connection connection = null;

		try {

			ResourceBundle bundle = ResourceBundle.getBundle("jdbc");

			String url = bundle.getString("url");
			String username = bundle.getString("username");
			String password = bundle.getString("password");
			
			Class.forName(bundle.getString("driver"));

			connection = DriverManager.getConnection(url, username, password);

			if (connection != null) {
				System.out.println("connection created successfully using properties file");
			}

			else {
				System.out.println(" unable to create connection");
			}

		} catch (SQLException e) {
			e.printStackTrace();

		} catch (Exception e) {
			e.printStackTrace();

		}

		return connection;
	}

}
