package persistence;

import model.PlannedIssue;
import org.springframework.data.repository.CrudRepository;

public interface PlannedIssueRepository extends CrudRepository<PlannedIssue, String> {
}
