import java.sql.*;

public class PreparedStatement01 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        //2. Adım: Database'e bağlan
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/tecproed001", "postgres", "serapuykur123456");
        //3. Adım: Statement oluştur.
        Statement st = con.createStatement();

        //1. Örnek: Prepared statement kullanarak company adı IBM olan number_of_employees değerini 9999 olarak güncelleyin.
//1. adim:Prepared statement  querysini olusturun

        String sql1 = " update companies set number_of_employees=? where company=?";//hazir method yani prepared method

        //2. adim: PrepareStatement objesini olustur
        PreparedStatement pst1 = con.prepareStatement(sql1);

        //3.Adim:set...() methodlari ile soru isaretleri icin deger gir
        pst1.setInt(1, 9999);
        pst1.setString(2, "IBM");

        //4.Adim execute query
        int updateRowSayisi = pst1.executeUpdate();
        System.out.println(updateRowSayisi + " satir guncellendi");

        String sql2 = "select * from companies";
        ResultSet result1 = st.executeQuery(sql2);
        while (result1.next()) {
            System.out.println(result1.getInt(1) + "--" + result1.getString(2) + "--" + result1.getInt(3));
        }

//======================================================================================//
        ///google icin degisiklik
        pst1.setInt(1, 15000);
        pst1.setString(2, "GOOGLE");

        //4.Adim execute query
        int updateRowSayisi2 = pst1.executeUpdate();
        System.out.println(updateRowSayisi + " satir guncellendi");

        String sql3 = "select * from companies";
        ResultSet result3 = st.executeQuery(sql3);
        while (result3.next()) {
            System.out.println(result3.getInt(1) + "--" + result3.getString(2) + "--" + result3.getInt(3));
        }
        //2. Örnek: "SELECT * FROM <table name>" query'sini prepared statement ile kullanin

        String sql4="SELECT * FROM ?";
        PreparedStatement pst2=con.prepareStatement(sql4);
        pst2.setString(1,"companies");

        ResultSet result4=pst2.executeQuery();
        while(result4.next()){
            System.out.println(result4.getInt(1) + "--" + result4.getString(2) + "--" + result4.getInt(3));
        }

    }
}
