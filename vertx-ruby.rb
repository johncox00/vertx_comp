require "vertx"
include Vertx

# Inspired from Sinatra / Express
rm = RouteMatcher.new

# Extract the params from the uri
rm.get('/:var') do |req| 
  (1..100).each{|t| puts t}
  req.response.end("Hello #{req.params['var']}!") 
end

HttpServer.new.request_handler(rm).listen(8080)