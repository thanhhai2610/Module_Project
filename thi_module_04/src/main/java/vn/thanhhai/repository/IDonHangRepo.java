package vn.thanhhai.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import vn.thanhhai.model.DonHang;

public interface IDonHangRepo extends JpaRepository<DonHang,Integer> {


    @Query(value = "SELECT * FROM thi_module_04.don_hang WHERE is_delete = 1", nativeQuery = true)
    Page<DonHang> myFindAll( Pageable pageable);


}
