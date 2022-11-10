package com.mycompany.myapp.model;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.HashMap;
/**
 *
 * @author Houta
 */
public class GiangVien implements Comparable<GiangVien>{
    private String maGV,tenGV,lopGV,tenChinh;
    int gioiTinh;
    private Date ngaySinh; // format dd/MM/yyyy
    private String soDienThoai,email,diaChi,ghiChu;
    private byte[] avatar ;

    public String getMaGV() {
        return maGV;
    }

    public void setMaGV(String maGV) {
        this.tenGV = chuanHoaTen(tenGV);
        int k = this.tenGV.lastIndexOf(" ");
        this.tenChinh = this.tenGV.substring(k+1);
    }

    public String getTenGV() {
        return tenGV;
    }

    public void setTenGV(String tenGV) {
        this.tenGV = tenGV;
    }

    public String getLopGV() {
        return lopGV;
    }

    public void setLopGV(String lopGV) {
        this.lopGV = lopGV;
    }

    public String getTenChinh() {
        return tenChinh;
    }

    public void setTenChinh(String tenChinh) {
        this.tenChinh = tenChinh;
    }

    public byte[] getAvatar() {
        return avatar;
    }

    public void setAvatar(byte[] avatar) {
        this.avatar = avatar;
    }
    
    
    public String getNgaySinh() {
        return new SimpleDateFormat("dd/MM/yyyy").format(this.ngaySinh);
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getGioiTinh() {
        return gioiTinh==1? "Nam":"Nữ";
    }

    public void setGioiTinh(int gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }
    
    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai==null? null: soDienThoai.trim().equals("") ? null:soDienThoai.trim();
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu==null? null: ghiChu.trim().equals("") ? null:ghiChu.trim();
    }

    public void setEmail(String email) {
        this.email = email==null? null: email.trim().equals("") ? null:email.trim();
    }
    
    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi==null? null: diaChi.trim().equals("") ?null:diaChi.trim();
    }
    
    private static String chuanHoaTen(String s){
        s = s.trim().toLowerCase();
        String res = "" + Character.toUpperCase(s.charAt(0));
        for(int i=1; i< s.length();i++){
            if(Character.isLetterOrDigit(s.charAt(i))){
                if(s.charAt(i-1) == ' ') res+= " "+ Character.toUpperCase(s.charAt(i));
                else res += s.charAt(i);
            }
        }
        return res;
    }
    
    static HashMap<Character, String> codeVN = new HashMap<>();
    public String generator(String input){
        if(!codeVN.containsKey('a')){
            codeVN.put('a', "00");        codeVN.put('á', "01");      
            codeVN.put('à', "02");        codeVN.put('ả', "03");      
            codeVN.put('ã', "04");        codeVN.put('ạ', "05");      
            codeVN.put('ă', "06");        codeVN.put('ắ', "07");    
            codeVN.put('ằ', "08");        codeVN.put('ẳ', "09");      
            codeVN.put('ẵ', "10");        codeVN.put('ặ', "11");
            codeVN.put('â', "12");        codeVN.put('ấ', "13");
            codeVN.put('ầ', "14");        codeVN.put('ẩ', "15");
            codeVN.put('ẫ', "16");        codeVN.put('ậ', "17");
            codeVN.put('b', "18");        codeVN.put('c', "19");
            codeVN.put('d', "20");        codeVN.put('đ', "21");
            codeVN.put('e', "22");        codeVN.put('é', "23");
            codeVN.put('è', "24");        codeVN.put('ẻ', "25");
            codeVN.put('ẽ', "26");        codeVN.put('ẹ', "27");
            codeVN.put('ê', "28");        codeVN.put('ế', "29");
            codeVN.put('ề', "30");        codeVN.put('ể', "31");
            codeVN.put('ễ', "32");        codeVN.put('ệ', "33");
            codeVN.put('f', "34");        codeVN.put('g', "35");
            codeVN.put('h', "36");        codeVN.put('i', "37");
            codeVN.put('í', "38");        codeVN.put('ì', "39");
            codeVN.put('ỉ', "40");        codeVN.put('ĩ', "41");
            codeVN.put('ị', "42");        codeVN.put('j', "43");
            codeVN.put('k', "44");        codeVN.put('l', "45");
            codeVN.put('m', "46");        codeVN.put('n', "47");
            codeVN.put('o', "48");        codeVN.put('ó', "49");
            codeVN.put('ò', "50");        codeVN.put('ỏ', "51");
            codeVN.put('õ', "52");        codeVN.put('ọ', "53");
            codeVN.put('ô', "54");        codeVN.put('ố', "55");
            codeVN.put('ồ', "56");        codeVN.put('ổ', "57");
            codeVN.put('ỗ', "58");        codeVN.put('ộ', "59");
            codeVN.put('ơ', "60");        codeVN.put('ớ', "61");
            codeVN.put('ờ', "62");        codeVN.put('ở', "63");
            codeVN.put('ỡ', "64");        codeVN.put('ợ', "65");
            codeVN.put('p', "66");        codeVN.put('q', "67");
            codeVN.put('r', "68");        codeVN.put('s', "69");
            codeVN.put('t', "70");        codeVN.put('u', "71");
            codeVN.put('ú', "72");        codeVN.put('ù', "73");
            codeVN.put('ủ', "74");        codeVN.put('ũ', "75");
            codeVN.put('ụ', "76");        
            codeVN.put('ư', "77");        codeVN.put('ứ', "78");        
            codeVN.put('ừ', "79");        codeVN.put('ử', "80");
            codeVN.put('ữ', "81");        codeVN.put('ự', "82");
            codeVN.put('v', "83");        codeVN.put('x', "84");
            codeVN.put('y', "85");        codeVN.put('z', "86");
            codeVN.put(' ',"87");
        }
        String result="";
        char[] b = input.toLowerCase().toCharArray();
        for(int i=0; i < b.length;i++){
            result += codeVN.get(b[i]);
        }
        return result;
    }

    @Override
    public int compareTo(GiangVien o) {
        if(!this.tenChinh.equals(o.tenChinh)) return generator(this.tenChinh).compareTo(generator(o.tenChinh));
        if(!this.tenGV.equals(o.tenGV)) return generator(this.tenGV).compareTo(generator(o.tenGV));
        return this.maGV.compareTo(o.maGV);
    }
}
