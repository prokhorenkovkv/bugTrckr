package com.softserverinc.edu.services;

import com.softserverinc.edu.entities.Project;
import com.softserverinc.edu.entities.Release;
import com.softserverinc.edu.entities.User;

import java.util.List;

public interface ProjectService {

    Project findById(Long id);

    Project findByTitle(String title);

    Project findByProjectManager(User projectManager);

    Project findByUser(User user);

    Project findByRelease(Release release);

    List<Project> findByGuestView(Boolean guestView);

    List<Project> findByGuestCreateIssues(Boolean guestCreateIssues);

    List<Project> findByGuestAddComment(Boolean guestAddComment);

    List<Project> findByIsDeleted(Boolean isDeleted);

    List<Project> findAll();

    Project save(Project project);

    void delete(Long id);

    Project update(Project project);

}
