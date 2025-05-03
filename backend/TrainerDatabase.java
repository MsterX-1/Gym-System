package backend;
import java.util.ArrayList;

public class TrainerDatabase extends FileManagement {
    private String filename;
    private ArrayList<Trainer> records;

    public TrainerDatabase(String filename) {
        this.filename = filename;
        setFilename(this.filename);
        readFromFile();
        records = getTrainerRecords();
    }

    @Override
    public Trainer createRecordFrom(String line) {
        String[] attribute = line.split(",");
        return new Trainer(attribute[0],attribute[1],attribute[2],attribute[3],attribute[4]);
    }
    @Override
    public Trainer getRecord(String key) {
        records = getTrainerRecords();
        for (Trainer record : records) {
            if (key.equals(record.getSearchKey()))
                return record;
        }
        return null;
    }
    public ArrayList<Trainer> returnAllRecords() {
        records = getTrainerRecords();
        return records;
    }

}
