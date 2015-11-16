package rcia;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.regex.Pattern;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

import main.MainFrame;

import org.apache.xmlbeans.impl.xb.xmlconfig.NamespaceList.Member2.Item;
import org.jdesktop.swingx.JXTable;
import org.jdesktop.swingx.decorator.ColorHighlighter;
import org.jdesktop.swingx.decorator.ComponentAdapter;
import org.jdesktop.swingx.decorator.HighlightPredicate;
import org.jdesktop.swingx.search.SearchFactory;

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

		JPanel btnPanel = new JPanel(new GridLayout(1,3));
		JButton btnSave = new JButton("Save Changes");
		JButton btnCancel = new JButton("Cancel Edit");
		JButton btnFind = new JButton("Search");

		btnSave.addActionListener(new SaveActionListener());
		btnCancel.addActionListener(new CloseActionListener());
		btnFind.addActionListener(new FindActionListener());
		btnPanel.add(btnSave);
		btnPanel.add(btnCancel);
		btnPanel.add(btnFind);

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
	public void displayData(ArrayList<RciaData> retrieveRciaData) {
		adminModel.clearRows();
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
	
	private class FindActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			SearchFactory mySearch = new SearchFactory();
			mySearch.showFindInput(resultTable, resultTable.getSearchable());

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
				int col = resultTable.getSelectedColumn();
				
				System.out.println("The Value = "+ resultTable.getValueAt(row, col) + " at row = " + row + " col = "+ col);
//				resultTable.
				System.out.println("Selected Row = " + row);
				
				MyCellRenderer mcr = new MyCellRenderer();
				resultTable.getColumnModel().getColumn(0).setCellRenderer(mcr);
		        
				break;
			}

		}

	}
	
	private class MyCellRenderer extends javax.swing.table.DefaultTableCellRenderer {
	    public java.awt.Component getTableCellRendererComponent(javax.swing.JTable table, java.lang.Object value, boolean isSelected, boolean hasFocus, int row, int column) {
	        java.awt.Component cellComponent = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
	        
	        if(!isSelected)
	        {
	        	cellComponent.setBackground(java.awt.Color.YELLOW);
	        }
	        else
	        {
	        	cellComponent.setBackground(resultTable.getBackground());
	        }
	        return cellComponent;
	    }
	}
	
	

}
