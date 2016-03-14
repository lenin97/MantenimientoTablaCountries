package bd;
import java.sql.*;

public class Conexion {

	 public static Connection cnHR() throws SQLException, ClassNotFoundException{//static para no instanciar
		 
		 Class.forName("oracle.jdbc.OracleDriver");
			//conexion con la db
			return DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE",
					"hr","oracle");//url jdbc 1521#puerto
	 }//cnHR
}//class
