package com.example.detext.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.detext.Entity.HinhAnh;
@Repository
public interface HinhAnhRepository extends JpaRepository<HinhAnh, String> {

}
