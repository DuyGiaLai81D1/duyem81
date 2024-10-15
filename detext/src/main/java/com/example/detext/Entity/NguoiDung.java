package com.example.detext.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "dang_nhap")
public class NguoiDung {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
	private int id ;
	@Column(name = "ten_dang_nhap")
	private String tenDangNhap;
	@Column(name = "mat_khau")
	private String matKhau;
	@Column(name = "dia_chi")
	private String diaChi;
	@Column(name = "email")
	private String email;
	@Column(name = "so_dien_thoai")
	private String soDienThoai;
	@Column(name = "gioi_tinh")
	private String gioiTinh;
	@Column(name = "chu_vu")
	private String chuVu;
	@Column(name = "ho_ten")
	private String hoTen;
	@Column(name = "anh_dai_dien")
	private String anhDaiDien;
	
	public String getAnhDaiDien() {
		return anhDaiDien;
	}
	public void setAnhDaiDien(String anhDaiDien) {
		this.anhDaiDien = anhDaiDien;
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTenDangNhap() {
		return tenDangNhap;
	}
	public void setTenDangNhap(String tenDangNhap) {
		this.tenDangNhap = tenDangNhap;
	}
	public String getMatKhau() {
		return matKhau;
	}
	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSoDienThoai() {
		return soDienThoai;
	}
	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}
	public String getGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	public String getChuVu() {
		return chuVu;
	}
	public void setChuVu(String chuVu) {
		this.chuVu = chuVu;
	}
	

}
