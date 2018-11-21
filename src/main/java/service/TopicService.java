package service;



import model.Topic;

import java.util.List;

public interface TopicService {
    List<Topic>getPendingTopics();
    List<Topic>getActiveTopics();
}
