package vn.thanhhai.service;

import vn.thanhhai.model.QuanLyVe;

import java.util.List;

public interface IQuanLyVeService {

    List<QuanLyVe> myFindAll();

    void save(QuanLyVe quanLyVe);

    QuanLyVe findById(int id);

}
