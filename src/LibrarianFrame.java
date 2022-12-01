import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LibrarianFrame {

    public static void librarian_frame() {

        //Creating Librarian Frame
        JFrame librarianFrame = new JFrame("Librarian Functions");

        //Creating Button to view books
        JButton view_books_btn = new JButton("View Books");

        //Creating button to view issued books
        JButton view_issued_books_btn = new JButton("View Issued Books");

        //Creating button view returned books
        JButton view_returned_books_btn = new JButton("View Returned Books");

        //Creating button to add users
        JButton add_user_btn = new JButton("Add User");

        //Creating button to add books
        JButton add_book_btn = new JButton("Add Book");

        //Creating button to issue books
        JButton add_issue_book_btn = new JButton("Issue Book");

        //Creating button to return books
        JButton add_return_book_btn = new JButton("Return Book");

        //Setting the layout of Librarian Frame
        librarianFrame.setLayout(new GridLayout(2, 4));

        //Adding Librarian components in the Librarian Frame
        librarianFrame.add(add_user_btn);
        librarianFrame.add(add_book_btn);
        librarianFrame.add(add_issue_book_btn);
        librarianFrame.add(add_return_book_btn);
        librarianFrame.add(view_books_btn);
        librarianFrame.add(view_issued_books_btn);
        librarianFrame.add(view_returned_books_btn);

        //Setting size of the frame (width,height)
        librarianFrame.setSize(800, 200);

        //Setting up the frame visible to the user
        librarianFrame.setVisible(true);

        //Setting up frame non-resizable
        librarianFrame.setResizable(false);

    }
}
