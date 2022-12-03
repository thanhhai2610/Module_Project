package vn.thanhhai.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class DonHang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String ngayMua;
    private double soLuong;

   @ManyToOne
   @JoinColumn(name = "id_sp", referencedColumnName ="id")
   private SanPham sanPham;

    private int isDelete=1;

    public DonHang() {
    }

    public DonHang(int id, String ngayMua, double soLuong, SanPham sanPham, int isDelete) {
        this.id = id;
        this.ngayMua = ngayMua;
        this.soLuong = soLuong;
        this.sanPham = sanPham;
        this.isDelete = isDelete;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNgayMua() {
        return ngayMua;
    }

    public void setNgayMua(String ngayMua) {
        this.ngayMua = ngayMua;
    }

    public double getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(double soLuong) {
        this.soLuong = soLuong;
    }

    public SanPham getSanPham() {
        return sanPham;
    }

    public void setSanPham(SanPham sanPham) {
        this.sanPham = sanPham;
    }

    public int getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(int isDelete) {
        this.isDelete = isDelete;
    }
}
