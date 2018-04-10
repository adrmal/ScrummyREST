package rest;

import model.SuggestedIssue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import persistence.SuggestedIssueRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
@RequestMapping(path = "/rest/suggestedIssues")
public class SuggestedIssueController {

    @Autowired
    private SuggestedIssueRepository suggestedIssueRepository;

    @RequestMapping(path = "", method = GET)
    public List<SuggestedIssue> getAllSuggestedIssues(
            @RequestParam(required = false) String boardId) {
        List<SuggestedIssue> issues = new ArrayList<>();
        suggestedIssueRepository
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
    public SuggestedIssue getSuggestedIssue(@PathVariable String issueId) {
        return suggestedIssueRepository.findById(issueId).orElse(null);
    }

    @RequestMapping(method = POST)
    public void addSuggestedIssue(@RequestBody SuggestedIssue issue) {
        suggestedIssueRepository.save(issue);
    }

    @RequestMapping(path = "/{issueId}", method = PUT)
    public void updateSuggestedIssue(@RequestBody SuggestedIssue issue, @PathVariable String issueId) {
        suggestedIssueRepository.save(issue);
    }

    @RequestMapping(path = "/{issueId}", method = DELETE)
    public void deleteSuggestedIssue(@PathVariable String issueId) {
        suggestedIssueRepository.deleteById(issueId);
    }

}
