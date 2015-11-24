package rcia.admin;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.regex.Matcher;
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

import rcia.RciaData;
import database.DatabaseStore;
import database.DbWorker;
import database.QueryType;

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
		//		JButton btnSave = new JButton("Save Changes");
		//		JButton btnCancel = new JButton("Cancel Edit");
		JButton btnFind = new JButton("Search");

		//		btnSave.addActionListener(new SaveActionListener());
		//		btnCancel.addActionListener(new CloseActionListener());
		btnFind.addActionListener(new FindActionListener());
		//		btnPanel.add(btnSave);
		//		btnPanel.add(btnCancel);
		btnPanel.add(btnFind);

		//		searchResultPanel = new JPanel(new BorderLayout());
		adminModel = new RciaAdminTableModel(RciaAdminTableModel.columnNames, 0);
		resultTable = new JXTable(adminModel);
		resultTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

		setBorder(BorderFactory.createTitledBorder("Rcia Admin"));
		setLayout(new BorderLayout());
		add(btnPanel, BorderLayout.NORTH);
		add(new JScrollPane(resultTable),BorderLayout.CENTER);

		try {
			DbWorker dbWorker = new DbWorker(DatabaseStore.getAddress(), DatabaseStore.getPort(),
					DatabaseStore.getUserName(), DatabaseStore.getPassword());
			displayData(dbWorker.retrieveRciaData("", ""));
			dbWorker.dbClose();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//		mainGui.setPanel(searchResultPanel);

		//		adminModel.addTableModelListener(new AdminTableModelListener());

	}

	public void displayAll() {
		mainGui.setPanel(this);

	}
	public void displayData(ArrayList<RciaData> retrieveRciaData) {
		adminModel.clearRows();
		for(RciaData data: retrieveRciaData)
		{
			adminModel.addRow(data.getArray());
		}
		resultTable.packAll();
		displayAll();

	}

	private class SaveActionListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("Saving Changes");
			ArrayList<RciaData> dataArray = new ArrayList<RciaData>();

			for(int i = 0; i < resultTable.getRowCount(); i++)
			{
				ArrayList<String> stringArray = new ArrayList<String>();
				String str = (String) resultTable.getValueAt(i, 0);
				if(!str.isEmpty())
				{

					for(int j = 1; j <  resultTable.getColumnCount(); j++)
					{
						System.out.println("Column = " + (resultTable.getColumnCount() - j));
						String result = (String) resultTable.getValueAt(i, j);
						stringArray.add(result);
						System.out.println(result);
					}

				}
				dataArray.add(new RciaData(stringArray));

			}

			for(RciaData data: dataArray)
			{
				System.out.println(data.toString());
			}

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

	//	private class AdminTableModelListener implements TableModelListener
	//	{
	//
	//		@Override
	//		public void tableChanged(TableModelEvent e) {
	//			int row =  resultTable.getSelectedRow();
	//			//			int col = resultTable.getSelectedColumn();
	//
	//			resultTable.clearSelection();
	//			if(row == -1)
	//			{
	//				return;
	//			}
	//
	//			switch(e.getType())
	//			{
	//			case TableModelEvent.UPDATE:
	//				//				int row =  resultTable.getSelectedRow();
	//				//				int col = resultTable.getSelectedColumn();
	//
	//				//				System.out.println("The Value = "+ resultTable.getValueAt(row, col) + " at row = " + row + " col = "+ col);
	//				//				resultTable.
	//				//				System.out.println("Selected Row = " + row);
	//
	//				//				System.out.println(resultTable.getValueAt(row, 0));
	//				if(row != -1)
	//				{
	//					//					resultTable.getColumnExt(0).setEditable(true);
	//					resultTable.setValueAt("\u2713", row, 0);
	//					//					resultTable.getColumnExt(0).setEditable(false);
	//				}
	//
	//
	//				//				RowColorRenderer rowRenderer = new RowColorRenderer(0, row);
	//				//				TableColumn column = resultTable.getColumnModel().getColumn(0);
	//				//				column.setCellRenderer(rowRenderer);
	//
	//
	//
	//				break;
	//			}
	//
	//		}
	//
	//	}
	//
	//	private class RowColorRenderer extends DefaultTableCellRenderer {
	//
	//		private static final long serialVersionUID = 1L;
	//		private int colNo = 0;
	//		private int row;
	//
	//		RowColorRenderer(int col, int row) {
	//			colNo = col;
	//			this.row = row;
	//		}
	//
	//		@Override
	//		public Component getTableCellRendererComponent(JTable table, Object value,
	//				boolean isSelected, boolean hasFocus, int row, int column) {
	//			Component comp = super.getTableCellRendererComponent(table, value,
	//					isSelected, hasFocus, this.row, column);
	//			JComponent jc = (JComponent) comp;
	//
	//			//		    String txt="true";
	//			//
	//			//		    String re1="((?:[a-z][a-z]+))";	// Word 1
	//			//
	//			//		    Pattern p = Pattern.compile(re1,Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
	//			//		    Matcher m = p.matcher(txt);
	//			//		    if (m.find())
	//			//		    {
	//			//		        String word1=m.group(1);
	//			//		        System.out.print("("+word1.toString()+")"+"\n");
	//			//		    }
	//
	//			if (table.getValueAt(this.row, colNo) != null) {
	//				String str = table.getValueAt(this.row, colNo).toString();
	//				//				System.out.println("Result =" + str);
	//				if(!str.isEmpty())
	//				{
	//					System.out.println("Result at " + row + " " + column);
	//				}
	//				//					if(str.equalsIgnoreCase("true"))
	//				//					{
	//				//					System.out.println("Yes");
	//				//					}
	//				//					String txt = str;
	//				//				    String re1=".*?";	// Non-greedy match on filler
	//				//				    String re2="[a-z]";	// Uninteresting: w
	//				//				    String re3=".*?";	// Non-greedy match on filler
	//				//				    String re4="[a-z]";	// Uninteresting: w
	//				//				    String re5=".*?";	// Non-greedy match on filler
	//				//				    String re6="[a-z]";	// Uninteresting: w
	//				//				    String re7="([a-z])";	// Any Single Word Character (Not Whitespace) 1
	//				//
	//				//				    Pattern p = Pattern.compile(re1+re2+re3+re4+re5+re6+re7,Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
	//				//				    Matcher m = p.matcher(txt);
	//				//				    if (m.find())
	//				//				    {
	//				//				        String w1=m.group(1);
	//				//				        System.out.print("("+w1.toString()+")"+"\n");
	//				//				    }
	//				//					if(Pattern.compile("\\w").matcher(str).find())
	//				//					{
	//				//						if(Pattern.compile("true").matcher(str).find())
	//				//						{
	//				//							jc.setForeground(Color.magenta);
	//				//							jc.setBackground(Color.orange);
	//				//						}
	//				//					}
	//				//				}
	//			}
	//
	//
	//			//	            if (!isSelected) {
	//			//	                if (table.getValueAt(row, colNo) != null) {
	//			//	                    String str = table.getValueAt(row, colNo).toString();
	//			//	                    if (!str.isEmpty()) {
	//			//	                        if (Pattern.compile("\\d").matcher(str).find()) {
	//			//	                            if (((Pattern.compile("[02468]").matcher(str).find()))
	//			//	                                    && (!(Pattern.compile("true").matcher(str).find()))) {
	//			//	                                setForeground(Color.magenta);
	//			//	                                setBackground(Color.orange);
	//			//	                            } else if ((!(Pattern.compile("[02468]").matcher(str).find()))
	//			//	                                    && ((Pattern.compile("[13579]").matcher(str).find()))) {
	//			//	                                setForeground(Color.blue);
	//			//	                                setBackground(Color.yellow);
	//			//	                            } else if (((Pattern.compile("[02468]").matcher(str).find()))
	//			//	                                    && ((Pattern.compile("[13579]").matcher(str).find()))) {
	//			//	                                setForeground(Color.red);
	//			//	                                setBackground(Color.cyan);
	//			//	                            }
	//			//	                            setFont(new Font("Serif", Font.BOLD, 12));
	//			//	                            setHorizontalAlignment(CENTER);
	//			//	                        } else {
	//			//	                            setBackground(table.getBackground());
	//			//	                            setForeground(table.getForeground());
	//			//	                            setFont(new Font("Serif", Font.PLAIN, 8));
	//			//	                            setHorizontalAlignment(CENTER);
	//			//	                        }
	//			//	                    }
	//			//	                }
	//			//	            }
	//			return this;
	//		}
	//	}



}
