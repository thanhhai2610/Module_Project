package vn.thanhhai.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import vn.thanhhai.model.DonHang;
import vn.thanhhai.model.SanPham;

public interface ISanPhamRepo extends JpaRepository<SanPham,Integer> {

}
