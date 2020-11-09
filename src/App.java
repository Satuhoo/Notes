import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class App {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Start to add new notes for your notebook");
        System.out.println("*****************");
        List<Note> notes = new ArrayList<Note>();

        while (true){
            System.out.print("Add (a), print (p), remove (r), seach (s) or stop (enter): ");
            String command = scanner.nextLine();

            if (command.equals("a") || command.equals("A")){
                System.out.println("Label: ");
                String label = scanner.nextLine();
                System.out.println("Text: ");
                String text = scanner.nextLine();
                notes.add(new Note(label, text));
            } else if (command.equals("p") || command.equals("P")){
                for (Note note : notes){
                    System.out.println(note.printNote());
                }
            } else if (command.equals("r") || command.equals("R")){
                break; 
            } else if (command.equals("s") || command.equals("S")){
                break;
            } else if (command.equals("")){
                break;
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
}