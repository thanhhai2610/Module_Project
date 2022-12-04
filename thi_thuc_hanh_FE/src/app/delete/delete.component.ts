import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup} from "@angular/forms";
import {NhaXe} from "../model/nha-xe";
import {ActivatedRoute, ParamMap, Router} from "@angular/router";
import {QuanlyveService} from "../service/quanlyve.service";

@Component({
  selector: 'app-delete',
  templateUrl: './delete.component.html',
  styleUrls: ['./delete.component.css']
})
export class DeleteComponent implements OnInit {

  rfquanLyve: FormGroup;
  id: number;
  nhaXeList: NhaXe[] = [];

  equals(o1: NhaXe, o2: NhaXe) {
    return o1.id === o2.id;
  }

  constructor(private router: Router,
              private activatedRoute: ActivatedRoute,
              private formBuilder: FormBuilder,
              private quanlyveService: QuanlyveService) {

  }

  ngOnInit(): void {

    this.quanlyveService.findAllNhaXe().subscribe(data => {
      this.nhaXeList = data;
    });

    this.activatedRoute.paramMap.subscribe((paramMap: ParamMap) => {
      this.id = +paramMap.get('id');
      this.getById(this.id);
    });

  }

  private getById(id: number) {
    return this.quanlyveService.findById(id).subscribe(data => {
      this.rfquanLyve = this.formBuilder.group({
        id: [data.id],
        gia: [data.gia],
        diemDi: [data.diemDi],
        diemDen: [data.diemDen],
        ngayKhoiHanh: [data.ngayKhoiHanh],
        gioKhoiHanh: [data.gioKhoiHanh],
        soLuong: [data.soLuong],
        nhaXe: [data.nhaXe.ten],
      });
    });
  }

  submitDelete(id: number) {
    this.quanlyveService.delete(id).subscribe(data => {
      this.router.navigate(['/']);
    });
  }
}
