package entity;

public class User {
	private int id;
	
	private String hoTen;
	
	private String email;

	private String password;

	private Integer gioiTinh;
	
	private String chuyenNganh;

	private String avatar;
	
	private Integer role;
	
	private String ma;

	public User() {
	}

	public User(int id, String hoTen, String email, String password, Integer gioiTinh, String chuyenNganh,
			String avatar, Integer role, String ma) {
		super();
		this.id = id;
		this.hoTen = hoTen;
		this.email = email;
		this.password = password;
		this.gioiTinh = gioiTinh;
		this.chuyenNganh = chuyenNganh;
		this.avatar = avatar;
		this.role = role;
		this.ma = ma;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(Integer gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public String getChuyenNganh() {
		return chuyenNganh;
	}

	public void setChuyenNganh(String chuyenNganh) {
		this.chuyenNganh = chuyenNganh;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public Integer getRole() {
		return role;
	}

	public void setRole(Integer role) {
		this.role = role;
	}

	public String getMa() {
		return ma;
	}

	public void setMa(String ma) {
		this.ma = ma;
	}
}
