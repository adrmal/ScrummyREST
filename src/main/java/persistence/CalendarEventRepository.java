package persistence;

import model.CalendarEvent;
import org.springframework.data.repository.CrudRepository;

public interface CalendarEventRepository extends CrudRepository<CalendarEvent, String> {
}