package vn.thanhhai.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.thanhhai.model.SanPham;
import vn.thanhhai.repository.IDonHangRepo;
import vn.thanhhai.repository.ISanPhamRepo;

import java.util.List;

@Service
public class SanPhamService implements ISanPhamService {
    @Autowired
    ISanPhamRepo sanPhamRepo;

    @Override
    public List<SanPham> myFindAll() {
        return sanPhamRepo.findAll();
    }
}
