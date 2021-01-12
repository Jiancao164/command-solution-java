import java.util.ArrayList;
import java.util.List;


public class Command {
    public String solution(String currDirectory, String newDirectory) {
        // edge case
        if (currDirectory == null || newDirectory == null) return "";

        StringBuffer temp = new StringBuffer();
        // remove duplicate slashes
        for (int i = 0; i < newDirectory.length(); i++) {
            char c = newDirectory.charAt(i);
            if (i > 0 && c == '/' && newDirectory.charAt(i - 1) == '/') {
                continue;
            }
            temp.append(c);
        }
        newDirectory = temp.toString();

        String[] newDirectories  = newDirectory.split("/");
        // check if the new directory is valid
        for (String d : newDirectories) {
            if (d.length() == 0) continue;
            if (d.equals(".")) continue;
            if (d.equals("..")) continue;

            for (char c : d.toCharArray()) {
                if (c >= '0' && c <= '9') continue;
                if (c >= 'a' && c <= 'z') continue;
                if (c >= 'A' && c <= 'Z') continue;
                return "No such file or directory";
            }
        }

        List<String> list = new ArrayList<>();
        newDirectories = newDirectory.split("/");

        //check if the new directory is an absolute path
        if (newDirectory.charAt(0) != '/') {

            String[] currDirectories = currDirectory.split("/");
            for (String s : currDirectories) {
                if (s.length() == 0) continue;
                list.add(s);
            }

        }

        for (int i = 0; i < newDirectories.length; i++) {
            if (newDirectories[i].length() == 0) continue;
            // parse directories
            if (newDirectories[i].equals(".")) {
                continue;
            } else if (newDirectories[i].equals("..")) {
                if (list.size() > 0) list.remove(list.size() - 1);
            } else {
                list.add(newDirectories[i]);
            }
        }

        StringBuffer res = new StringBuffer("/");
        // construct the result from the list
        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i);
            if (i == 0) {
                res.append(s);
            } else {
                res.append("/" + s);
            }
        }

        return res.toString();

    }
}



