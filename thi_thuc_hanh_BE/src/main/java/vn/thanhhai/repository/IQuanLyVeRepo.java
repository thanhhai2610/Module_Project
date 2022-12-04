package vn.thanhhai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import vn.thanhhai.model.QuanLyVe;

import javax.transaction.Transactional;
import java.util.List;

public interface IQuanLyVeRepo extends JpaRepository<QuanLyVe, Integer> {

    @Query(value = "SELECT * FROM thi_thuc_hanh_m5.quan_ly_ve WHERE is_delete = 1", nativeQuery = true)
    List<QuanLyVe> myFindAll();


//    @Modifying
//    @Transactional
//    @Query(value = "UPDATE `thi_thuc_hanh_m5`.`quan_ly_ve` SET `is_delete` = '0' WHERE (`id` = :keywordId )", nativeQuery = true)
//    void myDeleteById(@Param("keywordId") int id);


}

