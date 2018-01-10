package edu.ntou.cse.softwareengineering.ees;

import java.awt.*;
//import java.awt.FlowLayout;
//import java.awt.BorderLayout;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Vector;
import java.awt.event.ItemEvent;
import java.awt.Font;
import javax.swing.*;
/*
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
*/
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.Desktop;
import java.net.URI;
import java.net.URISyntaxException;

import org.jfree.chart.*;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.axis.CategoryAxis;  
import org.jfree.chart.axis.NumberAxis;  
import org.jfree.chart.plot.*;  
import org.jfree.chart.renderer.category.BarRenderer; 
 
import org.jfree.data.*;  
import org.jfree.data.category.*;


public class EESMonitor extends JFrame
{
	private static final String[] abilityKind = 
	{"�п��", "����i��", "�n�J�H��", "��Ʈw�i��", "��Ʈw�u��"};
	private final JPanel displayInfoPanel;
	private final JPanel abilityPanel;
	private final JLabel displayLabel;
	private final JComboBox<String> abilityBox;
	//private final JButton returnPanelButton;
	public EESMonitor()
	{
		super("EES Monitor");
		setLayout(new BorderLayout());
		
		displayInfoPanel = new JPanel();
		displayInfoPanel.setLayout(new BorderLayout());
		abilityPanel = new JPanel();
		displayLabel = new JLabel("�п�ܱ���ܤ���T", SwingConstants.CENTER);
		abilityBox = new JComboBox<String>(abilityKind);
		//returnPanelButton = new JButton("��^�W�@��");
		/*...*/
		abilityBox.setMaximumRowCount(5);
		abilityBox.addItemListener
		(new ItemListener()
		{
			@Override
			public void itemStateChanged(ItemEvent event)
			{
				//choose someone
				if(event.getStateChange() == ItemEvent.SELECTED)
				{
					if(abilityBox.getSelectedItem() == abilityKind[0])
						return;
					displayInfoPanel.removeAll();
					JPanel tempPanel = new JPanel();
					if(abilityBox.getSelectedItem() == abilityKind[1])	//����i��
					{
						
						
						/*test*/
						/*
						String[] attribute = {"ExhibitionID", "ExhibitionName", "StartDate", 
								"EndDate", "ExhibitionLocation", "ExhibitionMoreInformation", 
								"ExhibitionHostID"};
						String[][] rowData = 
						{
							{"9487", "FF31", "2/10", "2/11", "���", "exhibition1 info", "9488", "100"},
							{"6666", "���e�P", "X/XX", "X/XX", "���j", "exhibition2 info", "8787", "200"}
						};
						*/
						Vector<String> attribute = new Vector<String>();
						attribute.addElement("ExhibitionID");
						attribute.addElement("ExhibitionName");
						attribute.addElement("StartDate");
						attribute.addElement("EndDate");
						attribute.addElement("ExhibitionLocation");
						attribute.addElement("ExhibitionMoreInformation");
						Vector<Vector> rowData = new Vector<Vector>();
						/*get exhibition info*/
						URL u;
						try {
							u = new URL ("http://www.citytalk.tw/cata/1425/");
							
							ExhibitionCrawler e = new ExhibitionCrawler(u);
							
							ArrayList<Exhibition> ex = e.getData();
							
							for (Exhibition ee : ex)
							{
								/*String[] exInfo = {
										Integer.toString(ee.getExhibitionID()), 
										ee.getExhibitionName(), 
										ee.getStartDate().toString(),
										ee.getEndDate().toString(),
										ee.getExhibitionLocation(), 
										ee.getExhibitionMoreInformation(),
										Integer.toString(ee.getExhibitionHostID())
										};
								*/
								Vector<String> exInfo = new Vector<String>();
								exInfo.addElement(Integer.toString(ee.getExhibitionID()));
								exInfo.addElement(ee.getExhibitionName());
								exInfo.addElement(ee.getStartDate().toString());
								exInfo.addElement(ee.getEndDate().toString());
								exInfo.addElement(ee.getExhibitionLocation());
								exInfo.addElement(ee.getExhibitionMoreInformation());
								
								rowData.addElement(exInfo);
							}
							
							JTable table =new JTable(rowData,attribute);
							table.setPreferredScrollableViewportSize(new Dimension(400,300));
							displayInfoPanel.add(new JScrollPane(table), BorderLayout.CENTER);
							
						} catch (MalformedURLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						
						
					}
					/*else if(abilityBox.getSelectedItem() == abilityKind[2])	//�̦h�H�ϥΪ�tag
					{
						tempPanel.add(new JTextField("Tag	�ϥΦ���"));
						tempPanel.add(new JTextField("�~��	10000000"));
						tempPanel.add(new JTextField("�g�T	99999999"));
						displayInfoPanel.add(tempPanel, BorderLayout.CENTER);
					}*/
					else if(abilityBox.getSelectedItem() == abilityKind[2])	//�n�J�H��
					{
						CategoryDataset dataset = getDataset();
						JFreeChart chart = createChart(dataset);  
						ChartPanel chartPanel = new ChartPanel(chart); 
						displayInfoPanel.add(chartPanel, BorderLayout.CENTER);
					}
					/*else if(abilityBox.getSelectedItem() == abilityKind[3])	//�i���y�q
					{
						CategoryDataset dataset = getDataset();
						JFreeChart chart = createChart(dataset);  
						ChartPanel chartPanel = new ChartPanel(chart); 
						displayInfoPanel.add(chartPanel, BorderLayout.CENTER);
					}*/
					/*else if(abilityBox.getSelectedItem() == abilityKind[5])	//API�ϥα��p
					{
						tempPanel.add(new JTextField("API	�ϥΦ���"));
						tempPanel.add(new JTextField("???	66666666"));
						tempPanel.add(new JTextField("XXX	23333333"));
						displayInfoPanel.add(tempPanel, BorderLayout.CENTER);
					}*/
					else if(abilityBox.getSelectedItem() == abilityKind[3])	//��Ʈw�i��
					{
						displayExhibition();
					}
					else if(abilityBox.getSelectedItem() == abilityKind[4])	//��Ʈw�u��
					{
						Vector<String> attribute = new Vector<String>();
						attribute.addElement("boothId");
						attribute.addElement("boothHolderId");
						attribute.addElement("boothBelong2Exhibition");
						attribute.addElement("boothDisplayName");
						attribute.addElement("boothPopularity");
						attribute.addElement("boothPosition");
						Vector<Vector> rowData = new Vector<Vector>();
						/*get exhibition info*/
						URL u;
						try {
							u = new URL ("http://www.citytalk.tw/cata/1425/");
							
							MysqlConnect mysqlConnect = new MysqlConnect();
					        //MonitorBundle monitorBundle = mysqlConnect.getMonitor();
							
							BoothBundle b = mysqlConnect.getBooth();
						        
						    for(int i = 0;i<b.getBoothId().length;i++)
						    {
								Vector<String> exInfo = new Vector<String>();
								exInfo.addElement(b.getBoothId()[i]);
								exInfo.addElement(b.getHolderId()[i]);
								exInfo.addElement(b.getExhibitionId()[i]);
								exInfo.addElement(b.getName()[i]);
								exInfo.addElement(b.getPopularity()[i]);
								exInfo.addElement(b.getPosition()[i]);
								rowData.addElement(exInfo);
						    }
								

							JTable table =new JTable(rowData,attribute);
							table.setPreferredScrollableViewportSize(new Dimension(400,300));
							displayInfoPanel.add(new JScrollPane(table), BorderLayout.CENTER);
							
						} catch (MalformedURLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}
				revalidate();
			}
			private CategoryDataset getDataset()
					{
						DefaultCategoryDataset dataset = new DefaultCategoryDataset();
						String[] date = {"12/23", "12/24", "12/25", "12/26", "12/27"}; 
						String[] people = {"A", "B", "C"};
						double[][] data = {{800, 550, 102}, {420, 780, 230}, {350, 530, 680}  
						,{920, 145, 107}, {660, 830, 790}};  
						for(int i = 0;i<date.length;i++)
						{
							for(int j=0; j<people.length; j++)  
							dataset.addValue(data[i][j], people[j], date[i]);
						}
						return dataset;
					}
			private JFreeChart createChart(final CategoryDataset dataset) 
			{  
				JFreeChart chart = ChartFactory.createBarChart
				(
					"Line Chart", "�n�J�ɶ�", "�n�J����",
					getDataset(),
					PlotOrientation.VERTICAL,
					true,
					true,
					false
				);
				CategoryPlot categoryplot = (CategoryPlot) chart.getPlot();  
				CategoryAxis domainAxis = categoryplot.getDomainAxis();  
				NumberAxis numberaxis = (NumberAxis) categoryplot.getRangeAxis();  
				numberaxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());  
				BarRenderer barrenderer = (BarRenderer) categoryplot.getRenderer();  
				barrenderer.setBaseItemLabelFont(new Font("�з���", Font.PLAIN, 12));  
				barrenderer.setSeriesItemLabelFont(1, new Font("�з���", Font.PLAIN, 12));  

				/*------�]�mX�b�y�ФW����r-----------*/  
				domainAxis.setTickLabelFont(new Font("sans-serif", Font.PLAIN, 11));  
  
				/*------�]�mX�b�����D��r------------*/  
				domainAxis.setLabelFont(new Font("�з���", Font.PLAIN, 12));  
	
				/*------�]�mY�b�y�ФW����r-----------*/  
				numberaxis.setTickLabelFont(new Font("sans-serif", Font.PLAIN, 12));  
  
				/*------�]�mY�b�����D��r------------*/  
				numberaxis.setLabelFont(new Font("���^", Font.PLAIN, 12));  
				chart.getLegend().setItemFont(new Font("�з���", Font.PLAIN, 12));  
				chart.getTitle().setFont(new Font("���^", Font.BOLD, 14));  
				return chart;  
			}  
		}
		);
		
		abilityPanel.setLayout(new FlowLayout());
		
		add(displayInfoPanel, BorderLayout.CENTER);
		add(abilityPanel, BorderLayout.EAST);
		
		displayInfoPanel.add(displayLabel);
		abilityPanel.add(abilityBox);
		
		
	}
	private void displayExhibition()
	{
		Vector<String> attribute = new Vector<String>();
		attribute.addElement("ExhibitionID");
		attribute.addElement("ExhibitionName");
		attribute.addElement("StartDate");
		attribute.addElement("EndDate");
		attribute.addElement("ExhibitionLocation");
		attribute.addElement("exhibitionURL");
		Vector<Vector> rowData = new Vector<Vector>();
		/*get exhibition info*/
		URL u;
		try {
			u = new URL ("http://www.citytalk.tw/cata/1425/");
			
			MysqlConnect mysqlConnect = new MysqlConnect();
	        //MonitorBundle monitorBundle = mysqlConnect.getMonitor();
			
	        ExhibitionBundle e = mysqlConnect.getExhibition();
		        
		    for(int i = 0;i<e.getExhibitionId().length;i++)
		    {
				Vector<String> exInfo = new Vector<String>();
				exInfo.addElement(e.getExhibitionId()[i]);
				exInfo.addElement(e.getName()[i]);
				exInfo.addElement(e.getStartDate()[i]);
				exInfo.addElement(e.getEndDate()[i]);
				exInfo.addElement(e.getLocation()[i]);
				exInfo.addElement(e.getURL()[i]);
				rowData.addElement(exInfo);
		    }
				

			JTable table =new JTable(rowData,attribute);
			table.setPreferredScrollableViewportSize(new Dimension(400,300));
			
			table.setCellSelectionEnabled(true);
		    ListSelectionModel cellSelectionModel = table.getSelectionModel();
		    cellSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		    cellSelectionModel.addListSelectionListener(new ListSelectionListener() {
		      public void valueChanged(ListSelectionEvent e) {
		        String selectedData = null;

		        int[] selectedRow = table.getSelectedRows();
		        int[] selectedColumns = table.getSelectedColumns();
		        System.out.printf("%d %d%n", selectedRow[0], selectedColumns[0])	;
		        
		        	for (int i = 0; i < selectedRow.length; i++)
		        	for (int j = 0; j < selectedColumns.length; j++) 
		        	{
		        		selectedData = (String) table.getValueAt(selectedRow[i], selectedColumns[j]);
		        		if(selectedColumns[0] == 5)	//attribute is URL
				        {
		        		if (Desktop.isDesktopSupported()) {
		        		    try {
								Desktop.getDesktop().browse(new URI(selectedData));
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							} catch (URISyntaxException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
		        		}
				        }
		        	}
		        	System.out.println("Selected: " + selectedData);
		      }
		    });
		    JPanel insertPanel = new JPanel();
		    insertPanel.setLayout(new GridLayout(2, 7));
		    ArrayList<JLabel> labelList = new ArrayList<JLabel>();
		    ArrayList<JTextField> textList = new ArrayList<JTextField>();
		    labelList.add(new JLabel("�i���W��:"));
		    textList.add(new JTextField("��کڰ��j�i", 6));
			labelList.add(new JLabel("�}�l���:"));
			textList.add(new JTextField("2018-01-01", 6));
			labelList.add(new JLabel("�������:"));
			textList.add(new JTextField("2018-01-09", 6));
			labelList.add(new JLabel("�i����}:"));
			textList.add(new JTextField("�`�Ω�", 6));
			labelList.add(new JLabel("�i���y�z:"));
			textList.add(new JTextField("���x�̤j���ڰ��j�i�W�u��", 6));
			labelList.add(new JLabel("�i�����}:"));
			textList.add(new JTextField("http://87", 6));
			labelList.add(new JLabel("�s�W�i��"));
			JButton updateButton = new JButton("INSERT");
			updateButton.addMouseListener(new MouseAdapter()
			{
				@Override
				public void mouseClicked(MouseEvent e)
				{
					MysqlConnect mysqlConnect = new MysqlConnect();
					String name = textList.get(0).getText();
					String startDate = textList.get(1).getText();
					String endDate = textList.get(2).getText();
					String location = textList.get(3).getText();
					String description = textList.get(4).getText();
					String exhibitionURL = textList.get(5).getText();
					
					mysqlConnect.insertExhibition(name, startDate, endDate,
							location, description, exhibitionURL);
					
					displayExhibition();
					revalidate();
				}
			});
		    
			/*for(int i = 0;i<labelList.size();i++)
			{
				insertPanel.add(labelList.get(i));
				insertPanel.add(textList.get(i));
			}*/
			for(JLabel label:labelList)
				insertPanel.add(label);
			for(JTextField text:textList)
				insertPanel.add(text);
			insertPanel.add(updateButton);
			
			displayInfoPanel.add(insertPanel, BorderLayout.SOUTH);
			displayInfoPanel.add(new JScrollPane(table), BorderLayout.CENTER);
			
		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}