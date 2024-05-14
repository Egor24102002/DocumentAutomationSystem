import java.sql.Connection;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public interface DocumentDatabase {
 DefaultTableModel getDocuments(Connection connection);
  void addDocument(Connection connectio);
  void update(Connection connection,int id);
  DefaultTableModel searchDocumentsByNumber(Connection connection,String number);
}