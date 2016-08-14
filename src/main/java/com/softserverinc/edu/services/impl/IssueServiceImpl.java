package com.softserverinc.edu.services.impl;

import com.softserverinc.edu.entities.Issue;
import com.softserverinc.edu.entities.Label;
import com.softserverinc.edu.entities.Release;
import com.softserverinc.edu.entities.User;
import com.softserverinc.edu.entities.enums.IssuePriority;
import com.softserverinc.edu.entities.enums.IssueStatus;
import com.softserverinc.edu.entities.enums.IssueType;
import com.softserverinc.edu.repositories.IssueRepository;
import com.softserverinc.edu.services.IssueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class IssueServiceImpl implements IssueService {

    @Autowired
    IssueRepository issueRepository;

    @Override
    public Issue findById(Long id) {
        return issueRepository.findOne(id);
    }

    @Override
    public List<Issue> findByTitle(String title) {
        return issueRepository.findByTitle(title);
    }

    @Override
    public List<Issue> findByType(IssueType type) {
        return issueRepository.findByType(type);
    }

    @Override
    public List<Issue> findByStatus(IssueStatus status) {
        return issueRepository.findByStatus(status);
    }

    @Override
    public List<Issue> findByPriority(IssuePriority priority) {
        return issueRepository.findByPriority(priority);
    }

    @Override
    public Issue findByRelease(Release release) {
        return issueRepository.findByRelease(release);
    }

    @Override
    public Issue findByAssignee(User assignee) {
        return issueRepository.findByAssignee(assignee);
    }

    @Override
    public List<Issue> findByLabel(Label label) {
        List<Issue> listOfAllIssues = issueRepository.findAll();
        List<Issue> listOfIssues = null;
        for (Issue issueIterator : listOfAllIssues) {
            if (issueIterator.getLabels().contains(label)) {
                listOfIssues.add(issueIterator);
            }
        }
        return listOfIssues;
    }

    @Override
    public List<Issue> findByCreateTime(Date createTime) {
        return issueRepository.findByCreateTime(createTime);
    }

    @Override
    public List<Issue> findByDueTime(Date dueTime) {
        return issueRepository.findByDueTime(dueTime);
    }

    @Override
    public List<Issue> findByLastUpdateTime(Date lastUpdateTime) {
        return issueRepository.findByLastUpdateTime(lastUpdateTime);
    }

    @Override
    public List<Issue> findByEstimateTime(Date estimateTime) {
        return issueRepository.findByEstimateTime(estimateTime);
    }

    @Override
    public Issue findByParent(Issue parent) {
        return issueRepository.findByParent(parent);
    }

    @Override
    public List<Issue> findAll() {
        return issueRepository.findAll();
    }

    @Override
    @Transactional
    public Issue save(Issue issue) {
        return issueRepository.saveAndFlush(issue);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        issueRepository.delete(id);
    }

    @Override
    @Transactional
    public Issue update(Issue issue) {
        return issueRepository.saveAndFlush(issue);
    }

}
