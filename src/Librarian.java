import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Scanner;

public class Librarian extends People {
    //constructors
    public Librarian(String userName, String password, String userType, String firstName, String lastName) {
        super(userName, password, userType, firstName, lastName);
    }

    public void viewUsers(){
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


    public void addPeople(){
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

    public void addBook(){
        //Creating form to add user
        JFrame add_book_frame = new JFrame("Enter Book Details"); //Frame to enter user details

        //Creating labels for book details
        JLabel isbLb = new JLabel("Book ISBN", SwingConstants.CENTER);
        JLabel titleLb = new JLabel("Book Title", SwingConstants.CENTER);
        JLabel authorLb = new JLabel("Book Author", SwingConstants.CENTER);
        JLabel categoryLb= new JLabel("Category", SwingConstants.CENTER);
        JLabel editionLb = new JLabel("Book Edition", SwingConstants.CENTER);


        //Creating text fields for each entry
        JTextField add_isbn_tf = new JTextField();
        JTextField add_title_tf = new JTextField();
        JTextField add_author_tf = new JTextField();
        JTextField add_category_tf = new JTextField();
        JTextField add_edition_tf = new JTextField();


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

                //create Book instance
                Book book = new Book(bookISBN,bookTitle,bookAuthor,bookCategory,edition);
                //Add book to file database
                try {
                    File data = new File("books_database.txt");
                    FileWriter fw = new FileWriter(data , true);
                    PrintWriter pw = new PrintWriter(fw);

                    //Format data to write
                    String bookToWrite = book.getIsbn() + "," + book.getTitle() + "," + book.getAuthors()
                            + "," + book.getCategory() + "," + book.getEdition();
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
        add_book_frame.add(createBook_btn);
        add_book_frame.add(book_entry_cancel_btn);


        //Setting up the size of the frame (width,height)
        add_book_frame.setSize(350, 300);

        //Setting up layout of the frame
        add_book_frame.setLayout(new GridLayout(6,2));

        //Setting up the frame visible
        add_book_frame.setVisible(true);

        //Setting up table auto-resizable.
        add_book_frame.setResizable(false);
    }

    public void issueBook(){
        //Creating form to add user
        JFrame issueBook_frame = new JFrame("Issue Book"); //Frame to enter user details

        //Creating label for username
        JLabel l1 = new JLabel("Issue ID", SwingConstants.CENTER);

        //Creating label for book ISBN
        JLabel l2 = new JLabel("Book ISBN", SwingConstants.CENTER);

        //Creating label for username of the student that is renting the book
        JLabel l3 = new JLabel("Patron User Name", SwingConstants.CENTER);

        //Creating label for Issue Date
        JLabel l4 = new JLabel("Issue Date", SwingConstants.CENTER);

        //Creating text fields for data
        JTextField add_issueID_tf = new JTextField();
        JTextField add_bookISBN_tf = new JTextField();
        JTextField add_patronID_tf = new JTextField();
        JTextField add_issueDate_tf = new JTextField();

        JButton issue_btn = new JButton("Issue Book");
        JButton cancel_btn = new JButton("Cancel");

        issue_btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String issueId = add_issueID_tf.getText();
                String bookISBN = add_bookISBN_tf.getText();
                String patronID = add_patronID_tf.getText();
                String issueDate = add_issueDate_tf.getText();

                IssuedBook issue_book = new IssuedBook(issueId, bookISBN, patronID, issueDate);

                try {
                    File data = new File("issued_books.txt");
                    FileWriter fw = new FileWriter(data,true);
                    PrintWriter pw = new PrintWriter(fw);

                    String book_to_issue = issue_book.getIssue_ID() + "," + issue_book.getIsbn() + "," + issue_book.getIssuedBy()
                                            + "," + issue_book.getIssueDate();

                    pw.println(book_to_issue);
                    pw.close();


                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        cancel_btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                issueBook_frame.dispose();
            }
        });

        //Adding Components to the frame
        issueBook_frame.add(l1);
        issueBook_frame.add(add_issueID_tf);
        issueBook_frame.add(l2);
        issueBook_frame.add(add_bookISBN_tf);
        issueBook_frame.add(l3);
        issueBook_frame.add(add_patronID_tf);
        issueBook_frame.add(l4);
        issueBook_frame.add(add_issueDate_tf);
        issueBook_frame.add(issue_btn);
        issueBook_frame.add(cancel_btn);

        //Setting window properties
        issueBook_frame.setLayout(new GridLayout(5,2));
        issueBook_frame.setSize(350, 300);
        issueBook_frame.setVisible(true);
        issueBook_frame.setResizable(false);

    }

    public void returnBook(){
        //Creating form to add user
        JFrame returnBook_frame = new JFrame("Return Book"); //Frame to enter user details

        //Creating label for username
        JLabel l1 = new JLabel("Return ID", SwingConstants.CENTER);

        //Creating label for book ISBN
        JLabel l2 = new JLabel("Book ISBN", SwingConstants.CENTER);

        //Creating label for username of the student that is renting the book
        JLabel l3 = new JLabel("Patron User Name", SwingConstants.CENTER);

        //Creating label for Issue Date
        JLabel l4 = new JLabel("Return Date", SwingConstants.CENTER);

        //Creating text fields for data
        JTextField add_returnID_tf = new JTextField();
        JTextField add_bookISBN_tf = new JTextField();
        JTextField add_patronID_tf = new JTextField();
        JTextField add_returnDate_tf = new JTextField();

        JButton issue_btn = new JButton("Return Book");
        JButton cancel_btn = new JButton("Cancel");

        issue_btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String returnId = add_returnID_tf.getText();
                String bookISBN = add_bookISBN_tf.getText();
                String patronID = add_patronID_tf.getText();
                String returnDate = add_returnDate_tf.getText();

                ReturnedBook returned_book = new ReturnedBook(returnId, bookISBN, patronID, returnDate);

                //add book to the returned book database file
                try {
                    File data = new File("returned_books.txt");
                    FileWriter fw = new FileWriter(data,true);
                    PrintWriter pw = new PrintWriter(fw);

                    String book_to_return = returned_book.getIssue_ID() + "," + returned_book.getIsbn() + "," +
                            returned_book.getIssuedBy() + "," + returned_book.getIssueDate();

                    pw.println(book_to_return);
                    pw.close();


                } catch (Exception ex) {
                    ex.printStackTrace();
                }

                //Delete book from issued books database file
                try{
                    //create temp file
                    String tempFile = "temp.txt";
                    File newFile = new File(tempFile);
                    //use current file
                    File oldFile  = new File("issued_books.txt");

                    //variables to hold data from issued books file
                    String issue_id = "";
                    String book_isbn = "";
                    String issued_by = "";
                    String issue_date = "";

                    FileWriter fw = new FileWriter(tempFile,true);
                    BufferedWriter  bw = new BufferedWriter(fw);
                    PrintWriter pw = new PrintWriter(bw);
                    Scanner scan = new Scanner(oldFile);
                    scan.useDelimiter("[,\n]");

                    while(scan.hasNext()) {
                        issue_id = scan.next();
                        book_isbn = scan.next();
                        issued_by = scan.next();
                        issue_date = scan.next();
                        if(!book_isbn.equals(bookISBN)){
                            pw.println(issue_id + "," + book_isbn + "," + issued_by + "," + issue_date);
                        }
                    }
                    scan.close();
                    pw.flush();
                    pw.close();
                    oldFile.delete();
                    File newData = new File("issued_books.txt");
                    newFile.renameTo(newData);


                }catch (Exception ex){
                    ex.printStackTrace();
                }

                JOptionPane.showMessageDialog(null, "Book has been returned");
            }
        });

        cancel_btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                returnBook_frame.dispose();
            }
        });

        //Adding Components to the frame
        returnBook_frame.add(l1);
        returnBook_frame.add(add_returnID_tf);
        returnBook_frame.add(l2);
        returnBook_frame.add(add_bookISBN_tf);
        returnBook_frame.add(l3);
        returnBook_frame.add(add_patronID_tf);
        returnBook_frame.add(l4);
        returnBook_frame.add(add_returnDate_tf);
        returnBook_frame.add(issue_btn);
        returnBook_frame.add(cancel_btn);

        //Setting window properties
        returnBook_frame.setLayout(new GridLayout(5,2));
        returnBook_frame.setSize(350, 300);
        returnBook_frame.setVisible(true);
        returnBook_frame.setResizable(false);

    }
}



