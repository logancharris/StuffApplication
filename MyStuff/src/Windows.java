import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;
import java.util.List;

public class Windows {
    JFrame mainWindow;
    SpringLayout layout = new SpringLayout();
    JFunctions functions;
    JLabel title;
    JButton startButton;

    public Windows(){
        functions = new JFunctions();
    }

    public void startWindow() throws Exception {
        mainWindow = functions.window("My Stuff", 900, 600, "./icon.png");
        mainWindow.setLayout(layout);

        title = functions.text("Welcome to My Stuff!");
        startButton = functions.button("View My Stuff",200, 50);

        functions.setCenter(startButton, mainWindow, layout);
        functions.setLocation("HH",title,0,mainWindow,"SN",-20,startButton,layout);

        mainWindow.add(startButton);
        mainWindow.add(title);

        mainWindow.pack();
        mainWindow.setVisible(true);
    }

    public void selectWindow() throws Exception {
        clear();
        JLabel selectTitle = functions.text("Choose a Category!");
        functions.setCenter(selectTitle, mainWindow,layout,30);
        mainWindow.add(selectTitle);

        JButton books = functions.button("Books", 200, 50);
        functions.setLocation("WW",books,100,mainWindow,"NN", 100, mainWindow,layout);
        mainWindow.add(books);

        JButton tech = functions.button("Tech", 200, 50);
        functions.setLocation("WE", tech,50,books,"NN", 100, mainWindow,layout);
        mainWindow.add(tech);

        JButton collections = functions.button("Collections", 200, 50); //Collections include: Lego, Mugs, Jersey's, etc.
        functions.setLocation("WE",collections,50, tech,"NN", 100, mainWindow,layout);
        mainWindow.add(collections);

        mainWindow.pack();

        books.addActionListener(e -> {
            try {
                booksWindow();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });

        tech.addActionListener(e -> techWindow());

        collections.addActionListener(e -> {
            try {
                collectionsWindow();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });
    }

    public void booksWindow() throws Exception {
        clear();

        CSVReader reader = new CSVReader("Books.csv",false);
        List<String> entry = reader.getNext();
        List<String> titles = new LinkedList<>();
        List<String> authors = new LinkedList<>();
        List<String> genre = new LinkedList<>();

        while(reader.hasNext()) {
            entry = reader.getNext();
            titles.add(entry.get(0));
            authors.add(entry.get(1));
            genre.add(entry.get(2));
        }

        JLabel bookTitle = functions.text(titles.get(0));
        bookTitle.setFont(new Font("Times New Roman", Font.BOLD, 18));
        functions.setLocation("WW", bookTitle,100, mainWindow,"NN", 100, mainWindow, layout);
        mainWindow.add(bookTitle);
        mainWindow.pack();
    }

    public void techWindow(){
        clear();
    }

    public void collectionsWindow() throws Exception{
        clear();
        JLabel selectTitle = functions.text("Welcome to my Collections!");
        functions.setCenter(selectTitle, mainWindow,layout,30);
        mainWindow.add(selectTitle);

        JButton lego = functions.button("Lego", 200, 50);
        functions.setLocation("WW",lego,100,mainWindow,"NN", 100, mainWindow,layout);
        mainWindow.add(lego);

        JButton mugs = functions.button("Mugs", 200, 50);
        functions.setLocation("WE", mugs,50,lego,"NN", 100, mainWindow,layout);
        mainWindow.add(mugs);

        JButton jerseys = functions.button("Jerseys", 200, 50); //Collections include: Lego, Mugs, Jersey's, etc.
        functions.setLocation("WE",jerseys,50, mugs,"NN", 100, mainWindow,layout);
        mainWindow.add(jerseys);

        mainWindow.pack();
    }

    public void clear(){
        mainWindow.getContentPane().removeAll();
        mainWindow.repaint();
    }
}
