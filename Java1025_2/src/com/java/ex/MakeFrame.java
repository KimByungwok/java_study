package com.java.ex;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Component;
import java.awt.Frame;
import java.awt.Label;
import java.awt.List;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MakeFrame extends Frame implements ActionListener {
	private List list;
	private Panel panel;
	private TextField textfield;
	private Button okBt;
	private Button exitBt;
	private Button plus;

	public MakeFrame() {
		list = new List();
		panel = new Panel();
		textfield = new TextField();
		okBt = new Button("Ok");
		exitBt = new Button("Exit");
		plus = new Button("삭제");
		

		setLayout(new BorderLayout());
		add(panel, BorderLayout.NORTH);
		add(list, BorderLayout.CENTER);
		panel.add(new Label("write"));
		panel.add(textfield);
		panel.add(okBt);
		panel.add(exitBt);
		panel.add(plus);

		okBt.addActionListener(this);
		exitBt.addActionListener(this);
		plus.addActionListener(this);

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				setVisible(false);
				dispose();
				System.exit(0);
			}
		});
	}

	@Override // ActionListner 메서드
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == okBt) {
			list.add(textfield.getText());
		} else if (e.getSource() == exitBt) {
			setVisible(false);
			dispose();
			System.exit(0);
		} else if (e.getSource() == plus) {
			
			list.remove(textfield.getText());
			
		}
	}
}
