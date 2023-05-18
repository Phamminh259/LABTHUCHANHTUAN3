
package hanghoa;

import java.time.LocalDate;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        QuanLyHangHoa quanLyHangHoa = new QuanLyHangHoa();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("====== MENU ======");
            System.out.println("1. Them hang hoa");
            System.out.println("2. In danh sach hang hoa");
            System.out.println("0. Thoat");
            System.out.print("Nhap lua chon: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    scanner.nextLine(); 
                    System.out.println("Chon loai hang hoa :");
                    System.out.println("1. Hang thuc pham");
                    System.out.println("2. Hang dien may");
                    System.out.println("3. Hang sanh su");
                    System.out.print("Nhap lua chon: ");
                    int type = scanner.nextInt();
                    scanner.nextLine(); 

                    System.out.print("Nhap ma hang: ");
                    String maHang = scanner.nextLine();

                    System.out.print("Nhap ten hang: ");
                    String tenHang = scanner.nextLine();

                    System.out.print("Nhap so luong ton: ");
                    int soLuongTon = scanner.nextInt();

                    System.out.print("Nhap don gia: ");
                    double donGia = scanner.nextDouble();

                    switch (type) {
                        case 1:
                            scanner.nextLine(); 

                            System.out.print("Nhap ngay san xuat (yyyy-mm-dd): ");
                            String ngaySanXuatStr = scanner.nextLine();
                            LocalDate ngaySanXuat = LocalDate.parse(ngaySanXuatStr);

                            System.out.print("Nhap ngay het han (yyyy-mm-dd): ");
                            String ngayHetHanStr = scanner.nextLine();
                            LocalDate ngayHetHan = LocalDate.parse(ngayHetHanStr);

                            System.out.print("Nhap nha cung cap: ");
                            String nhaCungCap = scanner.nextLine();

                            HangThucPham thucPham = new HangThucPham(maHang, tenHang, soLuongTon,
                                    donGia, ngaySanXuat, ngayHetHan, nhaCungCap);
                            quanLyHangHoa.themHangHoa(thucPham);
                            break;

                        case 2:
                            System.out.print("Nhap thoi gian bao hanh (thang): ");
                            int thoiGianBaoHanh = scanner.nextInt();

                            System.out.print("Nhap cong suat (KW): ");
                            double congSuat = scanner.nextDouble();

                            HangDienMay dienMay = new HangDienMay(maHang, tenHang, soLuongTon,
                                    donGia, thoiGianBaoHanh, congSuat);
                            quanLyHangHoa.themHangHoa(dienMay);
                            break;

                        case 3:
                            scanner.nextLine(); 

                            System.out.print("Nhap ngay san xuat: ");
                            String nhaSanXuat = scanner.nextLine();

                            System.out.print("Nhap ngay nhap kho (yyyy-mm-dd): ");
                            String ngayNhapKhoStr = scanner.nextLine();
                            LocalDate ngayNhapKho = LocalDate.parse(ngayNhapKhoStr);

                            HangSanhSu sanhSu = new HangSanhSu(maHang, tenHang, soLuongTon,
                                    donGia, nhaSanXuat, ngayNhapKho);
                            quanLyHangHoa.themHangHoa(sanhSu);
                            break;

                        default:
                            System.out.println("Lua chon khong hop le");
                            break;
                    }
                    break;

                case 2:
                    quanLyHangHoa.inDanhSachHangHoa();
                    break;

                case 0:
                    System.out.println("Ket thuc chuong trinh.");
                    break;

                default:
                    System.out.println("Lua chon khong hop le.");
                    break;
            }

            System.out.println();
        } while (choice != 0);
        
        scanner.close();
    }
}
