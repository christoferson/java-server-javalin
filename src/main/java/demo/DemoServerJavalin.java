package demo;

import io.javalin.Javalin;

public class DemoServerJavalin {

	public static void main(String[] args) {

	    Javalin app = Javalin.create().start(7001);
	    app.get("/", ctx -> ctx.result("Foo Bar " + System.currentTimeMillis()));

	}

}
