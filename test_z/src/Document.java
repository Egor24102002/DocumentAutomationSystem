
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import javax.swing.table.DefaultTableModel;

public abstract class Document {
    
    private String number;
    private Date date;
    private String type;

    public Document( String number, Date date, String type) {
  
        this.number = number;
        this.date = date;
        this.type = type;
    }

   public Document(){
   }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
  
    
  
}