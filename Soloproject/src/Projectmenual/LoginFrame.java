package Projectmenual;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class LoginFrame extends WindowAdapter implements ActionListener {
	private Frame f;
	private TextField tfId, tfPwd, tfMsg;
	private Button btnLogin;
	private MemberDAO dao;

	public LoginFrame() {
		dao = new MemberDAO();

		f = new Frame("Login");
		f.setLayout(new FlowLayout());
		f.setSize(400, 120);
		f.setLocation(2600, 100);
		f.addWindowListener(this);

		Label lid = new Label("ID", Label.RIGHT);
		Label lpwd = new Label("PWD", Label.RIGHT);

		tfId = new TextField(10);
		tfPwd = new TextField(10);

		btnLogin = new Button("Login");
		btnLogin.addActionListener(this);
		tfMsg = new TextField(40);

		f.add(lid);
		f.add(tfId);
		f.add(lpwd);
		f.add(tfPwd);
		f.add(btnLogin);
		f.add(tfMsg);
		f.setVisible(true);
	}

	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Login")) {
			System.out.println("Click!");
			ArrayList<MemberVo> list = dao.list(tfId.getText());

			String id = "", password = "";
			for (int i = 0; i < list.size(); i++) {
				MemberVo data = (MemberVo) list.get(i);
				id = data.getId();
				password = data.getPassword();

				System.out.println(id + " : " + password);
			}

			if (tfId.getText().equals(id) && tfPwd.getText().equals(password)) {
				System.out.println("로그인 성공");
				tfMsg.setText("로그인 성공");
			} else {
				System.out.println("로그인 실패");
				tfMsg.setText("로그인 실패");
			}
		}
	}

	public static void main(String[] args) {
		new LoginFrame();
	}
}