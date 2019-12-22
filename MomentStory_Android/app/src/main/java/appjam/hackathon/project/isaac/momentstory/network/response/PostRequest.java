package appjam.hackathon.project.isaac.momentstory.network.response;

public class PostRequest {
    private String title;
    private String description;
    private String goalTime;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGoalTime() {
        return goalTime;
    }

    public void setGoalTime(String goalTime) {
        this.goalTime = goalTime;
    }


    @Override
    public String toString() {
        return "PostRequest{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", goalTime='" + goalTime + '\'' +
                '}';
    }
}
