package rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import persistence.*;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
@RequestMapping(path = "/rest/utils")
public class UtilController {

    private static final String JIRA_URL_SUFFIX = ".atlassian.net";
    private static final String HTTPS = "https://";
    private static final String SLASH = "/";

    @Autowired
    private BoardUserRepository boardUserRepository;
    @Autowired
    private CalendarEventRepository calendarEventRepository;
    @Autowired
    private ChatMessageRepository chatMessageRepository;
    @Autowired
    private IssueRemarkRepository issueRemarkRepository;
    @Autowired
    private NoteRepository noteRepository;
    @Autowired
    private PlannedIssueRepository plannedIssueRepository;
    @Autowired
    private SuggestedIssueRepository suggestedIssueRepository;

    @RequestMapping(path = "/url", method = PUT)
    public void updateJiraUrlInAllEntities(@RequestParam String oldPrefix,
                                           @RequestParam String newPrefix) {
        boardUserRepository.findAll().forEach(boardUser -> {
            if(boardUser.getJiraUrl().contains(oldPrefix + JIRA_URL_SUFFIX)) {
                boardUser.setJiraUrl(HTTPS + newPrefix + JIRA_URL_SUFFIX + SLASH);
                boardUserRepository.save(boardUser);
            }
        });
        calendarEventRepository.findAll().forEach(calendarEvent -> {
            if(calendarEvent.getJiraUrl().contains(oldPrefix + JIRA_URL_SUFFIX)) {
                calendarEvent.setJiraUrl(HTTPS + newPrefix + JIRA_URL_SUFFIX + SLASH);
                calendarEventRepository.save(calendarEvent);
            }
        });
        chatMessageRepository.findAll().forEach(chatMessage -> {
            if(chatMessage.getJiraUrl().contains(oldPrefix + JIRA_URL_SUFFIX)) {
                chatMessage.setJiraUrl(HTTPS + newPrefix + JIRA_URL_SUFFIX + SLASH);
                chatMessageRepository.save(chatMessage);
            }
        });
        issueRemarkRepository.findAll().forEach(issueRemark -> {
            if(issueRemark.getJiraUrl().contains(oldPrefix + JIRA_URL_SUFFIX)) {
                issueRemark.setJiraUrl(HTTPS + newPrefix + JIRA_URL_SUFFIX + SLASH);
                issueRemarkRepository.save(issueRemark);
            }
        });
        noteRepository.findAll().forEach(note -> {
            if(note.getJiraUrl().contains(oldPrefix + JIRA_URL_SUFFIX)) {
                note.setJiraUrl(HTTPS + newPrefix + JIRA_URL_SUFFIX + SLASH);
                noteRepository.save(note);
            }
        });
        plannedIssueRepository.findAll().forEach(plannedIssue -> {
            if(plannedIssue.getJiraUrl().contains(oldPrefix + JIRA_URL_SUFFIX)) {
                plannedIssue.setJiraUrl(HTTPS + newPrefix + JIRA_URL_SUFFIX + SLASH);
                plannedIssueRepository.save(plannedIssue);
            }
        });
        suggestedIssueRepository.findAll().forEach(suggestedIssue -> {
            if(suggestedIssue.getJiraUrl().contains(oldPrefix + JIRA_URL_SUFFIX)) {
                suggestedIssue.setJiraUrl(HTTPS + newPrefix + JIRA_URL_SUFFIX + SLASH);
                suggestedIssueRepository.save(suggestedIssue);
            }
        });
    }

}
