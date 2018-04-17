package rest;

import model.CalendarEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import persistence.CalendarEventRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
@RequestMapping(path = "/rest/events")
public class CalendarEventController {

    @Autowired
    private CalendarEventRepository calendarEventRepository;

    @RequestMapping(path = "", method = GET)
    public List<CalendarEvent> getAllCalendarEvents(
            @RequestParam(required = false) String boardId,
            @RequestParam(required = false) String username,
            @RequestParam(required = false) String jiraUrl) {
        List<CalendarEvent> events = new ArrayList<>();
        calendarEventRepository
                .findAll()
                .forEach(events::add);

        if(boardId != null && !boardId.isEmpty()) {
            events = events
                    .stream()
                    .filter(event -> event.getBoardId().equals(boardId))
                    .collect(Collectors.toList());
        }

        if(username != null && !username.isEmpty()) {
            events = events
                    .stream()
                    .filter(event -> event.getUsername().equals(username))
                    .collect(Collectors.toList());
        }

        if(jiraUrl != null && !jiraUrl.isEmpty()) {
            events = events
                    .stream()
                    .filter(event -> event.getJiraUrl().equals(jiraUrl))
                    .collect(Collectors.toList());
        }

        return events;
    }

    @RequestMapping(path = "/{eventId}", method = GET)
    public CalendarEvent getCalendarEvent(@PathVariable String eventId) {
        return calendarEventRepository.findById(eventId).orElse(null);
    }

    @RequestMapping(method = POST)
    public CalendarEvent addCalendarEvent(@RequestBody CalendarEvent event) {
        return calendarEventRepository.save(event);
    }

    @RequestMapping(path = "/{eventId}", method = PUT)
    public void updateCalendarEvent(@RequestBody CalendarEvent event, @PathVariable String eventId) {
        calendarEventRepository.save(event);
    }

    @RequestMapping(method = DELETE)
    public void deleteAllCalendarEvents(
            @RequestParam(required = true) String boardId,
            @RequestParam(required = true) String username,
            @RequestParam(required = true) String jiraUrl) {
        List<CalendarEvent> events = new ArrayList<>();
        calendarEventRepository
                .findAll()
                .forEach(events::add);

        events = events
                .stream()
                .filter(event -> event.getBoardId().equals(boardId))
                .collect(Collectors.toList());

        events = events
                .stream()
                .filter(event -> event.getUsername().equals(username))
                .collect(Collectors.toList());

        events = events
                .stream()
                .filter(event -> event.getJiraUrl().equals(jiraUrl))
                .collect(Collectors.toList());

        calendarEventRepository.deleteAll(events);
    }

    @RequestMapping(path = "/{eventId}", method = DELETE)
    public void deleteCalendarEvent(@PathVariable String eventId) {
        calendarEventRepository.deleteById(eventId);
    }

}
