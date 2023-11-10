import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuanLySach {
    public static Scanner sc = new Scanner(System.in);
    public static List<Book> getListBook() {
        File f = new File("listBook.txt");
        try {
            Scanner sc = new Scanner(f.toPath());
            List<String> lines = Files.readAllLines(f.toPath());
            List<Book> books = new ArrayList<Book>();
            for(int i=0;i<lines.size();++i) {
                books.add(new Book(lines.get(i)));
            }
            return books;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return List.of(new Book[0]);
    }

    public static Book timSach(String s, List<Book> books) {
        for(int i=0;i<books.size();++i) {
            if(books.get(i).soSanh(s)) {
                return books.get(i);
            }
        }
        System.out.println("Không tìm thấy sách qua thông tin trên");
        return null;
    }

    public static void xoaSach(List<Book> books) {
        System.out.print("Nhập thông tin sách cần xóa: ");
        String s = sc.nextLine();
        int sLuongCu = books.size();
        for(int i=0;i<books.size();++i) {
            if(books.get(i).soSanh(s)) {
                System.out.println("Cuốn sách bạn muốn xóa là: ");
                books.get(i).display();
                books.remove(i);
            }
        }
        if(sLuongCu==books.size()) {
            System.out.println("Không tìm thấy sách cần xóa qua thông tin trên");
            return;
        } else {
            PrintWriter pw = null;
            try {
                pw = new PrintWriter("listBook.txt");
            } catch (Exception e) {
                e.printStackTrace();
            }
            for(int i=0;i<books.size();++i) {
                pw.println(books.get(i).toString());
                pw.flush();
            }
            pw.close();
        }
        System.out.println("Xóa sách thành công.");
    }

    public static void themSach(List<Book>books) {
        try {
            System.out.println("Nhập thông tin sách cần thêm:");
            System.out.print("Id: ");
            String id = sc.nextLine();
            System.out.print("Tiêu đề: ");
            String tieuDe = sc.nextLine();
            System.out.print("Tác giả: ");
            String tacGia = sc.nextLine();
            System.out.print("Thể loại: ");
            String theLoai = sc.nextLine();
            System.out.print("Ngày xuất bản: ");
            String nxb = sc.nextLine();
            books.add(new Book(id, tieuDe, new Author(tacGia), theLoai, new Day(nxb)));
            try {
                PrintWriter pw = null;
                pw = new PrintWriter(new FileWriter("listBook.txt", true)); // chọn file có địa chỉ như đường dẫn
                pw.println(id+"|"+tieuDe+"|"+tacGia+"|"+theLoai+"|"+nxb);
                pw.flush();
                pw.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            System.out.println("Thông tin thêm sách không hợp lệ.");
            return;
        }
        System.out.println("Thêm sách mới thành công.");
    }

    public static void menuSuaSach() {
        System.out.println("Nhập thông tin cần sửa: ");
        System.out.println("1. Tiêu để.");
        System.out.println("2. Tác giả.");
        System.out.println("3. Thể loại.");
        System.out.println("4. Ngày xuất bản.");
    }

    public static void suaSach(String s, List<Book> books) {
        Book sua = QuanLySach.timSach(s, books);
        if(sua == null) {
            System.out.println("Thông tin sách không hợp lệ.");
        } else {
            System.out.println("Thông tin sách cần sửa là: ");
            sua.display();
            QuanLySach.menuSuaSach();
            int cn = Integer.valueOf(sc.nextLine());
            System.out.print("Nhập thông tin mới: ");
            String tmp = sc.nextLine();
            if(cn==1) sua.setTieuDe(tmp);
            else if(cn==2) sua.setTacGia(new Author(tmp));
            else if(cn==3) sua.setTheLoai(tmp);
            else if(cn==4) sua.setNxb(new Day(tmp));
            else System.out.println("Chức năng sửa không hợp lệ.");
            PrintWriter pw = null;
            try {
                pw = new PrintWriter("listBook.txt");
            } catch (Exception e) {
                e.printStackTrace();
            }
            for(int i=0;i<books.size();++i) {
                pw.println(books.get(i).toString());
                pw.flush();
            }
            if(pw != null) {
                pw.close();
                System.out.println("Sửa thông tin sách thành công.");
            } else {
                System.out.println("Sửa thông tin sách không thành công.");
            }
        }
    }
}
