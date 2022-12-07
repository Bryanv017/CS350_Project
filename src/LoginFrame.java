import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Scanner;

public class LoginFrame {

    public static void loginFn() {

        //Creating Login Frame
        JFrame loginFrame = new JFrame("Login");

        //Creating label Username
        JLabel l1 = new JLabel("Username", SwingConstants.CENTER);

        //Creating label Password
        JLabel l2 = new JLabel("Password", SwingConstants.CENTER);

        //Create text field Username
        JTextField usernameTF = new JTextField();

        //Create text field Password
        JPasswordField passwordTF = new JPasswordField();

        //Create button Login
        JButton loginBtn = new JButton("Login");

        //Create button cancel
        JButton cancelBtn = new JButton("Cancel");


     loginBtn.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed (ActionEvent e){

            //Get username and password from form input
            String username = usernameTF.getText();
            String password = passwordTF.getText();

            //If username is empty
            if (username.isEmpty()) {
                //Display dialog box with the message
                JOptionPane.showMessageDialog(null, "Please enter username");
            } //If password is empty
            else if (password.isEmpty()) {
                //Display dialog box with the message
                JOptionPane.showMessageDialog(null, "Please enter password");
            }
            else{
                try{
                    //Create file and scanner for our database
                    File data = new File("user_database.txt");
                    Scanner scan = new Scanner(data);
                    //Scan file to see if the username and password entered matches in our database file
                    while(scan.hasNext()) {
                        String input = scan.nextLine();
                        //Create an array to store each value from the input separated by comma
                        String[] values = input.split(",");
                        //check if the values for username and password match with an entry in our database
                        if (values[0].trim().equals(username.trim()) && values[1].trim().equals(password.trim())) {
                            //if the value for userType equals 1 means user is librarian
                           if(values[2].equals("1")) {
                               Librarian librarian = new Librarian(values[0],values[1],values[2],values[3],values[4]);
                               LibrarianFrame librarian_view = new LibrarianFrame();
                               librarian_view.librarian_frame(librarian);
                               loginFrame.dispose();
                           }
                           //if the value for userType equals something else means user is patron
                           if(values[2].equals("0")){
                               Patron student = new Patron(values[0],values[1],values[2],values[3],values[4]);
                               UserFrame user_view = new UserFrame();
                               user_view.user_frame(student);
                               loginFrame.dispose();
                           }
                        }
                    }
                }catch (Exception ex){
                    ex.printStackTrace();
                }
            }
        }
    });


        //Adding all login components in login frame.
        loginFrame.add(l1);
        loginFrame.add(usernameTF);
        loginFrame.add(l2);
        loginFrame.add(passwordTF);
        loginFrame.add(loginBtn);
        loginFrame.add(cancelBtn);

        //Setting size of frame (width, height)
        loginFrame.setSize(330, 180);

        //Setting layout of the frame
        loginFrame.setLayout(new GridLayout(3, 2));

        //Setting frame visible to the user
        loginFrame.setVisible(true);

        //Setting frame non-resizable
        loginFrame.setResizable(false);

    }
}