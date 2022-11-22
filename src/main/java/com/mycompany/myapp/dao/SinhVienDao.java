package com.mycompany.myapp.dao;

import com.mycompany.myapp.helpers.DatabaseHelper;
import com.mycompany.myapp.model.SinhVien;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.rowset.serial.SerialBlob;

/**
 *
 * @author Houta
 */
public class SinhVienDao {

    private SinhVien createSinhVien(ResultSet rs) {
        SinhVien sv = new SinhVien();
        try {
            sv.setMaSV(rs.getString("maSV"));
            sv.setTenSV(rs.getString("tenSV"));
            sv.setLopSV(rs.getString("lopSV"));
            sv.setGioiTinh(rs.getInt("gioiTinh"));
            sv.setNgaySinh(rs.getDate("ngaySinh"));
            sv.setSoDienThoai(rs.getString("soDienThoai"));
            sv.setEmail(rs.getString("email"));
            sv.setDiaChi(rs.getString("diaChi"));
            sv.setGhiChu(rs.getString("ghiChu"));
            Blob avatar = rs.getBlob("avatar");
            if (avatar != null) {
                sv.setAvatar(avatar.getBytes(1, (int) avatar.length()));
            } else {
                sv.setAvatar(null);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SinhVienDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sv;
    }

    public List<SinhVien> findAll(String typeFind, String strFind, String sortBy, boolean asc) {
        List<SinhVien> list = new ArrayList<>();
        try {
            Map<String, String> dir = new HashMap<>();
            dir.put("", "maSV");
            dir.put("Mã sinh viên", "maSV");
            dir.put("Họ và tên", "tenSV");
            dir.put("Lớp", "lopSV");
            dir.put("Giới tính", "gioiTinh");
            dir.put("Số Điện Thoại", "soDienThoai");
            dir.put("Ngày sinh", "ngaySinh");
            dir.put("Địa Chỉ", "diaChi");
            if (typeFind == null) {
                typeFind = "";
            }
            if (typeFind.equals("Giới tính")) {
                if (strFind.equalsIgnoreCase("nam")) {
                    strFind = "1";
                } else if (strFind.equalsIgnoreCase("nữ") || strFind.equalsIgnoreCase("nu")) {
                    strFind = "0";
                } else {
                    return list;
                }
            }
            StringBuilder sql = new StringBuilder("Select * from databaseapp.sinh_vien Where ");
            sql.append(dir.get(typeFind)).append(" Like ? ");
            if (!sortBy.equals("") && !sortBy.equals("Tên")) {
                sql.append("Order By ").append(dir.get(sortBy));
                if ((asc == true && sortBy.equals("Giới tính"))) {
                    sql.append(" DESC");
                } else if (asc == false && !sortBy.equals("Giới tính")) {
                    sql.append(" DESC");
                }
            }
            Connection conn = DatabaseHelper.openConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql.toString());
            pstmt.setString(1, "%" + strFind + "%");

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                SinhVien sv = createSinhVien(rs);
                list.add(sv);
            }
            if (sortBy.equals("Tên")) {
                Collections.sort(list, (a, b) -> a.getTenChinh().compareTo(b.getTenChinh()) * (asc == true ? 1 : -1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(SinhVienDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public boolean updateSinhVien(SinhVien sv, String maSVOld) {
        try {
            String sql = "UPDATE `databaseapp`.`sinh_vien` SET maSV = ?, "
                    + "tenSV = ? ," + "lopSV = ? ," + "gioiTinh = ? ,"
                    + "ngaySinh = ? ," + "soDienThoai = ? ," + "email = ? ,"
                    + "diaChi = ? ," + "ghiChu = ? ," + "avatar = ? "
                    + "WHERE (maSV = ?);";
            Connection conn = DatabaseHelper.openConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, sv.getMaSV());
            pstmt.setString(2, sv.getTenSV());
            pstmt.setString(3, sv.getLopSV());
            pstmt.setInt(4, sv.getGioiTinh().equals("Nam") ? 1 : 0);
            pstmt.setString(5, new SimpleDateFormat("yyyy-MM-dd").format(sv.getNgaySinhDate()));
            pstmt.setString(6, sv.getSoDienThoai());
            pstmt.setString(7, sv.getEmail());
            pstmt.setString(8, sv.getDiaChi());
            pstmt.setString(9, sv.getGhiChu());
            pstmt.setBlob(10, sv.getAvatar() != null ? new SerialBlob(sv.getAvatar()) : null);
            pstmt.setString(11, maSVOld);
            return pstmt.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(SinhVienDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean addSinhVien(SinhVien sv) {
        try {
            String sql = "INSERT INTO sinh_vien (maSV,tenSV,lopSV,gioiTinh,ngaySinh,soDienThoai,email,diaChi,ghiChu,avatar)"
                    + " VALUES (?,?,?,?,?,?,?,?,?,?);";
            Connection conn = DatabaseHelper.openConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, sv.getMaSV());
            pstmt.setString(2, sv.getTenSV());
            pstmt.setString(3, sv.getLopSV());
            pstmt.setInt(4, sv.getGioiTinh().equals("Nam") ? 1 : 0);
            pstmt.setString(5, new SimpleDateFormat("yyyy-MM-dd").format(sv.getNgaySinhDate()));
            pstmt.setString(6, sv.getSoDienThoai());
            pstmt.setString(7, sv.getEmail());
            pstmt.setString(8, sv.getDiaChi());
            pstmt.setString(9, sv.getGhiChu());
            pstmt.setBlob(10, sv.getAvatar() != null ? new SerialBlob(sv.getAvatar()) : null);
            return pstmt.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(SinhVienDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean deleteSinhVien(SinhVien sv) {
        try {
            String sql = "DELETE FROM sinh_vien WHERE (maSV = ?);";
            Connection conn = DatabaseHelper.openConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, sv.getMaSV());
            return pstmt.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(SinhVienDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
