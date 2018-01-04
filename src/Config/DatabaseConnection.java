package Config;

import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.eclipse.jetty.websocket.WebSocket.Connection;
import org.testng.annotations.Test;

public class DatabaseConnection {

	SingleTonInstance prop = SingleTonInstance.getConfiguration();
	private static Logger LOGGER = Logger.getLogger("DatabaseConnection");

	private static Connection connection;
	private static DatabaseConnection dbIsntance;
	private static Connection con;

	private DatabaseConnection() {
		// private constructor //
	}

	public static DatabaseConnection getInstance() {
		if (dbIsntance == null) {
			dbIsntance = new DatabaseConnection();
		}
		return dbIsntance;
	}

	
	public Connection getConnection() {

		LOGGER.info("Connecting to IBS database");

		if (con == null) {
			try {

				String databaseURL = "jdbc:oracle:thin:@192.168.28.92:1521:orcl";
				String user = "TUQM3002";
				String password = "TUQM3002";
				Class.forName("oracle.jdbc.xa.client.OracleXADataSource");
				System.out.println("Connecting to IBS Database...");

				connection = (Connection) DriverManager.getConnection(databaseURL, user, password);

				if (connection != null) {

					System.out.println("Connected to the IBS Database...");
				}

			} catch (SQLException | ClassNotFoundException ex) {

				LOGGER.info("Connected to IBS database");

			}

		}
		return connection;

	}

	@Test
	public void closeConnection(Connection conn) {

		LOGGER.info("Disconnecting database connection");

		if (connection != null) {
			System.out.println("Closing Database Connection...");
			conn.close();

			LOGGER.info("Database connection disconnected");
		}
	}
}
