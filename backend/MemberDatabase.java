package backend;
import java.util.ArrayList;

public class MemberDatabase extends FileManagement{
    private String filename;
    private ArrayList<Member> records;

    public MemberDatabase(String filename) {
        this.filename = filename;
        setFilename(this.filename);
        readFromFile();
        records = getMemberRecords();
    }


    @Override
    public Member createRecordFrom(String line) {
        String[] attribute = line.split(",");
        return new Member(attribute[0],attribute[1],attribute[2],attribute[3],attribute[4],attribute[5]);
    }

    @Override
    public Member getRecord(String key) {
        records = getMemberRecords();
        for (Member record : records) {
            if (key.equals(record.getSearchKey()))
                return record;
        }
        return null;
    }

    public ArrayList<Member> returnAllRecords() {
        records = getMemberRecords();
        return records;
    }


}
