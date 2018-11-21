package dao;


import model.Topic;

import java.util.List;

public interface TopicDao {

    List<Topic>getPendingTopics();
    List<Topic>getActiveTopics();
}
