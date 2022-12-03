import {Component, OnInit} from '@angular/core';
import {NhaXe} from "../model/nha-xe";
import {QuanLyVe} from "../model/quan-ly-ve";
import {QuanlyveService} from "../service/quanlyve.service";
import {ToastrService} from "ngx-toastr";
import {ActivatedRoute, Router} from "@angular/router";
import {FormBuilder, FormControl, FormGroup} from "@angular/forms";

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListComponent implements OnInit {

  quanLyVe: QuanLyVe[] = [];
  quanLyVeO: QuanLyVe;
  nhaXeList: NhaXe[] = [];


  p: number;

  diemDiSearch: string;
  diemDenSearch: string;
  ngay1Serch: string;
  ngay2Search: string;

  rfquanLyve: FormGroup = new FormGroup({
    id: new FormControl(),
    gia: new FormControl(),
    diemDi: new FormControl(),
    diemDen: new FormControl(),
    ngayKhoiHanh: new FormControl(),
    gioKhoiHanh: new FormControl(),
    soLuong: new FormControl(),
    nhaXe: new FormControl(),

  });

  constructor(private quanlyveService: QuanlyveService,
              private activatedRoute: ActivatedRoute,
              private router: Router,
              private formBuiler: FormBuilder,
              private toast: ToastrService
  ) {
  }

  ngOnInit(): void {
    this.diemDiSearch = '';
    this.diemDenSearch = '';
    this.ngay1Serch = '';
    this.ngay2Search = '';

    this.p;

    this.quanlyveService.getList().subscribe(
      data => {
        this.quanLyVe = data
      });
    this.quanlyveService.findAllNhaXe().subscribe(
      data => {
        this.nhaXeList = data
      })
  }

  search() {
    this.quanlyveService.searchBy(this.diemDiSearch, this.diemDenSearch).subscribe(
      data => {
        this.p = 1;
        this.quanLyVe = data.filter(value => {
          if (this.ngay1Serch !== "" && this.ngay2Search !== "") {
            const format = new Date(value.ngayKhoiHanh);
            const ngay1Search = new Date(this.ngay1Serch);
            const ngay2Search = new Date(this.ngay2Search);
            if (format >= ngay1Search && format <= ngay2Search) {
              return value;
            }
          } else {
            return data;
          }
        })
      });
  }

  modalById(id: number): void {
    this.quanlyveService.findById(id).subscribe(data => {
      this.quanLyVeO = data;
    })
  }


  submit() {
    if (this.quanLyVeO.soLuong > 0) {
      this.quanLyVeO.soLuong = this.quanLyVeO.soLuong - 1;
      this.quanlyveService.updateProduct(this.quanLyVeO.id, this.quanLyVeO).subscribe(data => {
        this.ngOnInit();
      });
    }
  }

}
