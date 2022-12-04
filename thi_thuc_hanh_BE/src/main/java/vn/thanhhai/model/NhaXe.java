package vn.thanhhai.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table
public class NhaXe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String ten;

    @OneToMany(mappedBy = "nhaXe")
    @JsonBackReference
    private Set<QuanLyVe> quanLyVe;

    @Value("1")
    private int isDelete =1;

    public NhaXe() {
    }

    public NhaXe(long id, String ten, Set<QuanLyVe> quanLyVe, int isDelete) {
        this.id = id;
        this.ten = ten;
        this.quanLyVe = quanLyVe;
        this.isDelete = isDelete;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public Set<QuanLyVe> getQuanLyVe() {
        return quanLyVe;
    }

    public void setQuanLyVe(Set<QuanLyVe> quanLyVe) {
        this.quanLyVe = quanLyVe;
    }

    public int getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(int isDelete) {
        this.isDelete = isDelete;
    }

    @Override
    public String toString() {
        return "NhaXe{" +
                "id=" + id +
                ", ten='" + ten + '\'' +
                ", quanLyVe=" + quanLyVe +
                ", isDelete=" + isDelete +
                '}';
    }
}
