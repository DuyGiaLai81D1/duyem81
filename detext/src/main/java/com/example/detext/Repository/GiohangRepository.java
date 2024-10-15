package com.example.detext.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.example.detext.Entity.NguoiDung;
import com.example.detext.Entity.SanPham;
import com.example.detext.Entity.GioHang;
@Repository
public interface GiohangRepository extends JpaRepository<GioHang, Integer> {
	 List<GioHang> findByNguoiDung(NguoiDung nguoiDung);
	    Optional<GioHang> findByNguoiDungAndSanPham(NguoiDung nguoiDung, SanPham sanPham);

}
