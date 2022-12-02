import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class LibrarianFrame {

    public static void librarian_frame() {

        //Creating Librarian Frame
        JFrame librarianFrame = new JFrame("Librarian Functions");

        //Creating Button to view users
        JButton view_users_btn = new JButton("View Users");

        view_users_btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Creating Frame
                JFrame viewBooksUserFrame = new JFrame("Users");
                //Creating Table for to data will be in table format.
                JTable user_list = new JTable();
                String[] userColumnNames = {"User Name", "User Type", "First Name", "Last Name"};
                //Creating model for the table.
                DefaultTableModel userModel = new DefaultTableModel();
                //Setting up the columns names of the model.
                userModel.setColumnIdentifiers(userColumnNames);
                //Adding model to the table component.
                user_list.setModel(userModel);

                //Setting up table auto-resizable.
                user_list.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
                user_list.setFillsViewportHeight(true);
                user_list.setFocusable(false);

                //Creating scrollbars for table.
                JScrollPane scrollUser = new JScrollPane(user_list);
                scrollUser.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
                scrollUser.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

                //Retrieve books from database file
                try {
                    File data = new File("user_database.txt");
                    Scanner scan = new Scanner(data);

                    while(scan.hasNext()){
                        String input = scan.nextLine();
                        String[] values = input.split(",");
                        String username = values[0];
                        String userType = values[2];
                        String firstName = values[3];
                        String lastName = values[4];
                        userModel.addRow(new Object[]{ username, userType, firstName, lastName});
                    }
                    //Adding scrollbars in the frame.
                    viewBooksUserFrame.add(scrollUser);

                    //Setting up the size of the frame. (width,height)
                    viewBooksUserFrame.setSize(800, 400);

                    //Setting up frame visible for user.
                    viewBooksUserFrame.setVisible(true);


                } catch (Exception ex) {
                    ex.printStackTrace();

                }
            }
        });

        //Creating Button to view books
        JButton view_books_btn = new JButton("View Books");

        view_books_btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Creating Frame
                JFrame viewBooksUserFrame = new JFrame("Books Available");
                //Creating Table for to data will be in table format.
                JTable book_list = new JTable();
                String[] bookColumnNames = {"Book ISBN", "Book Name", "Book Publisher", "Book Genre", "Book Status"};
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
                        String book_Genre = values[3];
                        String book_Status = values[4];
                        bookModel.addRow(new Object[]{ book_ISBN, book_Name, book_Publisher, book_Genre, book_Status});
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
        });


        //Creating button to add users
        JButton add_user_btn = new JButton("Add User");

        //Performing actions on button.
        add_user_btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Creating form to add user
                JFrame add_user_frame = new JFrame("Enter User Details"); //Frame to enter user details

                //Creating label for username
                JLabel l1 = new JLabel("Username", SwingConstants.CENTER);

                //Creating label for password
                JLabel l2 = new JLabel("Password", SwingConstants.CENTER);

                //Creating label for user type
                JLabel l3 = new JLabel("User Type", SwingConstants.CENTER);

                JLabel l4 = new JLabel("First Name", SwingConstants.CENTER);

                JLabel l5 = new JLabel("Last Name", SwingConstants.CENTER);


                //Creating text field for username
                JTextField add_username_tf = new JTextField();
                //Creating text field for password
                JPasswordField add_password_tf = new JPasswordField();
                //Creating text field for user type
                JTextField add_usertype_tf = new JTextField();
                //Creating text field for username
                JTextField add_firstName_tf = new JTextField();
                //Creating text field for username
                JTextField add_lastName_tf = new JTextField();

                //Creating button to create user
                JButton createUser_btn = new JButton("Add User");
                //Creating button to close form
                JButton user_entry_cancel_btn = new JButton("Cancel");

                createUser_btn.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        //Get user data from form
                        String username = add_username_tf.getText();
                        String password = add_password_tf.getText();
                        String userType = add_username_tf.getText();
                        String firstName = add_firstName_tf.getText();
                        String lastName = add_lastName_tf.getText();

                        //Create Patron instance
                        Patron student = new Patron(username, password, userType, firstName, lastName);

                        //Add user to file database
                        try {
                            File data = new File("user_database.txt");
                            FileWriter fw = new FileWriter(data , true);
                            PrintWriter pw = new PrintWriter(fw);

                            //Format data to write
                            String dataToWrite = student.getUserName() + "," + student.getPassword() + "," + student.getUserType()
                                    + "," + student.getFirstName() + "," + student.getLastName();
                            //write data to file
                            pw.println(dataToWrite);
                            pw.close();

                        } catch (Exception ex) {
                            ex.printStackTrace();

                        }
                    }
                });
                user_entry_cancel_btn.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        add_user_frame.dispose();
                    }
                });

                //Setting up layout of the frame
                add_user_frame.setLayout(new GridLayout(6,2));

                //Adding components in frame.
                add_user_frame.add(l1);
                add_user_frame.add(add_username_tf);
                add_user_frame.add(l2);
                add_user_frame.add(add_password_tf);
                add_user_frame.add(l3);
                add_user_frame.add(add_usertype_tf);
                add_user_frame.add(l4);
                add_user_frame.add(add_firstName_tf);
                add_user_frame.add(l5);
                add_user_frame.add(add_lastName_tf);
                add_user_frame.add(createUser_btn);
                add_user_frame.add(user_entry_cancel_btn);

                //Setting up the size of the frame (width,height)
                add_user_frame.setSize(350 ,300);

                //Setting up the frame visible
                add_user_frame.setVisible(true);

                //Setting up table auto-resizable.
                add_user_frame.setResizable(false);
            }
        });

        //Creating button to add books
        JButton add_book_btn = new JButton("Add Book");

        add_book_btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Creating form to add user
                JFrame add_book_frame = new JFrame("Enter Book Details"); //Frame to enter user details

                //Creating labels for book details
                JLabel isbLb = new JLabel("Book ISBN", SwingConstants.CENTER);
                JLabel titleLb = new JLabel("Book Title", SwingConstants.CENTER);
                JLabel authorLb = new JLabel("Book Author", SwingConstants.CENTER);
                JLabel categoryLb= new JLabel("Category", SwingConstants.CENTER);
                JLabel editionLb = new JLabel("Book Edition", SwingConstants.CENTER);
                JLabel statusLb = new JLabel("Status", SwingConstants.CENTER);

                //Creating text fields for each entry
                JTextField add_isbn_tf = new JTextField();
                JTextField add_title_tf = new JTextField();
                JTextField add_author_tf = new JTextField();
                JTextField add_category_tf = new JTextField();
                JTextField add_edition_tf = new JTextField();
                JTextField add_status_tf = new JTextField();

                //Creating button to create user
                JButton createBook_btn = new JButton("Add Book");
                //Creating button to close form
                JButton book_entry_cancel_btn = new JButton("Cancel");

                createBook_btn.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String bookISBN = add_isbn_tf.getText();
                        String bookTitle = add_title_tf.getText();
                        String bookAuthor = add_author_tf.getText();
                        String bookCategory = add_category_tf.getText();
                        String edition = add_edition_tf.getText();
                        String bookStatus = add_status_tf.getText();

                        //create Book instance
                        Book book = new Book(bookISBN,bookTitle,bookAuthor,bookCategory,edition,bookStatus);
                        //Add book to file database
                        try {
                            File data = new File("books_database.txt");
                            FileWriter fw = new FileWriter(data , true);
                            PrintWriter pw = new PrintWriter(fw);

                            //Format data to write
                            String bookToWrite = book.getIsbn() + "," + book.getTitle() + "," + book.getAuthors()
                                    + "," + book.getCategory() + "," + book.getEdition() + "," + book.getBookStatus();
                            //write data to file
                            pw.println(bookToWrite);
                            pw.close();

                        } catch (Exception ex) {
                            ex.printStackTrace();

                        }

                    }
                });

                book_entry_cancel_btn.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        add_book_frame.dispose();
                    }
                });

                //Add all components to the frame
                add_book_frame.add(isbLb);
                add_book_frame.add(add_isbn_tf);
                add_book_frame.add(titleLb);
                add_book_frame.add(add_title_tf);
                add_book_frame.add(authorLb);
                add_book_frame.add(add_author_tf);
                add_book_frame.add(categoryLb);
                add_book_frame.add(add_category_tf);
                add_book_frame.add(editionLb);
                add_book_frame.add(add_edition_tf);
                add_book_frame.add(statusLb);
                add_book_frame.add(add_status_tf);
                add_book_frame.add(createBook_btn);
                add_book_frame.add(book_entry_cancel_btn);


                //Setting up the size of the frame (width,height)
                add_book_frame.setSize(350, 300);

                //Setting up layout of the frame
                add_book_frame.setLayout(new GridLayout(7,2));

                //Setting up the frame visible
                add_book_frame.setVisible(true);

                //Setting up table auto-resizable.
                add_book_frame.setResizable(false);
            }
        });

        //Creating button to issue books
        JButton add_issue_book_btn = new JButton("Issue Book");

        //Creating button to return books
        JButton add_return_book_btn = new JButton("Return Book");

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
