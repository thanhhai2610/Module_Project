package vn.thanhhai.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class SanPham {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String ten;
    private double gia;
    private String tinhTrang;

    @ManyToOne
    @JoinColumn(name = "id_loai_sp", referencedColumnName = "id")
    private LoaiSanPham loaiSanPham;


    @OneToMany(mappedBy = "sanPham")
    private Set<DonHang> donHang;

//    @ManyToOne
//    @JoinColumn(name = "id_donhang", referencedColumnName ="id")
//    private DonHang donHang;

    private int isDelete = 1;

    public SanPham() {
    }

    public SanPham(int id, String ten, double gia, String tinhTrang, LoaiSanPham loaiSanPham, Set<DonHang> donHang, int isDelete) {
        this.id = id;
        this.ten = ten;
        this.gia = gia;
        this.tinhTrang = tinhTrang;
        this.loaiSanPham = loaiSanPham;
        this.donHang = donHang;
        this.isDelete = isDelete;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }

    public String getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(String tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    public LoaiSanPham getLoaiSanPham() {
        return loaiSanPham;
    }

    public void setLoaiSanPham(LoaiSanPham loaiSanPham) {
        this.loaiSanPham = loaiSanPham;
    }

    public Set<DonHang> getDonHang() {
        return donHang;
    }

    public void setDonHang(Set<DonHang> donHang) {
        this.donHang = donHang;
    }

    public int getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(int isDelete) {
        this.isDelete = isDelete;
    }
}
