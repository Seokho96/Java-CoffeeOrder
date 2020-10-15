package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import dao.MemberDao;
import dto.MemberDto;

public class accountView extends JFrame implements ActionListener {

	private JTextField idTextF;
	private JTextField passTextF;
	private JTextField nameTextF;
	private JTextField ageTextF;
	
	private JButton accountBtn;
	private JButton idBtn;	
	
	public accountView() {
		super("회원가입");
		setLayout(null);		
		
		JLabel loginLabel = new JLabel("회원가입");
		loginLabel.setBounds(100, 10, 120, 15);
		add(loginLabel);
		
		JLabel idLabel = new JLabel("ID:");
		idLabel.setBounds(31, 60, 67, 15);
		add(idLabel);
		
		idTextF = new JTextField();
		idTextF.setBounds(100, 60, 150, 20);
		add(idTextF);
		idTextF.setColumns(10);
		
		idBtn = new JButton("id");
		idBtn.addActionListener(this);
		idBtn.setBounds(260, 60, 50, 20);
		add(idBtn);
		
		JLabel passLabel = new JLabel("PassWord:");
		passLabel.setBounds(31, 104, 67, 15);
		add(passLabel);
		
		passTextF = new JTextField();
		passTextF.setBounds(100, 104, 150, 20);
		add(passTextF);
		
		JLabel nameLabel = new JLabel("이름:");
		nameLabel.setBounds(31, 148, 67, 15);
		add(nameLabel);
		
		nameTextF = new JTextField();
		nameTextF.setBounds(100, 148, 150, 20);
		add(nameTextF);
		
		JLabel emailLabel = new JLabel("나이:");
		emailLabel.setBounds(31, 192, 67, 15);
		add(emailLabel);
		
		ageTextF = new JTextField();
		ageTextF.setBounds(100, 192, 150, 20);
		add(ageTextF);
		
		accountBtn = new JButton("회원가입");
		accountBtn.addActionListener(this);
		accountBtn.setBounds(31, 236, 280, 50);
		add(accountBtn);		
		
		getContentPane().setBackground(new Color(0, 255, 0));
		setBounds(100, 100, 350, 400);
		setVisible(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
	//	JOptionPane.showMessageDialog(null, "버튼 클릭");

		JButton btn = (JButton)e.getSource();
		String btnTitle = btn.getLabel();
		
		if(btnTitle.equals("id")) {
		//	JOptionPane.showMessageDialog(null, "id 버튼 클릭");
			
			// id 확인
			MemberDao dao = MemberDao.getInstance();
			
			String id = idTextF.getText().trim();
			boolean b = dao.getId(id);
			
			if(b == true) {
				JOptionPane.showMessageDialog(null, "사용할 수 없는 ID입니다");
				idTextF.setText("");
			}else {
				JOptionPane.showMessageDialog(null, "이 ID는 사용할 수 있습니다");
			}			
		}	
		else if(btnTitle.equals("회원가입")) {			
			if(idTextF.getText().equals("") || 
					passTextF.getText().equals("") ||
					nameTextF.getText().equals("") ||
					ageTextF.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "모두 기입해 주십시오");
				return;
			}
			
			MemberDao dao = MemberDao.getInstance();
			
			boolean b = dao.addMember(new MemberDto(idTextF.getText(), passTextF.getText(), nameTextF.getText(), Integer.parseInt(ageTextF.getText()), 0));
			if(b) {
				JOptionPane.showMessageDialog(null, "성공적으로 가입되었습니다");
				this.dispose();
				new loginView();
			}else {
				JOptionPane.showMessageDialog(null, "가입에 실패했습니다");
			}
		}
	}

}







