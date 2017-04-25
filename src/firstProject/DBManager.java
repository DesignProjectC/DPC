package firstProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBManager {

	private Connection conn = null;
	private java.sql.Statement st = null;
	private ResultSet rs = null;
	
	private String url = "jdbc:mysql://localhost:3306/dpc";
	private String user = "root";
	private String password = "1234";
	
	public DBManager(){}
	
	public Author loadAuthorData(int num)
	{
		Author at = new Author();
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			
			// Connection 按眉裙垫
			conn = DriverManager.getConnection(url, user, password);
						
			// Statement 按眉 积己
			st = conn.createStatement();
						
			// SQL 角青
			String sql = "select * from author where no=" + num;
			rs = st.executeQuery(sql);
			
			while(rs.next()){			    
			    at.setAuthorID(rs.getInt("no"));
			    at.setName(rs.getString("name"));
			    
			}
						
			rs.close();
			st.close();
			conn.close();
			
		} catch (ClassNotFoundException e) {
			System.out.println("DB Driver Error!! at loadAuthorData");
		} catch (SQLException sqex)	{
			System.out.println("DB Connection Error!! at loadAuthorData");
		} catch (Exception e) {	
			System.out.println("Exception:" + e);
		}
		
		return at;
	}
	
	public Paper loadPaperData(int num)
	{
		Paper pp = new Paper();
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			
			// Connection 按眉裙垫
			conn = DriverManager.getConnection(url, user, password);
						
			// Statement 按眉 积己
			st = conn.createStatement();
						
			// SQL 角青
			String sql = "select * from paper where no=" + num;
			rs = st.executeQuery(sql);
			
			while(rs.next()){ 			    
			    pp.setID(rs.getInt("no"));
			    pp.setName(rs.getString("name"));
			    pp.setAuthorIDList(rs.getString("authorID"));
			}
						
			rs.close();
			st.close();
			conn.close();
			
		} catch (ClassNotFoundException e) {
			System.out.println("DB Driver Error!! at loadPaperData");
		} catch (SQLException sqex)	{
			System.out.println("DB Connection Error!! at loadPaperData");
		} catch (Exception e) {	
			System.out.println("Exception:" + e);
		}
		
		return pp;
	}
	
	public int countAuthorRow()
	{
		int count = 0;
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			
			// Connection 按眉裙垫
			conn = DriverManager.getConnection(url, user, password);
						
			// Statement 按眉 积己
			st = conn.createStatement();
						
			// SQL 角青
			String sql = "select * from author";
			rs = st.executeQuery(sql);
			
			while(rs.next()){ 
				count++;
			}
						
			rs.close();
			st.close();
			conn.close();
			
		} catch (ClassNotFoundException e) {
			System.out.println("DB Driver Error!! at countAuthorRow");
		} catch (SQLException sqex)	{
			System.out.println("DB Connection Error!! at countAuthorRow");
		} catch (Exception e) {	
			System.out.println("Exception:" + e);
		}
		
		return count;
	}
	
	public int countPaperRow()
	{
		int count = 0;
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			
			// Connection 按眉裙垫
			conn = DriverManager.getConnection(url, user, password);
						
			// Statement 按眉 积己
			st = conn.createStatement();
						
			// SQL 角青
			String sql = "select * from paper";
			rs = st.executeQuery(sql);
			
			while(rs.next()){ 
				count++;
			}
						
			rs.close();
			st.close();
			conn.close();
			
		} catch (ClassNotFoundException e) {
			System.out.println("DB Driver Error!! at countPaperRow");
		} catch (SQLException sqex)	{
			System.out.println("DB Connection Error!! at countPaperRow");
		} catch (Exception e) {	
			System.out.println("Exception:" + e);
		}
		
		return count;
	}
}

