
public class Book {
    private String title, type, id;
    private Author author;
    private Day releaseDate;

    public Book(String id, String title, Author author, String type, Day releaseDate) {
        this.id = id;
        this.title = title;
        this.type = type;
        this.author = author;
        this.releaseDate = releaseDate;
    }

    public static Book bookFromString(String s) {
        String[] strings = s.split("\\|");
        return new Book(strings[0], strings[1], new Author(strings[2]), strings[3], new Day(strings[4]));
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Author getAuthor() {
        return author;
    }
    public String getNameAuthor() {
        return author.getName();
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Day getReleaseDate() {
        return releaseDate;
    }
    public String getStringReleaseDate() {
        return releaseDate.toString();
    }

    public void setReleaseDate(Day releaseDate) {
        this.releaseDate = releaseDate;
    }

    public boolean compare(String s) {
        if(s.equals(id) || s.equals(title) || s.equals(type) || s.equals(getNameAuthor()) || s.equals(getStringReleaseDate())) return true;
        return false;
    }

    public void showInformation() {
        System.out.println("Id: " + id);
        System.out.println("Tiêu đề: " + getTitle());
        System.out.println("Tác giả: " + getNameAuthor());
        System.out.println("Thể loại: " + getTitle());
        System.out.println("Ngày xuất bản: " + getStringReleaseDate());
    }
}
