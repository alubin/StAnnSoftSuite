package main;

import java.awt.CardLayout;

import javax.swing.JPanel;

public class MainDisplayPanel extends JPanel{

	/**
	 *
	 */
	private static final long serialVersionUID = -4477750223126275191L;
	private static JPanel  bodyPanel = new JPanel(new CardLayout());

	public MainDisplayPanel() {
		setLayout(new CardLayout());
		add(bodyPanel);
	}

	public static void setPanel(JPanel body)
	{
		bodyPanel = body;
	}

	public static JPanel getPanel()
	{
		return bodyPanel;
	}

}
