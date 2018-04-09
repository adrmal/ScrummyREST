package rest;

import model.SuggestedIssue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import persistence.SuggestedIssueRepository;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
@RequestMapping(path = "/rest/suggestedIssues")
public class SuggestedIssueController {

    @Autowired
    private SuggestedIssueRepository suggestedIssueRepository;

    @RequestMapping(path = "", method = GET)
    public List<SuggestedIssue> getAllSuggestedIssues() {
        List<SuggestedIssue> suggestedIssues = new ArrayList<>();
        suggestedIssueRepository
                .findAll()
                .forEach(suggestedIssues::add);
        return suggestedIssues;
    }

}
