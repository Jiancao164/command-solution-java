import java.util.ArrayList;
import java.util.List;

// A class to simulate a directory in the system
class Folder {
    // current folder's name
    String name;
    // the parent folder
    Folder parent;
    // all sub-folders
    List<Folder> subFolders;

    public Folder(String name) {
        this.name = name;
        subFolders = new ArrayList<>();
    }
}

public class Command {
        Folder root;
        String solution(String currentDirectory, String newDirectory) {
            if (newDirectory == null || newDirectory.length() == 0) return "";
            String[] folders = currentDirectory.split("/");

            List<String> list = new ArrayList<>();

            Folder path = root;
            // move the path's pointer to the current directory
            for (int i = 0; i < folders.length; i++) {
                // skip edge case, ""
                if (folders[i].length() == 0) continue;
                for (Folder p : path.subFolders) {
                    if (p.name.equals(folders[i])) {
                        path = p;
                        list.add(p.name);
                        break;
                    }
                }
            }

            StringBuffer sb = new StringBuffer(newDirectory);
            int idx = 0;
            // remove duplicate slashes
            while (idx < sb.length()) {
                if (idx - 1 >= 0 && sb.charAt(idx - 1) == '/' && sb.charAt(idx) == '/') {
                    sb.deleteCharAt(idx);
                } else {
                    idx++;
                }
            }
            newDirectory = sb.toString();
            //check if the new directory is an absolute path
            if (newDirectory.charAt(0) == '/') {
                path = root;
                newDirectory = newDirectory.substring(1);
                folders = newDirectory.split("/");
                list = new ArrayList<>();

            } else {
                folders = newDirectory.split("/");
            }

            for (int i = 0; i < folders.length; i++) {
                //skip edge cases like when newDirectory is "/"
                if (folders[i].length() == 0) continue;
                // parse directories
                if (folders[i].equals(".")) {
                    continue;
                } else if (folders[i].equals("..")) {
                    if(path.parent != null) path = path.parent;
                    if (list.size() > 0) list.remove(list.size() - 1);
                } else {
                    boolean flag = true;
                    for (Folder p : path.subFolders) {
                        if (p.name.equals(folders[i])) {
                            list.add(p.name);
                            path = p;
                            flag = false;
                            break;
                        }
                    }
                    if (flag) return "No such file or directory";
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



