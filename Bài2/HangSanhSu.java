
package hanghoa;

import java.time.LocalDate;

public class HangSanhSu extends HangHoa {

  private String nhaSanXuat;
  private LocalDate ngayNhapKho;

  public HangSanhSu(String maHang, String tenHang, int soLuongTon, double donGia,
                  String nhaSanXuat, LocalDate ngayNhapKho) {
    super(maHang, tenHang, soLuongTon, donGia);
    this.nhaSanXuat = nhaSanXuat;
    this.ngayNhapKho = ngayNhapKho;
}

public String getNhaSanXuat() {
    return nhaSanXuat;
}

public LocalDate getNgayNhapKho() {
    return ngayNhapKho;
}

@Override
public double tinhTienVAT() {
    return donGia * 0.1;
}

@Override
public String danhGiaBanBuon() {
    if (soLuongTon > 50 && LocalDate.now().minusDays(10).isAfter(ngayNhapKho)) {
        return "Ban cham";
    } else {
        return "";
    }
}
}

