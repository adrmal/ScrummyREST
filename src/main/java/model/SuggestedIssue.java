package model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Getter
@Setter
@Entity
public class SuggestedIssue {

    @Id
    @GeneratedValue(generator="uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    private String id;
    @Column
    private String summary;
    @Column
    private String description;
    @Column
    private String username;
    @Column
    private String boardId;
    @Column
    private Date createdAt;

}
