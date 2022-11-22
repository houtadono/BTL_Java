package com.mycompany.myapp.ui;

import com.mycompany.myapp.dao.SinhVienDao;
import com.mycompany.myapp.helpers.MessageDialogHelper;
import com.mycompany.myapp.model.SinhVien;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Houta
 */
public class ManagerStudentPanel extends javax.swing.JPanel {

    private DefaultTableModel tableModel;
    private List<SinhVien> list;
    private String strTypeFind = "", strFind = "";
    private javax.swing.JRadioButton preRadio;
    private StudentInfor studentInfor = null;
    private int chooseSV = 0;
    private int pos = -1;

    /**
     * Creates new form PanelTest
     */
    public ManagerStudentPanel() {
        initComponents();
        initTable();
        loadDataTable();
    }

    private void initTable() {
        tableModel = new DefaultTableModel();

        tableModel.setColumnIdentifiers(new String[]{"Mã Sinh Viên", "Tên Sinh Viên",
            "Lớp", "Giới Tính", "Ngày Sinh", "Số ĐT", "Email", "Địa Chỉ", ""});
        tableSV.setModel(tableModel);
        list = new SinhVienDao().findAll("", "", "", true);
        preRadio = radioTang;
    }

    private void loadDataTable() {
        tableModel.setRowCount(0);
        for (SinhVien it : list) {
            tableModel.addRow(new Object[]{it.getMaSV(), it.getTenSV(), it.getLopSV(),
                it.getGioiTinh(), it.getNgaySinh(), it.getSoDienThoai(), it.getEmail(), it.getDiaChi()});
        }

        TableColumn buttonColumn = tableSV.getColumnModel().getColumn(8);
        buttonColumn.setCellRenderer(new ButtonRenderer());
        buttonColumn.setCellEditor(new ButtonEditor(new JCheckBox()));
        tableModel.fireTableDataChanged();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        radioSort = new javax.swing.ButtonGroup();
        comboBoxFind = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        buttonFind = new javax.swing.JButton();
        txtFind = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        radioTang = new javax.swing.JRadioButton();
        radioGiam = new javax.swing.JRadioButton();
        comboBoxSort = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableSV = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        buttonThem = new javax.swing.JButton();
        xuatExel = new javax.swing.JButton();
        nhapExel = new javax.swing.JButton();

        comboBoxFind.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mã sinh viên", "Họ và tên", "Lớp", "Giới tính", "Ngày sinh", "Địa Chỉ" }));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel1.setText("Tìm kiếm theo:");

        buttonFind.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/myapp/icons/find_user_profile_person_avatar_icon_196545.png"))); // NOI18N
        buttonFind.setText("Tìm");
        buttonFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonFindActionPerformed(evt);
            }
        });

        txtFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFindActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel2.setText("Sắp xếp theo:");

        radioSort.add(radioTang);
        radioTang.setText("Tăng");
        radioTang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioTangActionPerformed(evt);
            }
        });

        radioGiam.setSelected(false);
        radioSort.add(radioGiam);
        radioGiam.setText("Giảm");
        radioGiam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioGiamActionPerformed(evt);
            }
        });

        comboBoxSort.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mã sinh viên", "Tên", "Lớp", "Giới tính", "Ngày sinh" }));
        comboBoxSort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxSortActionPerformed(evt);
            }
        });

        tableSV.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tableSV);

        buttonThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/myapp/icons/add_user_profile_person_avatar_icon_196535.png"))); // NOI18N
        buttonThem.setText("Thêm sinh viên");
        buttonThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonThemActionPerformed(evt);
            }
        });

        xuatExel.setText("Xuất Exel");
        xuatExel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xuatExelActionPerformed(evt);
            }
        });

        nhapExel.setText("Nhập Exel");
        nhapExel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nhapExelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator1)
                .addContainerGap())
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 707, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(comboBoxSort, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(comboBoxFind, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtFind, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(radioTang)
                        .addGap(18, 18, 18)
                        .addComponent(radioGiam)))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(buttonThem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonFind, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(nhapExel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(xuatExel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(comboBoxFind, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFind, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonFind)
                    .addComponent(xuatExel, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(radioTang)
                    .addComponent(radioGiam)
                    .addComponent(comboBoxSort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonThem)
                    .addComponent(nhapExel, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 570, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buttonFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonFindActionPerformed
        // TODO add your handling code here:
        List<SinhVien> tmpList = new SinhVienDao().findAll((String) comboBoxFind.getSelectedItem(), txtFind.getText(), "", true);
        if (tmpList.isEmpty()) {
            StringBuilder notice = new StringBuilder("Không tìm thấy sinh viên có ");
            notice.append(comboBoxFind.getSelectedItem()).append(": ");
            notice.append(txtFind.getText());
            MessageDialogHelper.showErrorDialog(this, notice.toString(), "Thông báo!");
            return;
        }
        list = tmpList;
        loadDataTable();
        strTypeFind = (String) comboBoxFind.getSelectedItem();
        strFind = txtFind.getText();
        comboBoxSort.setSelectedIndex(0);
        radioTang.setSelected(true);
        preRadio = radioTang;
    }//GEN-LAST:event_buttonFindActionPerformed

    private void comboBoxSortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxSortActionPerformed
        // TODO add your handling code here:
        radioTang.setSelected(true);
        if (comboBoxSort.getSelectedItem().equals("Tên")) {
            Collections.sort(list);
        } else {
            list = new SinhVienDao().findAll(strTypeFind, strFind, (String) comboBoxSort.getSelectedItem(), true);
        }
        loadDataTable();
    }//GEN-LAST:event_comboBoxSortActionPerformed

    private void radioTangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioTangActionPerformed
        // TODO add your handling code here:
        if (preRadio == radioTang) {
            return;
        }
        if (comboBoxSort.getSelectedItem().equals("Tên")) {
            Collections.sort(list);
            if (radioGiam.isSelected()) {
                Collections.reverse(list);
            }
        } else {
            list = new SinhVienDao().findAll(strTypeFind, strFind, (String) comboBoxSort.getSelectedItem(), true);
        }
        loadDataTable();
        preRadio = radioTang;
        radioTang.setBackground(Color.YELLOW);
        radioTang.requestFocus();
    }//GEN-LAST:event_radioTangActionPerformed

    private void radioGiamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioGiamActionPerformed
        // TODO add your handling code here:
        if (preRadio == radioGiam) {
            return;
        }
        if (comboBoxSort.getSelectedItem().equals("Tên")) {
            Collections.reverse(list);
        } else {
            list = new SinhVienDao().findAll(strTypeFind, strFind, (String) comboBoxSort.getSelectedItem(), false);
        }
        loadDataTable();
        preRadio = radioGiam;
        radioTang.setSelected(false);
    }//GEN-LAST:event_radioGiamActionPerformed

    private void txtFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFindActionPerformed
        // TODO add your handling code here:
        buttonFindActionPerformed(evt);
    }//GEN-LAST:event_txtFindActionPerformed

    private void buttonThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonThemActionPerformed
        // TODO add your handling code here:
        if (studentInfor != null) {
            studentInfor.dispose();
        }
        studentInfor = new StudentInfor(list, tableModel);
        studentInfor.setAlwaysOnTop(true);
        studentInfor.setVisible(true);// 
    }//GEN-LAST:event_buttonThemActionPerformed

    private void xuatExelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xuatExelActionPerformed
        OutExelFile excelFile = new OutExelFile();
        excelFile.setVisible(true);
        excelFile.requestFocus();
        excelFile.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    }//GEN-LAST:event_xuatExelActionPerformed

    private void nhapExelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nhapExelActionPerformed
        // TODO add your handling code here:
        JFileChooser chooser;
        String choosePath = "";

        // Đường dẫn
        chooser = new JFileChooser();
        chooser.setCurrentDirectory(new java.io.File(System.getProperty("user.home") + "\\Desktop"));
        chooser.setDialogTitle("Chọn File");
        chooser.setAcceptAllFileFilterUsed(false);
        if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            choosePath = (chooser.getSelectedFile()).toString();
        }
        System.out.println(choosePath);
        try {
            //        Đọc file Exel
            readExcel(choosePath);
        } catch (IOException ex) {
            Logger.getLogger(ManagerStudentPanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(ManagerStudentPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_nhapExelActionPerformed

    public void readExcel(String excelFilePath) throws IOException, ParseException {
        // Get file
        InputStream inputStream = new FileInputStream(new File(excelFilePath));

        // Get workbook
        Workbook workbook = getWorkbook(inputStream, excelFilePath);

        // Get sheet
        Sheet sheet = workbook.getSheetAt(0);

        // Get all rows
        Iterator<Row> iterator = sheet.iterator();
        while (iterator.hasNext()) {
            Row nextRow = iterator.next();
            if (nextRow.getRowNum() == 0) {
                // Ignore header
                continue;
            }

            // Get all cells
            Iterator<Cell> cellIterator = nextRow.cellIterator();

            // Read cells and set value for SinhVien object
            SinhVien sinhVien = new SinhVien();
            while (cellIterator.hasNext()) {
                //Read cell
                Cell cell = cellIterator.next();
                // Set value for SinhVien object
                int columnIndex = cell.getColumnIndex();
                switch (columnIndex) {
//                  Ma Sinh Vien
                    case 1:
                        sinhVien.setMaSV((cell.getStringCellValue()).trim());
                        break;
//                  Ho Va Ten
                    case 2:
                        sinhVien.setTenSV((cell.getStringCellValue()).trim());
                        break;
//                  Lop
                    case 3:
                        sinhVien.setLopSV((cell.getStringCellValue()).trim());
                        break;
//                  Gioi Tinh                        
                    case 4:
                        sinhVien.setGioiTinh((cell.getStringCellValue()).trim().equals("Nam") ? 1 : 0);
                        break;
//                  Ngay Sinh
                    case 5:
                        String sa = (cell.getStringCellValue()).trim();
                        sinhVien.setNgaySinh(java.sql.Date.valueOf(LocalDate.parse(sa, DateTimeFormatter.ofPattern("dd/MM/yyyy"))));
                        break;
//                  So Dien Thoai                        
                    case 6:
                        sinhVien.setSoDienThoai(cell.getStringCellValue());
                        break;
//                  Email                        
                    case 7:
                        sinhVien.setEmail(cell.getStringCellValue());
                        break;
//                  Dia Chi                        
                    case 8:
                        sinhVien.setDiaChi(cell.getStringCellValue());
                        break;
//                  Ghi Chu                        
                    case 9:
                        sinhVien.setGhiChu(cell.getStringCellValue());
                        break;
                }
            }

            boolean k = new SinhVienDao().addSinhVien(sinhVien);
            if (k) {
                pos = 0;
                list.add(pos, sinhVien);
                tableModel.insertRow(pos,
                        new Object[]{
                            sinhVien.getMaSV(), sinhVien.getTenSV(), sinhVien.getLopSV(),
                            sinhVien.getGioiTinh(), sinhVien.getNgaySinh(), sinhVien.getSoDienThoai(),
                            sinhVien.getEmail(), sinhVien.getDiaChi()
                        });
            }
        }
        MessageDialogHelper.showMessageDialog(this, "Nhập Danh Sách Xong", "Thông báo");
        workbook.close();
        inputStream.close();
    }

    // Get Workbook
    private Workbook getWorkbook(InputStream inputStream, String excelFilePath) throws IOException {
        Workbook workbook = null;
        if (excelFilePath.endsWith("xlsx")) {
            workbook = new XSSFWorkbook(inputStream);
        } else if (excelFilePath.endsWith("xls")) {
            workbook = new HSSFWorkbook(inputStream);
        } else {
            throw new IllegalArgumentException("The specified file is not Excel file");
        }
        return workbook;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonFind;
    private javax.swing.JButton buttonThem;
    private javax.swing.JComboBox<String> comboBoxFind;
    private javax.swing.JComboBox<String> comboBoxSort;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton nhapExel;
    private javax.swing.JRadioButton radioGiam;
    private javax.swing.ButtonGroup radioSort;
    private javax.swing.JRadioButton radioTang;
    private javax.swing.JTable tableSV;
    private javax.swing.JTextField txtFind;
    private javax.swing.JButton xuatExel;
    // End of variables declaration//GEN-END:variables
    class ButtonEditor extends DefaultCellEditor {

        protected JButton button;
        private boolean isPushed;

        public ButtonEditor(JCheckBox checkBox) {
            super(checkBox);
            button = new JButton();
            button.addActionListener((ActionEvent e) -> {
                fireEditingStopped();
            });
        }

        @Override
        protected void fireEditingStopped() {
            super.fireEditingStopped();
            chooseSV = tableSV.getSelectedRow();
            if (studentInfor != null) {
                studentInfor.dispose();
            }
            studentInfor = new StudentInfor(list, chooseSV, tableModel);
            studentInfor.setAlwaysOnTop(true);
            studentInfor.setVisible(true);
        }
    }

}

class ButtonRenderer extends JButton implements TableCellRenderer {

    public ButtonRenderer() {
        setOpaque(true);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int column) {
        if (isSelected) {
            setForeground(table.getSelectionForeground());
            setBackground(table.getSelectionBackground());
        } else {
            setForeground(table.getForeground());
            setBackground(UIManager.getColor("Button.background"));
        }
        setText("Xem thông tin");
        return this;
    }
}
