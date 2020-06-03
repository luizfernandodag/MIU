package edu.miu.cs.cs425.lesson11.mybooksmgmt.service.impl;

import edu.miu.cs.cs425.lesson11.mybooksmgmt.model.Publisher;

import java.util.List;

public interface PublisherService {

    Iterable<Publisher> getAllPublishers();
    Publisher registerNewPublisher( Publisher newPublisher);
    List<Publisher> getAllPubllshersSorted();

}
