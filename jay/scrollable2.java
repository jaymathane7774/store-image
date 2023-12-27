import java.sql.*;
public class scrollable2{
	public static void main(String[] args){
	String url="jdbc:mysql://localhost:3307/employee";
	String username="root";
	String password="12345";
	try 
	(Connection conn = DriverManager.getConnection(url,username,password)) {
	String sql = "SELECT * FROM emp";
	statement statement = conn.createstatement(
		Resultset.TYPE_SCROLL_INSENSITIVE,Resultset.CONCUR_READ_ONLY);
	Resultset result = statement.executeQuery(sql);
	result.first();
	readEmpInfo("first",result);
	result.relative(3);
	readEmpInfo("relative(3)",result);
	result.previous();
	readEmpInfo("previous",result);
	result.absolute(4);
	readEmpInfo("absolute(4)",result);
	result.last();
	readEmpInfo("last",result);
	result.relative(-2);
	readEmpInfo("relative(-2)",result);
	} catch (SQLException ex) {
		ex.PrintStackTrace();
	}
}
private static void readEmpInfo(String position,Resultset result)
	throws SQLException {
String empid = result.getString("empid");
String empname = result.getString("empname");
String salary = result.getString("salary");

String empInfo="%s: %s- %s- %s\n";
System.out.format(empInfo,position,empid,ename,salary);
}
}