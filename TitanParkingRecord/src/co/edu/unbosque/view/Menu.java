package co.edu.unbosque.view;

import java.awt.Font;
import java.awt.Image;

import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;

public class Menu extends JPanel {

	private JLabel background;
	private JPanel p1;
	private JList<String> list;
	private DefaultListModel<String> model;
	private DefaultListCellRenderer dlr;
	private JPopupMenu popUp;
	private JMenuItem delete, show;
	private JScrollPane scroll;
	private JButton addBtn;

	public Menu() {

		setBounds(0, 0, 800, 600);
		setLayout(null);

		background = new JLabel();
		background.setBounds(0, 0, 785, 565);
		ImageIcon background2 = new ImageIcon("src/Assets/background.jpg");
		background.setIcon(new ImageIcon(background2.getImage().getScaledInstance(785, 580, Image.SCALE_SMOOTH)));

		p1 = new JPanel();
		p1.setBounds(0, 0, 800, 600);
		p1.setLayout(null);

		list = new JList<>();
		list.setBounds(400 - (450 / 2), 172, 450, 280);
		list.setFont(new Font(null, Font.ITALIC, 22));
		model = new DefaultListModel<>();
		dlr = (DefaultListCellRenderer)list.getCellRenderer();
		dlr.setHorizontalAlignment(SwingConstants.CENTER);
		
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setModel(model);

		scroll = new JScrollPane(list);
		scroll.setBounds(400 - (500 / 2), 300 - (360 / 2) + 10, 500, 340);
		scroll.setOpaque(false);

		delete = new JMenuItem("Delete this vehicle");
		show = new JMenuItem("Show this vehicle");

		popUp = new JPopupMenu();
		popUp.add(delete);
		popUp.add(show);

		addBtn = new JButton();
		addBtn.setBounds(400 - (120 / 2) - 10, 480, 120, 60);
		ImageIcon addbt = new ImageIcon("src/Assets/addbutton.png");
		addBtn.setIcon(new ImageIcon(addbt.getImage().getScaledInstance(120, 60, Image.SCALE_SMOOTH)));
		addBtn.setOpaque(false);
		addBtn.setBorderPainted(false);
		addBtn.setContentAreaFilled(false);
		addBtn.setFocusPainted(false);

		add(addBtn);
		add(scroll);
		add(popUp);
		p1.add(background);
		add(p1);
		setVisible(true);
	}

	public void setBackground(JLabel background) {
		this.background = background;
	}

	public JPanel getP1() {
		return p1;
	}

	public void setP1(JPanel p1) {
		this.p1 = p1;
	}

	public JList<String> getList() {
		return list;
	}

	public void setList(JList<String> list) {
		this.list = list;
	}

	public DefaultListModel<String> getModel() {
		return model;
	}

	public void setModel(DefaultListModel<String> model) {
		this.model = model;
	}

	public JPopupMenu getPopUp() {
		return popUp;
	}

	public void setPopUp(JPopupMenu popUp) {
		this.popUp = popUp;
	}

	public JMenuItem getDelete() {
		return delete;
	}

	public void setDelete(JMenuItem delete) {
		this.delete = delete;
	}

	public JMenuItem getShow() {
		return show;
	}

	public void setShow(JMenuItem show) {
		this.show = show;
	}

	public JScrollPane getScroll() {
		return scroll;
	}

	public void setScroll(JScrollPane scroll) {
		this.scroll = scroll;
	}

	public JButton getAddBtn() {
		return addBtn;
	}

	public void setAddBtn(JButton addBtn) {
		this.addBtn = addBtn;
	}

}
