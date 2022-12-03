package vn.thanhhai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.thanhhai.model.DonHang;
import vn.thanhhai.model.LoaiSanPham;

public interface ILoaiSanPhamRepo extends JpaRepository<LoaiSanPham,Integer> {
}
