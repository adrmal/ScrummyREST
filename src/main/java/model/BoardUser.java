package model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class BoardUser {

    @Id
    @GeneratedValue(generator="uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    private String id;
    @Column
    private String username;
    @Column
    private String userRole;
    @Column
    private String boardId;

}
