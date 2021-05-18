package lt.vu.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "MOVIE")
@NamedQueries({
        @NamedQuery(name = "Movie.findAll", query = "select m from Movie as m"),
})
@Getter
@Setter
public class Movie implements Serializable {
    public Movie()
    {

    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Version
    private Integer version;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "REVENUE")
    private double revenue;

    @Column(name = "RATING")
    private Integer rating;

    @ManyToOne
    @JoinColumn(name="COMPANY_ID")
    private Company company;

    @ManyToMany
    @JoinTable(name = "GENRE_MOVIE",
            joinColumns = @JoinColumn(name = "MOVIE_ID"),
            inverseJoinColumns = @JoinColumn(name = "GENRE_ID"))
    private List<Genre> genres;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return Objects.equals(id, movie.id) &&
                Objects.equals(movie, movie.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title);
    }

//    @Override
//    public String toString() {
//        StringBuilder name = new StringBuilder(title + "(");
//        for(Genre g : genres)
//        {
//            name.append(g.getName()).append(",");
//        }
//        name.append(")");
//        return name.toString();
//    }

}
