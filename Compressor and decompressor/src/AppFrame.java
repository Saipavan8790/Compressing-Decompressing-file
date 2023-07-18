package GUI;

import comp_decomp.compressor;
import comp_decomp.decompressor;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
/**
 *
 * @author Saipavan
 */
public class AppFrame extends JFrame implements ActionListener {

    JButton compressButton;
    JButton decompressButton;

    AppFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("File Compressor Decompressor");
        this.setLayout(null);
        compressButton = new JButton("Select file to compress");
        this.add(compressButton);
        compressButton.setBounds(30,100,100,30);
        compressButton.setSize(200, 50);
        compressButton.setLocation(250, 400);
        compressButton.addActionListener(this);

        // compressButton.setLocation(100, 200);

        decompressButton = new JButton("Select file to decompress");
        this.add(decompressButton);
        decompressButton.setBounds(30,100,300,30);
        decompressButton.setSize(200, 50);
        decompressButton.setLocation(550, 400);
        decompressButton.addActionListener(this);

        this.setSize(600, 400);
        this.getContentPane().setBackground(Color.gray);
        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == compressButton){
            JFileChooser filechooser = new JFileChooser();
            int response = filechooser.showSaveDialog(null);
            if(response == JFileChooser.APPROVE_OPTION){
                File file = new File(filechooser.getSelectedFile().getAbsolutePath());
                System.out.print(file);
                try{
                    compressor.method(file);
                } catch(Exception ee) {
                    JOptionPane.showMessageDialog(null, ee.toString());
                }
            }
        }

        if(e.getSource() == decompressButton){
            JFileChooser filechooser = new JFileChooser();
            int response = filechooser.showSaveDialog(null);
            if(response == JFileChooser.APPROVE_OPTION){
                File file = new File(filechooser.getSelectedFile().getAbsolutePath());
                System.out.print(file);
                try{
                    decompressor.method(file);
                } catch(Exception ee) {
                    JOptionPane.showMessageDialog(null, ee.toString());
                }
            }
        }
    }

}