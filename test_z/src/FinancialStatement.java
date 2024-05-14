
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import javax.swing.table.DefaultTableModel;

public class FinancialStatement extends Document implements DocumentDatabase{
    private String statementType;
    private double amount;

    public FinancialStatement(String number, Date date, String statementType, double amount) {
        super( number, date, "FinancialStatement");
        this.statementType = statementType;
        this.amount = amount;
    }

     public FinancialStatement() {
     
    }

    
    public String getStatementType() {
        return statementType;
    }

    public void setStatementType(String statementType) {
        this.statementType = statementType;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

       @Override
public DefaultTableModel getDocuments(Connection connection) {
    DefaultTableModel model = new DefaultTableModel();
    model.addColumn("ID");
    model.addColumn("Number");
    model.addColumn("Date");
    model.addColumn("Type");

    try {
        
        String query = "SELECT id, number, date, type FROM documents WHERE type = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, "FinancialStatement");  

        ResultSet resultSet = statement.executeQuery();

        
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String number = resultSet.getString("number");
            java.util.Date date = resultSet.getDate("date");
            String type = resultSet.getString("type");

            model.addRow(new Object[]{id, number, date, type});
        }

        resultSet.close();
        statement.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return model;
}
 

 

@Override
public void addDocument(Connection connection) {
    try {
       
        String documentQuery = "INSERT INTO documents (number, date, type) VALUES (?, ?, ?)";
        try (PreparedStatement documentStatement = connection.prepareStatement(documentQuery, Statement.RETURN_GENERATED_KEYS)) {
            documentStatement.setString(1, getNumber());
            documentStatement.setDate(2, new java.sql.Date(getDate().getTime()));  
            documentStatement.setString(3, getType());
            
            
            int rowsInserted = documentStatement.executeUpdate();
            ResultSet generatedKeys = documentStatement.getGeneratedKeys();
            int docId = -1;
            if (generatedKeys.next()) {
                docId = generatedKeys.getInt(1);
            }
            
            
            if (rowsInserted > 0 && docId != -1) {
                
                String specificQuery = "INSERT INTO financial_statements (id, statement_type, amount) VALUES (?, ?, ?)";
                try (PreparedStatement specificStatement = connection.prepareStatement(specificQuery)) {
                    specificStatement.setInt(1, docId);
                    specificStatement.setString(2, getStatementType());
                    specificStatement.setDouble(3, getAmount());

                    
                    int specificRowsInserted = specificStatement.executeUpdate();
                    if (specificRowsInserted > 0) {
                        System.out.println("Документ успешно добавлен в базу данных!");
                    } else {
                        System.out.println("Ошибка: Данные не были вставлены в таблицу " );
                    }
                }
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
}


public FinancialStatement getFinancialStatementdById(Connection connection, int id) {
    String query = "SELECT * FROM documents WHERE id = ?";
    try (PreparedStatement statement = connection.prepareStatement(query)) {
        statement.setInt(1, id);
        try (ResultSet resultSet = statement.executeQuery()) {
            if (resultSet.next()) {
               
                String number = resultSet.getString("number");
                Date date = resultSet.getDate("date");
                
                
             
                String statement_type = "";
                Double amount = 0.0;
                String specificQuery = "SELECT * FROM financial_statements WHERE id = ?";
                try (PreparedStatement specificStatement = connection.prepareStatement(specificQuery)) {
                    specificStatement.setInt(1, id);
                    try (ResultSet specificResultSet = specificStatement.executeQuery()) {
                        if (specificResultSet.next()) {
                            statement_type = specificResultSet.getString("statement_type");
                            amount = specificResultSet.getDouble("amount");
                        }
                    }
                }
                
                
                return new FinancialStatement(number, date, statement_type, amount);
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return null;
}
@Override
 public void update(Connection connection, int id) {
        try {
             
            String documentsQuery = "UPDATE documents SET number = ?, date = ?, type = ? WHERE id = ?";
            try (PreparedStatement documentsStatement = connection.prepareStatement(documentsQuery)) {
                documentsStatement.setString(1, getNumber());
                documentsStatement.setDate(2, new java.sql.Date(getDate().getTime())); 
                documentsStatement.setString(3, getType());
                    documentsStatement.setInt(4, id);

                int rowsUpdated = documentsStatement.executeUpdate();
                if (rowsUpdated > 0) {
                    System.out.println("Запись в таблице documents обновлена успешно.");
                } else {
                    System.out.println("Не удалось обновить запись в таблице documents.");
                }
            }

            
            String FinancialStatementQuery = "UPDATE financial_statements SET statement_type = ?, amount = ? WHERE id = ?";
            try (PreparedStatement FinancialStatement = connection.prepareStatement(FinancialStatementQuery)) {
                FinancialStatement.setString(1, getStatementType());
                FinancialStatement.setDouble(2, getAmount());
         FinancialStatement.setInt(3, id);

                int rowsUpdated = FinancialStatement.executeUpdate();
                if (rowsUpdated > 0) {
                    System.out.println("Запись в таблице financial_statements обновлена успешно.");
                } else {
                    System.out.println("Не удалось обновить запись в таблице financial_statements.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
@Override
    public DefaultTableModel searchDocumentsByNumber(Connection connection,String docNumber) {
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.addColumn("ID");
        tableModel.addColumn("Number");
        tableModel.addColumn("Date");
        tableModel.addColumn("Type");
        
        String searchQuery = "SELECT id, number, date, type FROM documents WHERE number = ? AND type = ?";
        
        try (
             PreparedStatement searchStatement = connection.prepareStatement(searchQuery)) {
         
            searchStatement.setString(1, docNumber);
              searchStatement.setString(2, "FinancialStatement"); 
            try (ResultSet resultSet = searchStatement.executeQuery()) {
             
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String number = resultSet.getString("number");
                    Date date = resultSet.getDate("date");
                    String type = resultSet.getString("type");
                    
                    Object[] rowData = {id, number, date, type};
                    tableModel.addRow(rowData);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
      
        }
        
        return tableModel;
    }



}