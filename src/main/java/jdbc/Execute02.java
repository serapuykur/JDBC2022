package jdbc;

import java.sql.*;

public class Execute02 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/tecproed001","postgres","serapuykur123456");
       Statement st=con.createStatement();
        String sql1="select country_name from countres where region_id=1";
        st.execute(sql1);
        boolean r1=st.execute(sql1);
        System.out.println(r1);//true ya da false verir cunku data cagirma islemi yaptik

       ResultSet result1= st.executeQuery(sql1);
       //recortlari gormek iicn executeQuery() methodu kullanmaliyiz
       while(result1.next()){

           System.out.println(result1.getString("country_name"));

       }




            //2.Örnek: "region_id"nin 2'den büyük olduğu "country_id" ve "country_name" değerlerini çağırın.

        String sql2="select country_id,country_name from countries where region_id>2";
       ResultSet result2=st.executeQuery(sql2);
       while(result2.next()){
           System.out.println(result2.getString("country_id")+"-->"+result2.getString("country_name"));
       }

        //3.Example: "number_of_employees" değeri en düşük olan satırın tüm değerlerini çağırın.

        String sql3="select * from companies where number_of_employees=(select min(number_of_employees) from companies)";

       ResultSet result3 =st.executeQuery(sql3);
       while(result3.next()){
           System.out.println(result3.getInt("company_id")+" -->"+result3.getString("company")+"-->"+result3.getInt("number_of_employees"));
       }


    }
}
