package vn.thanhhai.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.thanhhai.model.DonHang;

import java.util.List;

public interface IDonHangService {
    Page<DonHang> myFindAll(Pageable pageable);

    DonHang findById(int id);

    void save(DonHang donHang);

}
