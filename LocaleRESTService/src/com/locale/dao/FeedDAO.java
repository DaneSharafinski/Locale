package com.locale.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.locale.database.DBConnection;
import com.locale.rest.models.feed.FeedItem;

public class FeedDAO {

	
	public List<FeedItem> findByUserId(Integer userId) {
		List<FeedItem> retFeedList = new ArrayList<FeedItem>();
		
		Connection c = null;
    	String sql = "		SELECT u.user_id, u.display_name" 
						+ "	FROM t_users u";
      
        try {
            c = DBConnection.getConnection();
            Statement s = c.createStatement();
            ResultSet rs = s.executeQuery(sql);
            while (rs.next()) {
                retFeedList.add(processFeedListResultRow(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
		} finally {
			DBConnection.close(c);
		}
        
		
		return retFeedList;
	}
	
	
	private FeedItem processFeedListResultRow(ResultSet rs) throws SQLException {
		
		FeedItem retFI = new FeedItem();
		
		retFI.setUserId(rs.getInt("user_id"));
		retFI.setDisplayName(rs.getString("display_name"));
		try {
			retFI.setTimeStamp(new Timestamp(new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").parse("2015.10.29.07.23.45").getTime()));
		} catch (ParseException e) {
			System.out.println("!!!!!ERROR!!!! FAILED TO SET TIMESTAMP FOR FeedItem");
			e.printStackTrace();
		}
		
		return retFI;
	}
	
}
