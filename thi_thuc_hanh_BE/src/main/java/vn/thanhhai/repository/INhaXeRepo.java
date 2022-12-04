package vn.thanhhai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import vn.thanhhai.model.NhaXe;
import vn.thanhhai.model.QuanLyVe;

import javax.transaction.Transactional;
import java.util.List;

public interface INhaXeRepo extends JpaRepository<NhaXe, Integer> {

    @Modifying
    @Transactional
    @Query(value = "SELECT * FROM thi_thuc_hanh_m5.nha_xe WHERE is_delete = 1", nativeQuery = true)
    List<NhaXe> myFindAll();
}
