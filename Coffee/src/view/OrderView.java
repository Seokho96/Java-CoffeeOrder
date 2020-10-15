package view;

import java.awt.Checkbox;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import dao.MemberDao;
import dao.ordDao;
import dto.OrderDto;


public class OrderView extends JFrame implements ActionListener {

	JComboBox<String> choice, sizeChoice;
	
	JPanel sizePanel, syrupPanel, othersPanel;
	JRadioButton shortBtn,tallBtn,grandeBtn, banilaBtn,caramelBtn, heyBtn;
	JCheckBox shotBtn,creamBtn;
	JTextField cupTextF;
	ButtonGroup sizeGroup, syrupGroup, otherGroup;
	
	
	JButton pricetBtn;
	JButton orderBtn;
	
	public OrderView() {
		super("주문하기");
		
		setLayout(null);
		
		JLabel loginLabel = new JLabel("주문 하기");
		loginLabel.setBounds(300, 10, 120, 15);
		add(loginLabel);
				
		sizePanel = new JPanel();
		sizePanel.setLayout(new GridLayout(5, 1));
		sizePanel.setBorder(new LineBorder(Color.BLACK, 1));
		sizePanel.setBounds(100, 180, 130, 130);
		sizePanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		add(sizePanel);
		
		
		 JLabel sizelabel = new JLabel("Size");
		 sizePanel.add(sizelabel);
		 
		 shortBtn = new JRadioButton("Short");
		 sizePanel.add(shortBtn);
		 tallBtn = new JRadioButton("Tall");
		 sizePanel.add(tallBtn);
		 grandeBtn = new JRadioButton("Grande");
		 sizePanel.add(grandeBtn);
		 
		 sizeGroup = new ButtonGroup();
		 
	//	 banilaBtn,caramelBtn, heyBtn
		 
		 
		 syrupPanel = new JPanel();
		 syrupPanel.setLayout(new GridLayout(5, 1));
		 syrupPanel.setBorder(new LineBorder(Color.BLACK, 1));
		 syrupPanel.setBounds(250, 180, 130, 130);
		 syrupPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
			add(syrupPanel);
		
		JLabel syruplabel = new JLabel("Syrup");
		syrupPanel.add(syruplabel);
		
		banilaBtn = new JRadioButton("바닐라");
		syrupPanel.add(banilaBtn);
		 caramelBtn = new JRadioButton("카라멜");
		 syrupPanel.add(caramelBtn);
		 heyBtn = new JRadioButton("헤이즐럿");
		 syrupPanel.add(heyBtn);
		 
		 syrupGroup = new ButtonGroup();
		 
		 othersPanel = new JPanel();
		 othersPanel.setLayout(new GridLayout(5, 1));
		 othersPanel.setBorder(new LineBorder(Color.BLACK, 1));
		 othersPanel.setBounds(400, 180, 130, 130);
		 othersPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
			add(othersPanel);
		
			JLabel otherlabel = new JLabel("The Others");
			othersPanel.add(otherlabel);
			
			 shotBtn = new JCheckBox("샷 추가");
			othersPanel.add(shotBtn);
			 creamBtn = new JCheckBox("휘핑크림 추가");
			othersPanel.add(creamBtn);
			
			otherGroup = new ButtonGroup();
		
		cupTextF = new JTextField();
		cupTextF.setBounds(160, 370, 80, 30);
		add(cupTextF);
		
		String ctitle[] = {
				"Choice(커피를 선택)",
				"헤이즐넛 카라멜 모카",
				"카라멜 마끼아또",
				"화이트 초콜릿 모카",
				"카라멜 모카",
				"카페 모카",
				"카라멜 라떼",
				"카페 라떼",
				"카푸치노",
				"아메리카노",
				"오늘의 커피"				
		};
		choice = new JComboBox<String>(ctitle);
		choice.setBounds(150, 80, 350, 30);
		choice.setBackground(Color.white);				
		add(choice);
		
		JLabel amountLabel = new JLabel("잔");
		amountLabel.setBounds(250, 380, 100, 15);
		add(amountLabel);
	
				
		pricetBtn = new JButton("가격표 보기");
		pricetBtn.addActionListener(this);
		pricetBtn.setBounds(450, 25, 140, 40);
		add(pricetBtn);	
		
		orderBtn = new JButton("주문");
		orderBtn.addActionListener(this);
		orderBtn.setBounds(480, 360, 120, 40);
		add(orderBtn);			
		
		getContentPane().setBackground(Color.PINK);
		setBounds(100, 100, 640, 480);
		setVisible(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		ordDao ord = new ordDao();
		
		
		JButton btn = (JButton)e.getSource();
		String id = MemberDao.getInstance().getLoginID();
		String ctitle[] = {
				"헤이즐넛 카라멜 모카",
				"카라멜 마끼아또",
				"화이트 초콜릿 모카",
				"카라멜 모카",
				"카페 모카",
				"카라멜 라떼",
				"카페 라떼",
				"카푸치노",
				"아메리카노",
				"오늘의 커피"				
		};
		String selectSize = null;
		if(shortBtn.isSelected()) {
			selectSize = shortBtn.getText();
		}else if(tallBtn.isSelected()) {
			selectSize = tallBtn.getText();
		}else if(grandeBtn.isSelected()) {
			selectSize = grandeBtn.getText();
		}
		
		String selectSyrup = null;
		if(banilaBtn.isSelected()) {
			selectSyrup = banilaBtn.getText();
		}else if(caramelBtn.isSelected()) {
			selectSyrup = caramelBtn.getText();
		}else if(heyBtn.isSelected()) {
			selectSyrup = heyBtn.getText();
		}else {
			selectSyrup = "추가 안함";
		}
			
		
		String shot = null;
		if(shotBtn.isSelected()) {
			shot = "추가";
		}
		else {
			shot = "추가안함";
		}
		String wheep = null;
		if(creamBtn.isSelected()) {
			wheep = "추가";
		}
		else {
		    wheep = "추가안함";	
		}
	   
	
	String cof =choice.getSelectedItem().toString();
	
	int price =	Integer.parseInt(ord.priceCheck(cof));
	
	if(shortBtn.isSelected()) {
		price = price * Integer.parseInt(cupTextF.getText().toString());
	}
	else if(tallBtn.isSelected()) {
		price = (price + 500) * Integer.parseInt(cupTextF.getText().toString());
	}
	else if(grandeBtn.isSelected()) {
		price = (price + 1000) * Integer.parseInt(cupTextF.getText().toString());
	}
		
		
	if(btn == orderBtn) {	
		
	OrderDto dto = new OrderDto(id, choice.getSelectedItem().toString(), selectSyrup, selectSize, shot, wheep, Integer.parseInt(cupTextF.getText()), price);
	
	boolean b = ord.orderList(dto);
	
	if(b) {
		//System.out.println(price);
		JOptionPane.showMessageDialog(null, "주문이 완료되었습니다.");
		new OrderList();
		System.out.println(dto.toString());
	}else {
		JOptionPane.showMessageDialog(null, "잘못된 주문입니다. 다시 한번 확인해주세요.");
	}
	
	
	
	
	}
		else if(btn == pricetBtn) {
			
			new priceView();		
		}
	}
	


}
