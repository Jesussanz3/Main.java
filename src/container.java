public class container{
    int IDNumber;
    int weight;
    String country;
    boolean inspected;
    int priority;
    String description;
    String sender;
    String receiver;



    public container (int IDNumber, int weight, String country, boolean inspected, int priority, String description, String sender, String receiver) {
        this.IDNumber = IDNumber;
        this.weight = weight;
        this.country = country;
        this.inspected = inspected;
        if((priority>=1)&&(priority<=3)) this.priority = priority;
        this.description = description;
        this.sender = sender;
        this.receiver = receiver;
    }

    public int getIDNumber() {
        return IDNumber;
    }

    public void setIDNumber(int IDNumber) {
        this.IDNumber = IDNumber;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public boolean isInspected() {
        return inspected;
    }

    public void setInspected(boolean inspected) {
        this.inspected = inspected;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }
}
