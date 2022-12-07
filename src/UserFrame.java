import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserFrame {

    public static void user_frame(Patron patron) {

        //Creating Frame for Student
        JFrame studentFrame = new JFrame("Student Functions");

        //Creating button for view books
        JButton view_books_btn = new JButton("View Books");

        view_books_btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                patron.viewBooks();
            }
        });

        //Creating Button for issued books
       // JButton view_user_issued_books_btn = new JButton("Issued Books");


        //Setting Layout of the student frame.
        studentFrame.setLayout(new GridLayout(1, 1));

        //Adding all the components in the student frame.
        studentFrame.add(view_books_btn);
        //studentFrame.add(view_user_issued_books_btn);


        //Setting size of the student frame (width,height)
        studentFrame.setSize(300, 200);

        //Setting up the frame visible
        studentFrame.setVisible(true);

        //Setting up frame non-resizable
        studentFrame.setResizable(false);


    }
}
