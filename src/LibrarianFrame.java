import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LibrarianFrame {

    public void librarian_frame(Librarian librarian) {

        //Creating Librarian Frame
        JFrame librarianFrame = new JFrame("Librarian Functions");

        //Creating Button to view users
        JButton view_users_btn = new JButton("View Users");

        view_users_btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                librarian.viewUsers();
            }
        });

        //Creating Button to view books
        JButton view_books_btn = new JButton("View Books");

        view_books_btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                librarian.viewBooks();
            }
        });


        //Creating button to add users
        JButton add_user_btn = new JButton("Add User");

        //Performing actions on button.
        add_user_btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                librarian.addPeople();
            }
        });

        //Creating button to add books
        JButton add_book_btn = new JButton("Add Book");

        add_book_btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                librarian.addBook();
            }
        });

        //Creating button to issue books
        JButton add_issue_book_btn = new JButton("Issue Book");

        add_issue_book_btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                librarian.issueBook();
            }
        });

        //Creating button to return books
        JButton add_return_book_btn = new JButton("Return Book");

        add_return_book_btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                librarian.returnBook();
            }
        });

        //Setting the layout of Librarian Frame
        librarianFrame.setLayout(new GridLayout(1, 6));

        //Adding Librarian components in the Librarian Frame
        librarianFrame.add(add_user_btn);
        librarianFrame.add(add_book_btn);
        librarianFrame.add(view_users_btn);
        librarianFrame.add(view_books_btn);
        librarianFrame.add(add_issue_book_btn);
        librarianFrame.add(add_return_book_btn);


        //Setting size of the frame (width,height)
        librarianFrame.setSize(800, 200);

        //Setting up the frame visible to the user
        librarianFrame.setVisible(true);

        //Setting up frame non-resizable
        librarianFrame.setResizable(false);

    }
}
