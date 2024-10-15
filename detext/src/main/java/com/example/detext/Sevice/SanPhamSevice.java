package com.example.detext.Sevice;

import java.util.List;
import java.util.Optional;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.detext.Entity.SanPham;
import com.example.detext.Repository.SanPhamRepository;

import jakarta.persistence.criteria.CriteriaBuilder.In;

@Service
public class SanPhamSevice {
	@Autowired private SanPhamRepository sanPhamRepository;
	public List<SanPham> getAll(){
		return sanPhamRepository.findAll();
		
	}
	public void add(SanPham sanPham) {
		sanPhamRepository.save(sanPham);
	}
	public SanPham layTheoID(int id) {
		return sanPhamRepository.findById(id).orElse(null);
	}
	public void update(SanPham sanPham) {
		if(sanPhamRepository.existsById(sanPham.getId())) {
			sanPhamRepository.save(sanPham);
		}else {
			throw new RuntimeException("Không tìm thấy sản phẩm"+sanPham.getId());
		}
	}
	public void delete(int id) {
		if(sanPhamRepository.existsById(id)) {
			sanPhamRepository.deleteById(id);
		}else {
			throw new RuntimeException("Không tìm thấy id"+id);
		}
	}
	 public SanPham SanPhamChiTiettt(int id) {
	        Optional<SanPham> sanPhamOptional = sanPhamRepository.findById(id);
	        if (sanPhamOptional.isPresent()) {
	            return sanPhamOptional.get();
	        } else {
	            throw new RuntimeException("Không tìm thấy sản phẩm với mã: " + id);
	        }
	    }
}
