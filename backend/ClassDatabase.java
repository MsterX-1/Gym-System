package backend;
import java.util.ArrayList;

public class ClassDatabase extends FileManagement {
    private String filename;
    private ArrayList<Class> records;

    public ClassDatabase(String filename) {
        this.filename = filename;
        setFilename(this.filename);
        readFromFile();
        records = getClassRecords();
    }
    
    @Override
    public Class createRecordFrom(String line) {
        String[] attribute = line.split(",");
        return new Class(attribute[0], attribute[1], attribute[2], attribute[3], attribute[4]);
    }
    @Override
    public Class getRecord(String key) {
        records = getClassRecords();
        for (Class record : records) {
            if (key.equals(record.getSearchKey()))
                return record;
        }
        return null;
    }

    public ArrayList<Class> returnAllRecords() {
        records = getClassRecords();
        return records;
    }


}
