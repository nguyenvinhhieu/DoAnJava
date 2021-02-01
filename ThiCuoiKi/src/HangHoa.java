import java.util.Date;

public class HangHoa {
	private int ID;
	private String tenHangHoa;
	private String chuSoHuu;
	private Date ngayNhapKho;
	private String nguoiNhap;
	private int daXuat;
	public String getTenHangHoa() {
		return tenHangHoa;
	}
		
	public void setTenHangHoa(String tenHangHoa) {
		this.tenHangHoa = tenHangHoa;
	}
	public String getChuSoHuu() {
		return chuSoHuu;
	}
	public void setChuSoHuu(String chuSoHuu) {
		this.chuSoHuu = chuSoHuu;
	}
	public Date getNgayNhapKho() {
		return ngayNhapKho;
	}
	public void setNgayNhapKho(Date ngayNhapKho) {
		this.ngayNhapKho = ngayNhapKho;
	}
	public String getNguoiNhap() {
		return nguoiNhap;
	}
	public void setNguoiNhap(String nguoiNhap) {
		this.nguoiNhap = nguoiNhap;
	}
	public int getDaXuat() {
		return daXuat;
	}
	public void setDaXuat(int daXuat) {
		this.daXuat = daXuat;
	}
	
	
	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public HangHoa() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
