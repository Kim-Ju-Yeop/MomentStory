package appjam.hackathon.project.isaac.momentstory.network;

public final class Response<Data> {
    private String message;
    private boolean status;
    private Data data;

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String value) {
        this.message = value;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }
}
