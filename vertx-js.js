var vertx = require('vertx');
var console = require('vertx/console');

// Inspired from Sinatra / Express
var rm = new vertx.RouteMatcher();

// Extract the params from the uri
rm.get('/:var', function(req) {
  for(i=0; i<100; i++)
    console.log(i);
  req.response.end("Hello " + req.params().get('var') + "!")
});

vertx.createHttpServer().requestHandler(rm).listen(8080);