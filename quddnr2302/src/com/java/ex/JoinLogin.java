package com.java.ex;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import javax.swing.*;
import javax.swing.plaf.metal.MetalBorders.TextFieldBorder;

import java.awt.*;

public class JoinLogin extends JFrame{
	String choice = null;
	
	public JoinLogin() {
		setTitle("회원가입");
		JLabel title = new JLabel("회원가입",JLabel.CENTER);
		JButton join = new JButton("회원가입");
		JButton cancel = new JButton("가입취소");
		
		JTextField id = new JTextField(10);
		JPasswordField pwd = new JPasswordField(10);
		JTextField name = new JTextField(10);
		
		JPanel idPanel = new JPanel();
		idPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		idPanel.add(new JLabel("아이디 : "));
		idPanel.add(pwd);
		
		JPanel pwdPanel = new JPanel();
		pwdPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		pwdPanel.add(new JLabel("비밀번호 : "));
		pwdPanel.add(pwd);
		
		JPanel namePanel = new JPanel();
		namePanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		namePanel.add(new JLabel("이    름 : "));
		namePanel.add(name);
		
		JPanel formPanel = new JPanel();
		formPanel.setLayout(new GridLayout(4, 1));
		formPanel.add(idPanel);
		formPanel.add(pwdPanel);
		formPanel.add(namePanel);
		
		JPanel panel = new JPanel();
		panel.add(join);
		panel.add(cancel);
		panel.add(id);
		panel.add(pwd);
		panel.add(name);
		
		
		add(title, BorderLayout.NORTH);
		add(panel, BorderLayout.CENTER);
		add(panel, BorderLayout.SOUTH);
		
		setSize(500,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
join.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String myId = id.getText();
				String myPwd = new String(pwd.getPassword());
				String myName = name.getText();	
				JOptionPane.showMessageDialog
					(null, "아이디 : "+myId+", 비밀번호 : "+myPwd+
					", 이 름 : "+myName);
			}
		});
		// 취소 버튼을 클릭했을 때 이벤트 처리
		cancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				new JoinLogin();
				dispose();
				
			}
		});
	}
}
