package dao;


import model.Topic;
import model.User;
import util.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TopicDaoImpl implements TopicDao {
    private final String GET_PENDING_TOPICS="select t.id_topic, t.title, t.description as topic_description, t.share_date, t.view_count, t.status, u.id_user, u.email, u.first_name, u.last_name from topic t inner join user u on t.id_user = u.id_user where t.status=TopicConstants.TOPIC_STATUS_INACTIVE";
    private final String GET_ACTIVE_TOPICS="select t.id_topic, t.title, t.description as topic_description, t.share_date, t.view_count, t.status, u.id_user, u.email, u.first_name, u.last_name from topic t inner join user u on t.id_user = u.id_user where t.status=TopicConstants.TOPIC_STATUS_ACTIVE";
    @Override
    public List<Topic> getPendingTopics() {
        Connection con=null;
        PreparedStatement ps=null;
        List<Topic>listPendingTopics=new ArrayList<>();
        ResultSet rs=null;
        try {
            con=DbUtil.getConnection();
            ps=con.prepareStatement(GET_PENDING_TOPICS);
            rs=ps.executeQuery();
            while(rs.next()){
                Topic topic = new Topic();
                topic.setId(rs.getInt("id_topic"));
                topic.setTitle(rs.getString("title"));
                topic.setDesc(rs.getString("topic_description"));
                topic.setShareDate(rs.getTimestamp("share_date").toLocalDateTime());
                topic.setViewCount(rs.getInt("view_count"));
                topic.setStatus(rs.getInt("status"));

                User user = new User();
                user.setId(rs.getInt("id_user"));
                user.setEmail(rs.getString("email"));
                user.setFirstName(rs.getString("first_name"));
                user.setLastName(rs.getString("last_name"));

                topic.setUser(user);
                listPendingTopics.add(topic);
            }

        }catch (SQLException e) {
            e.printStackTrace();

        } finally {
            DbUtil.closeAll(con, ps, rs);
        }

        return listPendingTopics;
    }

    @Override
    public List<Topic> getActiveTopics() {

        Connection con=null;
        PreparedStatement ps=null;
        List<Topic>listActiveTopics=new ArrayList<>();
        ResultSet rs=null;
        try {
            con=DbUtil.getConnection();
            ps=con.prepareStatement(GET_PENDING_TOPICS);
            rs=ps.executeQuery();
            while(rs.next()){
                Topic topic = new Topic();
                topic.setId(rs.getInt("id_topic"));
                topic.setTitle(rs.getString("title"));
                topic.setDesc(rs.getString("topic_description"));
                topic.setShareDate(rs.getTimestamp("share_date").toLocalDateTime());
                topic.setViewCount(rs.getInt("view_count"));
                topic.setStatus(rs.getInt("status"));

                User user = new User();
                user.setId(rs.getInt("id_user"));
                user.setEmail(rs.getString("email"));
                user.setFirstName(rs.getString("first_name"));
                user.setLastName(rs.getString("last_name"));

                topic.setUser(user);
                listActiveTopics.add(topic);
            }

        }catch (SQLException e) {
            e.printStackTrace();

        } finally {
            DbUtil.closeAll(con, ps, rs);
        }

        return listActiveTopics;
    }
}
