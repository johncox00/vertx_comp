require 'sinatra'

get '/:var' do
  (1..100).each{|t| puts t}
  "Hello #{params[:var]}!"
end