package backend;
//Member fifth class

import java.time.LocalDate;

public class MemberClassRegistration implements Information {

    private String memberID;
    private String classID;
    private String status;
    private LocalDate registrationDate;

    public MemberClassRegistration(String memberID, String classID, String registrationDate , String status) {
        this.memberID = memberID;
        this.classID = classID;
        this.status = status;
        String[] date = registrationDate.split("-");
        int year = Integer.parseInt(date[0]);
        int month = Integer.parseInt(date[1]);
        int day = Integer.parseInt(date[2]);
        this.registrationDate = LocalDate.of(year, month, day);

    }

    public String getMemberID() {
        return memberID;
    }

    public String getClassID() {
        return classID;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    @Override
    public String lineRepresentation() {
        return memberID + "," + classID + "," + registrationDate + "," + status;
    }

    @Override
    public String getSearchKey() {
       return memberID + classID;
    }

}
