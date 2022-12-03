package vn.thanhhai.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class LoaiSanPham {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String tenSanPham;

    @OneToMany(mappedBy ="loaiSanPham")
    private Set<SanPham> sanPham;

    private int isDelete=1;

    public LoaiSanPham() {
    }

    public LoaiSanPham(int id, String tenSanPham, Set<SanPham> sanPham, int isDelete) {
        this.id = id;
        this.tenSanPham = tenSanPham;
        this.sanPham = sanPham;
        this.isDelete = isDelete;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public Set<SanPham> getSanPham() {
        return sanPham;
    }

    public void setSanPham(Set<SanPham> sanPham) {
        this.sanPham = sanPham;
    }

    public int getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(int isDelete) {
        this.isDelete = isDelete;
    }
}
