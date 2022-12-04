package vn.thanhhai.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.thanhhai.model.NhaXe;
import vn.thanhhai.repository.INhaXeRepo;

import java.util.List;
@Service
public class NhaXeService implements INhaXeService {
    @Autowired
    private INhaXeRepo nhaXeRepo;

    @Override
    public List<NhaXe> myFindAll() {
        return nhaXeRepo.myFindAll();
    }
}
