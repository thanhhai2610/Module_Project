import {Component, OnInit} from '@angular/core';
import {NhaXe} from "../model/nha-xe";
import {FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";
import {QuanlyveService} from "../service/quanlyve.service";
import {Router} from "@angular/router";
import {ToastrService} from "ngx-toastr";

@Component({
  selector: 'app-create',
  templateUrl: './create.component.html',
  styleUrls: ['./create.component.css']
})
export class CreateComponent implements OnInit {

  nhaXe: NhaXe[] = [];

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
              private router: Router,
              private formBuiler: FormBuilder,
              private toastr: ToastrService,
  ) {
  }

  ngOnInit(): void {
    this.quanlyveService.findAllNhaXe().subscribe(data => {
      this.rfquanLyve = this.formBuiler.group({
        gia: ['',
          [Validators.required, Validators.min(0)]],
        diemDi: ['',
          [Validators.required]],
        diemDen: ['',
          [Validators.required]],
        ngayKhoiHanh: ['',
          [Validators.required]],
        gioKhoiHanh: ['',
          [Validators.required]],
        soLuong: ['',
          [Validators.required, Validators.min(0)]],
        nhaXe: ['',
          [Validators.required]],
      })
      this.nhaXe = data;
    })
  }

  submit() {
    const quanLyVe = this.rfquanLyve.value;
    this.quanlyveService.save(quanLyVe).subscribe(data => {
      this.router.navigate(['/'])
      this.rfquanLyve.reset();
      this.toastr.success("Them moi thanh cong")
    })
  }

}
