jQuery(Load);
function Load($) {


    //MAIN PAGE MOST POPULAR
    let URL = "https://api.themoviedb.org/3/discover/movie?api_key=e58e3961f5be7e510894dc736fee6937&language=en-US&sort_by=popularity.desc&include_adult=false&include_video=false&page=1&vote_count.gte=200";
    $.ajax({

        url: URL,
        success: handleResponse,
        error: handleError
    });

    function handleResponse(data) {
        $("#movies").html("");
        console.log(data);
        for (i = 0; i < 20; i++) {
            $("#movies").append("<div class='col-md-3'><div class='well text-center'><a href='getMovie/"+data.results[i].id+"'><img src='https://image.tmdb.org/t/p/w300" + data.results[i].poster_path + "'></a><h5>"+data.results[i].title+"</h5></div></div>");   
          
        
        }
    };


    function handleError(jqXHR, textStatus, errorThrown) {
        console.log(textStatus, errorThrown);

    };

//SEARCH BOX
$("#searchForm").on("keyup",function (event) {
    event.preventDefault();
    let $userInput=$("#searchText").val();
    let URL = "https://api.themoviedb.org/3/search/movie?api_key=e58e3961f5be7e510894dc736fee6937&query="+$userInput;
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
            $("#movies").append("<div class='col-md-3'><div class='well text-center'><a href='getMovie/"+data.results[i].id+"'><img src='https://image.tmdb.org/t/p/w300" + data.results[i].poster_path + "'></a><h5>"+data.results[i].title+"</h5></div></div>");   
          
        }
        }
    } ; 
});

 
}
