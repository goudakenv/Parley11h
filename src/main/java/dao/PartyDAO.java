package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import domain.Party;

public class PartyDAO {

    private DataSource ds;

    public PartyDAO(DataSource ds) {
        this.ds = ds;
    }

    public List<Party> getAllParties() {
        List<Party> parties = new ArrayList<>();
        String query = "SELECT * FROM partys";  // テーブル名を変更

        try (Connection con = ds.getConnection()) {
            PreparedStatement stmt = con.prepareStatement(query);
            ResultSet resultSet = stmt.executeQuery(query);
            while (resultSet.next()) {
                Party party = new Party();
                party.setId(resultSet.getInt("id"));
                party.setAttendeeCount(resultSet.getString("attendee_count"));
                party.setAttendeeName(resultSet.getString("attendee_name"));
                party.setEventLocation(resultSet.getString("event_location"));
                party.setOrganizerName(resultSet.getString("organizer_name"));
                party.setComments(resultSet.getString("comments"));
                parties.add(party);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return parties;
    }
    
    public List<Party> getParties(String text) {
        List<Party> parties = new ArrayList<>();
        String query = "SELECT * FROM partys where attendee_count = ?";  // パラメータの値をセット


        try (Connection con = ds.getConnection(); PreparedStatement stmt = con.prepareStatement(query)) {
            stmt.setString(1, text); // パラメータの値をセット
            ResultSet resultSet = stmt.executeQuery();

            while (resultSet.next()) {
                Party party = new Party();
                party.setId(resultSet.getInt("id"));
                party.setAttendeeCount(resultSet.getString("attendee_count"));
                party.setAttendeeName(resultSet.getString("attendee_name"));
                party.setEventLocation(resultSet.getString("event_location"));
                party.setOrganizerName(resultSet.getString("organizer_name"));
                party.setComments(resultSet.getString("comments"));
                parties.add(party);
            }
        

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return parties;
    }

    public void addParty(Party party) {
        String query = "INSERT INTO partys (attendee_count, attendee_name, event_location, organizer_name, comments) VALUES (?, ?, ?, ?, ?)";

        try (Connection con = ds.getConnection()) {
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1, party.getAttendeeCount());
            stmt.setString(2, party.getAttendeeName());
            stmt.setString(3, party.getEventLocation());
            stmt.setString(4, party.getOrganizerName());
            stmt.setString(5, party.getComments());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
