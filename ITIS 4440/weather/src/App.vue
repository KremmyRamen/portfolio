<script setup> 
// base url is good practice in case we have multiple API calls 
var base_url = "https://api.openweathermap.org/data/2.5/"; 
// our query keeps track of which city we are getting weather data about 
var query = 'Charlotte'; 
// insert your API key in the string. Usually we would use an environment 
// variable but since we all may be using different build tools just 
// plug in your api_key here. 
var api_key = 'e76a258e7b54d6a634d41b84590855cd'; 
 
// defining our request options, since we are receiving data it is GET 
var requestOptions = { 
  method: "GET", 
  redirect: "follow", 
}; 
 
// using fetch and giving it two parameters, our url and our requestsOptions 
fetch(`${base_url}weather?q=${query}&appid=${api_key}&units=imperial`, requestOptions) 
  // our .then() will handle the response once it arrives 
  .then((response) => { return response.json(); }) 
  // our response.json() is not synchronous either so we have another .then() 
  // this one will display our result to the console 
  .then((result) => console.log(result)) 
  // in case there is an error with our query or url this .catch() will catch 
  // our error 
  .catch((error) => console.log("Error", error)); 
</script>
 
<template> 
  <div> 
    <div> 
    </div> 
    <div> 
    </div> 
    <div> 
    </div> 
    <input> 
  </div> 
</template> 
 
<style> 
</style>