package awarwick2740ex3H;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.AbstractListModel;

import java.awt.Color;

import javax.swing.UIManager;
import javax.swing.border.EtchedBorder;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.DecimalFormat;

import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class RainfallMain extends JFrame {

	private JPanel contentPane;
	private JList rainfallList;
	private JLabel totalLabel;
	private JTextField updateTextField;
	private JLabel maxLabel;
	private JLabel averageLabel;
	private JLabel minLabel;
	private JButton btnUpdate;
	private JButton btnCalculate;
	private String [] strRainfall = {
			"1.2", "2.7", "2.2", "3.1", "2.9", "5.1",
			"3.2", "2.7", "3.6", "1.8", "2.2", "1.7"};

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RainfallMain frame = new RainfallMain();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public RainfallMain() {
		setTitle("Rainfall");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 409, 378);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMonthlyRainfall = new JLabel("Monthly rainfall");
		lblMonthlyRainfall.setBounds(10, 11, 86, 14);
		contentPane.add(lblMonthlyRainfall);
		
		JList monthList = new JList();
		monthList.setBackground(UIManager.getColor("Label.background"));
		monthList.setEnabled(false);
		monthList.setModel(new AbstractListModel() {
			String[] values = new String[] {"01 Jan", "02 Feb", "03 Mar", "04 Apr", "05 May", "06 Jun", "07 Jul", "08 Aug", "09 Sep", "10 Oct", "11 Nov", "12 Dec"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		monthList.setBounds(10, 36, 50, 199);
		contentPane.add(monthList);
		
		rainfallList = new JList(strRainfall);
		rainfallList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				do_rainfallList_valueChanged(e);
			}
		});
		rainfallList.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		rainfallList.setBounds(57, 36, 50, 199);
		contentPane.add(rainfallList);
		
		JLabel lblTotal = new JLabel("Total:");
		lblTotal.setBounds(147, 50, 46, 14);
		contentPane.add(lblTotal);
		
		JLabel lblAverage = new JLabel("Average:");
		lblAverage.setBounds(147, 88, 72, 14);
		contentPane.add(lblAverage);
		
		JLabel lblMaximum = new JLabel("Maximum:");
		lblMaximum.setBounds(147, 127, 72, 14);
		contentPane.add(lblMaximum);
		
		JLabel lblMinimum = new JLabel("Minimum:");
		lblMinimum.setBounds(147, 163, 60, 14);
		contentPane.add(lblMinimum);
		
		totalLabel = new JLabel("0.0\"");
		lblTotal.setLabelFor(totalLabel);
		totalLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		totalLabel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		totalLabel.setBounds(254, 50, 50, 24);
		contentPane.add(totalLabel);
		
		averageLabel = new JLabel("0.0\"");
		lblAverage.setLabelFor(averageLabel);
		averageLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		averageLabel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		averageLabel.setBounds(254, 88, 50, 24);
		contentPane.add(averageLabel);
		
		maxLabel = new JLabel("0.0\"");
		lblMaximum.setLabelFor(maxLabel);
		maxLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		maxLabel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		maxLabel.setBounds(254, 127, 50, 24);
		contentPane.add(maxLabel);
		
		minLabel = new JLabel("0.0\"");
		lblMinimum.setLabelFor(minLabel);
		minLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		minLabel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		minLabel.setBounds(254, 163, 50, 24);
		contentPane.add(minLabel);
		
		btnCalculate = new JButton("Calculate");
		btnCalculate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnCalculate_actionPerformed(e);
			}
		});
		btnCalculate.setBounds(231, 198, 89, 23);
		contentPane.add(btnCalculate);
		
		updateTextField = new JTextField();
		updateTextField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				do_updateTextField_focusGained(e);
			}
		});
		updateTextField.setBounds(57, 246, 50, 20);
		contentPane.add(updateTextField);
		updateTextField.setColumns(10);
		
		btnUpdate = new JButton("Update");
		btnUpdate.setEnabled(false);
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnUpdate_actionPerformed(e);
			}
		});
		btnUpdate.setBounds(32, 275, 80, 23);
		contentPane.add(btnUpdate);
	}
	protected void do_btnCalculate_actionPerformed(ActionEvent e) {
		RainFall rainfallData = new RainFall(strRainfall);
		DecimalFormat fmt = new DecimalFormat("0.0\"");
		totalLabel.setText(fmt.format(rainfallData.getTotal()));
		averageLabel.setText(fmt.format(rainfallData.getAverage()));
		maxLabel.setText(fmt.format(rainfallData.getHighest()));
		minLabel.setText(fmt.format(rainfallData.getLowest()));
	}
	protected void do_btnUpdate_actionPerformed(ActionEvent e) {
		int selectedIndex = rainfallList.getSelectedIndex();
		double r = Double.parseDouble(updateTextField.getText());
		strRainfall[selectedIndex] = Double.toString(r);
		rainfallList.repaint();
		updateTextField.setText("0.0");
		btnUpdate.setEnabled(false);
		totalLabel.setText("0.0\"");
		averageLabel.setText("0.0\"");
		minLabel.setText("0.0\"");
		maxLabel.setText("0.0\"");
		rainfallList.clearSelection();
		do_btnCalculate_actionPerformed(e);
	}
	protected void do_rainfallList_valueChanged(ListSelectionEvent e) {
		btnUpdate.setEnabled(true);
		updateTextField.setText((String) rainfallList.getSelectedValue());
		updateTextField.requestFocus();
		updateTextField.selectAll();
	}
	protected void do_updateTextField_focusGained(FocusEvent e) {
		updateTextField.selectAll();
	}
}
