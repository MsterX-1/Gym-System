package backend;
public class Class implements Information {
    private String classID;
    private String className;
    private String trainerID;
    private int duration;
    private int availableSeats;

    public Class(String classID, String className, String trainerID, String duration, String availableSeats) {
        this.classID = classID;
        this.className = className;
        this.trainerID = trainerID;
        this.duration = Integer.parseInt(duration);
        this.availableSeats = Integer.parseInt(availableSeats);
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }


    @Override
    public String lineRepresentation() {
        return classID + "," + className + "," + trainerID + "," + duration + "," + availableSeats;
    }

    @Override
    public String getSearchKey() {
      return classID;
    }


}
