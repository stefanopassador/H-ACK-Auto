package it.spassador.bluetime.TDA;

/**
 * Created by stefanopassador on 11/04/15.
 */
public class TodoTask {
    int id;
    String title;
    String description;
    Double latitude;
    Double longitude;

    public TodoTask() {
        id = -1;
        title = "";
        description = "";
        latitude = 0.0;
        longitude = 0.0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }
}
