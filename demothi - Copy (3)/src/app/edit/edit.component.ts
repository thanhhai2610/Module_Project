import {Component, OnInit} from '@angular/core';
import {NhaXe} from "../model/nha-xe";
import {FormBuilder, FormControl, FormGroup} from "@angular/forms";
import {QuanlyveService} from "../service/quanlyve.service";
import {ActivatedRoute, ParamMap, Router} from "@angular/router";

@Component({
  selector: 'app-edit',
  templateUrl: './edit.component.html',
  styleUrls: ['./edit.component.css']
})
export class EditComponent implements OnInit {

  nhaXeList: NhaXe[] = [];
  id: number;

  rfquanLyve: FormGroup;

  equals(o1: NhaXe, o2: NhaXe) {
    return o1.id === o2.id;
  }

  constructor(private quanlyveService: QuanlyveService,
              private activatedRoute: ActivatedRoute,
              private formBuiler: FormBuilder,
              private router: Router) {
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

  getById(id: number) {
    return this.quanlyveService.findById(id).subscribe(data => {
      console.log(data)
      this.rfquanLyve = this.formBuiler.group({
          id: [data.id],
          gia: [data.gia],
          diemDi: [data.diemDi],
          diemDen: [data.diemDen],
          ngayKhoiHanh: [data.ngayKhoiHanh],
          gioKhoiHanh: [data.gioKhoiHanh],
          soLuong: [data.soLuong],
          nhaXe: [data.nhaXe],
        });
    });
  }

  submit() {
    const product = this.rfquanLyve.value;
    this.quanlyveService.update(product.id, product).subscribe(data => {
      this.router.navigate(['/']);
    });
  }

}
