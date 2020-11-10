import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class App {
    static List<Note> notes = new ArrayList<Note>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args){
        System.out.println("Start to add new notes for your notebook");

        while (true){
            System.out.println("------------------");
            System.out.print("Add (a), print (p), remove (r), seach (s) or stop (enter): ");
            String command = scanner.nextLine();

            if (command.equals("a") || command.equals("A")){
                addNote();
            } else if (command.equals("p") || command.equals("P")){
                printNotes();
            } else if (command.equals("r") || command.equals("R")){
                removeNote();
            } else if (command.equals("s") || command.equals("S")){
                searchNote();
            } else if (command.equals("")){
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
            System.out.println(note.printNote());
            System.out.println(" ");
        }
    }

    public static void removeNote(){
        System.out.println("Remove with label: ");
        String label = scanner.nextLine();
        for (Note note: notes){
            if(label.equals(note.getLabel())){
                notes.remove(note);
                System.out.println("Removed succesfully");
            }
        }
    }

    public static void searchNote(){
        System.out.println("Search with label: ");
        String label = scanner.nextLine();
        for (Note note: notes){
            if(label.equals(note.getLabel())){
                System.out.println(note.printNote());
            }
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