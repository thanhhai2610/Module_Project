package vn.thanhhai.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.thanhhai.model.DonHang;
import vn.thanhhai.repository.IDonHangRepo;

@Service
public class DonHangService implements IDonHangService {
    @Autowired
    IDonHangRepo donHangRepo;

    @Override
    public Page<DonHang> myFindAll(Pageable pageable) {
        return donHangRepo.myFindAll(pageable);
    }

    @Override
    public DonHang findById(int id) {
        return donHangRepo.findById(id).orElse(null);
    }

    @Override
    public void save(DonHang donHang) {
        donHangRepo.save(donHang);
    }
}
