package lt.vu.reviewFinder;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Alternative;
import javax.enterprise.inject.Specializes;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;

@Alternative
@Specializes
@SessionScoped
public class ReviewFinderExtendedComponent extends ReviewFinderComponent {
    private final List<String> mockExternalData = new ArrayList<String>() {
        {
            add("To be faced with the challenge of adapting Harry Potter for the Silver screen must have been any director's nightmare- the chance of directing possibly the biggest film of this decade, but also the hardest audience-the millions of fans of the book who know every line and will pick up on every mistake. Being one of the above, I can only say that Christopher Columbus and all of the team working on HP did marvelously. The cast was brilliant (particularly notable are Alan Rickman as Snape, Maggie Smith as McGonagall, and the eerily creepy David Bradley as Argus Filch), the directing wonderful, and the scenery perfect. The only qualm is that it does not track perfectly with the book, but squeezed into 2.5 hours, this can only be expected. Well done all involved!");
            add("To millions of children of all ages, November 16 has been more eagerly anticipated than Christmas, as the long-awaited film version of J. K. Rowling's beloved novel \"Harry Potter and the Sorceror's Stone\" hits the screen.\n" +
                    "\n" +
                    "Each of Rowling's four Harry Potter books have been critically acclaimed worldwide best-sellers, turning a generation of video-game playing children into avid readers.\n" +
                    "\n" +
                    "In translating Rowling's world of wizards and magic to the screen, the film makers claimed to be intensely aware of the fans' high expectations and had sworn to be faithful to the book.\n" +
                    "\n" +
                    "\"Harry Potter and the Sorceror's Stone\" is indeed the most loyal film adaptation of a book that this fan has ever seen.\n" +
                    "\n" +
                    "It's the story of an orphaned boy who discovers on his eleventh birthday that his parents were wizards and that he is in fact a famous and powerful wizard himself.\n" +
                    "\n" +
                    "Released from the clutches of his desperately ordinary (and non-magical) Uncle Vernon and Aunt Petunia - and their deliciously obnoxious son Dudley - Harry takes his place in the wizarding world as a first year student at the venerated Hogwarts School of Witchcraft and Wizardry.\n" +
                    "\n" +
                    "A great deal of \"Harry Potter and the Sorceror's Stone\" is an introduction to this fantastic and dangerous world and its richly drawn characters. There's not only a lot of plot to cover in this film, but an entire world to create.\n" +
                    "\n" +
                    "At two and a half hours long (hit the restroom before it starts), the film includes the book's most memorable scenes, bringing many of them to life with pure cinematic wizardry.\n" +
                    "\n" +
                    "The Quidditch match (a soccer/hockey/rugby thing played on broomsticks) is much more exciting on the screen than on the page, as is the bathroom battle with an enormous mountain troll and the larger-than-life game of wizard's chess.\n" +
                    "\n" +
                    "The frightening aspects of the book are in full force in the film, and its PG rating (for some scary moments) should be taken seriously.\n" +
                    "\n" +
                    "Screenwriter Steven Kloves (\"Wonder Boys\") has done a fine job of streamlining Rowling's tale while maintaining its spirit. Director Chris Columbus (\"Home Alone\") makes good on his promise to be faithful to the book. But at times the film is a bit too reverent; you want the actors to cut loose and have a bit more fun.\n" +
                    "\n" +
                    "Columbus clearly understands that fantasy works best when it's played most real. Across the board, his fine ensemble of actors are so perfectly cast that they appear to have literally stepped out of Rowling's book.\n" +
                    "\n" +
                    "In the title role, Daniel Radcliffe pulls off the very difficult task of playing an introverted hero who spends most of the movie reacting to the amazing sights and events around him. He beautifully captures the deep soul and untapped potential of Harry Potter. And when this kid smiles the screen lights up.\n" +
                    "\n" +
                    "Rupert Grint is delightful as Harry's sardonic buddy Ron Weasley and Emma Watson nearly steals the film as their overachieving friend Hermione Granger. Three cheers to the film makers for giving three unknown child actors the top billing they deserve.\n" +
                    "\n" +
                    "The strong cast of veteran actors includes Richard Harris as the wise Headmaster Dumbledore and Robbie Coltrane as the lovable giant Hagrid. Alan Rickman is wonderfully villainous as Professor Snape and Zoe Wanamaker has just the right touch of girls gym teacher as flying instructor Madame Hooch.\n" +
                    "\n" +
                    "As the strict but just Professor McGonagall, Oscar winner Maggie Smith seems born to play the role - and is ready for another Oscar.\n" +
                    "\n" +
                    "John Cleese (as Nearly Headless Nick) and Julie Walters (as Mrs. Weasley) have all-too-brief cameo roles, but if the next film \"Harry Potter and the Chamber of Secrets\" remains true to the book, we'll be seeing more of them.\n" +
                    "\n" +
                    "In addition to being highly engaging, the film is a marvelous thing to look at. From the bustling wizard street Diagon Alley to the magnificently gothic Hogwarts School to the dark and misty Forbidden Forest, the film breaks new ground in imaginative production design.\n" +
                    "\n" +
                    "To paraphrase the film's tagline, let the magic (and box office records) begin.\n");
            add("This movie is a delight for those of all ages.\n" +
                    "\n" +
                    "I have seen it several times and each time I am enchanted by the characters and magic.\n" +
                    "\n" +
                    "The cast is outstanding, the special effects delightful, everything most believable.\n" +
                    "\n" +
                    "You have young Harry, a mistreated youth who is \"Just Harry\" to himself. And then, he embarks on a most beautiful adventure to the Hogwarts school.\n" +
                    "\n" +
                    "He meets Ron and Hermione, one an adorable mischief maker, the other a very tense and studious young lady.\n" +
                    "\n" +
                    "Together, the trio try to set things right in the school.\n" +
                    "\n" +
                    "It's the ultimate fantasy for young and old.");
            add("When I knew the film was being made, I thought how could they make a film that would be up to the standard of such a perfect book. But they did! Sure they missed bits out but they captured the essence of the book brilliantly. One member of the cast was mis-cast for me but my children disagreed.I even found myself believing they were flying and not wondering \"how are they doing that?\" So 10 out 10 Warner Brothers. Bring on the next one!");
            add("I watched all Harry Potter movies when I was 7 years old. After five years I watched the movies again at 12 years old and I feel this saga a classic, well, it is a classic. I started reading the first book like one day ago. Which my mom gave to me when I was a little kid. I like Harry Potter a lot and I would watch all the saga again");
        }
    };

    public CompletableFuture<String> findNewReviewAsync() throws InterruptedException {
        Random rand = new Random();
        CompletableFuture<String> completableFuture = new CompletableFuture<>();

        Executors.newCachedThreadPool().submit(() -> {
            Thread.sleep(200);
            int index = rand.nextInt(mockExternalData.size());
            completableFuture.complete(mockExternalData.get(index));
            return null;
        });

        return completableFuture;
    }
}
