import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.IOException;

public class Book {
    private String tieuDe, theLoai, id;
    private Author tacGia;
    private Day nxb;
    public static Scanner sc = new Scanner(System.in);

    public Book(String id, String tieuDe, Author tacGia,String theLoai, Day nxb) {
        this.id = id;
        this.tieuDe = tieuDe;
        this.theLoai = theLoai;
        this.tacGia = tacGia;
        this.nxb = nxb;
    }

    public Book(String s) {
        String[] strings = s.split("\\|");
        id = strings[0];
        tieuDe = strings[1];
        tacGia = new Author(strings[2]);
        theLoai = strings[3];
        nxb = new Day(strings[4]);
    }

    public String getId() {
        return id;
    }

    public String getTieuDe() {
        return tieuDe;
    }

    public String getTacGia() {
        return tacGia.getName();
    }

    public String getTheLoai() {
        return theLoai;
    }

    public String getNxb() {
        return nxb.toString();
    }

    public void setTieuDe(String tieuDe) {
        this.tieuDe = tieuDe;
    }

    public void setTheLoai(String theLoai) {
        this.theLoai = theLoai;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTacGia(Author tacGia) {
        this.tacGia = tacGia;
    }

    public void setNxb(Day nxb) {
        this.nxb = nxb;
    }

    public boolean soSanh(String s) {
        if(s.equals(id) || s.equals(theLoai) || s.equals(tieuDe) || s.equals(getTacGia()) || s.equals(getNxb())) return true;
        return false;
    }

    @Override
    public String toString() {
        return id+"|"+tieuDe+"|"+getTacGia()+"|"+theLoai+"|"+getNxb();
    }

    public void display() {
        System.out.println("Id: " + id);
        System.out.println("Tiêu đề: " + getTieuDe());
        System.out.println("Tác giả: " + getTacGia());
        System.out.println("Thể loại: " + getTheLoai());
        System.out.println("Năm xuất bản: " + getNxb());
    }
}
