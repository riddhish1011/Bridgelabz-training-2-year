import java.util.Locale;

/**
 * Solutions for the Library Management System DSA assignment.
 *
 * Assumptions:
 * - removeDuplicates receives books sorted by bookId.
 * - sortByPrice uses selection sort, as requested.
 * - minBooksForTargetCost expects non-negative book prices.
 */
public class LibraryManagementSystem {

    // Task 1: Remove duplicate book IDs from a bookId-sorted array in-place.
    public static int removeDuplicates(Book[] books, int n) {
        if (books == null || n <= 0) {
            return 0;
        }

        int uniqueIndex = 1;
        for (int currentIndex = 1; currentIndex < n; currentIndex++) {
            if (books[currentIndex].bookId != books[uniqueIndex - 1].bookId) {
                books[uniqueIndex] = books[currentIndex];
                uniqueIndex++;
            }
        }
        return uniqueIndex;
    }

    // Task 2: Print all books whose title contains the query, ignoring case.
    public static void searchByTitle(Book[] books, int count, String query) {
        if (books == null || query == null) {
            return;
        }

        String normalizedQuery = query.toLowerCase(Locale.ROOT);
        boolean found = false;

        for (int i = 0; i < count; i++) {
            if (books[i].title.toLowerCase(Locale.ROOT).contains(normalizedQuery)) {
                System.out.println("- Found: " + books[i]);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No books found.");
        }
    }

    // Task 3: Selection sort by price in ascending order and print swap count.
    public static void sortByPrice(Book[] books, int count) {
        if (books == null) {
            return;
        }

        int swaps = 0;
        for (int i = 0; i < count - 1; i++) {
            int minimumIndex = i;

            for (int j = i + 1; j < count; j++) {
                if (books[j].price < books[minimumIndex].price) {
                    minimumIndex = j;
                }
            }

            if (minimumIndex != i) {
                Book temp = books[i];
                books[i] = books[minimumIndex];
                books[minimumIndex] = temp;
                swaps++;
            }
        }
        System.out.println("Total Swaps: " + swaps);
    }

    // Task 4: Binary search for a price in the price-sorted array.
    public static int searchByPrice(Book[] books, int count, double targetPrice) {
        int left = 0;
        int right = count - 1;

        while (left <= right) {
            int middle = left + (right - left) / 2;
            int comparison = Double.compare(books[middle].price, targetPrice);

            if (comparison == 0) {
                return middle;
            }
            if (comparison < 0) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return -1;
    }

    // Task 5: Sliding-window solution for the shortest consecutive price total >= target.
    public static int minBooksForTargetCost(Book[] books, int count, double targetCost) {
        if (books == null || count == 0 || targetCost <= 0) {
            return 0;
        }

        int minimumLength = Integer.MAX_VALUE;
        int left = 0;
        double currentSum = 0;

        for (int right = 0; right < count; right++) {
            currentSum += books[right].price;

            while (currentSum >= targetCost) {
                minimumLength = Math.min(minimumLength, right - left + 1);
                currentSum -= books[left].price;
                left++;
            }
        }

        return minimumLength == Integer.MAX_VALUE ? 0 : minimumLength;
    }

    private static void printBooks(Book[] books, int count) {
        for (int i = 0; i < count; i++) {
            System.out.println((i + 1) + ". " + books[i]);
        }
    }

    public static void main(String[] args) {
        // Input must be sorted by bookId for Task 1.
        Book[] books = {
            new Book(101, "Data Structures", "Mark", 400.0),
            new Book(101, "Data Structures", "Mark", 400.0),
            new Book(102, "Java Basics", "James", 300.0),
            new Book(103, "Python Guide", "Guido", 600.0),
            new Book(104, "Database Systems", "Raghu", 500.0),
            new Book(105, "Computer Networks", "Andrew", 700.0)
        };

        int count = removeDuplicates(books, books.length);
        System.out.println("Unique Books Count: " + count);
        System.out.println("Book List:");
        printBooks(books, count);

        System.out.println("\nSearch Results for 'data':");
        searchByTitle(books, count, "data");

        System.out.println("\nBooks Sorted by Price:");
        sortByPrice(books, count);
        printBooks(books, count);

        double targetPrice = 500.0;
        System.out.println("\nSearching for Price Rs. " + targetPrice + "...");
        int index = searchByPrice(books, count, targetPrice);
        if (index == -1) {
            System.out.println("Result: Book not found.");
        } else {
            System.out.println("Result: Book found at index " + index + ": " + books[index]);
        }

        double targetCost = 1000.0;
        System.out.println("\nFinding minimum consecutive books whose total price >= Rs. "
                + targetCost + "...");
        System.out.println("Minimum Consecutive Books Needed: "
                + minBooksForTargetCost(books, count, targetCost));
    }
}

class Book {
    int bookId;
    String title;
    String author;
    double price;

    public Book(int bookId, String title, String author, double price) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.price = price;
    }

    @Override
    public String toString() {
        return "[" + bookId + "] " + title + " (Rs. " + price + ")";
    }
}
