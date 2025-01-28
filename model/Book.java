
package Model;


public class Book {
    private int id;
    private String title;
    private String publishedYear;
    private Author author;
    
    public Book(int id,String title,String publishedYear,Author author){
        this.id=id;
        this.title=title;
        this.publishedYear=publishedYear;
        this.author=author;
    }
    public int getId(){
        return id;
    }
    public String getTitle(){
        return title;
    }
    public String getPublishedYear(){
        return publishedYear;
    }
    public Author getAuthor(){
        return author;
    }
    
    public String searchBook(String title){
        return "Book title is:"+title;
    }
    public String searchBook(String title,String author){
        return title+author;
    }
   
}
