
import java.util.Scanner;

/**
 * Created by mmiotk on 2016-04-28.
 */
public class Solution {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int chapters = scanner.nextInt();
            int maximumNumberOfProblemsPerPage = scanner.nextInt();
            int specials = 0;
            int currentPage = 1;
            for (int i = 0; i < chapters; i++) {
                int problemsInChapter = scanner.nextInt();

                int fullPages = problemsInChapter / maximumNumberOfProblemsPerPage;
                int problemsInLastPage = problemsInChapter % maximumNumberOfProblemsPerPage;
                int pagesInChapter = fullPages + (problemsInLastPage > 0 ? 1 : 0);

                for (int page = 0; page < pagesInChapter; page++) {
                    int from = page * maximumNumberOfProblemsPerPage;
                    int to = from + maximumNumberOfProblemsPerPage;
                    if (to > problemsInChapter) {
                        to = problemsInChapter;
                    }

                    if (currentPage > from && currentPage <= to) {
                        specials++;
                    }

                    currentPage++;
                }
            }
            System.out.println(specials);
        }
    }
}
