package vn.thanhhai.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.thanhhai.model.LoaiSanPham;
import vn.thanhhai.model.SanPham;
import vn.thanhhai.repository.ILoaiSanPhamRepo;
import vn.thanhhai.repository.ISanPhamRepo;

import java.util.List;

@Service
public class LoaiSanPhamService implements ILoaiSanPhamService {
    @Autowired
    ILoaiSanPhamRepo loaiSanPhamRepo;

    @Override
    public List<LoaiSanPham> myFindAll() {
        return loaiSanPhamRepo.findAll();
    }
}
