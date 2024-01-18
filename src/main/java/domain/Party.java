package domain;

import java.io.Serializable;

public class Party implements Serializable {
    private static final long serialVersionUID = 1L;

    private int id;
    private String attendeeCount;
    private String attendeeName;
    private String eventLocation;
    private String organizerName;
    private String comments;

    // コンストラクタ
    public Party() {
    }

    // ゲッターとセッター
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAttendeeCount() {
        return attendeeCount;
    }

    public void setAttendeeCount(String attendeeCount) {
        this.attendeeCount = attendeeCount;
    }

    public String getAttendeeName() {
        return attendeeName;
    }

    public void setAttendeeName(String attendeeName) {
        this.attendeeName = attendeeName;
    }

    public String getEventLocation() {
        return eventLocation;
    }

    public void setEventLocation(String eventLocation) {
        this.eventLocation = eventLocation;
    }

    public String getOrganizerName() {
        return organizerName;
    }

    public void setOrganizerName(String organizerName) {
        this.organizerName = organizerName;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "Party [id=" + id + ", attendeeCount=" + attendeeCount + ", attendeeName=" + attendeeName
                + ", eventLocation=" + eventLocation + ", organizerName=" + organizerName + ", comments=" + comments
                + "]";
    }
}
