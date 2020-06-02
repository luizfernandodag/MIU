package edu.miu.cs.cs425.lesson11.mybooksmgmt.service.impl;

import edu.miu.cs.cs425.lesson11.mybooksmgmt.model.Publisher;
import edu.miu.cs.cs425.lesson11.mybooksmgmt.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PublisherServiceImpl implements PublisherService {

    private PublisherRepository publisherRepository;

    @Autowired
    public PublisherServiceImpl(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    @Override
    public Iterable<Publisher> getAllPublishers() {
        return publisherRepository.findAll();
    }
}
