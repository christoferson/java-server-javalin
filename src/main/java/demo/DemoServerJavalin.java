package demo;

import io.javalin.Javalin;
import io.javalin.http.Context;
import io.javalin.http.Handler;

public class DemoServerJavalin {

	public static void main(String[] args) {

	    Javalin app = Javalin.create(config -> {
	    	config.http.defaultContentType = "application/json";
	    });
	    app.get("/", ctx -> ctx.result("Foo Bar " + System.currentTimeMillis()));
	    app.get("/static/method", DemoServerJavalin::mstatic);
	    app.get("/static/lambda", DemoServerJavalin.mstaticl);

	    app.start(7001);
	    
	}

	public static void mstatic(Context ctx) {
		ctx.result("Static Method: " + System.currentTimeMillis());
	}
	
	public static Handler mstaticl = ctx -> {
	    ctx.result("Static Lambda: " + System.currentTimeMillis());
	};

}
