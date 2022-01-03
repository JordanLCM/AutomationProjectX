package Jdbc.Connection;
import java.io.IOException;
//import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.protocol.Resultset;

/**
 * Servlet implementation class JdbcOfficial
 */
@WebServlet("/JdbcOfficial")
public class JdbcOfficial extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JdbcOfficial() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
			
			try {
				PrintWriter out = response.getWriter();
				out.println("<html><body>");
				String dbURL = "jdbc:mysql://localhost:3306/task0001";
				String username = "root";
				String password = "jlcm1994";
				JdbcMysqlConnection Con;
				Con = new JdbcMysqlConnection(dbURL, username, password);
//				JdbcMysqlConnection Con = new JdbcMysqlConnection(Props.getProperty("dbURL"), Props.getProperty("username"), Props.getProperty("password"));
				out.println("Jdbc connected!<br>");
				Statement State = Con.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
//				State.executeUpdate("insert into product values('Bag','Gucci', '15')");
//				CallableStatement SqlState = Con.getConnection().prepareCall("call addproduct ('Pants', 'Puma', '25')");
//				SqlState.executeUpdate();
				ResultSet Result = State.executeQuery("select * from product");
				while (Result.next()) {
					out.println(Result.getString("Name") + " / " + Result.getString("Brand") + " / " + Result.getString("Amount"));
				}
				Con.closeConnection();
				out.println("Jdbc closed!<br>");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
