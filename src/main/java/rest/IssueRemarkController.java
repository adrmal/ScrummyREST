package rest;

import model.IssueRemark;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import persistence.IssueRemarkRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
@RequestMapping(path = "/rest/remarks")
public class IssueRemarkController {

    @Autowired
    private IssueRemarkRepository issueRemarkRepository;

    @RequestMapping(path = "", method = GET)
    public List<IssueRemark> getAllIssueRemarks(
            @RequestParam(required = false) String boardId,
            @RequestParam(required = false) String jiraUrl) {
        List<IssueRemark> remarks = new ArrayList<>();
        issueRemarkRepository
                .findAll()
                .forEach(remarks::add);

        if(boardId != null && !boardId.isEmpty()) {
            remarks = remarks
                    .stream()
                    .filter(remark -> remark.getBoardId().equals(boardId))
                    .collect(Collectors.toList());
        }

        if(jiraUrl != null && !jiraUrl.isEmpty()) {
            remarks = remarks
                    .stream()
                    .filter(remark -> remark.getJiraUrl().equals(jiraUrl))
                    .collect(Collectors.toList());
        }

        return remarks;
    }

    @RequestMapping(path = "/{remarkId}", method = GET)
    public IssueRemark getIssueRemark(@PathVariable String remarkId) {
        return issueRemarkRepository.findById(remarkId).orElse(null);
    }

    @RequestMapping(method = POST)
    public IssueRemark addIssueRemark(@RequestBody IssueRemark remark) {
        return issueRemarkRepository.save(remark);
    }

    @RequestMapping(path = "/{remarkId}", method = PUT)
    public void updateIssueRemark(@RequestBody IssueRemark remark, @PathVariable String remarkId) {
        issueRemarkRepository.save(remark);
    }

    @RequestMapping(path = "/{remarkId}", method = DELETE)
    public void deleteIssueRemark(@PathVariable String remarkId) {
        issueRemarkRepository.deleteById(remarkId);
    }

}
