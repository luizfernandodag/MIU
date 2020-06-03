package edu.miu.cs.cs425.lesson11.mybooksmgmt.service.impl;

import edu.miu.cs.cs425.lesson11.mybooksmgmt.model.Publisher;
import edu.miu.cs.cs425.lesson11.mybooksmgmt.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public Publisher registerNewPublisher(Publisher newPublisher) {
        return publisherRepository.save(newPublisher);
    }

    @Override
    public List<Publisher> getAllPubllshersSorted() {
        return null;
    }
}
