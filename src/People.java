import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.File;
import java.util.Scanner;

public class People
{
    //field-variables
    private String userName; //Primary Key
    private String password;
    private String userType; //0 = librarian; 1 = patron
    private String firstName;
    private String lastName;

    //constructors
    public People(String userName,String password, String userType,String firstName, String lastName)
    {
        this.userName = userName;
        this.password = password;
        this.userType = userType;
        this.firstName = firstName;
        this.lastName = lastName;

    }
    //class-methods
    public String getUserName()
    {
        return userName;
    }
    public String getPassword()
    {
        return password;
    }
    public String getUserType()
    {
        return userType;
    }
    public String getFirstName()
    {
        return firstName;
    }
    public String getLastName()
    {
        return lastName;
    }


    public void setUserID(String userID)
    {
        this.userName= userID;
    }
    public void setPassword( String password ) //we need this in change person wants to change their password or they are initializing their password for the first time
    {
        this.password = password;
    }
    public void setUserType( String userType ) //we need this in case someone needs to change role
    {
        this.userType = userType;
    }
    public void setFirstName( String firstName ) //we need this because a person may want to change their name later
    {
        this.firstName = firstName;
    }
    public void setLastName( String lastName )
    {
        this.lastName = lastName;
    }

    public void viewBooks(){
        //Creating Frame
        JFrame viewBooksUserFrame = new JFrame("Books Available");
        //Creating Table for to data will be in table format.
        JTable book_list = new JTable();
        String[] bookColumnNames = {"Book ISBN", "Book Name", "Book Publisher", "Book Category", "Book Edition"};
        //Creating model for the table.
        DefaultTableModel bookModel = new DefaultTableModel();
        //Setting up the columns names of the model.
        bookModel.setColumnIdentifiers(bookColumnNames);

        //Adding model to the table component.
        book_list.setModel(bookModel);

        //Setting up table auto-resizable.
        book_list.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        book_list.setFillsViewportHeight(true);
        book_list.setFocusable(false);

        //Creating scrollbars for table.
        JScrollPane scrollBook = new JScrollPane(book_list);
        scrollBook.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollBook.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        //Retrieve books from database file
        try {
            File data = new File("books_database.txt");
            Scanner scan = new Scanner(data);

            while(scan.hasNext()){
                String input = scan.nextLine();
                String[] values = input.split(",");
                String book_ISBN = values[0];
                String book_Name = values[1];
                String book_Publisher = values[2];
                String book_Category = values[3];
                String book_Edition = values[4];
                bookModel.addRow(new Object[]{ book_ISBN, book_Name, book_Publisher, book_Category,book_Edition});
            }
            //Adding scrollbars in the frame.
            viewBooksUserFrame.add(scrollBook);

            //Setting up the size of the frame. (width,height)
            viewBooksUserFrame.setSize(800, 400);

            //Setting up frame visible for user.
            viewBooksUserFrame.setVisible(true);


        } catch (Exception ex) {
            ex.printStackTrace();

        }
    }
}