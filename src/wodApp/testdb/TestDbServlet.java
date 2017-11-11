package wodApp.testdb;

import java.io.IOException;



import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class TestDbServlet
 */
@WebServlet("/TestDbServlet")
public class TestDbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// setup connection variables
		String user = "stavros";
		String pass = "kapridakis";

		String jdbcUrl = "jdbc:mysql://localhost:3306/finalproject?useSSL=false";

		String driver = "com.mysql.jdbc.Driver";

		// get connection to database

		try {
			PrintWriter out = response.getWriter();
			out.println("Connecting to databse: " + jdbcUrl);

			Class.forName(driver);

			Connection myConn = DriverManager.getConnection(jdbcUrl, user, pass);

			out.println("Success !");

			myConn.close();
		} catch (Exception exc) {
			exc.printStackTrace();

			throw new ServletException(exc);

		}

	}

}
