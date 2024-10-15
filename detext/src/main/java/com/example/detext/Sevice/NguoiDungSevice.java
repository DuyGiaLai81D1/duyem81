package com.example.detext.Sevice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.detext.Entity.NguoiDung;
import com.example.detext.Repository.NguoiDungRepository;

@Service
public class NguoiDungSevice {
	@Autowired private NguoiDungRepository nguoiDungRepository;
	
	
	public void addThongTin(NguoiDung nguoiDung) {
		nguoiDungRepository.save(nguoiDung);
	}
	public NguoiDung finByTenDangNhap(String tenDangNhap) {
		return nguoiDungRepository.findByTenDangNhap(tenDangNhap);
	}
	public List<NguoiDung> getAll(){
		return nguoiDungRepository.findAll();
	}
	public NguoiDung LayThongTinnNguooiDung( int id) {
		return nguoiDungRepository.findById(id).orElse(null);
	}

}
