package ua.horbatiuk88;

import org.h2.tools.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.SQLException;

@SpringBootApplication
public class UserManagerApplication {

	public static void main(String[] args) throws SQLException {
		Server server = Server.createTcpServer(args).start();
		SpringApplication.run(UserManagerApplication.class, args);
		server.stop();
	}
}
