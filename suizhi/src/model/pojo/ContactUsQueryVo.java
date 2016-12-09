package model.pojo;
/*
 * 联系方式的包装对象
 */
public class ContactUsQueryVo {
	//联系方式信息
	private	ContactUs contactUs;
	//为了系统可拓展性，对原始生成的po进行拓展
	private ContactUsCustom contactUsCustom;
	public ContactUs getContactUs() {
		return contactUs;
	}
	public void setContactUs(ContactUs contactUs) {
		this.contactUs = contactUs;
	}
	public ContactUsCustom getContactUsCustom() {
		return contactUsCustom;
	}
	public void setContactUsCustom(ContactUsCustom contactUsCustom) {
		this.contactUsCustom = contactUsCustom;
	}
	
}
