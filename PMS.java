package pharmecy.ms;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.awt.Container;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PMS extends JFrame implements ActionListener {

    private Container c;
    private JLabel titleLable,mnLabel,cnLabel,expLabel,stockLable,priceLabel;
    private JTextField mnTf,cnTf,expTf,stockTf,priceTf;
    private JButton addButton,updateButton,deleteButton,clearButton;
    private ImageIcon aimg, uimg, dimg, cimg;
    private JTable table;
    private JScrollPane scroll;
    private DefaultTableModel model;
    private String[] colums = {"Medicine Name","Company Name","EXP Date","Stock Amount","Price"};
    private String[] rows = new String[5];




    PMS(){
        bishwambar ();
    }


    public void bishwambar(){

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(780, 690);
        this.setLocationRelativeTo(null);
        this.setTitle("Pharmecy Management System");

        c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.PINK);

        Font font = new Font("Arial",Font.BOLD,16);

        titleLable = new JLabel("Medicine Details");
        titleLable.setFont(font);
        titleLable.setBounds(140,10,250,50);
        c.add(titleLable);

        mnLabel = new JLabel("Medicine Name");
        mnLabel.setFont(font);
        mnLabel.setBounds(10,80,140,30);
        c.add(mnLabel);

        mnTf = new JTextField();
        mnTf.setFont(font);
        mnTf.setBounds(180,80,200,30);
        c.add(mnTf);

        cnLabel = new JLabel("Company Name");
        cnLabel.setFont(font);
        cnLabel.setBounds(10,130,150,30);
        c.add(cnLabel);

        cnTf = new JTextField();
        cnTf.setFont(font);
        cnTf.setBounds(180,130,200,30);
        c.add(cnTf);

        expLabel = new JLabel("EXP Date");
        expLabel.setFont(font);
        expLabel.setBounds(10,180,150,30);
        c.add(expLabel);

        expTf = new JTextField();
        expTf.setFont(font);
        expTf.setBounds(180,180,200,30);
        c.add(expTf);

        stockLable = new JLabel("Stock Amount");
        stockLable.setFont(font);
        stockLable.setBounds(10,230,150,30);
        c.add(stockLable);

        stockTf = new JTextField();
        stockTf.setFont(font);
        stockTf.setBounds(180,230,200,30);
        c.add(stockTf);

        priceLabel = new JLabel("Price of Medicine");
        priceLabel.setFont(font);
        priceLabel.setBounds(10,280,180,30);
        c.add(priceLabel);

        priceTf = new JTextField();
        priceTf.setFont(font);
        priceTf.setBounds(180,280,200,30);
        c.add(priceTf);


        aimg = new ImageIcon(getClass().getResource("addimg.png"));
        uimg = new ImageIcon(getClass().getResource("updateimg.png"));
        dimg = new ImageIcon(getClass().getResource("deleteimg.png"));
        cimg = new ImageIcon(getClass().getResource("clearimg.png"));

        addButton = new JButton(aimg);
        addButton.setFont(font);
        addButton.setBounds(400,80,120,35);
        c.add(addButton);

        updateButton = new JButton(uimg);
        updateButton.setFont(font);
        updateButton.setBounds(400,130,120,35);
        c.add(updateButton);

        deleteButton = new JButton(dimg);
        deleteButton.setFont(font);
        deleteButton.setBounds(400,180,120,35);
        c.add(deleteButton);

        clearButton = new JButton(cimg);
        clearButton.setFont(font);
        clearButton.setBounds(400,230,120,35);
        c.add(clearButton);



        table = new JTable();


        model = new DefaultTableModel();
        model.setColumnIdentifiers(colums);
        table.setModel(model);
        table.setFont(font);
        table.setSelectionBackground(Color.GREEN);
        table.setBackground(Color.WHITE);
        table.setRowHeight(30);

        scroll = new JScrollPane(table);
        scroll.setBounds(10,360,740,265);
        c.add(scroll);

        addButton.addActionListener(this);
        updateButton.addActionListener(this);
        deleteButton.addActionListener(this);
        clearButton.addActionListener(this);

        table.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent me) {

                int numberOfROW  = table.getSelectedRow();

                String m_name = model.getValueAt(numberOfROW, 0).toString();
                String c_name = model.getValueAt(numberOfROW, 1).toString();
                String expdate = model.getValueAt(numberOfROW, 2).toString();
                String stock = model.getValueAt(numberOfROW, 3).toString();
                String price = model.getValueAt(numberOfROW, 4).toString();

                mnTf.setText(m_name);
                cnTf.setText(c_name);
                expTf.setText(expdate);
                stockTf.setText(stock);
                priceTf.setText(price);

            }
        });

    }

     @Override
    public void actionPerformed(ActionEvent e) {


        if(e.getSource()==addButton) {

            rows[0] = mnTf.getText();
            rows[1] = cnTf.getText();
            rows[2] = expTf.getText();
            rows[3] = stockTf.getText();
            rows[4] = priceTf.getText();

            model.addRow(rows);

        }

        else if(e.getSource()==clearButton){

                mnTf.setText("null");
                cnTf.setText("null");
                expTf.setText("null");
                stockTf.setText("null");
                priceTf.setText("null");

        }

        else if(e.getSource()==deleteButton){

                int numberOfROW =  table.getSelectedRow();

                if(numberOfROW >= 0){
                    model.removeRow(numberOfROW);
                }
                else {
                    JOptionPane.showMessageDialog(null, "nothig select");
                }

        }

        else if(e.getSource()==updateButton){

            int numberOfROW = table.getSelectedRow();

            String m_name = mnTf.getText();
            String c_name = cnTf.getText();
            String exp = expTf.getText();
            String stock = stockTf.getText();
            String price = priceTf.getText();

            model.setValueAt(m_name,numberOfROW,0);
            model.setValueAt(c_name,numberOfROW,1);
            model.setValueAt(exp,numberOfROW,2);
            model.setValueAt(stock,numberOfROW,3);
            model.setValueAt(price,numberOfROW,4);



        }

    }


}
