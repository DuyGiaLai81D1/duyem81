package com.example.detext.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.detext.Entity.SanPham;
@Repository
public interface SanPhamRepository  extends JpaRepository<SanPham, Integer>{

}
