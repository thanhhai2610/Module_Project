package vn.thanhhai.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.thanhhai.model.QuanLyVe;
import vn.thanhhai.repository.IQuanLyVeRepo;

import java.util.List;

@Service
public class QuanLyVeService implements IQuanLyVeService {

    @Autowired
    private IQuanLyVeRepo quanLyVeRepo;

    @Override
    public List<QuanLyVe> myFindAll() {
        return quanLyVeRepo.myFindAll();
    }

    @Override
    public void save(QuanLyVe quanLyVe) {
        quanLyVeRepo.save(quanLyVe);
    }

    @Override
    public QuanLyVe findById(int id) {
        return quanLyVeRepo.findById(id).orElse(null);
    }

}
