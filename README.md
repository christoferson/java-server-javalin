# java-server-javalin
Java Server Javalin



### RouteOverviewPlugin

```
config.plugins.register(new RouteOverviewPlugin("/overview"));
```

http://localhost:7001/overview


### Exception Handling


```
app.exception(ApplicationException.class, (e, ctx) -> {
	  ctx.status(500);
	  ctx.result(e.getLocalizedMessage());
});
```

http://localhost:7001/error/throw