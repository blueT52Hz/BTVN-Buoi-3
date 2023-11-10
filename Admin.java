import java.io.File;
import java.util.Scanner;

public class Admin {
    private String userName, passWord;
    public static Scanner sc = new Scanner(System.in);
    public Admin(String userName, String password) {
        this.userName = userName;
        this.passWord = password;
    }
    public String getUserName() {
        return userName;
    }
    public String getPassWord() {
        return passWord;
    }
    public static Admin[] getListAdmin() {
        File f = new File("listAdmin.txt");
        try {
            Scanner sc = new Scanner(f.toPath());
            String line = new String(sc.nextLine());
            String[] strings = line.split("\\|");
            Admin[] admins = new Admin[strings.length/2];
            for(int i=0;i<strings.length;i+=2) {
                admins[i/2]=new Admin(strings[i], strings[i+1]);
            }
            return admins;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Admin[0];
    }
    public static void menuAdmin() {
        System.out.println("1. Thêm sách mới.");
        System.out.println("2. Xóa sách");
        System.out.println("3. Sửa sách.");
        System.out.println("4. Test chức năng của khách.");
        System.out.println("5. Thoát tài khoản Admin");
        System.out.print("Chọn chức năng Admin: ");
    }
    public static void chonChucNang() {
        while(true) {
            menuAdmin();
            try {
                int cn = Integer.valueOf(sc.nextLine());
                System.out.println("=============================");
                if(cn==1) {
                    System.out.println("Thêm sách mới");
                    QuanLySach.themSach(Khach.books);
                    System.out.println("=============================");
                } else if(cn==2) {
                    System.out.println("Xóa sách.");
                    QuanLySach.xoaSach(Khach.books);
                    System.out.println("=============================");
                } else if(cn==3) {
                    System.out.println("Sửa sách");
                    System.out.print("Nhập thông tin bất kỳ của sách: ");
                    String s = sc.nextLine();
                    QuanLySach.suaSach(s, Khach.books);
                    System.out.println("=============================");
                } else if(cn==4) {
                    System.out.println("Test chức năng của khách:");
                    Khach.chonChucNang();
                    System.out.println("=============================");
                } else if(cn==5) {
                    System.out.println("Thoát tài khoản Admin");
                    System.out.println("=============================");
                    DangNhap.login();
                } else {
                    System.out.println("Chức năng của Admin không hợp lệ!");
                    System.out.println("=============================");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
