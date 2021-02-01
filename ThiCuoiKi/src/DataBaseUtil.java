import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



public class DataBaseUtil {
	private static String DB_URL = "jdbc:sqlserver://localhost:1433;"
            + "databaseName=KHOHANG;";
    private static String USER_NAME = "sa";
    private static String PASSWORD = "12345678";
    
	public static Connection getConnection() {
		Connection conn = null;
		try {
			DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
			conn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
			if (conn != null) {
			    System.out.println("Connected");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public static List<HangHoa> getDanhSachHangHoa(String tenHangHoa){
		List<HangHoa> dshanghoa= new ArrayList<HangHoa>();
		try {
			Connection conn =  getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("Select ID,TENHANGHOA,CHUSOHUU,NGAYNHAPKHO,NGUOINHAP,DAXUAT  From KHOHANG WHERE LOWER(TENHANGHOA) LIKE '%"+tenHangHoa.toLowerCase()+"%'");
			while (rs.next()) {
	           HangHoa hanghoa = new HangHoa();
	           hanghoa.setChuSoHuu(rs.getString("CHUSOHUU"));
	           hanghoa.setID(rs.getInt("ID"));
	           hanghoa.setTenHangHoa(rs.getString("TENHANGHOA"));;
	           hanghoa.setNgayNhapKho(rs.getTime("NGAYNHAPKHO"));
	           hanghoa.setNguoiNhap(rs.getString("NGUOINHAP"));
	           hanghoa.setDaXuat(rs.getInt("DAXUAT"));
	           dshanghoa.add(hanghoa);
	        }
		} catch (Exception ex) {
            ex.printStackTrace();
        }
		return dshanghoa;
    }
	public static boolean themHangHoa(String  tenhanghoa,String chusohuu, String tennguoinhap ) {
		try {
			Connection conn = getConnection();
			Statement stmt = conn.createStatement();
			stmt.execute("INSERT INTO KHOHANG (TENHANGHOA,CHUSOHUU,NGAYNHAPKHO,NGUOINHAP,DAXUAT) VALUES(N'"+tenhanghoa+"',N'"+chusohuu+"', GETDATE(),N'"+tennguoinhap+"',0)");
			return true;
		}catch(Exception ex) {
            ex.printStackTrace();
        }
		return false;
	}
	
	public static boolean xoaHangHoa(int id){
		try {
			Connection conn = getConnection();
			Statement stmt = conn.createStatement();
			stmt.execute("DELETE FROM KHOHANG WHERE  id = "+id);
			return true;
		}catch(Exception ex) {
            ex.printStackTrace();
        }
		return false;
		
	}
	public static boolean capNhapHangHoa(int id,String  tenhanghoa,String chusohuu, String tennguoinhap ) {
		try {
			Connection conn = getConnection();
			Statement stmt = conn.createStatement();
			stmt.execute("UPDATE KHOHANG SET tenhanghoa=N'"+tenhanghoa+"',chusohuu=N'"+chusohuu+"',nguoinhap=N'"+tennguoinhap+"' where id ="+id);
			return true;
		}catch(Exception ex) {
            ex.printStackTrace();
        }
		return false;
	}
}
