package vn.thanhhai.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import vn.thanhhai.model.NhaXe;

import javax.validation.constraints.NotEmpty;

public class QuanLyVeDto implements Validator {

    private int id;

    @NotEmpty(message = "Ban can nhap gi do")
    private String diemDi;

    @NotEmpty(message = "Ban can nhap gi do")
    private String diemDen;

    @NotEmpty(message = "Ban can nhap gi do")
    private String ngayKhoiHanh;

    @NotEmpty(message = "Ban can nhap gi do")
    private String gioKhoiHanh;

    @NotEmpty(message = "Ban can nhap gi do")
    private String soLuong;

    @NotEmpty(message = "Ban can nhap gi do")
    private String gia;

    @NotEmpty(message = "Ban can nhap gi do")
    private NhaXe nhaXe;



    public QuanLyVeDto() {
    }

    public QuanLyVeDto(int id, @NotEmpty(message = "Ban can nhap gi do") String diemDi, @NotEmpty(message = "Ban can nhap gi do") String diemDen, @NotEmpty(message = "Ban can nhap gi do") String ngayKhoiHanh, @NotEmpty(message = "Ban can nhap gi do") String gioKhoiHanh, @NotEmpty(message = "Ban can nhap gi do") String soLuong, @NotEmpty(message = "Ban can nhap gi do") String gia, @NotEmpty(message = "Ban can nhap gi do") NhaXe nhaXe) {
        this.id = id;
        this.diemDi = diemDi;
        this.diemDen = diemDen;
        this.ngayKhoiHanh = ngayKhoiHanh;
        this.gioKhoiHanh = gioKhoiHanh;
        this.soLuong = soLuong;
        this.gia = gia;
        this.nhaXe = nhaXe;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDiemDi() {
        return diemDi;
    }

    public void setDiemDi(String diemDi) {
        this.diemDi = diemDi;
    }

    public String getDiemDen() {
        return diemDen;
    }

    public void setDiemDen(String diemDen) {
        this.diemDen = diemDen;
    }

    public String getNgayKhoiHanh() {
        return ngayKhoiHanh;
    }

    public void setNgayKhoiHanh(String ngayKhoiHanh) {
        this.ngayKhoiHanh = ngayKhoiHanh;
    }

    public String getGioKhoiHanh() {
        return gioKhoiHanh;
    }

    public void setGioKhoiHanh(String gioKhoiHanh) {
        this.gioKhoiHanh = gioKhoiHanh;
    }

    public String getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(String soLuong) {
        this.soLuong = soLuong;
    }

    public String getGia() {
        return gia;
    }

    public void setGia(String gia) {
        this.gia = gia;
    }

    public NhaXe getNhaXe() {
        return nhaXe;
    }

    public void setNhaXe(NhaXe nhaXe) {
        this.nhaXe = nhaXe;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
    }
}
