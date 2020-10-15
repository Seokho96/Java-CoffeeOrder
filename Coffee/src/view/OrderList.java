package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;


import dao.MemberDao;
import dao.ordDao;

import dto.OrderDto;

public class OrderList extends JFrame implements ActionListener {
	
	JButton insertBtn, termBtn, searchBtn;
    JLabel kind[], long_lb, long_lb2, cup; 
	public OrderList() {		
		super("주문내역");
		
		String login_id = MemberDao.getInstance().getLoginID();
		ordDao ord = new ordDao();
		setTitle(login_id);
		
		setLayout(null);
		
		JLabel menuLabel = new JLabel("주문내역");
		menuLabel.setBounds(350, 5, 120, 50);
		menuLabel.setFont(new Font(null, Font.BOLD, 16));	
		menuLabel.setForeground(Color.black);
		add(menuLabel);		
		
		long_lb = new JLabel("Espresso");
		long_lb.setBounds(20, 50, 120, 30);
		long_lb.setFont(new Font("굴림", Font.BOLD, 13));
		add(long_lb);
		
		long_lb2 = new JLabel("Beverages");
		long_lb2.setBounds(100, 50, 120, 30);
		long_lb2.setFont(new Font("굴림", Font.BOLD, 13));
		add(long_lb2);
		
		cup = new JLabel("잔");
		cup.setBounds(650, 50, 120, 30);
		cup.setFont(new Font ("바탕", Font.BOLD, 12));
		add(cup);
		
		String title[] = { "시럽" , "크기" , "샷 추가" , "휘핑 크림 잔","총액"};
		
		kind = new JLabel[title.length];
		for(int i =0; i < title.length; i++) {
			
			kind[i] = new JLabel(title[i]);
			kind[i].setBounds(230 + 100*i, 50, 120, 30);
			if(i ==4) {
				kind[i].setBounds(250 + 460, 50, 120, 30);
			}
			kind[i].setFont(new Font("바탕", Font.BOLD, 12));
			add(kind[i]);
		}
		
		JTextArea jta = new JTextArea();
	    
		jta.setBounds(20, 80, 750, 300);
		jta.setBackground(new Color(153, 204, 204));
		
		OrderDto dto = new OrderDto();
		
		ordDao dao = ordDao.getInstance();
		
		List<OrderDto> list = dao.getOrderlist();
		
		for (OrderDto a : list) {		
			
			jta.append("[" + a.getMenu() + "]" +
					a.getSyrup() + ", " +
					"금액:" + a.getSize() + "원 " +
					a.getShot() + "\t" + a.getWheeping() + "\t" + a.getCup() + "\t" + a.getPrice());
			// textArea에 출력
		}
		
		
		
		
		
		add(jta);
		
		termBtn = new JButton("주문화면");
		termBtn.setBounds(500, 400, 120, 50);
		//termBtn.setBackground(Color.BLUE);
		termBtn.addActionListener(this);
		add(termBtn);
		
		searchBtn = new JButton("종료");
		searchBtn.setBounds(650, 400, 120, 50);
		searchBtn.addActionListener(this);
		add(searchBtn);
		
		
		getContentPane().setBackground(new Color(204, 255, 255));
		setBounds(100, 100, 800, 500);
		setVisible(true);
		
		setDefaultCloseOperation(OrderList.EXIT_ON_CLOSE);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		JButton btn = (JButton)e.getSource();
		
	if(btn == termBtn) {
	new OrderView();
	this.dispose();
		}
	else if(btn == searchBtn) {
		this.dispose();
	}
	}

}
