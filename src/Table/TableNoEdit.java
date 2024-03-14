
package Table;
import javax.swing.table.DefaultTableModel;

public class TableNoEdit extends DefaultTableModel {
    @Override
    public boolean isCellEditable(int row, int column) {
    return false;
    }
}
