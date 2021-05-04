package lt.vu.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "GENRE")
@NamedQueries({
        @NamedQuery(name = "Genre.findAll", query = "select c from Genre as c")
})
@Getter
@Setter
public class Genre implements Serializable {
    public Genre()
    {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "NAME")
    private String name;

    @ManyToMany(mappedBy = "genres")
    private List<Movie> movies;

}
