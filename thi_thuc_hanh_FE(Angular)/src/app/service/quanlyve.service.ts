import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {QuanLyVe} from "../model/quan-ly-ve";
import {environment} from "../../environments/environment";
import {NhaXe} from "../model/nha-xe";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class QuanlyveService {

  constructor(private httpClient: HttpClient) {
  }

  getList() {
    return this.httpClient.get<QuanLyVe[]>(
      environment.api_url_quanLyve);
  }

  findAllNhaXe() {
    return this.httpClient.get<NhaXe[]>(
      environment.api_url_nhaXe);
  }

  save(quanLyVe: QuanLyVe): Observable<QuanLyVe> {
    return this.httpClient.post<QuanLyVe>(
      environment.api_url_quanLyve, quanLyVe);
  }
  searchBy(diemDi: string, diemDen: string): Observable<QuanLyVe[]> {
    return this.httpClient.get<QuanLyVe[]>(environment.api_url_quanLyve + `?diemDi_like=${diemDi}&diemDen_like=${diemDen}`);
  }
  findById(id: number) {
    return this.httpClient.get<QuanLyVe>(environment.api_url_quanLyve + '/' + id);
  }


  updateProduct(id: number, quanLyVe: QuanLyVe ): Observable<QuanLyVe> {
    return this.httpClient.put<QuanLyVe>(environment.api_url_quanLyve + '/' + id, quanLyVe);
  }



}
