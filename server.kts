import java.io.*
import java.net.ServerSocket
import java.net.Socket
import java.util.Scanner

val port = 8081;
val serverSocket = ServerSocket(port);
println("listening port: " + port.toString());

while (true) {
    val clientSocket = serverSocket.accept();
    System.err.println("error");

    val `in` = BufferedReader(InputStreamReader(clientSocket.getInputStream()));
    val out = BufferedWriter(OutputStreamWriter(clientSocket.getOutputStream()));

    var s = "";
    do {
        s = `in`.readLine()
        println(s);
    } while (!s.isNullOrEmpty())

    val body = """
        <!DOCTYPE html><html><head><title>Exemple</title></head><body><p>Server exemple.</p></body></html>
    """.trimIndent()

    out.write("HTTP/1.0 200 OK\r\n");
    out.write("Date: Fri, 31 Dec 1999 23:59:59 GMT\r\n");
    out.write("Server: Apache/0.8.4\r\n");
    out.write("Content-Type: text/html\r\n");
    out.write("Content-Length: ${body.toByteArray().size}\r\n");
    out.write("Expires: Sat, 01 Jan 2000 00:59:59 GMT\r\n");
    out.write("Last-modified: Fri, 09 Aug 1996 14:21:40 GMT\r\n");
    out.write("\r\n");
    out.write(body)

    out.close();
    `in`.close();
    clientSocket.close();
}
