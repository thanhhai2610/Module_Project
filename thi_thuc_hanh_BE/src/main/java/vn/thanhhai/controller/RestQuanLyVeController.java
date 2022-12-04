package vn.thanhhai.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.thanhhai.dto.QuanLyVeDto;
import vn.thanhhai.model.QuanLyVe;
import vn.thanhhai.service.IQuanLyVeService;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/quanLyVe/v1")
public class RestQuanLyVeController {

    @Autowired
    private IQuanLyVeService quanLyVeService;

//    @Autowired
//    private IQuanLyVeDtoService quanLyVeDtoService;
//

    @GetMapping
    public ResponseEntity<List<QuanLyVeDto>> quanLyVe() {
        List<QuanLyVe> quanLyVeList = quanLyVeService.myFindAll();

        if (quanLyVeList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        List<QuanLyVeDto> quanLyVeDtoList = new ArrayList<>();
        for (QuanLyVe item : quanLyVeList) {
            QuanLyVeDto quanLyVeDto = new QuanLyVeDto();
            BeanUtils.copyProperties(item, quanLyVeDto);
            quanLyVeDto.setId(item.getId());
            quanLyVeDtoList.add(quanLyVeDto);
        }
        return new ResponseEntity<>(quanLyVeDtoList, HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<QuanLyVe> addQuanLyVe(@RequestBody QuanLyVeDto quanLyVeDto) {

        QuanLyVe quanLyVe = new QuanLyVe();
        BeanUtils.copyProperties(quanLyVeDto, quanLyVe);

        quanLyVeService.save(quanLyVe);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<QuanLyVe> quanLyVeById(@PathVariable() int id) {
        QuanLyVe quanLyVe = quanLyVeService.findById(id);
        if (quanLyVe == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(quanLyVe, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<QuanLyVe> updateQuanLyVe(@PathVariable() int id,
                                                   @RequestBody QuanLyVeDto quanLyVeDto) {
        QuanLyVe quanLyVeOld = quanLyVeService.findById(id);
        if (quanLyVeOld == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        BeanUtils.copyProperties(quanLyVeDto, quanLyVeOld);
        quanLyVeService.save(quanLyVeOld);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<QuanLyVe> deleteQuanLyVe(@PathVariable() int id) {
        QuanLyVe quanLyVe = quanLyVeService.findById(id);
        if (quanLyVe == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        quanLyVe.setIsDelete(0);
        quanLyVeService.save(quanLyVe);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
