package com.example.detext.Entity;


import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "san_pham")
public class SanPham {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String tenSanPham;
	private String phuDe;
	private String moTa;
	@Column(name = "hinh_san_pham")
	private String hinhAnhSanPham;
	@Column(name = "icon_hinh_anh")
	private String iconSanPham;
	private BigDecimal giaHienTai;
	private BigDecimal giaCu;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTenSanPham() {
		return tenSanPham;
	}
	public void setTenSanPham(String tenSanPham) {
		this.tenSanPham = tenSanPham;
	}
	public String getPhuDe() {
		return phuDe;
	}
	public void setPhuDe(String phuDe) {
		this.phuDe = phuDe;
	}
	public String getMoTa() {
		return moTa;
	}
	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}
	public String getHinhAnhSanPham() {
		return hinhAnhSanPham;
	}
	public void setHinhAnhSanPham(String hinhAnhSanPham) {
		this.hinhAnhSanPham = hinhAnhSanPham;
	}
	public String getIconSanPham() {
		return iconSanPham;
	}
	public void setIconSanPham(String iconSanPham) {
		this.iconSanPham = iconSanPham;
	}
	public BigDecimal getGiaHienTai() {
		return giaHienTai;
	}
	public void setGiaHienTai(BigDecimal giaHienTai) {
		this.giaHienTai = giaHienTai;
	}
	public BigDecimal getGiaCu() {
		return giaCu;
	}
	public void setGiaCu(BigDecimal giaCu) {
		this.giaCu = giaCu;
	}
	

}
