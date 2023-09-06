package test;
import java.sql.*;

public class RetrieveDAO {
	public String fname=null;
	public String retrieve(UserBean ub) {
		try {
			Connection con=DBConnection.getCon();
			PreparedStatement ps=con.prepareStatement
					("select * from user49 where uname=?");
			ps.setString(1, ub.getUname());
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				
				fname=rs.getString(3);
			}
		}catch(Exception e) {e.printStackTrace();}
		return fname;
	}

}
