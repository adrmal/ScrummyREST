package rest;

import model.CalendarEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import persistence.CalendarEventRepository;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping(path = "/rest/events")
public class CalendarEventController {

    @Autowired
    private CalendarEventRepository calendarEventRepository;

    @RequestMapping(path = "", method = GET)
    public List<CalendarEvent> getAllCalendarEvents() {
        List<CalendarEvent> events = new ArrayList<>();
        calendarEventRepository
                .findAll()
                .forEach(events::add);
        return events;
    }

}
