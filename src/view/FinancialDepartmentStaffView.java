package view;
//This class is the UI design for Financial Department Staff

import Model.ClaimForm;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class FinancialDepartmentStaffView extends JFrame {
    private JLabel timeLabel;

    public FinancialDepartmentStaffView() {
        int UNIT = 20;
        this.setSize(40 * UNIT, 30 * UNIT);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setTitle("< PTT System > Financial Department Staff");
        this.setLayout(new BorderLayout());

        final JTabbedPane tabbedPane = new JTabbedPane();

        Font font = new Font("TimesRoman", Font.PLAIN, 20);
        timeLabel = new JLabel();
        this.setTimer(timeLabel);

        JPanel eastPanel = new JPanel(new FlowLayout());
        JPanel centerPanel = new JPanel(new BorderLayout());

        Border blackline = BorderFactory.createLineBorder(Color.gray, 2);
        eastPanel.setBorder(blackline);
        centerPanel.setBorder(blackline);

        JPanel topBoard = new JPanel(new FlowLayout());
        JPanel leftBorder1 = new JPanel();
        JPanel leftBorder2 = new JPanel();
        JPanel leftBorder3 = new JPanel();
        JPanel leftBorder4 = new JPanel();
        JPanel rightBorder1 = new JPanel();
        JPanel rightBorder2 = new JPanel();
        JPanel leftCenter = new JPanel(new BorderLayout());
        JPanel rightCenter = new JPanel(new GridLayout(0, 1));

        leftBorder1.setPreferredSize(new Dimension(0, UNIT));
        leftBorder2.setPreferredSize(new Dimension(0, UNIT));
        leftBorder3.setPreferredSize(new Dimension(UNIT, 0));
        leftBorder4.setPreferredSize(new Dimension(UNIT, 0));
        rightBorder1.setPreferredSize(new Dimension(UNIT, 0));
        rightBorder2.setPreferredSize(new Dimension(UNIT, 0));

        centerPanel.add(leftBorder1, BorderLayout.NORTH);
        centerPanel.add(leftBorder2, BorderLayout.SOUTH);
        centerPanel.add(leftBorder3, BorderLayout.WEST);
        centerPanel.add(leftBorder4, BorderLayout.EAST);
        centerPanel.add(leftCenter, BorderLayout.CENTER);
        eastPanel.add(rightBorder1, BorderLayout.WEST);
        eastPanel.add(rightBorder2, BorderLayout.EAST);
        eastPanel.add(rightCenter, BorderLayout.CENTER);
        leftCenter.add(topBoard, BorderLayout.NORTH);

        JPanel TopInstruction = new JPanel(new FlowLayout());
        JLabel instruction = new JLabel("Hello Staff! Today is: ");
        instruction.setFont(font);

        TopInstruction.add(instruction);

        JPanel claimFormPanel = new JPanel(new BorderLayout());
        Object[] columnNames = {"ID", "Title", "Content", "Cost", "Date"};

        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
        ClaimForm claimForm = new ClaimForm();
        for (Object item : claimForm.getList(new HashMap<>())) {
            ClaimForm claimFromItem = (ClaimForm) item;
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            Object[] objs = new Object[]{claimFromItem.getID(), claimFromItem.getTitle(),
                    claimFromItem.getContent(), claimFromItem.getCost(), claimFromItem.getSubmitTime().format(formatter)};
            tableModel.addRow(objs);
        }

        JTable table = new JTable(tableModel);
        claimFormPanel.add(table.getTableHeader(), BorderLayout.NORTH);
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportView(table);
        claimFormPanel.add(scrollPane, BorderLayout.CENTER);

        tabbedPane.addTab("Claims Form", claimFormPanel);

        topBoard.add(instruction);
        topBoard.add(timeLabel);
        leftCenter.add(tabbedPane);

        this.add(centerPanel, BorderLayout.CENTER);

        this.setVisible(true);

    }

    private void setTimer(JLabel time) {
        timeLabel = time;
        timeLabel.setFont(new Font("TimesRoman", Font.BOLD, 20));
        timeLabel.setForeground(new Color(30, 144, 255));
        //	private JButton button1, button2;
        Timer tmr = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                long timemillis = System.currentTimeMillis();
                SimpleDateFormat df = new SimpleDateFormat(" dd/MM/yyyy  HH:mm:ss");
                timeLabel.setText(df.format(new Date(timemillis)));

            }
        });
        tmr.start();
    }
}
