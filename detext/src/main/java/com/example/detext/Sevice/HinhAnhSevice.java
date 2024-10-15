package com.example.detext.Sevice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.detext.Entity.HinhAnh;
import com.example.detext.Repository.HinhAnhRepository;

@Service
public class HinhAnhSevice {
	@Autowired private HinhAnhRepository hinhAnhRepository;
	public List<HinhAnh> getAll(){ 
		return hinhAnhRepository.findAll(); 
	}
}
