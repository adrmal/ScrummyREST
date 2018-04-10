package rest;

import model.PlannedIssue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import persistence.PlannedIssueRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
@RequestMapping(path = "/rest/plannedIssues")
public class PlannedIssueController {

    @Autowired
    private PlannedIssueRepository plannedIssueRepository;

    @RequestMapping(path = "", method = GET)
    public List<PlannedIssue> getAllPlannedIssues(
            @RequestParam(required = false) String boardId) {
        List<PlannedIssue> issues = new ArrayList<>();
        plannedIssueRepository
                .findAll()
                .forEach(issues::add);

        if(boardId != null && !boardId.isEmpty()) {
            issues = issues
                    .stream()
                    .filter(issue -> issue.getBoardId().equals(boardId))
                    .collect(Collectors.toList());
        }

        return issues;
    }

    @RequestMapping(path = "/{issueId}", method = GET)
    public PlannedIssue getPlannedIssue(@PathVariable String issueId) {
        return plannedIssueRepository.findById(issueId).orElse(null);
    }

    @RequestMapping(method = POST)
    public void addPlannedIssue(@RequestBody PlannedIssue issue) {
        plannedIssueRepository.save(issue);
    }

    @RequestMapping(path = "/{issueId}", method = DELETE)
    public void deletePlannedIssue(@PathVariable String issueId) {
        plannedIssueRepository.deleteById(issueId);
    }

}
