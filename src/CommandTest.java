import static org.junit.Assert.*;
 
public class CommandTest {

    @org.junit.Test
    public void solution() {

        Command command = new Command();


        assertEquals(command.solution("/", "abc"), "/abc");
        assertEquals(command.solution("/abc/def", "ghi"), "/abc/def/ghi");
        assertEquals(command.solution("/abc/def", ".."), "/abc");
        assertEquals(command.solution("/abc/def", "/abc"), "/abc");
        assertEquals(command.solution("/abc/def", "/abc/klm"), "/abc/klm");
        assertEquals(command.solution("/abc/def", "../.."), "/");
        assertEquals(command.solution("/abc/def", "../../.."), "/");
        assertEquals(command.solution("/abc/def", "."), "/abc/def");
        assertEquals(command.solution("/abc/def", "..klm"), "No such file or directory");
        assertEquals(command.solution("/abc/def", "//////"), "/");
        assertEquals(command.solution("/abc/def", "......"), "No such file or directory");
        assertEquals(command.solution("/abc/def", "../gh///../klm/."), "/abc/klm");

        assertEquals(command.solution("/a/b/c", "d/"), "/a/b/c/d");
        assertEquals(command.solution("/l/n/m", "o"), "/l/n/m/o");
        assertEquals(command.solution("/a/b/c", "/./../a/../b/../"), "/");
        assertEquals(command.solution("/a/b/c", "../../c/"), "/a/c");
        assertEquals(command.solution("/a/b/c", "../b/c"), "/a/b/b/c");


    }
}