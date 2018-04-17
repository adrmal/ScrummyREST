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
public class PlannedIssue {

    @Id
    @GeneratedValue(generator="uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    private String id;
    @Column
    private String issueKey;
    @Column
    private String username;
    @Column
    private String boardId;
    @Column
    private String jiraUrl;
    @Column
    private Date createdAt;

}
