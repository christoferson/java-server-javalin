package demo;

import demo.exceptions.ApplicationException;
import io.javalin.Javalin;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import io.javalin.plugin.bundled.RouteOverviewPlugin;

public class DemoServerJavalin {

	public static void main(String[] args) {

	    Javalin app = Javalin.create(config -> {
	    	//config.http.defaultContentType = "application/json";
	    	config.plugins.register(new RouteOverviewPlugin("/overview"));
	    });
	    app.get("/", ctx -> ctx.result("Foo Bar " + System.currentTimeMillis()));
	    app.get("/static/method", DemoServerJavalin::mstatic);
	    app.get("/static/lambda", DemoServerJavalin.mstaticl);
	    app.get("/error/throw", ctx -> { throw new ApplicationException("Error " + System.currentTimeMillis()); });
	    
	    app.exception(ApplicationException.class, (e, ctx) -> {
	    	  ctx.status(500);
	    	  ctx.result(e.getLocalizedMessage());
	    });

	    app.start(7001);
	    
	}

	public static void mstatic(Context ctx) {
		ctx.result("Static Method: " + System.currentTimeMillis());
	}
	
	public static Handler mstaticl = ctx -> {
	    ctx.result("Static Lambda: " + System.currentTimeMillis());
	};

}
