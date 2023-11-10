import java.util.Scanner;

public class DangNhap {
    private static Admin[] admins = Admin.getListAdmin();

    public static void inDsachAdmin() {
        admins = Admin.getListAdmin();
        for (int i=0;i<admins.length;++i) {
            System.out.println("Ussername: " + admins[i].getUserName());
            System.out.println(("Password: " + admins[i].getPassWord()));
        }
    }
    public static boolean ktraAdmin(String userName, String passWord) {
        for(int i=0;i<admins.length;++i) {
            if(admins[i].getUserName().equals(userName)){
                if(admins[i].getPassWord().equals(passWord)) return true;
            }
        }
        return false;
    }

    public static void login(){
        Scanner sc = new Scanner(System.in);
        int dn=1;
        while(true) {
            System.out.printf("Nhập tên đăng nhập: ");
            String username = String.valueOf(sc.nextLine());
            if(username.equals("khach")) {
                System.out.println("Đăng nhập với tư cách khách.");
                System.out.println("=============================");
                Khach.chonChucNang();
            } else {
                System.out.printf("Nhập mật khẩu: ");
                String password = String.valueOf(sc.nextLine());
                if(DangNhap.ktraAdmin(username, password)) {
                    System.out.println("Đăng nhập với tư cách Admin.");
                    System.out.println("=============================");
                    Admin.chonChucNang();
                    System.out.println("=============================");
                } else {
                    System.out.println("Sai mật khẩu hoặc tên đăng nhập.");
                    System.out.println("=============================");
                }
            }
        }
    }
}
