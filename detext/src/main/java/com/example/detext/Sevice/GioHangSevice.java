package com.example.detext.Sevice;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.Set;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.detext.Entity.GioHang;
import com.example.detext.Entity.NguoiDung;
import com.example.detext.Entity.SanPham;
import com.example.detext.Repository.GiohangRepository;

@Service
public class GioHangSevice {

	@Autowired private GiohangRepository giohangRepository;
	public List<GioHang> getAll(){
		return giohangRepository.findAll();
	}
	public List<GioHang> layGioHangTheoNguooiDung(NguoiDung nguoiDung){
		return giohangRepository.findByNguoiDung(nguoiDung);
	}
	public void themSanPhamVaoGioHang(NguoiDung nguoiDung, SanPham sanPham) {
		Optional<GioHang> optional = giohangRepository.findByNguoiDungAndSanPham(nguoiDung, sanPham);
		GioHang gioHang;
		if(optional.isPresent()) {
			gioHang = optional.get();
			gioHang.setSoLuong(gioHang.getSoLuong()+1);
		}else {
			gioHang = new GioHang();
			gioHang.setNguoiDung(nguoiDung);
			gioHang.setSanPham(sanPham);
			gioHang.setSoLuong(1);
		}
		giohangRepository.save(gioHang);
	}

	public BigDecimal tinhTongTien(NguoiDung nguoiDung) {
	    List<GioHang> gioHangList = giohangRepository.findByNguoiDung(nguoiDung);
	    return gioHangList.stream()
	            .map(item -> {
	                BigDecimal soLuong = BigDecimal.valueOf(item.getSoLuong());
	                BigDecimal gia = item.getSanPham().getGiaHienTai();
	                return soLuong.multiply(gia);
	            })
	            .reduce(BigDecimal.ZERO, BigDecimal::add); 
	}

	public void capNhapSanPham(int id, int soLuong) {
		GioHang gioHang = giohangRepository.findById(id).orElse(null);
		if(gioHang != null) {
			gioHang.setSoLuong(soLuong);
			giohangRepository.save(gioHang);
		}
	}

	public void xoaSanPham (int maGioHang) {
		giohangRepository.deleteById(maGioHang);
	}
}
