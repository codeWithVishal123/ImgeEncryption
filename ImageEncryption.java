package v1.x;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.io.FileInputStream;
import java.nio.channels.FileChannel;
import java.awt.FlowLayout;
import java.io.*;
///vishal sencha
public class ImageEncryption{
    public static void Decrypt(int key) {
        JFileChooser filechooser=new JFileChooser();
        filechooser.showOpenDialog(null);
        File file = filechooser.getSelectedFile();

        try{
            FileInputStream fis=new FileInputStream(file);
            byte []data=new byte[fis.available()];
            fis.read(data);
            int i=0;
            for(byte b:data)
            {
                System.out.println(b);
                data[i]=(byte)(b^key);
                i++;
            }
            FileOutputStream fos=new FileOutputStream(file);
            fos.write(data);
            fos.close();
            fis.close();
            JOptionPane.showMessageDialog(null, "Image Has Been Successfully Decrypted");

        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void Encrypt(int key) {
        JFileChooser filechooser=new JFileChooser();
        filechooser.showOpenDialog(null);
        File file = filechooser.getSelectedFile();

        try{
            FileInputStream fis=new FileInputStream(file);
            byte []data=new byte[fis.available()];
            fis.read(data);
            int i=0;
            for(byte b:data)
            {
                System.out.println(b);
                data[i]=(byte)(b^key);
                i++;
            }
            FileOutputStream fos=new FileOutputStream(file);
            fos.write(data);
            fos.close();
            fis.close();
            JOptionPane.showMessageDialog(null, "Image Has Been Successfully Encrypted");

        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        System.out.println("this is testing");
        JFrame f=new JFrame();
        
        f.setTitle("image encryption");
        f.setSize(500, 400);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Font font=new Font("Roboto",Font.BOLD,25);
        JButton button=new JButton();
        button.setText("Encrypt Image");
        button.setFont(font);

        
        JTextField textField=new JTextField(10);
        textField.setFont(font);
        textField.getSize();
        
        button.addActionListener(e->{
            String text=textField.getText();
            int temp=Integer.parseInt(text);
            Encrypt(temp);
         });

         f.setLayout(new FlowLayout());
        f.add(button);
        f.add(textField);
        f.setVisible(true);
        JButton button1=new JButton();
        button1.setText("Decrypt Image");
        button1.setFont(font);

        
        JTextField textField1=new JTextField(10);
        textField1.setFont(font);
        textField1.getSize();
        
        button1.addActionListener(e->{
            String text=textField1.getText();
            int temp=Integer.parseInt(text);
            Decrypt(temp);
         });

         f.setLayout(new FlowLayout());
        f.add(button1);
        f.add(textField1);
        f.setVisible(true);


    }
    
}
