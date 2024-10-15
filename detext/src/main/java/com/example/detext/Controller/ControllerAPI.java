package com.example.detext.Controller;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Entity.DonHang;
import com.example.detext.Entity.GioHang;
import com.example.detext.Sevice.GioHangSevice;
import com.example.detext.Entity.HinhAnh;
import com.example.detext.Entity.NguoiDung;
import com.example.detext.Entity.SanPham;
import com.example.detext.Sevice.HinhAnhSevice;
import com.example.detext.Sevice.NguoiDungSevice;
import com.example.detext.Sevice.SanPhamSevice;

import jakarta.servlet.http.HttpSession;

@Controller 

public class ControllerAPI {
	@Autowired private NguoiDungSevice nguoiDungSevice;
	@Autowired private SanPhamSevice sanPhamSevice;
	@Autowired private HinhAnhSevice hinhAnhSevice;
	@Autowired private GioHangSevice gioHangSevice;
	@GetMapping("/dangnhap")
	public String dangNhap() {
		return"dangnhap";
	}
	@PostMapping("/dangnhap")
	public String checktaikhoan(@RequestParam String tenDangNhap, @RequestParam String matKhau, HttpSession session, Model model) {
		NguoiDung nguoiDung = nguoiDungSevice.finByTenDangNhap(tenDangNhap);
		if(nguoiDung !=  null && nguoiDung.getMatKhau().equals(matKhau)) {
			session.setAttribute("nguoidung", nguoiDung);
			if("admin".equals(nguoiDung.getChuVu())) {
				return"redirect:/adminn";
			}else {
				return "redirect:/trangchu";
			}
			
		}else {
			model.addAttribute("errorMessage", "Tài khoản mật khẩu không chính xác");
		}
		return"dangnhap";
	}
	@GetMapping("/dangky")
	public String dangkytaikhoa(Model model) {
		model.addAttribute("nguoidung", new NguoiDung());
		return"dangky";
	}
	@PostMapping("/dangky")
	public String themthongtinnguoidung(@ModelAttribute("nguoidung") NguoiDung nguoiDung) {
		nguoiDung.setChuVu("nguoidung");
		nguoiDungSevice.addThongTin(nguoiDung);
		return"redirect:/dangnhap";
	}
	@GetMapping("/adminn")
	public String duLieuNguoiDung(Model model) {
		List<NguoiDung> ls = nguoiDungSevice.getAll();
		List<SanPham> lss = sanPhamSevice.getAll();
		List<GioHang> lsss = gioHangSevice.getAll();
		model.addAttribute("nguoidung", ls);
		model.addAttribute("sanpham", lss);
		model.addAttribute("giohang", lsss);
		return "adminn";
	}
	@GetMapping("/trangchu")
	public String trangchu(Model model, HttpSession session) {
		NguoiDung nguoiDung =(NguoiDung) session.getAttribute("nguoidung");
		if(nguoiDung != null) {
			model.addAttribute("nguoidung", nguoiDung);
			List<SanPham> sp = sanPhamSevice.getAll();
			if(sp != null&& !sp.isEmpty()) {
				List<SanPham> sanphamdau = sp.stream().limit(4).collect(Collectors.toList());
	            List<SanPham> sanphamcuoi = sp.stream().skip(4).collect(Collectors.toList());
	            List<HinhAnh> ls = hinhAnhSevice.getAll();
	            model.addAttribute("hinhanh", ls);
	            model.addAttribute("sanphamdau", sanphamdau);
	            model.addAttribute("sanphamcuoi", sanphamcuoi);
			}
		}
		return "trangchu";
	}
	
	@GetMapping("/trangchu/thongtinnguoidung/{id}")
	public String thongTinNguoiiDung(Model model, @PathVariable("id") Integer id) {
		NguoiDung nguoiDung = nguoiDungSevice.LayThongTinnNguooiDung(id);
		if(nguoiDung == null) {
			return"redirect:/trangchu";
		}
		model.addAttribute("nguoidung", nguoiDung);
		return"thongtinnguoidung";
	}
	@GetMapping("/add")
	public String themSanPham(Model model) {
		model.addAttribute("sanPham",new SanPham() );
		return"add";
	}
	@PostMapping("/addsanpham")
	public String themSanPhamVoAdminnn (SanPham sanPham) {
		sanPhamSevice.add(sanPham);
			return"redirect:/adminn";
	}
	@GetMapping("/giohang/{id}")
	public String themSanPhamvoGioHang(@PathVariable("id") int id, HttpSession session, Model model) {
		NguoiDung nguoiDung = (NguoiDung) session.getAttribute("nguoidung");
		if(nguoiDung == null) {
		 return"redirect:/dangnhap";
		}
		SanPham sanPham = sanPhamSevice.SanPhamChiTiettt(id);
		if(sanPham != null) {
			gioHangSevice.themSanPhamVaoGioHang(nguoiDung, sanPham);
			model.addAttribute("gioHang", gioHangSevice.layGioHangTheoNguooiDung(nguoiDung));
			BigDecimal tongTien = gioHangSevice.tinhTongTien(nguoiDung);
			model.addAttribute("tongtien", tongTien);
			
		}else {
			model.addAttribute("erro", "Sản Phẩm Không tồn Tại");
		}
		return"gioHang";
	}

	@GetMapping("/giohang")
	public String hienThiGioHang(HttpSession session, Model model) {
		NguoiDung nguoiDung = (NguoiDung) session.getAttribute("nguoidung");
		if(nguoiDung == null) {
			return"redirect:/dangnhap";
		}
		model.addAttribute("gioHang", gioHangSevice.layGioHangTheoNguooiDung(nguoiDung));
		BigDecimal tongTien = gioHangSevice.tinhTongTien(nguoiDung);
		model.addAttribute("tongtien", tongTien);
		return"giohang";
	}
	@GetMapping("/adminn")
	public String hienThiGioHangTrongAdmin(HttpSession session, Model model) {
		NguoiDung nguoiDung = (NguoiDung) session.getAttribute("nguoidung");
		if(nguoiDung == null) {
			return"redirect:/dangnhap";
		}
		List<NguoiDung> ls = nguoiDungSevice.getAll();
		List<SanPham> lss = sanPhamSevice.getAll();
		model.addAttribute("nguoidung", ls);
		model.addAttribute("sanpham", lss);
		model.addAttribute("gioHang", gioHangSevice.layGioHangTheoNguooiDung(nguoiDung));
		BigDecimal tongTien = gioHangSevice.tinhTongTien(nguoiDung);
		model.addAttribute("tongtien", tongTien);
		return"adminn";
	}

	@PostMapping("/giohang/xoa/{id}")
	public String xoaGioHang(@PathVariable("id") int id, HttpSession session, Model model) {
		NguoiDung nguoiDung = (NguoiDung) session.getAttribute("nguoidung");
				if(nguoiDung == null) {
					return "redirect:/dangnhap";
				}
		try {
			gioHangSevice.xoaSanPham(id);
			List<GioHang> gioHangs = gioHangSevice.layGioHangTheoNguooiDung(nguoiDung);
			if(gioHangs.isEmpty()) {
				model.addAttribute("message", "giỏ hàng của bạn đang trông");
			}else {
				model.addAttribute("tongtien", BigDecimal.ZERO);
			}
		} catch (Exception e) {
			model.addAttribute("errorMessage","Không thể xóa sản phẩm");
		}
		return"redirect:/giohang";
	}
	
	@PostMapping("/giohang/capnhatsanpham/{id}")
	public String capNhapGioHang(@PathVariable("id") int id, @RequestParam("soLuong") int soLuong, HttpSession session, Model model) {
		NguoiDung nguoiDung = (NguoiDung) session.getAttribute("nguoidung");
		if(nguoiDung == null) {
			return "redirect:/dangnhap";
		}
		gioHangSevice.capNhapSanPham(id, soLuong);
		model.addAttribute("giohang", gioHangSevice.layGioHangTheoNguooiDung(nguoiDung));
		BigDecimal tongTien = gioHangSevice.tinhTongTien(nguoiDung);
		model.addAttribute("tongtien", tongTien);
		return"redirect:/giohang";
	}


	@GetMapping("/trangchu/sanphamchitiet/{id}")
	public String sanPhamChiTiet(Model model, @PathVariable("id") Integer id) {
		SanPham sanPham = sanPhamSevice.layTheoID(id);
		if(sanPham == null) {
			return "redirect:/trangchu";
		}
		model.addAttribute("sanpham", sanPham);
		return"sanphamchitiet";
	}
//	@GetMapping("/tim-kiem")
//    public String timKiem(@RequestParam(value = "ngayDat", required = false) Date ngayDat,
//                          @RequestParam(value = "hoTen", required = false) String hoTen,
//                          @RequestParam(value = "trangThai", required = false) String trangThai,
//                          Model model) {
//        
//        List<DonHang> donHangs = donHangService.timKiemDonHang(ngayDat, hoTen, trangThai);
//        model.addAttribute("donhang", donHangs);
//        return "your-view-name"; // Thay 'your-view-name' bằng tên view của bạn
//    }


}
