package rcia;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.ChangeListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.BadLocationException;
import javax.swing.text.JTextComponent;

import main.MainFrame;

import org.jdesktop.swingx.JXTable;
import org.jdesktop.swingx.decorator.ColorHighlighter;
import org.jdesktop.swingx.decorator.ComponentAdapter;
import org.jdesktop.swingx.decorator.HighlightPredicate;
import org.jdesktop.swingx.decorator.Highlighter;
import org.jdesktop.swingx.decorator.PatternPredicate;

public class RciaAdminPanel extends JPanel {

	/**
	 *
	 */
	private static final long serialVersionUID = 1233345764207263629L;
	private final MainFrame mainGui;
//	private final JPanel searchResultPanel;
	private JXTable resultTable;
	private RciaAdminTableModel adminModel;

	public RciaAdminPanel(MainFrame mainGui) {
		this.mainGui = mainGui;
		
		JPanel btnPanel = new JPanel(new GridLayout(1,2));
		JButton btnSave = new JButton("Save Changes");
		JButton btnCancel = new JButton("Cancel Edit");
		
		btnSave.addActionListener(new SaveActionListener());
		btnCancel.addActionListener(new CloseActionListener());
		btnPanel.add(btnSave);
		btnPanel.add(btnCancel);
		
//		searchResultPanel = new JPanel(new BorderLayout());
		adminModel = new RciaAdminTableModel(RciaAdminTableModel.columnNames, 0);
		resultTable = new JXTable(adminModel);
		resultTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
		setBorder(BorderFactory.createTitledBorder("Rcia Admin"));
		setLayout(new BorderLayout());
		add(btnPanel, BorderLayout.NORTH);
		add(new JScrollPane(resultTable),BorderLayout.CENTER);
//		mainGui.setPanel(searchResultPanel);
		
		adminModel.addTableModelListener(new AdminTableModelListener());

	}

	public void displayAll() {
		mainGui.setPanel(this);

	}
	public void displayAll(ArrayList<RciaData> retrieveRciaData) {
		for(RciaData data: retrieveRciaData)
		{
			adminModel.addRow(new RciaAdminFieldData(data).getObjArray());
		}
		resultTable.packAll();
		displayAll();

	}
	
	private class SaveActionListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("Saving Changes");
			
		}
		
	}
	
	private class CloseActionListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			setVisible(false);
			
		}
		
	}
	
	private class AdminTableModelListener implements TableModelListener
	{

		@Override
		public void tableChanged(TableModelEvent e) {
			switch(e.getType())
			{
			case TableModelEvent.UPDATE:
				int row =  resultTable.getSelectedRow();

//				DefaultTableModel model = (DefaultTableModel) e.getSource();
				System.out.println("Selected Row = " + row);
//				PatternPredicate pattern = new PatternPredicate("ˆM", 1);
//				resultTable.addHighlighter(new ColorHighlighter(pattern, null, Color.RED)); 
				break;
			}
			
		}
		
	}

}
