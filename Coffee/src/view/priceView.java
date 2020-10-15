package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

import dao.MemberDao;


public class priceView extends JFrame  {

	JTextField syearTF, smonthTF, sdayTF;
	JTextField eyearTF, emonthTF, edayTF;
	
	JLabel co_namelb[], price[], price2[], price3[], t[];
	JButton resultBtn;
	JButton backBtn;
	
	JTextArea textArea;
	
	String ctitle[] = {"헤이즐넛 카라멜 모카","카라멜 마끼아또","화이트 초콜릿 모카","카라멜 모카","카페 모카","카라멜 라떼","카페 라떼","카푸치노","아메리카노","오늘의 커피"};
	String ptitle[] = {"4800",	"4300", "4300", "4300", "3800", "3800", "3300", "3300", "2800" ,"2500"};
	String tt[] = {"--"};
	public priceView() {
		super("메뉴판");
		
		setLayout(null);
		
		JLabel loginLabel = new JLabel("가격표");
		loginLabel.setBounds(320, 10, 120, 15);
		add(loginLabel);
		
		JLabel Label1 = new JLabel("Espresso Beverages");
		Label1.setBounds(20, 40, 120, 30);
		add(Label1);
		
		JLabel Label2 = new JLabel("Short");
		Label2.setBounds(250, 40, 120, 30);
		add(Label2);
		
		JLabel Label3 = new JLabel("Tall");
		Label3.setBounds(410, 40, 120, 30);
		add(Label3);
		
		JLabel Label4 = new JLabel("Grande");
		Label4.setBounds(540, 40, 120, 30);
		add(Label4);
		
		co_namelb = new JLabel[ctitle.length];
	for(int i =0; i < ctitle.length; i++) {
		
		co_namelb[i] = new JLabel(ctitle[i]);
		co_namelb[i].setBounds(20, 80+40*i, 120, 30);
		co_namelb[i].setFont(new Font("바탕", Font.PLAIN, 12));
		add(co_namelb[i]);
	}
	
	    price = new JLabel[ptitle.length];
	for(int i =0; i < ptitle.length; i++) {
		
		price[i] = new JLabel(ptitle[i]);
		price[i].setBounds(250, 80+40*i, 120, 30);
		price[i].setFont(new Font("바탕", Font.BOLD, 12));
		add(price[i]);
	}
	  price2 = new JLabel[ptitle.length];
		for(int i =0; i < price.length; i++) {
			
			price2[i] = new JLabel((Integer.parseInt(ptitle[i])+500)+"");
			price2[i].setBounds(410, 80+40*i, 120, 30);
			price2[i].setFont(new Font("바탕", Font.BOLD, 12));
			add(price2[i]);
		}
		  price3 = new JLabel[ptitle.length];
			for(int i =0; i < price.length; i++) {
				
				price3[i] = new JLabel((Integer.parseInt(ptitle[i])+1000)+"");
				price3[i].setBounds(550, 80+40*i, 120, 30);
				price3[i].setFont(new Font("바탕", Font.BOLD, 12));
				add(price3[i]);
			}
		t = new JLabel[65];
		for(int i =0; i < 65; i++) {
			
			t[i] = new JLabel(tt[0]);
			t[i].setBounds(10+10*i, 60, 120, 30);
			t[i].setFont(new Font("바탕", Font.BOLD, 12));
			add(t[i]);
		}
		getContentPane().setBackground(Color.white);
		setBounds(100, 100, 700, 600);
		setVisible(true);
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	
}





