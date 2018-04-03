package rest;

import model.CalendarEvent;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping(path = "/rest/events")
public class CalendarEventController {

    @RequestMapping(path = "", method = GET)
    public List<CalendarEvent> getAllCalendarEvents() {
        return new ArrayList<>();
    }

}
