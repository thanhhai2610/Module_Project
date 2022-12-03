package vn.thanhhai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.thanhhai.model.DonHang;
import vn.thanhhai.model.LoaiSanPham;
import vn.thanhhai.model.SanPham;
import vn.thanhhai.service.IDonHangService;
import vn.thanhhai.service.ILoaiSanPhamService;
import vn.thanhhai.service.ISanPhamService;

import java.util.List;

@Controller
@RequestMapping("/donhang")
public class ProductController {

    @Autowired
    IDonHangService donHangService;

    @Autowired
    ILoaiSanPhamService loaiSanPhamService;

    @Autowired
    ISanPhamService sanPhamService;


    @ModelAttribute("sanPhamList")
    public List<SanPham> sanPhamList() {
        return sanPhamService.myFindAll();
    }

    @ModelAttribute("loaiSanPhamList")
    public List<LoaiSanPham> loaiSanPhamList() {
        return loaiSanPhamService.myFindAll();
    }


    @GetMapping("")
    public String search(@PageableDefault(value = 5) Pageable pageable, Model model) {
        Page<DonHang> donHangPage = donHangService.myFindAll(pageable);
        model.addAttribute("donHangPage", donHangPage);
        return "list";
    }

    @GetMapping("/edit/{id}")
    public String editProduct(@PathVariable("id") int id, Model model) {
        DonHang donHang = donHangService.findById(id);
        model.addAttribute("donHang", donHang);
        return "edit";
    }

    @PostMapping("/edit")
    public String editProduct(@ModelAttribute("donHang") DonHang donHang, RedirectAttributes redirectAttributes) {
        donHangService.save(donHang);
        redirectAttributes.addFlashAttribute("success", "Chỉnh sủa thành công");
        return "redirect:/donhang";
    }


}
