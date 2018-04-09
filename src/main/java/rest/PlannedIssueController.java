package rest;

import model.PlannedIssue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import persistence.PlannedIssueRepository;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
@RequestMapping(path = "/rest/plannedIssues")
public class PlannedIssueController {

    @Autowired
    private PlannedIssueRepository plannedIssueRepository;

    @RequestMapping(path = "", method = GET)
    public List<PlannedIssue> getAllPlannedIssues() {
        List<PlannedIssue> plannedIssues = new ArrayList<>();
        plannedIssueRepository
                .findAll()
                .forEach(plannedIssues::add);
        return plannedIssues;
    }

}
