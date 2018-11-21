package service;



import dao.TopicDao;
import model.Topic;

import java.util.List;

public class TopicServiceImpl implements TopicService {
    private TopicDao topicDao;

    public TopicServiceImpl(TopicDao topicDao) {
        this.topicDao = topicDao;
    }



    @Override
    public List<Topic> getPendingTopics() {
        return topicDao.getPendingTopics();
    }

    @Override
    public List<Topic> getActiveTopics() {
        return topicDao.getActiveTopics();
    }
}
