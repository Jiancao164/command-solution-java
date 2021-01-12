import static org.junit.Assert.*;
 
public class CommandTest {

    @org.junit.Test
    public void solution() {

        Command command = new Command();


        assertEquals("/abc", command.solution("/", "abc"));
        assertEquals("/abc/def/ghi", command.solution("/abc/def", "ghi"));
        assertEquals("/abc", command.solution("/abc/def", ".."));
        assertEquals("/abc", command.solution("/abc/def", "/abc"));
        assertEquals("/abc/klm", command.solution("/abc/def", "/abc/klm"));
        assertEquals("/", command.solution("/abc/def", "../.."));
        assertEquals("/", command.solution("/abc/def", "../../.."));
        assertEquals("/abc/def", command.solution("/abc/def", "."));
        assertEquals("No such file or directory", command.solution("/abc/def", "..klm"));
        assertEquals("/", command.solution("/abc/def", "//////"));
        assertEquals("No such file or directory", command.solution("/abc/def", "......"));
        assertEquals("/abc/klm", command.solution("/abc/def", "../gh///../klm/."));

        assertEquals( "/a/b/c/d", command.solution("/a/b/c", "d/"));
        assertEquals("/l/n/m/o", command.solution("/l/n/m", "o"));
        assertEquals("/", command.solution("/a/b/c", "/./../a/../b/../"));
        assertEquals("/a/c", command.solution("/a/b/c", "../../c/"));
        assertEquals("/a/b/b/c", command.solution("/a/b/c", "../b/c"));


    }
}