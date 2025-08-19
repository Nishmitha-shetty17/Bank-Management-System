package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class mini extends JFrame implements ActionListener {
    String pin;
    JButton button;
    mini(String pin){
        this.pin=pin;
        getContentPane().setBackground(new Color(255,204,204));
        setSize(400,600);
        setLocation(20,20);
        setLayout(null);

        JLabel label1=new JLabel();
        label1.setBounds(20,140,400,200);
        add(label1);

        JLabel label2 =new JLabel("LAST 6 TRANSACTION HISTORY");
        label2.setFont(new Font("System",Font.BOLD,15));
        label2.setBounds(70,20,300,20);
        add(label2);

        JLabel label3 =new JLabel();
        label3.setBounds(20,80,300,20);
        add(label3);

        JLabel label4 =new JLabel();
        label4.setBounds(20,400,300,20);
        add(label4);

        try{
            con1 c=new con1();
            ResultSet resultSet=c.statement.executeQuery("select * from login where pin = '"+pin+"'");
            while(resultSet.next()){
                label3.setText("Card Number : "+resultSet.getString("card_number").substring(0,4)+"XXXXXXXX"+resultSet.getString("card_number").substring(12));
            }
        }catch(Exception e){
            e.printStackTrace();
        }

        try {
            con1 c = new con1();
            ResultSet resultSet = c.statement.executeQuery("Select * from bank where pin='" + pin + "'");
            java.util.List<String> transactions = new java.util.ArrayList<>();
            int balance = 0;

            while (resultSet.next()) {
                String date = resultSet.getString("date");
                String type = resultSet.getString("type");
                String amount = resultSet.getString("amount");

                String transactionLine = date + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + type + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + amount;
                transactions.add(transactionLine);

                if (type.equals("Deposit")) {
                    balance += Integer.parseInt(amount);
                } else {
                    balance -= Integer.parseInt(amount);
                }
            }

            StringBuilder sb = new StringBuilder("<html>");
            int start = Math.max(transactions.size() - 6, 0);
            for (int i = start; i < transactions.size(); i++) {
                sb.append(transactions.get(i)).append("<br><br>");
            }
            sb.append("</html>");
            label1.setText(sb.toString());

            label4.setText("Your Total Balance is Rs. " + balance);
        } catch (Exception e) {
            e.printStackTrace();
        }

        button=new JButton("EXIT");
        button.setBounds(20,500,100,25);
        button.setBackground(Color.BLACK);
        button.setForeground(Color.WHITE);
        button.addActionListener(this);
        add(button);

        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);

    }
    public static void main(String[] args) {
        new mini("");
    }
}
