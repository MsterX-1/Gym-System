package backend;
import java.util.ArrayList;

public class MemberClassRegistrationDatabase extends FileManagement{
    private String filename;
    private ArrayList<MemberClassRegistration> records;

    public MemberClassRegistrationDatabase(String filename) {
        this.filename = filename;
        setFilename(this.filename);
        readFromFile();
        records = getRegistrationRecords();
    }

    @Override
    public MemberClassRegistration createRecordFrom(String line) {
        String[] attribute = line.split(",");
        return new MemberClassRegistration(attribute[0], attribute[1], attribute[2] , attribute[3]);
    }

    @Override
    public MemberClassRegistration getRecord(String key) {
        records = getRegistrationRecords();
        for (MemberClassRegistration record : records) {
            if (key.equals(record.getSearchKey()))
                return record;
        }
        return null;
    }

    public ArrayList<MemberClassRegistration> returnAllRecords() {
        records = getRegistrationRecords();
        return records;
    }



}
