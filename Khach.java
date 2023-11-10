import java.util.List;
import java.util.Scanner;

public class Khach {
    public static Scanner sc = new Scanner(System.in);
    public static List<Book> books = QuanLySach.getListBook();
    public static void menuKhach() {
        System.out.println("0. Thoát");
        System.out.println("1. Tìm kiếm sách.");
        System.out.println("2. Xem danh sách sách");
        System.out.print("Chọn chức năng của khách: ");
    }
    public static void chonChucNang() {
        while(true) {
            try {
                menuKhach();
                int cn = Integer.valueOf(sc.nextLine());
                System.out.println("=============================");
                if(cn==0) break;
                else if(cn==1) timSach();
                else if(cn==2) inDsachSach();
                else System.out.println("Chức năng của Khách không hợp lệ.");
                System.out.println("=============================");
            } catch (Exception e) {
                System.out.println("Xảy ra lỗi khi chọn chức năng Khách.");
                System.out.println("=============================");
            }
        }
    }
    public static void timSach() {
        System.out.print("Nhập thông tin sách: ");
        String s = sc.nextLine();
        System.out.println("=============================");
        Book res = QuanLySach.timSach(s, books);
        if(res != null) {
            System.out.println("Sách bạn cần tìm là: ");
            res.display();
        } else {
            System.out.println("Thông tin sách không hợp lệ.");
        }
    }
    public static void inDsachSach() {
        for (int i=0;i< books.size();++i) {
            books.get(i).display();
            System.out.println("-------------------------------------------------");
        }
    }

}
