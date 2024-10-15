package com.example.detext.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.detext.Entity.NguoiDung;
@Repository
public interface NguoiDungRepository extends JpaRepository<NguoiDung, Integer> {
	 NguoiDung findByTenDangNhap(String tenDangNhap);
}
