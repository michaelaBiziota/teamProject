jQuery(Load);
function Load($) {
var slider = document.getElementById("myRange");
var output = document.getElementById("year");
output.innerHTML = slider.value;
slider.oninput = function () {
   output.innerHTML = this.value;
};


$("#myRange").on("keyup click",function(){
    $("#pages").html("");
   var currentVal=slider.value;
     if($(".active").attr("id")==="popular"){
    URL = "https://api.themoviedb.org/3/discover/movie?api_key=e58e3961f5be7e510894dc736fee6937&language=en-US&sort_by=popularity.desc&include_adult=false&page=1&vote_count.gte=200&primary_release_year="+currentVal;
   }else if($(".active").attr("id")==="toprated"){
     URL = "https://api.themoviedb.org/3/discover/movie?api_key=e58e3961f5be7e510894dc736fee6937&language=en-US&sort_by=vote_average.desc&include_adult=false&include_video=false&page=1&vote_count.gte=700&primary_release_year="+currentVal;
   }//TODO
   $.ajax({

       url: URL,
       success: handleResponse,
       error: handleError
   });


   function handleResponse(data) {
       $("#movies").html("");
       console.log(data);
       for (i = 0; i < 20; i++) {
           if(data.results[i].poster_path!==null){
           $("#movies").append("<div class='col-md-3'><div class=' text-center'><a href='getMovie/"+data.results[i].id+"'><img src='https://image.tmdb.org/t/p/w300" + data.results[i].poster_path + "'></a><h5 id='moviestitle'>"+data.results[i].title+"</h5></div></div>");

       }
       }
   };
   function handleError(jqXHR, textStatus, errorThrown) {
       console.log(textStatus, errorThrown);

   };
});
}