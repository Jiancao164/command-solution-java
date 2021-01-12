import static org.junit.Assert.*;
 
public class CommandTest {

    @org.junit.Test
    public void solution() {
        /* create the following directory in system
             |--def -- ghi
        abc--|--klm
             |--gh

        tmt--|
        */
        Command command = new Command();
        Folder root = new Folder("mycd");
        Folder p1 = new Folder("abc");
        p1.parent = root;

        root.subFolders.add(p1);
        Folder p2 = new Folder("def");
        p2.parent = p1;
        p1.subFolders.add(p2);
        Folder p3 = new Folder("klm");
        p3.parent = p1;
        p1.subFolders.add(p3);
        Folder p4 = new Folder("ghi");
        p4.parent = p2;
        p2.subFolders.add(p4);

        Folder p5 = new Folder("gh");
        p5.parent = p1;
        p1.subFolders.add(p5);

        Folder p6 = new Folder("tmt");
        p6.parent = root;
        root.subFolders.add(p6);



        command.root = root;

        assertEquals(command.solution("/", "abc"), "/abc");
        assertEquals(command.solution("/abc/def", "ghi"), "/abc/def/ghi");
        assertEquals(command.solution("/abc/def", ".."), "/abc");
        assertEquals(command.solution("/abc/def", "/abc"), "/abc");
        assertEquals(command.solution("/abc/def", "../.."), "/");
        assertEquals(command.solution("/abc/def", "../../.."), "/");
        assertEquals(command.solution("/abc/def", "."), "/abc/def");
        assertEquals(command.solution("/abc/def", "..klm"), "No such file or directory");
        assertEquals(command.solution("/abc/def", "//////"), "/");
        assertEquals(command.solution("/abc/def", "......"), "No such file or directory");
        assertEquals(command.solution("/abc/def", "../gh///../klm/."), "/abc/klm");
        assertEquals(command.solution("/tmt", "../abc/def/../../tmt///././."), "/tmt");
    }
}