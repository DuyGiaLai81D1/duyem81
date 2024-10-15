package com.example.detext.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "hinh_anh")
public class HinhAnh {
	@Id
	private String banner;
	private String img;
	private String imgg;
	private String imggg;
	private String imgggg;
	
	public String getBanner() {
		return banner;
	}
	public void setBanner(String banner) {
		this.banner = banner;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getImgg() {
		return imgg;
	}
	public void setImgg(String imgg) {
		this.imgg = imgg;
	}
	public String getImggg() {
		return imggg;
	}
	public void setImggg(String imggg) {
		this.imggg = imggg;
	}
	public String getImgggg() {
		return imgggg;
	}
	public void setImgggg(String imgggg) {
		this.imgggg = imgggg;
	}
	
}
