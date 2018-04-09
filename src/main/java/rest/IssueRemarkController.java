package rest;

import model.IssueRemark;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import persistence.IssueRemarkRepository;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
@RequestMapping(path = "/rest/remarks")
public class IssueRemarkController {

    @Autowired
    private IssueRemarkRepository issueRemarkRepository;

    @RequestMapping(path = "", method = GET)
    public List<IssueRemark> getAllIssueRemarks() {
        List<IssueRemark> issueRemarks = new ArrayList<>();
        issueRemarkRepository
                .findAll()
                .forEach(issueRemarks::add);
        return issueRemarks;
    }

}
