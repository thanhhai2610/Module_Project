import {NhaXe} from './nha-xe';

export interface QuanLyVe {
  id: number;
  gia: number;
  diemDi: string;
  diemDen: string;
  ngayKhoiHanh: string;
  gioKhoiHanh: string;
  soLuong: number;
  nhaXe: NhaXe;
}
