package com.softserverinc.edu.repositories;

import com.softserverinc.edu.entities.Issue;
import com.softserverinc.edu.entities.Project;
import com.softserverinc.edu.entities.ProjectRelease;
import com.softserverinc.edu.entities.enums.ReleaseStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectReleaseRepository extends JpaRepository<ProjectRelease, Long> {

    List<ProjectRelease> findByProject(Project project);

    ProjectRelease findByIssues(Issue issue);

    List<ProjectRelease> findByVersion(String version);

    List<ProjectRelease> findByReleaseStatus(ReleaseStatus releaseStatus);

}
