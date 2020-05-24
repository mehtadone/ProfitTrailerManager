package com.profittrailer.form;

import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.StringUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

@Log4j2
public class ManagerForm extends JFrame {

	private JPanel mainPanel;
	private JLabel lblUrl;
	private JButton btnQuit;
	private JTextField fldPassword;
	private String managerUrl = "http://localhost:";
	private String defaultPassword = "";

	public ManagerForm(String port, String defaultPassword) {
		managerUrl = managerUrl + port;
		this.defaultPassword = defaultPassword;
		initUI();
	}

	private void initUI() {
		setTitle("ProfitTrailer Manager");
		setSize(350, 150);

		lblUrl.setForeground(Color.BLUE.darker());
		lblUrl.setCursor(new Cursor(Cursor.HAND_CURSOR));

		setContentPane(mainPanel);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		lblUrlSetupListener();
		btnQuitSetupListener();

		fldPassword.setVisible(false);
		fldPassword.setBorder(null);
		if (StringUtils.isNotBlank(defaultPassword)) {
			fldPassword.setText(defaultPassword);
			fldPassword.setVisible(true);
		}
	}

	private void lblUrlSetupListener() {
		lblUrl.setText(managerUrl);
		lblUrl.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Desktop.getDesktop().browse(new URI(managerUrl));
				} catch (IOException | URISyntaxException e1) {
					log.error(e1);
				}
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblUrl.setText(managerUrl);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				lblUrl.setText("<html><a href=''>" + managerUrl + "</a></html>");
			}

		});
	}

	private void btnQuitSetupListener() {
		btnQuit.addActionListener(e -> System.exit(0));
	}

	{
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
		$$$setupUI$$$();
	}

	/**
	 * Method generated by IntelliJ IDEA GUI Designer
	 * >>> IMPORTANT!! <<<
	 * DO NOT edit this method OR call it in your code!
	 *
	 * @noinspection ALL
	 */
	private void $$$setupUI$$$() {
		mainPanel = new JPanel();
		mainPanel.setLayout(new GridBagLayout());
		final JLabel label1 = new JLabel();
		label1.setText("Welcome to ProfitTrailer Manager ");
		GridBagConstraints gbc;
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 2;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.insets = new Insets(0, 10, 0, 0);
		mainPanel.add(label1, gbc);
		lblUrl = new JLabel();
		lblUrl.setForeground(new Color(-15058245));
		lblUrl.setText("http://localhost:10000");
		gbc = new GridBagConstraints();
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.weighty = 1.0;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.insets = new Insets(0, 0, 0, 10);
		mainPanel.add(lblUrl, gbc);
		final JLabel label2 = new JLabel();
		label2.setText("");
		gbc = new GridBagConstraints();
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.weighty = 1.0;
		gbc.anchor = GridBagConstraints.WEST;
		mainPanel.add(label2, gbc);
		btnQuit = new JButton();
		btnQuit.setText("Quit");
		gbc = new GridBagConstraints();
		gbc.gridx = 1;
		gbc.gridy = 3;
		gbc.weighty = 1.0;
		gbc.anchor = GridBagConstraints.EAST;
		gbc.insets = new Insets(0, 0, 0, 10);
		mainPanel.add(btnQuit, gbc);
		final JLabel label3 = new JLabel();
		label3.setText("Your manager is running at:");
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.insets = new Insets(0, 10, 0, 0);
		mainPanel.add(label3, gbc);
		fldPassword = new JTextField();
		fldPassword.setEditable(false);
		fldPassword.setEnabled(true);
		Font fldPasswordFont = this.$$$getFont$$$(null, -1, -1, fldPassword.getFont());
		if (fldPasswordFont != null) {
			fldPassword.setFont(fldPasswordFont);
		}
		fldPassword.setForeground(new Color(-16382458));
		fldPassword.setToolTipText("Default Password");
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(0, 10, 0, 0);
		mainPanel.add(fldPassword, gbc);
	}

	/**
	 * @noinspection ALL
	 */
	private Font $$$getFont$$$(String fontName, int style, int size, Font currentFont) {
		if (currentFont == null) {
			return null;
		}
		String resultName;
		if (fontName == null) {
			resultName = currentFont.getName();
		} else {
			Font testFont = new Font(fontName, Font.PLAIN, 10);
			if (testFont.canDisplay('a') && testFont.canDisplay('1')) {
				resultName = fontName;
			} else {
				resultName = currentFont.getName();
			}
		}
		return new Font(resultName, style >= 0 ? style : currentFont.getStyle(), size >= 0 ? size : currentFont.getSize());
	}

	/**
	 * @noinspection ALL
	 */
	public JComponent $$$getRootComponent$$$() {
		return mainPanel;
	}

}
