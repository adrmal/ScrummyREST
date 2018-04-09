package persistence;

import model.IssueRemark;
import org.springframework.data.repository.CrudRepository;

public interface IssueRemarkRepository extends CrudRepository<IssueRemark, Long> {
}
