package model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Getter
@Setter
@Entity
public class CalendarEvent {

    @Id
    @GeneratedValue
    private Long id;
    @Column
    private Date date;
    @Column
    private String content;
    @Column
    private String userId;

}
