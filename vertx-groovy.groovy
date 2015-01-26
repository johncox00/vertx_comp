import org.vertx.groovy.core.http.RouteMatcher

// Inspired from Sinatra / Express
def rm = new RouteMatcher()
def logger = container.logger


// Extract the params from the uri
rm.get('/:var') { req ->
  for (int i = 0; i < 100; i++) {
    logger.info(i)
  }
  // And just spit them out in the response
  req.response.end "Hello ${req.params['var']}!"
}

vertx.createHttpServer().requestHandler(rm.asClosure()).listen(8080)