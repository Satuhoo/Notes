import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class App {
    static List<Note> notes = new ArrayList<Note>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args){
        System.out.println("Start to add new notes for your notebook");

        while (true){
            System.out.println(" ");
            System.out.println("------------------");
            System.out.println("A: Add note \nP: Print notes \nR: Remove note \nS: Search note \nQ: Quit: ");
            String command = scanner.nextLine();

            if (command.equals("Q") || command.equals("q")){
                break;
            }

            switch (command){
                case "A": case "a":
                    addNote();
                    break;
                case "P": case "p":
                    printNotes();
                    break;
                case "R": case "r":
                    removeNote();
                    break;
                case "S": case "s":
                    searchNote();
                    break;
            }
        }
    }

    public static void addNote(){
        System.out.println("Label: ");
        String label = scanner.nextLine();
        System.out.println("Text: ");
        String text = scanner.nextLine();
        notes.add(new Note(label, text));
    }

    public static void printNotes(){
        for (Note note : notes){
            System.out.println(" ");
            System.out.println(note.printNote());
        }
    }

    public static void removeNote(){
        System.out.println("Remove with label: ");
        String label = scanner.nextLine();
        Note remove = null;
        for (Note note: notes){
            if(label.equals(note.getLabel())){
                remove = note;
            }
        }
        if (remove != null){
            notes.remove(remove);
            System.out.println("Removed succesfully");
        } else {
            System.out.println("Not found");
        }
    }

    public static void searchNote(){
        System.out.println("Search with label: ");
        String label = scanner.nextLine();
        String print = null;
        for (Note note: notes){
            if(label.equals(note.getLabel())){
                print = note.printNote();
            }
        }
        if (print != null){
            System.out.println(" ");
            System.out.println(print);
        } else {
            System.out.println("Not found");
        }
    }
}

class Note {
    String label;
    String text;

    public Note(String label, String text){
        super();
        this.label = label;
        this.text = text;
    }

    public String printNote(){
        String note = "NOTE: " + label + "\n      " + text;
        return note;
    }

    public String getLabel(){
        return label;
    }
}