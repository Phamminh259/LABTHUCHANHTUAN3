
package hanghoa;

import java.util.ArrayList;
import java.util.List;


public class QuanLyHangHoa {
    private List<HangHoa> danhSachHangHoa;
 public QuanLyHangHoa() {
    danhSachHangHoa = new ArrayList<>();
}

public void themHangHoa(HangHoa hangHoa) {
    boolean trungMaHang = danhSachHangHoa.stream().anyMatch(h -> h.getMaHang().equals(hangHoa.getMaHang()));
    if (!trungMaHang) {
        danhSachHangHoa.add(hangHoa);
        System.out.println("Them hang hoa thanh cong");
    } else {
        System.out.println("Ma hang da ton tai.khong the them");
    }
}

public void inDanhSachHangHoa() {
    System.out.println("Danh sach hang hoa:");
    for (HangHoa hangHoa : danhSachHangHoa) {
        System.out.println("Ma hang: " + hangHoa.getMaHang());
        System.out.println("Ten hang: " + hangHoa.getTenHang());
        System.out.println("So luong ton: " + hangHoa.getSoLuongTon());
        System.out.println("Đon gia: " + hangHoa.getDonGia());
        System.out.println("Thue VAT: " + hangHoa.tinhTienVAT());
        System.out.println("Danh gia ban buon: " + hangHoa.danhGiaBanBuon());
        System.out.println("-----------------------------------");
    }
}
   
    
}
