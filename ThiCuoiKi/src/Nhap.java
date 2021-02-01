import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.Vector;

import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Nhap extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	

	/**
	 * Create the frame.
	 */
	public Nhap(int id, String tenhanghoa, String chusohuu, String nguoinhap) {
		JFrame _this = this;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 528, 357);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("NHẬP");
		lblNewLabel.setBounds(95, 11, 282, 41);
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		contentPane.add(lblNewLabel);
		
		
		JLabel lblNewLabel_1 = new JLabel("Tên hàng hóa");
		lblNewLabel_1.setBounds(10, 66, 90, 33);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Chủ hàng hóa");
		lblNewLabel_1_1.setBounds(10, 109, 90, 33);
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Người nhập");
		lblNewLabel_1_2.setBounds(10, 153, 90, 33);
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		contentPane.add(lblNewLabel_1_2);
		
		textField = new JTextField();
		textField.setBounds(131, 72, 306, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		textField.setText(id==0 ? "" : tenhanghoa);
		
		textField_1 = new JTextField();
		textField_1.setBounds(131, 115, 306, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		textField_1.setText(id==0 ? "" : chusohuu);
		
		textField_2 = new JTextField();
		textField_2.setBounds(131, 159, 306, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		textField_2.setText(id==0 ? "" : nguoinhap);
		
		JButton btnNewButton_1 = new JButton( id==0 ? "Thêm" : "Cập nhật");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tenhanghoanew = textField.getText();
				String chusohuunew = textField_1.getText();
				String nguoinhapnew = textField_2.getText();
				if(id==0) {
					DataBaseUtil.themHangHoa(tenhanghoanew, chusohuunew, nguoinhapnew);
				}else {
					DataBaseUtil.capNhapHangHoa(id, tenhanghoanew, chusohuunew, nguoinhapnew);
				}
				
				_this.setVisible(false);
				QuanLi.showDanhsach(QuanLi.textFieldHang.getText());
			}	
		});
		btnNewButton_1.setBounds(204, 216, 89, 23);
		btnNewButton_1.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		contentPane.add(btnNewButton_1);
	}
}
