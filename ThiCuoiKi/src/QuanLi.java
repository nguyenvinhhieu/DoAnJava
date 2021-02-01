import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.RowSorterEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Date;
import java.util.List;
import java.util.Vector;
import java.awt.Color;
import java.awt.Component;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;

import com.sun.source.doctree.SerialTree;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.PrintStream;
import java.awt.event.ActionEvent;

@SuppressWarnings({ "serial", "unused" })
public class QuanLi extends JFrame {

	private JPanel contentPane;
	public static JTextField textFieldHang;
	private static JTable table;
	@SuppressWarnings("rawtypes")
	Vector Vtieude = new Vector();
	@SuppressWarnings("rawtypes")
	Vector Vndung = new Vector();
	@SuppressWarnings("rawtypes")
	Vector Vdong;

	DefaultTableModel dtm = new DefaultTableModel();
	Nhap nhap = null;

	void Tieude() {
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			public void run() {
				try {
					QuanLi frame = new QuanLi();
					frame.setVisible(true);
					frame.showDanhsach("");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */

	public QuanLi() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 822, 435);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("QUẢN LÝ XUẤT NHẬP KHO HÀNG");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setBackground(Color.RED);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel.setBounds(122, 11, 561, 38);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabelHang = new JLabel("Hàng hóa");
		lblNewLabelHang.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblNewLabelHang.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabelHang.setBounds(25, 55, 106, 38);
		contentPane.add(lblNewLabelHang);

		textFieldHang = new JTextField();
		textFieldHang.setBounds(152, 60, 262, 28);
		contentPane.add(textFieldHang);
		textFieldHang.setColumns(10);

		JButton btnNewButtonSearch = new JButton("Search");
		btnNewButtonSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tenhanghoanew1 = textFieldHang.getText();
				QuanLi.showDanhsach(tenhanghoanew1);
			}
		});

		btnNewButtonSearch.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnNewButtonSearch.setBounds(442, 60, 106, 28);
		contentPane.add(btnNewButtonSearch);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 126, 749, 216);
		contentPane.add(scrollPane);

		table = new JTable();
		table.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		table.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null, null, null, null, null }, },
				new String[] { "ID", "Tên hàng hóa", "Chủ hàng", "Ngày", "Người nhập", "Trạng thái", "Sửa", "Xuất" }));
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {

				int hangthu = table.getSelectedRow();
				int cotthu = table.getSelectedColumn();
				
				//Xuất
				if(cotthu==7) {
					String idChu = table.getModel().getValueAt(hangthu, 0).toString();
					int id = Integer.parseInt(idChu);
					System.out.println("ID la"+id);
					DataBaseUtil.xoaHangHoa(id);
					QuanLi.showDanhsach(QuanLi.textFieldHang.getText());
				}
				//Sửa
				else if(cotthu == 6) {
					String idChu = table.getModel().getValueAt(hangthu, 0).toString();
					int id = Integer.parseInt(idChu);
					String tenhanghoa = table.getModel().getValueAt(hangthu, 1).toString();
					String chusohuu = table.getModel().getValueAt(hangthu, 2).toString();
					String nguoinhap = table.getModel().getValueAt(hangthu, 4).toString();
					nhap = new Nhap(id, tenhanghoa, chusohuu, nguoinhap);
					nhap.setVisible(true);
					nhap.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				}
			
			}
		});
		scrollPane.setViewportView(table);

		JButton button = new JButton("New button");
		scrollPane.setColumnHeaderView(button);

		JButton btnNewButton = new JButton("Nhập");
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnNewButton.setBounds(583, 60, 89, 28);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				nhap = new Nhap(0, null, null, null);
				nhap.setVisible(true);
				nhap.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			}

		});

		JButton btnNewButton_2 = new JButton("Thoát");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				;
			}
		});
		btnNewButton_2.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnNewButton_2.setBounds(695, 364, 89, 23);
		contentPane.add(btnNewButton_2);
	}

	protected void updateTable() {
		// TODO Auto-generated method stub

	}

	protected static void setText(Object object) {
		// TODO Auto-generated method stub

	}
	
	public static void showDanhsach(String tenHangHoa) {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);

		List<HangHoa> dshanghoa = DataBaseUtil.getDanhSachHangHoa(tenHangHoa);
		int stt = 0;
		for (HangHoa hang : dshanghoa) {
			stt++;
			Object[] o = new Object[8];
			o[0] = hang.getID();
			o[1] = hang.getTenHangHoa();
			o[2] = hang.getChuSoHuu();
			o[3] = hang.getNgayNhapKho();
			o[4] = hang.getNguoiNhap();
			if (hang.getDaXuat() == 1) {
				o[5] = "Đã xuất";
			} else {
				o[5] = "Chưa xuất";
			}
			o[6] = "Sửa";
			o[7] = "Xuất";
			model.addRow(o);
		}
	}
}
