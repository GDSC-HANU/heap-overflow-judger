package hanu.gdsc.infrastructure.repositories.submissionEvent;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EventJPARepository extends JpaRepository<SubmissionEventEntity, String> {
}
