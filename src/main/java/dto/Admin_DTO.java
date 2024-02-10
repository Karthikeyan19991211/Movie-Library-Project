package dto;

public class Admin_DTO 
{
	private int adminId;
	private String adminName;
	private long adminContact;
	private String adminEmail;
	private String adminPassword;
	
	private byte[] adminImage;

	public byte[] getAdminImage() {
		return adminImage;
	}

	public void setAdminImage(byte[] adminImage) {
		this.adminImage = adminImage;
	}

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public long getAdminContact() {
		return adminContact;
	}

	public void setAdminContact(long adminContact) {
		this.adminContact = adminContact;
	}

	public String getAdminEmail() {
		return adminEmail;
	}

	public void setAdminEmail(String adminEmail) {
		this.adminEmail = adminEmail;
	}

	public String getAdminPassword() {
		return adminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}
}
