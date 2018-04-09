package persistence;

import model.SuggestedIssue;
import org.springframework.data.repository.CrudRepository;

public interface SuggestedIssueRepository extends CrudRepository<SuggestedIssue, Long> {
}
