package medonline.utils;

import medonline.entities.Classification;
import medonline.entities.Drug;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DBUtils {
    /*public static UserAccount findUser(Connection conn, String userName, String password) throws SQLException {

        String sql = "Select a.User_Name, a.Password, a.Gender from User_Account a " + " where a.User_Name = ? and a.password= ?";

        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, userName);
        pstm.setString(2, password);
        ResultSet rs = pstm.executeQuery();

        if (rs.next()) {
            String gender = rs.getString("Gender");
            UserAccount user = new UserAccount();
            user.setUserName(userName);
            user.setPassword(password);
            user.setGender(gender);
            return user;
        }
        return null;
    }*/
    public static List<Classification> querryClassification (Connection connection) throws SQLException {
        String sql ="select * from classification;";

        PreparedStatement statement= connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        List <Classification> classificationList = new ArrayList<Classification>();
        while (resultSet.next()){
            int id = resultSet.getInt("id_class");
            String desc = resultSet.getString("description");
            Classification classification = new Classification();
            classification.setId_class(id);
            classification.setDescription(desc);
            classificationList.add(classification);

        }
        return classificationList;
    }

    public static List<Drug> querryDrugs (Connection connection) throws SQLException {
        String sql ="select * from drugs;";

        PreparedStatement statement= connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        List <Drug> drugsList = new ArrayList<Drug>();
        while (resultSet.next()){

            Drug drug = new Drug(resultSet.getInt("id_drug"),resultSet.getString("drug_name"),resultSet.getInt("id_provider"),resultSet.getFloat("price"),resultSet.getInt("quantity"),resultSet.getInt("id_class"));
            drugsList.add(drug);

        }
        return drugsList;
    }

    public static List<Drug> querryDrugsByClass (Connection connection, int id_class) throws SQLException {
        String sql ="select * from drugs where drugs.id_class="+"id_class"+";";

        PreparedStatement statement= connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        List <Drug> drugsList = new ArrayList<Drug>();
        while (resultSet.next()){
            Drug drug = new Drug(resultSet.getInt("id_drug"),resultSet.getString("drug_name"),resultSet.getInt("id_provider"),resultSet.getFloat("price"),resultSet.getInt("quantity"),resultSet.getInt("id_class"));
            drugsList.add(drug);

        }
        return drugsList;
    }
}
